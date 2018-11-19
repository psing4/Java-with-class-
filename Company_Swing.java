package 최종발표;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
public class Company_Swing extends Company_GUI { //화면 구성 클래스 상속
	//테이블 전체 저장하는 클래스
	ArrayList<Company> datas = new ArrayList<Company>();
	Company_DAO dao = new Company_DAO(); //DB연동 클래스
	Company dept= new Company(); //행저장 및 처리 클래스
	
	Company_Swing(){ 
	startUI(); //화면 생성
	refreshData(); //데이터 갱신 기능
	}//생성자 종료
	
	// 이벤트 발생 처리 메서드 3개의 버튼을 한꺼번에 처리
    public void actionPerformed(ActionEvent e) {
    	//어떤 버튼을 눌렸는지 obj에 저장
    	Object obj = e.getSource();
    	
       	if(obj == b1) {//등록 버튼 클릭 처리       		
    		dept.setCompany_id(Integer.parseInt( t1.getText()));
    		dept.setCompany_name(t2.getText());
    		dept.setCompany_pay(Integer.parseInt( t3.getText()));
			if(dao.insert_company(dept)){
				ml.setText(" 부서정보를 등록했습니다.!!");
				clearField();
				refreshData();
			}else{
				ml.setText("부서정보를 등록이 실패 했습니다.!!");
       		}
       	}
       	
       	if(obj == b2) {//변경 버튼 클릭 처리       		
    		dept.setCompany_id(Integer.parseInt( t1.getText()));
    		dept.setCompany_name(t2.getText());
    		dept.setCompany_pay(Integer.parseInt( t3.getText()));
			if(dao.update_company(dept)) {
				ml.setText("부서 정보를 변경했습니다.!!");
				clearField();
				refreshData();
			}else{
				ml.setText("부서 정보를 변경이 실패 했습니다.!!");
       		}
       	}
       	
    	if(obj == b3) {//삭제 버튼 클릭 처리       		
    		dept.setCompany_id(Integer.parseInt( t1.getText()));
    		if(dao.delete_company(dept.getCompany_id())) {
				ml.setText("부서 정보를 삭제했습니다.!!");
				clearField();
				refreshData();
			}else{
				ml.setText("부서 정보를 삭제가 실패 했습니다.!!");
       		}

    	}
    	if(obj == b4) {//종료 처리 버튼
    		dispose();
    	}
    }//버튼 클릭 이벤트 종료    
 
 	public void refreshData() {// 전체 데이터 목록 출력 및 갱신 메서드
 		ta.setText("");
 		clearField();
 		ta.append("회사번호\t 회사이름\t 월지급액\n");
 		datas = dao.getAll(); 		
 		if(datas != null) {
 			// ArrayList 의 전체 데이터를 형식에 맞춰 출력
 			for(Company p : datas) {
 				StringBuffer sb = new StringBuffer();
 				
 				sb.append(p.getCompany_id()+"\t");
 				sb.append(p.getCompany_name()+"\t");
 				sb.append(p.getCompany_pay()+"원"+"\t"+"\n");
 				ta.append(sb.toString());
 				ta.disable();
 			}
 		}
 		else { 
 			ta.append("등록된 부서가 없습니다.!!\n부서를 등록해 주세요 !!");	
 		}
 	}  //화면 갱신 종료
	
/*	public static void main(String[] args) {
		swing_db_final app1 = new swing_db_final();
	}*/
}//클래스 종료
