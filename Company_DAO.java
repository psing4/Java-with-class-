package ������ǥ;
import java.sql.*;
import java.util.ArrayList;
public class Company_DAO {
	//Company ���̺� Data Access Object
	DBconnecter db = new DBconnecter(); //������ ���̽��� ����
	String sql = null; //sql���� null������ 
	
	public ArrayList<Company> getAll() {// ��ü ���۴� �����͸� ������ ���� �޼���
		  db.connectDB();
			sql = "select * from Company order by company_id";			
			//��ü �˻� �����͸� �����ϱ� ���� ArrayList
			ArrayList<Company> datas = new ArrayList<Company>();				
			try {
				db.pstmt = db.conn.prepareStatement(sql);
				db.rs = db.pstmt.executeQuery();			
				// �˻��� �����ͼ� ��ŭ ������ ���� company ��ü�� ����� �̸� �ٽ� ArrayList �� �߰���.
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
	    //��ȣ�� �������� ���� ���� ��ȣ�� �˻�
	    db.pstmt=db.conn.prepareStatement(sql);//������ ���� ��ü ����
	    db.pstmt.setInt(1, company.getCompany_id()); //ù��° ����ǥ�� ��ȣ���� ����
	    db.pstmt.setString(2, company.getCompany_name()); //�ι�° ����ǥ�� ��ȣ���� ����
	    db.pstmt.setInt(3, company.getCompany_pay()); //����° ����ǥ�� ��ȣ���� ����	    
	    int i = db.pstmt.executeUpdate();//�˻� insert�� ���� 
	    db.connectDB();
	 	    if(i ==1){ //insert ������
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
	    	   //��ȣ�� �������� ���� ���� ��ȣ�� �˻�
	    	   db.pstmt=db.conn.prepareStatement(sql);//������ ���� ��ü ����
	    	   db.pstmt.setInt(1, company.getCompany_id());//ù��° ����ǥ�� ��ȣ���� ����    	   
	    	   db.rs=db.pstmt.executeQuery();//�˻� select�� ����
	    	   
	    	   if(db.rs.next()){//�˻� ��ȣ���� ���� ��� ����
	    		   sql="update company set company_pay=?, company_name=?  where company_id=?";
	    		   db.pstmt=db.conn.prepareStatement(sql);
	    		   db.pstmt.setInt(1,company.getCompany_pay());//1������ǥ�� ���ڿ��� �̸� ����
	    		   db.pstmt.setString(2,company.getCompany_name());//1������ǥ�� ���ڿ��� �̸� ����
	    		   db.pstmt.setInt(3,company.getCompany_id());//1������ǥ�� ���ڿ��� �̸� ����
	    		   
	    		   int re=db.pstmt.executeUpdate();//������ ����	  
	    		   db.connectDB();
		    		   if(re==1){ //������ 1 �� ��ȯ
		    			   result = true;
		    		   }else{
		    			   result= false;
		    			   db.conn.rollback(); //�۾� ���
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
	    	   //��ȣ�� �������� ���� ���� ��ȣ�� �˻�
	    	   db.pstmt=db.conn.prepareStatement(sql);//������ ���� ��ü ����
	    	   db.pstmt.setInt(1, company_id);//ù��° ����ǥ�� ��ȣ���� ����    	   
	    	   db.rs=db.pstmt.executeQuery();//�˻� select�� ����	    	   
	    	   if(db.rs.next()){//�˻� ��ȣ���� ���� ��� ����
	    		   sql="delete from company  where company_id=?";
	    		   db.pstmt=db.conn.prepareStatement(sql);
	    		   db.pstmt.setInt(1,company_id);//1������ǥ�� ���ڿ��� �̸� ����
	    		   int re=db.pstmt.executeUpdate();//������ ����	 
	    		   db.closeDB();
		    		   if(re==1){ //������ 1 �� ��ȯ
		    			   result = true;
		    		   }else{
		    			   result= false;
		    			   db.conn.rollback(); //�۾� ���
		    		   }
	    	   }else{
	    		   result = false;
	    	   }   			
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return result;		
	}			
}//��ü Ŭ���� ��



