package ������ǥ;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
// ���� ���α׷� ���� Ŭ���� JFrame �� ��ӹ��� �̺�Ʈ ó����� �߰�
public abstract class Product_GUI extends 
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
	JTextField t4 = new JTextField(20);
	JTextField t5 = new JTextField(20);
	// ������ ����� ���� �ؽ�Ʈ����
	JTextArea ta;	
	// �޴� ��ư
	JButton b1 = new JButton("���");
	JButton b2 = new JButton("����");
	JButton b3 = new JButton("����"); 	
	JButton b4 = new JButton("����");
	
	// ���, ����, ��ü ��� ��ȸ�� �ʵ� �ʱ�ȭ
	public void clearField() {
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
	
}	
	public void startUI2() {// ���� UI ���� �޼���
		ml.setText(" ���α׷��� ���� �Ǿ����ϴ�.!!" + " (ȸ�� ������ ��ȣ, �� �Է�)");	
		// ��� ��ġ�� ���� �г� ���̾ƿ� ���� 4�� 1��, ����
		p1.setLayout(new GridLayout(5,1,20,2));
		p2.setLayout(new GridLayout(5,1,20,2));		
		// ��Ŀ� ���� �� ����
		JLabel l1 = new JLabel("ȸ���ȣ");
		JLabel l2 = new JLabel("�ش� ��");
		JLabel l3 = new JLabel("�� �̺ҷ�");
		JLabel l4 = new JLabel("�� ��Ʈ��");	
		JLabel l5 = new JLabel("�� ���Ǿ�");	
		// �ؽ�Ʈ ���� �ʱ�ȭ
		ta = new JTextArea(10,40);
		 Font font = new Font("Times",Font.BOLD,12);
		
		 
		ta.setFont(font);
		//��ũ�� ��� �гο� �ؽ�Ʈ ������ �߰�
		JScrollPane scroll = new JScrollPane (ta, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);	
		
		// �гο� ������Ʈ �߰�
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
		
		// �̺�Ʈ ������ ���
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		// ���� �����ӿ� �г� �� ������Ʈ ��ġ
		add(ml,BorderLayout.PAGE_START);
		add(p1,BorderLayout.LINE_START);
		add(p2,BorderLayout.CENTER);
		add(scroll,BorderLayout.LINE_END);
		add(p3,BorderLayout.PAGE_END);		
		setResizable(false);
		setVisible(true);
	}		
	
	public Product_GUI() {// ������, ������ �ʱ�ȭ
		super("Product Manager Application V2.0");
		setLayout(new BorderLayout(20,20));
/*		setDefaultCloseOperation(EXIT_ON_CLOSE);*/
		setSize(700,300);
		setLocationRelativeTo(null);
	}	    
	
}
