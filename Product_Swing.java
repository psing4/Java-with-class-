package ������ǥ;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
public class Product_Swing extends Product_GUI { //ȭ�� ���� Ŭ���� ���
	//���̺� ��ü �����ϴ� Ŭ����
	ArrayList<Product> datas = new ArrayList<Product>();
	Product_DAO dao = new Product_DAO(); //DB���� Ŭ����
	Product dept= new Product(); //������ �� ó�� Ŭ����
	
	Product_Swing(){ 
	startUI2(); //ȭ�� ����
	refreshData(); //������ ���� ���
	}//������ ����
	
	// �̺�Ʈ �߻� ó�� �޼��� 3���� ��ư�� �Ѳ����� ó��
    public void actionPerformed(ActionEvent e) {
    	//� ��ư�� ���ȴ��� obj�� ����
    	Object obj = e.getSource();
    	
    	
       	if(obj == b1) {//��� ��ư Ŭ�� ó��       		
    		dept.setCompany_id(Integer.parseInt( t1.getText()));
    		dept.setMonth(Integer.parseInt( t2.getText()));
    		dept.setBlanket(Integer.parseInt( t3.getText()));
    		dept.setSheet(Integer.parseInt( t4.getText()));
    		dept.setTowel(Integer.parseInt( t5.getText()));

			if(dao.insert_Product(dept)){
				ml.setText(" �μ������� ����߽��ϴ�.!!");
				clearField();
				refreshData();
			}else{
				ml.setText("�μ������� ����� ���� �߽��ϴ�.!!");
       		}
       	}
       	
       	if(obj == b2) {//���� ��ư Ŭ�� ó��       		
    		dept.setCompany_id(Integer.parseInt( t1.getText()));
    		dept.setMonth(Integer.parseInt( t2.getText()));
    		dept.setBlanket(Integer.parseInt( t3.getText()));
    		dept.setSheet(Integer.parseInt( t4.getText()));
    		dept.setTowel(Integer.parseInt( t5.getText()));

			if(dao.update_Product(dept)) {
				ml.setText("�μ� ������ �����߽��ϴ�.!!");
				clearField();
				refreshData();
			}else{
				ml.setText("�μ� ������ ������ ���� �߽��ϴ�.!!");
       		}
       	}
       	
    	if(obj == b3) {//���� ��ư Ŭ�� ó��       		
    		dept.setCompany_id(Integer.parseInt( t1.getText()));
    		dept.setMonth(Integer.parseInt( t2.getText()));
    		if(dao.delete_company(dept.getcompany_id(),dept.getMonth())) {
				ml.setText("�μ� ������ �����߽��ϴ�.!!");
				clearField();
				refreshData();
			}else{
				ml.setText("�μ� ������ ������ ���� �߽��ϴ�.!!");
       		}
       	} 
    	if(obj == b4)
    	{
    		dispose();
    	}
    }//��ư Ŭ�� �̺�Ʈ ����    
 
 	public void refreshData() {// ��ü ������ ��� ��� �� ���� �޼���
 		ta.setText("");
 		clearField();
 		ta.append("ȸ���ȣ\t �ش��\t �� �̺ҷ�\t �� ���Ƿ�\t �� ��Ʈ��\t  \n");
 		datas = dao.getAll();	
 		if(datas != null) {
 			// ArrayList �� ��ü �����͸� ���Ŀ� ���� ���
 			for(Product p : datas) {
 				StringBuffer sb = new StringBuffer();
 				
 				sb.append(p.getcompany_id()+"\t");
 				sb.append(p.getMonth()+"\t");
 				sb.append(p.getBlanket()+"\t");
 				sb.append(p.getSheet()+"\t");
 				sb.append(p.getTowel()+"\t"+"\n");
 				ta.append(sb.toString());
 				ta.disable();
 			}
 		}
 		else {
 			ta.append("��ϵ� �μ��� �����ϴ�.!!\n�μ��� ����� �ּ��� !!");	
 		}
 	}  //ȭ�� ���� ����
	
/*	public static void main(String[] args) {
		swing_db_final2 app1 = new swing_db_final2();
	}*/
}//Ŭ���� ����
