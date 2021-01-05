import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Join extends JFrame {

	private JPanel contentPane;
	private JPasswordField PwField;
	private JTextField IdField;
	private JTextField NicField;
	private JButton Okbutton;
	private JButton Nobutton;
	ButtonListener listener = new ButtonListener();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Join frame = new Join();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Join() {
		setTitle("회원가입");
		setSize(450,280);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel IdLabel = new JLabel("아이디");
		IdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IdLabel.setFont(new Font("����", Font.BOLD, 16));
		IdLabel.setBounds(57, 41, 89, 30);
		contentPane.add(IdLabel);
		
		JLabel PwLabel = new JLabel("비밀번호");
		PwLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PwLabel.setFont(new Font("����", Font.BOLD, 16));
		PwLabel.setBounds(57, 85, 89, 30);
		contentPane.add(PwLabel);
		
		JLabel NicLabel = new JLabel("닉네임");
		NicLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NicLabel.setFont(new Font("����", Font.BOLD, 16));
		NicLabel.setBounds(57, 130, 89, 30);
		contentPane.add(NicLabel);
		
		IdField = new JTextField(10);
		IdField.setFont(new Font("����", Font.PLAIN, 18));
		IdField.setToolTipText("");
		IdField.setBounds(164, 45, 215, 24);
		contentPane.add(IdField);
		
		PwField = new JPasswordField(10);
		PwField.setFont(new Font("����", Font.PLAIN, 18));
		PwField.setToolTipText("");
		PwField.setBounds(164, 89, 215, 24);
		contentPane.add(PwField);
		
		NicField = new JTextField(10);
		NicField.setFont(new Font("����", Font.PLAIN, 18));
		NicField.setToolTipText("");
		NicField.setBounds(164, 134, 215, 24);
		contentPane.add(NicField);
		
		Okbutton = new JButton("확인");
		Okbutton.setBounds(123, 185, 61, 27);
		contentPane.add(Okbutton);
		Okbutton.addActionListener(listener);
		
		Nobutton = new JButton("취소");
		Nobutton.setBounds(252, 185, 61, 27);
		contentPane.add(Nobutton);
		Nobutton.addActionListener(listener);
	}
	public class ButtonListener implements ActionListener{
        
        public void actionPerformed(ActionEvent e) {
        	 if(e.getSource()==Okbutton) {
        		 //Test test = new Test();
        		 if(!IdField.getText().equals("") && !PwField.getText().equals("") && !NicField.getText().equals("")) {
        		 try {
					
        			 MemTable.insert(String.valueOf(IdField.getText()),String.valueOf(PwField.getText()),String.valueOf(NicField.getText()));
        			 JOptionPane.showMessageDialog(null, "ȸ������ �Ϸ�!");
        			 dispose();
            		 Calendar3 frame = new Calendar3("","");
            		 Calendar3.Memobutton mebt=frame.new Memobutton();
         			mebt.MemoCreate();
                 	Calendar3.Daybutton daybt = frame.new Daybutton();
         			daybt.buttonCreate();
                 	frame.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "�ߺ� ID");
					e1.printStackTrace(); //�ߺ���
					IdField.setText("");
					PwField.setText("");
					NicField.setText("");
					
				}
        		 
        		}
        		 else
        			 JOptionPane.showMessageDialog(null, "��ĭ�� ��� ä���ּ���.");
        	 }
        	 if(e.getSource()==Nobutton) {
        		 dispose();
        		 Calendar3 frame = new Calendar3("","");
        		 Calendar3.Memobutton mebt=frame.new Memobutton();
     			mebt.MemoCreate();
             	Calendar3.Daybutton daybt = frame.new Daybutton();
     			daybt.buttonCreate();
             	frame.setVisible(true);
        	 }
        }
	}
}
