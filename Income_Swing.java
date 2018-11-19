package 최종발표;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
public class Income_Swing extends Income_GUI { //화면 구성 클래스 상속
	//테이블 전체 저장하는 클래스
	ArrayList<Income> datas = new ArrayList<Income>();
	Income_DAO dao = new Income_DAO(); //DB연동 클래스
	Income dept= new Income(); //행저장 및 처리 클래스
	
	public Income_Swing() { 
		startUI(); //화면 생성
		refreshData(); //데이터 갱신 기능
		}//생성자 종료
		
		// 이벤트 발생 처리 메서드 3개의 버튼을 한꺼번에 처리
	    public void actionPerformed(ActionEvent e) {
	    	//어떤 버튼을 눌렸는지 obj에 저장
	    	Object obj = e.getSource();
	    	
	       	if(obj == b1) {//변경 버튼 클릭 처리       		
	       		dao.delete_Income();
	    		dept.setBlanket_pay(Integer.parseInt( t1.getText()));
	    		dept.setSheet_pay(Integer.parseInt( t1.getText()));
	    		dept.setTowel_pay(Integer.parseInt( t1.getText()));	
	    		if(dao.insert_Income(dept.getBlanket_pay(),dept.getSheet_pay(),dept.getTowel_pay()))
				{
					ml.setText(" 변경 완료 !!");
					clearField();
					refreshData();
				}else{
					ml.setText("부서정보를 변경이 실패 했습니다.!!");
	       		}
	   
	       	}
	       	
	       	if(obj == b2) {//차트 버튼 클릭 처리       		
	    		ml.setText("차트생성");
	    		JFreeChart chart = new IncomeChart().getChart();
	            ChartFrame cf = new ChartFrame("My Chart", chart);
	            cf.setSize(800,400);
	            cf.setVisible(true);

	       	}
	       	
	    	if(obj == b3) {
	    		dispose();
	    	}
	    }//버튼 클릭 이벤트 종료    
	 
	 	public void refreshData() {// 전체 데이터 목록 출력 및 갱신 메서드
	 		ta.setText("");
	 		clearField();
	 		ta.append("회사번호\t 해당 월\t 월지급액 \t 이득기준치 \t 이득여부\n");
	 		datas = dao.getAll(); 		
	 		if(datas != null) {
	 			// ArrayList 의 전체 데이터를 형식에 맞춰 출력
	 			for(Income p : datas) {
	 				StringBuffer sb = new StringBuffer();
	 				
	 				sb.append(p.getcompany_id()+"\t");
	 				sb.append(p.getMonth()+"\t");
	 				sb.append(p.getCompany_pay()+"원"+"\t");
	 				sb.append(p.getIdeal_pay()+"원"+"\t");
	 				if(p.getCompany_pay()>p.getIdeal_pay()) //이득기준치보다 크면 이득
	 					sb.append("이득"+"\n");
	 				else sb.append("손해"+"\n");//이득 기준치보다 작으면 손해 
	 				ta.append(sb.toString());
	 				ta.disable();
	 			}
	 		}
	 		else { 
	 			ta.append("등록된 부서가 없습니다.!!\n부서를 등록해 주세요 !!");	
	 		}
	 	}
}//클래스 종료
