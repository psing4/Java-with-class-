package 최종발표;
import java.sql.*;
import java.util.ArrayList;
public class Company_DAO {
	//Company 테이블 Data Access Object
	DBconnecter db = new DBconnecter(); //데이터 베이스르 연결
	String sql = null; //sql문을 null값으로 
	
	public ArrayList<Company> getAll() {// 전체 컴퍼니 데이터를 가지고 오는 메서드
		  db.connectDB();
			sql = "select * from Company order by company_id";			
			//전체 검색 데이터를 전달하기 위한 ArrayList
			ArrayList<Company> datas = new ArrayList<Company>();				
			try {
				db.pstmt = db.conn.prepareStatement(sql);
				db.rs = db.pstmt.executeQuery();			
				// 검색된 데이터수 만큼 루프를 돌며 company 객체를 만들고 이를 다시 ArrayList 에 추가함.
				while(db.rs.next()) {
					Company p = new Company();
					p.setCompany_id(db.rs.getInt("company_id"));
					p.setCompany_name(db.rs.getString("company_name"));
					p.setCompany_pay(db.rs.getInt("company_pay"));
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
	public Boolean insert_company(Company company){
		Boolean result = false;
		
		try{		
		db.connectDB();
		sql="insert into company values(?,?,?)";
	    //번호를 기준으로 디비로 부터 번호값 검색
	    db.pstmt=db.conn.prepareStatement(sql);//쿼리문 실행 객체 생성
	    db.pstmt.setInt(1, company.getCompany_id()); //첫번째 물음표에 번호값을 저장
	    db.pstmt.setString(2, company.getCompany_name()); //두번째 물음표에 번호값을 저장
	    db.pstmt.setInt(3, company.getCompany_pay()); //세번째 물음표에 번호값을 저장	    
	    int i = db.pstmt.executeUpdate();//검색 insert문 실행 
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
	public Boolean update_company(Company company){
		Boolean result = false;		
		try{
			  db.connectDB();
			  sql = "select company_id from company where company_id=?";
	    	   //번호를 기준으로 디비로 부터 번호값 검색
	    	   db.pstmt=db.conn.prepareStatement(sql);//쿼리문 실행 객체 생성
	    	   db.pstmt.setInt(1, company.getCompany_id());//첫번째 물음표에 번호값을 저장    	   
	    	   db.rs=db.pstmt.executeQuery();//검색 select문 실행
	    	   
	    	   if(db.rs.next()){//검색 번호값이 있을 경우 수정
	    		   sql="update company set company_pay=?, company_name=?  where company_id=?";
	    		   db.pstmt=db.conn.prepareStatement(sql);
	    		   db.pstmt.setInt(1,company.getCompany_pay());//1번물음표에 문자열로 이름 저장
	    		   db.pstmt.setString(2,company.getCompany_name());//1번물음표에 문자열로 이름 저장
	    		   db.pstmt.setInt(3,company.getCompany_id());//1번물음표에 문자열로 이름 저장
	    		   
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
	public boolean delete_company(int company_id){
		boolean result = false;		
		try{  db.connectDB();
			  sql = "select company_id from company where company_id=?";
	    	   //번호를 기준으로 디비로 부터 번호값 검색
	    	   db.pstmt=db.conn.prepareStatement(sql);//쿼리문 실행 객체 생성
	    	   db.pstmt.setInt(1, company_id);//첫번째 물음표에 번호값을 저장    	   
	    	   db.rs=db.pstmt.executeQuery();//검색 select문 실행	    	   
	    	   if(db.rs.next()){//검색 번호값이 있을 경우 수정
	    		   sql="delete from company  where company_id=?";
	    		   db.pstmt=db.conn.prepareStatement(sql);
	    		   db.pstmt.setInt(1,company_id);//1번물음표에 문자열로 이름 저장
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



