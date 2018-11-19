package 최종발표;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
// 메인 프로그램 공용 클래스 JFrame 을 상속받음 이벤트 처리기능 추가
public abstract class Product_GUI extends 
JFrame implements ActionListener{	
	// 화면 구성을 위한 패널 정의
	JPanel p1 = new JPanel(); // 텍스트 라벨 패널
	JPanel p2 = new JPanel(); // 입력 양식 패널
	JPanel p3 = new JPanel(); // 데이터 출력 패널
	// 메시지 출력을 위한 라벨
	JLabel ml = new JLabel();
	// 입력양식에 사용될 텍스트 필드
    JTextField t1 = new JTextField(20);
	JTextField t2 = new JTextField(20);
	JTextField t3 = new JTextField(20);
	JTextField t4 = new JTextField(20);
	JTextField t5 = new JTextField(20);
	// 데이터 출력을 위한 텍스트영역
	JTextArea ta;	
	// 메뉴 버튼
	JButton b1 = new JButton("등록");
	JButton b2 = new JButton("변경");
	JButton b3 = new JButton("삭제"); 	
	JButton b4 = new JButton("종료");
	
	// 등록, 삭제, 전체 목록 조회시 필드 초기화
	public void clearField() {
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
	
}	
	public void startUI2() {// 메인 UI 실행 메서드
		ml.setText(" 프로그램이 시작 되었습니다.!!" + " (회사 삭제시 번호, 월 입력)");	
		// 양식 배치를 위한 패널 레이아웃 설정 4행 1열, 여백
		p1.setLayout(new GridLayout(5,1,20,2));
		p2.setLayout(new GridLayout(5,1,20,2));		
		// 양식에 사용될 라벨 설정
		JLabel l1 = new JLabel("회사번호");
		JLabel l2 = new JLabel("해당 월");
		JLabel l3 = new JLabel("월 이불량");
		JLabel l4 = new JLabel("월 시트양");	
		JLabel l5 = new JLabel("월 수건양");	
		// 텍스트 영역 초기화
		ta = new JTextArea(10,40);
		 Font font = new Font("Times",Font.BOLD,12);
		
		 
		ta.setFont(font);
		//스크롤 기능 패널에 텍스트 에리아 추가
		JScrollPane scroll = new JScrollPane (ta, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);	
		
		// 패널에 컴포넌트 추가
		p1.add(l1);
		p1.add(l2);
		p1.add(l3);
		p1.add(l4);		
		p1.add(l5);		

		p2.add(t1);
		p2.add(t2);
		p2.add(t3);
		p2.add(t4);
		p2.add(t5);

		p3.add(b1);
		p3.add(b2);
		p3.add(b3);
		p3.add(b4);
		
		// 이벤트 리스너 등록
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		// 메인 프레임에 패널 및 컴포넌트 배치
		add(ml,BorderLayout.PAGE_START);
		add(p1,BorderLayout.LINE_START);
		add(p2,BorderLayout.CENTER);
		add(scroll,BorderLayout.LINE_END);
		add(p3,BorderLayout.PAGE_END);		
		setResizable(false);
		setVisible(true);
	}		
	
	public Product_GUI() {// 생성자, 프레임 초기화
		super("Product Manager Application V2.0");
		setLayout(new BorderLayout(20,20));
/*		setDefaultCloseOperation(EXIT_ON_CLOSE);*/
		setSize(700,300);
		setLocationRelativeTo(null);
	}	    
	
}
