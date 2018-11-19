package ������ǥ;
import java.sql.*;
import java.util.ArrayList;
public class Product_DAO {
	//Product ���̺� Data Access Object
	DBconnecter db = new DBconnecter(); //������ ���̽��� ����
	String sql = null; //sql���� null������ 
	
	public ArrayList<Product> getAll() {// ��ü �μ� �����͸� ������ ���� �޼���
		  db.connectDB();
			sql = "select * from product order by company_id";			
			//��ü �˻� �����͸� �����ϱ� ���� ArrayList
			ArrayList<Product> datas = new ArrayList<Product>();				
			try {
				db.pstmt = db.conn.prepareStatement(sql);
				db.rs = db.pstmt.executeQuery();			
				// �˻��� �����ͼ� ��ŭ ������ ���� product ��ü�� ����� �̸� �ٽ� ArrayList �� �߰���.
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
	    //��ȣ�� �������� ���� ���� ��ȣ�� �˻�
	    db.pstmt=db.conn.prepareStatement(sql);//������ ���� ��ü ����
	    db.pstmt.setInt(1, product.getcompany_id()); //ù��° ����ǥ�� ��ȣ���� ����
	    db.pstmt.setInt(2, product.getMonth()); //�ι�° ����ǥ�� ��ȣ���� ����
	    db.pstmt.setInt(3, product.getBlanket()); //����° ����ǥ�� ��ȣ���� ����
	    db.pstmt.setInt(4, product.getSheet()); //4��° ����ǥ�� ��ȣ���� ����	  
	    db.pstmt.setInt(5, product.getTowel()); //5��° ����ǥ�� ��ȣ���� ����	  
	    int i = db.pstmt.executeUpdate();//�˻� select�� ���� 
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
	public Boolean update_Product(Product product){
		Boolean result = false;		
		try{
			  db.connectDB();
			  sql = "select company_id from product where company_id=? and month=?";
	    	   //��ȣ�� ���� �������� ���� ���� ��ȣ�� �˻�
	    	   db.pstmt=db.conn.prepareStatement(sql);//������ ���� ��ü ����
	    	   db.pstmt.setInt(1, product.getcompany_id());//ù��° ����ǥ�� ��ȣ���� ����  
	    	   db.pstmt.setInt(2, product.getMonth());//ù��° ����ǥ�� ��ȣ���� ����    
	    	   db.rs=db.pstmt.executeQuery();//�˻� select�� ����
	    	   
	    	   if(db.rs.next()){//�˻� ��ȣ���� ���� ��� ����
	    		   sql="update product set blanket=?, sheet=?, towel=? where company_id=? and month=?";
	    		   db.pstmt=db.conn.prepareStatement(sql);
	    		   db.pstmt.setInt(1, product.getBlanket());//1������ǥ�� ���ڿ��� �̸� ����
	    		   db.pstmt.setInt(2, product.getTowel());//2������ǥ�� ���ڿ��� �̸� ����
	    		   db.pstmt.setInt(3, product.getSheet());//3������ǥ�� ���ڿ��� �̸� ����
	    		   db.pstmt.setInt(4, product.getcompany_id());//4������ǥ�� ���ڿ��� �̸� ����
	    		   db.pstmt.setInt(5,product.getMonth());//5������ǥ�� ���ڿ��� �̸� ����
	    		   
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
	public boolean delete_company(int company_id, int month){
		boolean result = false;		
		try{  db.connectDB();
			  sql="SET SQL_SAFE_UPDATES =0";
			  db.pstmt=db.conn.prepareStatement(sql);
			  db.rs=db.pstmt.executeQuery();
			  
			  sql = "select company_id, month from product where company_id=? and month=?";
	    	   //��ȣ�� �������� ���� ���� ��ȣ�� �˻�
	    	   db.pstmt=db.conn.prepareStatement(sql);//������ ���� ��ü ����
	    	   db.pstmt.setInt(1, company_id);//ù��° ����ǥ�� ��ȣ���� ����
	    	   db.pstmt.setInt(2, month);//�ι�° ����ǥ�� ��ȣ���� ����   
	    	   db.rs=db.pstmt.executeQuery();//�˻� select�� ����	    	   
	    	   if(db.rs.next()){//�˻� ��ȣ���� ���� ��� ����
	    		   sql="delete from product where company_id=? and month=?";
	    		   db.pstmt=db.conn.prepareStatement(sql);
	    		   db.pstmt.setInt(1,company_id);//1������ǥ�� ��Ʈ��
	    		   db.pstmt.setInt(2,month);//2������ǥ�� ��Ʈ��
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


