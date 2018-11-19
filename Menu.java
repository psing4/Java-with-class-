package 최종발표;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

public class Menu extends JFrame {
	//자바 툴을 이용한 Menu 설정 
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		//Menu 생성자 설정 
		setTitle("Menu");
		setForeground(Color.ORANGE);
/*		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
		setBounds(100, 100, 184, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setForeground(UIManager.getColor("CheckBox.foreground"));
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JButton button1 = new JButton("\uD68C\uC0AC\uAD00\uB9AC");
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Company_Swing app1 = new Company_Swing();
			}
		
		});
		button1.setBounds(27, 49, 107, 23);
		layeredPane.add(button1);
		
		JButton button2 = new JButton("\uC6D4\uBCC4 \uBB3C\uAC74\uB7C9");
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Product_Swing app2 = new Product_Swing();
			}
		});
		button2.setBounds(27, 82, 107, 23);
		layeredPane.add(button2);
		
		JButton button3 = new JButton("\uC218\uC785 \uBE44\uAD50 ");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Income_Swing app2 = new Income_Swing();
			}
		});
		button3.setBounds(27, 119, 107, 23);
		layeredPane.add(button3);
		
		JLabel label = new JLabel("\uBA54\uB274 \uC120\uD0DD");
		label.setBounds(58, 24, 59, 15);
		layeredPane.add(label);
		
		JButton button4 = new JButton("\uC885\uB8CC");
		button4.setBounds(27, 154, 107, 23);
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		layeredPane.add(button4);
	}
}
