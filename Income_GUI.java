package 최종발표;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

// 메인 프로그램 공용 클래스 JFrame 을 상속받음 이벤트 처리기능 추가
public abstract class Income_GUI extends 
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
	// 데이터 출력을 위한 텍스트영역
	JTextArea ta;	
	// 메뉴 버튼
	JButton b1 = new JButton("변경");
	JButton b2 = new JButton("차트");
	JButton b3 = new JButton("종료"); 
	// 변경 시 필드 초기화
	public void clearField() {
		t1.setText("");
		t2.setText("");
		t3.setText("");
	
}	
	public void startUI() {// 메인 UI 실행 메서드
		
		ml.setText(" 프로그램이 시작 되었습니다.!!");	
		// 양식 배치를 위한 패널 레이아웃 설정 4행 1열, 여백
		p1.setLayout(new GridLayout(4,1,20,2));
		p2.setLayout(new GridLayout(4,1,20,2));		
		// 양식에 사용될 라벨 설정
		JLabel l1 = new JLabel("이불당 가격");
		JLabel l2 = new JLabel("시트당 가격");
		JLabel l3 = new JLabel("수건당 가격");	
	
	
		// 텍스트 영역 초기화
		ta = new JTextArea(10,40);
		 Font font = new Font("Times",Font.BOLD,15);
		 ta.setSelectedTextColor(Color.red);
		 
		ta.setFont(font);
		//스크롤 기능 패널에 텍스트 에리아 추가
		JScrollPane scroll = new JScrollPane (ta, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);	
		p1.add(l1);// 패널에 컴포넌트 추가
		p1.add(l2);
		p1.add(l3);		

		p2.add(t1);
		p2.add(t2);
		p2.add(t3);

		p3.add(b1);
		p3.add(b2);
		p3.add(b3);

		// 이벤트 리스너 등록
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		// 메인 프레임에 패널 및 컴포넌트 배치
		add(ml,BorderLayout.PAGE_START);
		add(p1,BorderLayout.LINE_START);
		add(p2,BorderLayout.CENTER);
		add(scroll,BorderLayout.LINE_END);
		add(p3,BorderLayout.PAGE_END);		
		setResizable(false);
		setVisible(true);
	}	
	public Income_GUI() {// 생성자, 프레임 초기화
		
		super("Income Manager Application V1.0");
		setLayout(new BorderLayout(20,20));
/*		setDefaultCloseOperation(EXIT_ON_CLOSE);*/
		setSize(700,300);
		setLocationRelativeTo(null);
	}	    
	
}
