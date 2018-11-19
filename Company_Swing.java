package ������ǥ;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
public class Company_Swing extends Company_GUI { //ȭ�� ���� Ŭ���� ���
	//���̺� ��ü �����ϴ� Ŭ����
	ArrayList<Company> datas = new ArrayList<Company>();
	Company_DAO dao = new Company_DAO(); //DB���� Ŭ����
	Company dept= new Company(); //������ �� ó�� Ŭ����
	
	Company_Swing(){ 
	startUI(); //ȭ�� ����
	refreshData(); //������ ���� ���
	}//������ ����
	
	// �̺�Ʈ �߻� ó�� �޼��� 3���� ��ư�� �Ѳ����� ó��
    public void actionPerformed(ActionEvent e) {
    	//� ��ư�� ���ȴ��� obj�� ����
    	Object obj = e.getSource();
    	
       	if(obj == b1) {//��� ��ư Ŭ�� ó��       		
    		dept.setCompany_id(Integer.parseInt( t1.getText()));
    		dept.setCompany_name(t2.getText());
    		dept.setCompany_pay(Integer.parseInt( t3.getText()));
			if(dao.insert_company(dept)){
				ml.setText(" �μ������� ����߽��ϴ�.!!");
				clearField();
				refreshData();
			}else{
				ml.setText("�μ������� ����� ���� �߽��ϴ�.!!");
       		}
       	}
       	
       	if(obj == b2) {//���� ��ư Ŭ�� ó��       		
    		dept.setCompany_id(Integer.parseInt( t1.getText()));
    		dept.setCompany_name(t2.getText());
    		dept.setCompany_pay(Integer.parseInt( t3.getText()));
			if(dao.update_company(dept)) {
				ml.setText("�μ� ������ �����߽��ϴ�.!!");
				clearField();
				refreshData();
			}else{
				ml.setText("�μ� ������ ������ ���� �߽��ϴ�.!!");
       		}
       	}
       	
    	if(obj == b3) {//���� ��ư Ŭ�� ó��       		
    		dept.setCompany_id(Integer.parseInt( t1.getText()));
    		if(dao.delete_company(dept.getCompany_id())) {
				ml.setText("�μ� ������ �����߽��ϴ�.!!");
				clearField();
				refreshData();
			}else{
				ml.setText("�μ� ������ ������ ���� �߽��ϴ�.!!");
       		}

    	}
    	if(obj == b4) {//���� ó�� ��ư
    		dispose();
    	}
    }//��ư Ŭ�� �̺�Ʈ ����    
 
 	public void refreshData() {// ��ü ������ ��� ��� �� ���� �޼���
 		ta.setText("");
 		clearField();
 		ta.append("ȸ���ȣ\t ȸ���̸�\t �����޾�\n");
 		datas = dao.getAll(); 		
 		if(datas != null) {
 			// ArrayList �� ��ü �����͸� ���Ŀ� ���� ���
 			for(Company p : datas) {
 				StringBuffer sb = new StringBuffer();
 				
 				sb.append(p.getCompany_id()+"\t");
 				sb.append(p.getCompany_name()+"\t");
 				sb.append(p.getCompany_pay()+"��"+"\t"+"\n");
 				ta.append(sb.toString());
 				ta.disable();
 			}
 		}
 		else { 
 			ta.append("��ϵ� �μ��� �����ϴ�.!!\n�μ��� ����� �ּ��� !!");	
 		}
 	}  //ȭ�� ���� ����
	
/*	public static void main(String[] args) {
		swing_db_final app1 = new swing_db_final();
	}*/
}//Ŭ���� ����
