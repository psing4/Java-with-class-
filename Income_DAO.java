package 최종발표;
import java.sql.*;
import java.util.ArrayList;
public class Income_DAO {
	//Income 테이블 Data Access Object
	DBconnecter db = new DBconnecter(); //데이터 베이스르 연결
	String sql = null; //sql문을 null값으로 
	
	public ArrayList<Income> getAll() {// 전체 부서 데이터를 가지고 오는 메서드
		  db.connectDB();
			sql = "select * from income order by company_id";			
			//전체 검색 데이터를 전달하기 위한 ArrayList
			ArrayList<Income> datas = new ArrayList<Income>();				
			try {
				db.pstmt = db.conn.prepareStatement(sql);
				db.rs = db.pstmt.executeQuery();			
				// 검색된 데이터수 만큼 루프를 돌며 Income 객체를 만들고 이를 다시 ArrayList 에 추가함.
				while(db.rs.next()) {
					Income p = new Income();
					p.setCompany_id(db.rs.getInt("company_id"));
					p.setMonth(db.rs.getInt("month"));
					p.setIdeal_pay(db.rs.getInt("ideal_pay"));
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
	public Boolean insert_Income(int sheet_pay,int blanket_pay, int towel_pay){
		Boolean result = false;
		
		try{		
			
		db.connectDB();
		sql="insert into income (company_id, company_pay, ideal_pay,month)"
				+ "(select c.company_id,company_pay,towel*"+towel_pay+"+sheet*"+sheet_pay+"+blanket*"+blanket_pay+",month "
				+ "from product as p,company as c "
				+ "where p.company_id=c.company_id)";
	    //company 테이블(company_pay) 과 product 테이블(company_id,month) 데이터 연동 
		//ideal_pay를 product테이블을 이용하여 사용자가 주는 가중치 값에 의해 구함 

	    db.pstmt=db.conn.prepareStatement(sql);//쿼리문 실행 객체 생성
	    int i = db.pstmt.executeUpdate();//insert문 실행 
	    db.connectDB();
	 	    if(i ==6){ //insert 성공시
	 	    	result = true;  	
	 	    }else{
	 	    	result = false;
	 	    } 	     	  		
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return result;			
	}
	public boolean delete_Income(){
		boolean result = false;		
		try{  db.connectDB();
			  sql="SET SQL_SAFE_UPDATES =0";//삭제시 나타나는 경고 삭제 
			  db.pstmt=db.conn.prepareStatement(sql);//쿼리문 실행 객체 생성
			  db.rs=db.pstmt.executeQuery();
			  
			  sql = "delete from income";//income 테이블에 있는 모든 값 삭제 
	    	   db.pstmt=db.conn.prepareStatement(sql);   
	    	   int re=db.pstmt.executeUpdate();//수정문 실행	
	    	   
	    	   db.closeDB();
	    	   if(re==1){ //성공시 1 을 반환
		    			result = true;
		    		   }
	    	   else{
		    			result= false;
		    			db.conn.rollback(); //작업 취소
		    		   }     			
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return result;		
	}			

}//전체 클래스 끝



