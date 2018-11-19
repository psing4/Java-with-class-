package ������ǥ;
import java.sql.*;
import java.util.ArrayList;
public class Income_DAO {
	//Income ���̺� Data Access Object
	DBconnecter db = new DBconnecter(); //������ ���̽��� ����
	String sql = null; //sql���� null������ 
	
	public ArrayList<Income> getAll() {// ��ü �μ� �����͸� ������ ���� �޼���
		  db.connectDB();
			sql = "select * from income order by company_id";			
			//��ü �˻� �����͸� �����ϱ� ���� ArrayList
			ArrayList<Income> datas = new ArrayList<Income>();				
			try {
				db.pstmt = db.conn.prepareStatement(sql);
				db.rs = db.pstmt.executeQuery();			
				// �˻��� �����ͼ� ��ŭ ������ ���� Income ��ü�� ����� �̸� �ٽ� ArrayList �� �߰���.
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
	    //company ���̺�(company_pay) �� product ���̺�(company_id,month) ������ ���� 
		//ideal_pay�� product���̺��� �̿��Ͽ� ����ڰ� �ִ� ����ġ ���� ���� ���� 

	    db.pstmt=db.conn.prepareStatement(sql);//������ ���� ��ü ����
	    int i = db.pstmt.executeUpdate();//insert�� ���� 
	    db.connectDB();
	 	    if(i ==6){ //insert ������
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
			  sql="SET SQL_SAFE_UPDATES =0";//������ ��Ÿ���� ��� ���� 
			  db.pstmt=db.conn.prepareStatement(sql);//������ ���� ��ü ����
			  db.rs=db.pstmt.executeQuery();
			  
			  sql = "delete from income";//income ���̺� �ִ� ��� �� ���� 
	    	   db.pstmt=db.conn.prepareStatement(sql);   
	    	   int re=db.pstmt.executeUpdate();//������ ����	
	    	   
	    	   db.closeDB();
	    	   if(re==1){ //������ 1 �� ��ȯ
		    			result = true;
		    		   }
	    	   else{
		    			result= false;
		    			db.conn.rollback(); //�۾� ���
		    		   }     			
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return result;		
	}			

}//��ü Ŭ���� ��



