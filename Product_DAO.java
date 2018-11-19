package 최종발표;
import java.sql.*;
import java.util.ArrayList;
public class Product_DAO {
	//Product 테이블 Data Access Object
	DBconnecter db = new DBconnecter(); //데이터 베이스르 연결
	String sql = null; //sql문을 null값으로 
	
	public ArrayList<Product> getAll() {// 전체 부서 데이터를 가지고 오는 메서드
		  db.connectDB();
			sql = "select * from product order by company_id";			
			//전체 검색 데이터를 전달하기 위한 ArrayList
			ArrayList<Product> datas = new ArrayList<Product>();				
			try {
				db.pstmt = db.conn.prepareStatement(sql);
				db.rs = db.pstmt.executeQuery();			
				// 검색된 데이터수 만큼 루프를 돌며 product 객체를 만들고 이를 다시 ArrayList 에 추가함.
				while(db.rs.next()) {
					Product p = new Product();
					p.setCompany_id(db.rs.getInt("company_id"));
					p.setMonth(db.rs.getInt("month"));
					p.setBlanket(db.rs.getInt("blanket"));
					p.setTowel(db.rs.getInt("towel"));
					p.setSheet(db.rs.getInt("sheet"));
					
					datas.add(p);
				}				
			}
			catch(SQLException e) {
				e.printStackTrace();
				return null;
			}	
			db.closeDB();
			return datas;
	}	
	public Boolean insert_Product(Product product){
		Boolean result = false;
		
		try{		
		db.connectDB();
		sql="insert into product values(?,?,?,?,?)";
	    //번호를 기준으로 디비로 부터 번호값 검색
	    db.pstmt=db.conn.prepareStatement(sql);//쿼리문 실행 객체 생성
	    db.pstmt.setInt(1, product.getcompany_id()); //첫번째 물음표에 번호값을 저장
	    db.pstmt.setInt(2, product.getMonth()); //두번째 물음표에 번호값을 저장
	    db.pstmt.setInt(3, product.getBlanket()); //세번째 물음표에 번호값을 저장
	    db.pstmt.setInt(4, product.getSheet()); //4번째 물음표에 번호값을 저장	  
	    db.pstmt.setInt(5, product.getTowel()); //5번째 물음표에 번호값을 저장	  
	    int i = db.pstmt.executeUpdate();//검색 select문 실행 
	    db.connectDB();
	 	    if(i ==1){ //insert 성공시
	 	    	result = true;  	
	 	    }else{
	 	    	result = false;
	 	    } 	     	  		
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return result;			
	}
	public Boolean update_Product(Product product){
		Boolean result = false;		
		try{
			  db.connectDB();
			  sql = "select company_id from product where company_id=? and month=?";
	    	   //번호와 달을 기준으로 디비로 부터 번호값 검색
	    	   db.pstmt=db.conn.prepareStatement(sql);//쿼리문 실행 객체 생성
	    	   db.pstmt.setInt(1, product.getcompany_id());//첫번째 물음표에 번호값을 저장  
	    	   db.pstmt.setInt(2, product.getMonth());//첫번째 물음표에 번호값을 저장    
	    	   db.rs=db.pstmt.executeQuery();//검색 select문 실행
	    	   
	    	   if(db.rs.next()){//검색 번호값이 있을 경우 수정
	    		   sql="update product set blanket=?, sheet=?, towel=? where company_id=? and month=?";
	    		   db.pstmt=db.conn.prepareStatement(sql);
	    		   db.pstmt.setInt(1, product.getBlanket());//1번물음표에 문자열로 이름 저장
	    		   db.pstmt.setInt(2, product.getTowel());//2번물음표에 문자열로 이름 저장
	    		   db.pstmt.setInt(3, product.getSheet());//3번물음표에 문자열로 이름 저장
	    		   db.pstmt.setInt(4, product.getcompany_id());//4번물음표에 문자열로 이름 저장
	    		   db.pstmt.setInt(5,product.getMonth());//5번물음표에 문자열로 이름 저장
	    		   
	    		   int re=db.pstmt.executeUpdate();//수정문 실행	  
	    		   db.connectDB();
		    		   if(re==1){ //성공시 1 을 반환
		    			   result = true;
		    		   }else{
		    			   result= false;
		    			   db.conn.rollback(); //작업 취소
		    		   }
	    	   }else{
	    		   result = false;
	    	   }			
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return result;		
	}
	public boolean delete_company(int company_id, int month){
		boolean result = false;		
		try{  db.connectDB();
			  sql="SET SQL_SAFE_UPDATES =0";
			  db.pstmt=db.conn.prepareStatement(sql);
			  db.rs=db.pstmt.executeQuery();
			  
			  sql = "select company_id, month from product where company_id=? and month=?";
	    	   //번호를 기준으로 디비로 부터 번호값 검색
	    	   db.pstmt=db.conn.prepareStatement(sql);//쿼리문 실행 객체 생성
	    	   db.pstmt.setInt(1, company_id);//첫번째 물음표에 번호값을 저장
	    	   db.pstmt.setInt(2, month);//두번째 물음표에 번호값을 저장   
	    	   db.rs=db.pstmt.executeQuery();//검색 select문 실행	    	   
	    	   if(db.rs.next()){//검색 번호값이 있을 경우 수정
	    		   sql="delete from product where company_id=? and month=?";
	    		   db.pstmt=db.conn.prepareStatement(sql);
	    		   db.pstmt.setInt(1,company_id);//1번물음표에 인트형
	    		   db.pstmt.setInt(2,month);//2번물음표에 인트형
	    		   int re=db.pstmt.executeUpdate();//수정문 실행	 
	    		   db.closeDB();
		    		   if(re==1){ //성공시 1 을 반환
		    			   result = true;
		    		   }else{
		    			   result= false;
		    			   db.conn.rollback(); //작업 취소
		    		   }
	    	   }else{
	    		   result = false;
	    	   }   			
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return result;		
	}			
}//전체 클래스 끝


