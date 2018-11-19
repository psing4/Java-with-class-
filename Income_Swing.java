package ������ǥ;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
public class Income_Swing extends Income_GUI { //ȭ�� ���� Ŭ���� ���
	//���̺� ��ü �����ϴ� Ŭ����
	ArrayList<Income> datas = new ArrayList<Income>();
	Income_DAO dao = new Income_DAO(); //DB���� Ŭ����
	Income dept= new Income(); //������ �� ó�� Ŭ����
	
	public Income_Swing() { 
		startUI(); //ȭ�� ����
		refreshData(); //������ ���� ���
		}//������ ����
		
		// �̺�Ʈ �߻� ó�� �޼��� 3���� ��ư�� �Ѳ����� ó��
	    public void actionPerformed(ActionEvent e) {
	    	//� ��ư�� ���ȴ��� obj�� ����
	    	Object obj = e.getSource();
	    	
	       	if(obj == b1) {//���� ��ư Ŭ�� ó��       		
	       		dao.delete_Income();
	    		dept.setBlanket_pay(Integer.parseInt( t1.getText()));
	    		dept.setSheet_pay(Integer.parseInt( t1.getText()));
	    		dept.setTowel_pay(Integer.parseInt( t1.getText()));	
	    		if(dao.insert_Income(dept.getBlanket_pay(),dept.getSheet_pay(),dept.getTowel_pay()))
				{
					ml.setText(" ���� �Ϸ� !!");
					clearField();
					refreshData();
				}else{
					ml.setText("�μ������� ������ ���� �߽��ϴ�.!!");
	       		}
	   
	       	}
	       	
	       	if(obj == b2) {//��Ʈ ��ư Ŭ�� ó��       		
	    		ml.setText("��Ʈ����");
	    		JFreeChart chart = new IncomeChart().getChart();
	            ChartFrame cf = new ChartFrame("My Chart", chart);
	            cf.setSize(800,400);
	            cf.setVisible(true);

	       	}
	       	
	    	if(obj == b3) {
	    		dispose();
	    	}
	    }//��ư Ŭ�� �̺�Ʈ ����    
	 
	 	public void refreshData() {// ��ü ������ ��� ��� �� ���� �޼���
	 		ta.setText("");
	 		clearField();
	 		ta.append("ȸ���ȣ\t �ش� ��\t �����޾� \t �̵����ġ \t �̵濩��\n");
	 		datas = dao.getAll(); 		
	 		if(datas != null) {
	 			// ArrayList �� ��ü �����͸� ���Ŀ� ���� ���
	 			for(Income p : datas) {
	 				StringBuffer sb = new StringBuffer();
	 				
	 				sb.append(p.getcompany_id()+"\t");
	 				sb.append(p.getMonth()+"\t");
	 				sb.append(p.getCompany_pay()+"��"+"\t");
	 				sb.append(p.getIdeal_pay()+"��"+"\t");
	 				if(p.getCompany_pay()>p.getIdeal_pay()) //�̵����ġ���� ũ�� �̵�
	 					sb.append("�̵�"+"\n");
	 				else sb.append("����"+"\n");//�̵� ����ġ���� ������ ���� 
	 				ta.append(sb.toString());
	 				ta.disable();
	 			}
	 		}
	 		else { 
	 			ta.append("��ϵ� �μ��� �����ϴ�.!!\n�μ��� ����� �ּ��� !!");	
	 		}
	 	}
}//Ŭ���� ����
