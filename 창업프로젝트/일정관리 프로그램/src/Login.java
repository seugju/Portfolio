import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class Login extends JFrame {

	 
	 private JPanel panel1;
	 private JTextField IdField;
	 private JPasswordField PwField;
	 private JButton Okbutton, Nobutton;
	 ButtonListener listener = new ButtonListener();
		ArrayList<String> list= new ArrayList<>();
		public ArrayList<String> getList(){return this.list;}
		public void setList(ArrayList<String> list) {this.list=list;}
	 
	 public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Login frame = new Login();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} //end main
	 
	 public Login(){
	 	setTitle("로그인");
	 	setSize(450,280);
			JFrame frame=new JFrame("�������� ���α׷�");
			frame.setLocation(200,400);

			JLabel IdLabel=new JLabel("아이디");
			IdLabel.setFont(new Font("����", Font.BOLD, 16));
			IdLabel.setHorizontalAlignment(SwingConstants.CENTER);
			JLabel PwLabel=new JLabel("비밀번호");
			PwLabel.setFont(new Font("����", Font.BOLD, 16));
			PwLabel.setHorizontalAlignment(SwingConstants.CENTER);
	       panel1=new JPanel();  // pane 1�� Frame�� �߰�.
	       panel1.setLayout(null); 

	//2�� 2���� pane�� ȭ���� ����.

	       IdField=new JTextField(10);
	       IdField.setFont(new Font("����", Font.PLAIN, 18));
	       IdField.setBounds(164, 55, 215, 24);
	       panel1.add(IdLabel);
	       IdLabel.setBounds(57, 51,89,30);
	       panel1.add(IdField);
	       IdField.setToolTipText("ID�� �Է��ϼ���");

	       PwField=new JPasswordField(10);
	       PwField.setFont(new Font("����", Font.PLAIN, 18));
	       PwField.setBounds(164, 107, 215, 24);
	       PwLabel.setBounds(57, 103,89,30);
	       panel1.add(PwLabel);
	       panel1.add(PwField);
	       PwField.setToolTipText("��й�ȣ�� �Է��ϼ���");



	  getContentPane().add(panel1, "Center");
	  Okbutton=new JButton("확인");
	  Okbutton.setBounds(123, 176, 61, 27);
	  panel1.add(Okbutton);
	  Okbutton.addActionListener(listener);
	  
	  Nobutton=new JButton("취소");
	  Nobutton.setBounds(252, 176, 61, 27);
	  panel1.add(Nobutton);
	  Nobutton.addActionListener(listener);

	  /* JFrame�� ��ӹ޾����Ƿ�, getContentPane()�տ� JFrame ��ü�� ������ ���̴�.
	   ( ex. JFrame e;

	   e.getContentPane() )

	   */
	  
//	  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//	  this.setSize(484,350);
//	  this.setVisible(true);
	  // this : Ŭ���� ��ü�� ����Ŵ
	  

	 } //end LoginForm()
	 
	 public class ButtonListener implements ActionListener{
	        
	        public void actionPerformed(ActionEvent e) {
	        	 if(e.getSource()==Okbutton) {
	        		 int s=0;
	        		 if(!IdField.getText().equals("") && !PwField.getText().equals("")) {
	            		 try {
	     					 ResultSet rs= MemTable.selectAll();
	     					 while(rs.next()) {
	     						 String id = rs.getString("id");
	     						String pw = rs.getString("pw");
	     						 if(IdField.getText().equals(id)) {
	     							if(PwField.getText().equals(pw)) {
	     								s++;
	     							}
	     						 }
	     						 
	     							 
	     					 }
	     					 if(s!=0) {
	     						JOptionPane.showMessageDialog(null, "로그인 성공!");
	     						dispose();
		                		 Calendar3 frame = new Calendar3(IdField.getText(),"");
		                		 
		                		 Calendar3.Memobutton mebt=frame.new Memobutton();
		             			mebt.MemoCreate();
		             			frame.getList();
		                     	Calendar3.Daybutton daybt = frame.new Daybutton();
		             			daybt.buttonCreate();
		                     	frame.setVisible(true);
		                     	daybt.setButton("로그아웃");

		                     	
	     					 }
	     					 else
	     						JOptionPane.showMessageDialog(null, "잘못된 입력입니다.");
	     					 
	     						 
	            			 
	    				} catch (SQLException e1) {
	    					// TODO Auto-generated catch block
	    					
	    					e1.printStackTrace(); //�ߺ���
	    					
	    				}
	        		 }
	        		 
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
//	 @Override
//	 public void actionPerformed(ActionEvent ae) {
//	  Object o=ae.getSource();
//	  /* � Ŭ������ �޾ƾ� �� �� �𸦶�
//	    : �ֻ���Ŭ������ java.lang.Object�� ����Ŭ���� ��ü�� ������ ���ϴ�.
//	   */
//	  
//	  String db_id="1";
//	  String db_pwd="1";
//	  
//	  if(o==Okbutton){
//	   /* ���ú��� db_id�� db_pwd�� ���ڰ� 1�� �ڵ����������� ���ǵǾ���,
//
//	id�� password�� 1�� �Է��ؾ����� ���� ���´�. */
//
//	   if(db_id.equals( IdField.getText().trim() ) && db_pwd.equals(PwField.getText().trim()) ){
//
//	// trim() : ���ڿ��� �����ϴ� space�� ����.
//
//	    
//	    IdField.setText("Success");
//	    PwField.setText("Success");
//
//	   }else{
//
//	    IdField.setText("Fail");
//	    PwField.setText("Fail");
//	    IdField.requestFocus();
//
//	   } //end if(db_id, db_pwd)
//
//	  }else if(o==Nobutton){
//
//	   IdField.setText("");
//	   PwField.setText("");
//	   IdField.requestFocus();
//
//	  } //end if( confirm else if cancel)
//	 } //end actionPerformed
//	 



} 
