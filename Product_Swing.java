package 최종발표;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
public class Product_Swing extends Product_GUI { //화면 구성 클래스 상속
	//테이블 전체 저장하는 클래스
	ArrayList<Product> datas = new ArrayList<Product>();
	Product_DAO dao = new Product_DAO(); //DB연동 클래스
	Product dept= new Product(); //행저장 및 처리 클래스
	
	Product_Swing(){ 
	startUI2(); //화면 생성
	refreshData(); //데이터 갱신 기능
	}//생성자 종료
	
	// 이벤트 발생 처리 메서드 3개의 버튼을 한꺼번에 처리
    public void actionPerformed(ActionEvent e) {
    	//어떤 버튼을 눌렸는지 obj에 저장
    	Object obj = e.getSource();
    	
    	
       	if(obj == b1) {//등록 버튼 클릭 처리       		
    		dept.setCompany_id(Integer.parseInt( t1.getText()));
    		dept.setMonth(Integer.parseInt( t2.getText()));
    		dept.setBlanket(Integer.parseInt( t3.getText()));
    		dept.setSheet(Integer.parseInt( t4.getText()));
    		dept.setTowel(Integer.parseInt( t5.getText()));

			if(dao.insert_Product(dept)){
				ml.setText(" 부서정보를 등록했습니다.!!");
				clearField();
				refreshData();
			}else{
				ml.setText("부서정보를 등록이 실패 했습니다.!!");
       		}
       	}
       	
       	if(obj == b2) {//변경 버튼 클릭 처리       		
    		dept.setCompany_id(Integer.parseInt( t1.getText()));
    		dept.setMonth(Integer.parseInt( t2.getText()));
    		dept.setBlanket(Integer.parseInt( t3.getText()));
    		dept.setSheet(Integer.parseInt( t4.getText()));
    		dept.setTowel(Integer.parseInt( t5.getText()));

			if(dao.update_Product(dept)) {
				ml.setText("부서 정보를 변경했습니다.!!");
				clearField();
				refreshData();
			}else{
				ml.setText("부서 정보를 변경이 실패 했습니다.!!");
       		}
       	}
       	
    	if(obj == b3) {//삭제 버튼 클릭 처리       		
    		dept.setCompany_id(Integer.parseInt( t1.getText()));
    		dept.setMonth(Integer.parseInt( t2.getText()));
    		if(dao.delete_company(dept.getcompany_id(),dept.getMonth())) {
				ml.setText("부서 정보를 삭제했습니다.!!");
				clearField();
				refreshData();
			}else{
				ml.setText("부서 정보를 삭제가 실패 했습니다.!!");
       		}
       	} 
    	if(obj == b4)
    	{
    		dispose();
    	}
    }//버튼 클릭 이벤트 종료    
 
 	public void refreshData() {// 전체 데이터 목록 출력 및 갱신 메서드
 		ta.setText("");
 		clearField();
 		ta.append("회사번호\t 해당월\t 월 이불량\t 월 수건량\t 월 시트량\t  \n");
 		datas = dao.getAll();	
 		if(datas != null) {
 			// ArrayList 의 전체 데이터를 형식에 맞춰 출력
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
 			ta.append("등록된 부서가 없습니다.!!\n부서를 등록해 주세요 !!");	
 		}
 	}  //화면 갱신 종료
	
/*	public static void main(String[] args) {
		swing_db_final2 app1 = new swing_db_final2();
	}*/
}//클래스 종료
