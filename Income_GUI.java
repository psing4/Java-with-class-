package ������ǥ;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

// ���� ���α׷� ���� Ŭ���� JFrame �� ��ӹ��� �̺�Ʈ ó����� �߰�
public abstract class Income_GUI extends 
JFrame implements ActionListener{	
	// ȭ�� ������ ���� �г� ����
	JPanel p1 = new JPanel(); // �ؽ�Ʈ �� �г�
	JPanel p2 = new JPanel(); // �Է� ��� �г�
	JPanel p3 = new JPanel(); // ������ ��� �г�
	// �޽��� ����� ���� ��
	JLabel ml = new JLabel();
	// �Է¾�Ŀ� ���� �ؽ�Ʈ �ʵ�
    JTextField t1 = new JTextField(20);
	JTextField t2 = new JTextField(20);
	JTextField t3 = new JTextField(20);
	// ������ ����� ���� �ؽ�Ʈ����
	JTextArea ta;	
	// �޴� ��ư
	JButton b1 = new JButton("����");
	JButton b2 = new JButton("��Ʈ");
	JButton b3 = new JButton("����"); 
	// ���� �� �ʵ� �ʱ�ȭ
	public void clearField() {
		t1.setText("");
		t2.setText("");
		t3.setText("");
	
}	
	public void startUI() {// ���� UI ���� �޼���
		
		ml.setText(" ���α׷��� ���� �Ǿ����ϴ�.!!");	
		// ��� ��ġ�� ���� �г� ���̾ƿ� ���� 4�� 1��, ����
		p1.setLayout(new GridLayout(4,1,20,2));
		p2.setLayout(new GridLayout(4,1,20,2));		
		// ��Ŀ� ���� �� ����
		JLabel l1 = new JLabel("�̺Ҵ� ����");
		JLabel l2 = new JLabel("��Ʈ�� ����");
		JLabel l3 = new JLabel("���Ǵ� ����");	
	
	
		// �ؽ�Ʈ ���� �ʱ�ȭ
		ta = new JTextArea(10,40);
		 Font font = new Font("Times",Font.BOLD,15);
		 ta.setSelectedTextColor(Color.red);
		 
		ta.setFont(font);
		//��ũ�� ��� �гο� �ؽ�Ʈ ������ �߰�
		JScrollPane scroll = new JScrollPane (ta, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);	
		p1.add(l1);// �гο� ������Ʈ �߰�
		p1.add(l2);
		p1.add(l3);		

		p2.add(t1);
		p2.add(t2);
		p2.add(t3);

		p3.add(b1);
		p3.add(b2);
		p3.add(b3);

		// �̺�Ʈ ������ ���
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		// ���� �����ӿ� �г� �� ������Ʈ ��ġ
		add(ml,BorderLayout.PAGE_START);
		add(p1,BorderLayout.LINE_START);
		add(p2,BorderLayout.CENTER);
		add(scroll,BorderLayout.LINE_END);
		add(p3,BorderLayout.PAGE_END);		
		setResizable(false);
		setVisible(true);
	}	
	public Income_GUI() {// ������, ������ �ʱ�ȭ
		
		super("Income Manager Application V1.0");
		setLayout(new BorderLayout(20,20));
/*		setDefaultCloseOperation(EXIT_ON_CLOSE);*/
		setSize(700,300);
		setLocationRelativeTo(null);
	}	    
	
}
