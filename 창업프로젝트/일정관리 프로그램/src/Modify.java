import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class Modify extends JFrame {

	private JPanel contentPane;
	private JTextField MemoField;
	private JTextField PlaceField;
	public JTextField DayField;
	private JButton OkButton;
	private JButton NoButton;
	private JSpinner Timespinner;
	private JCheckBox HoliCheckBox;
	 private Calendar today = Calendar.getInstance();
	   int Year = this.today.get(Calendar.YEAR);
		int Month = this.today.get(Calendar.MONTH);
		int Date=today.get(Calendar.DAY_OF_MONTH); 
		int FirstDate = today.get(Calendar.DAY_OF_WEEK);
	private String id1="";
	private String memo1="";
	private String day1="";

	ArrayList<String> list= new ArrayList<>();
	ButtonListener listener = new ButtonListener();
	private int day;
	public ArrayList<String> getList(){return this.list;}
	public void setList(ArrayList<String> list) {this.list=list;}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Calendar3 frame2 = new Calendar3("","");
		// Calendar3.Memobutton mebt=frame.new Memobutton();
		//mebt.MemoCreate();
    	Calendar3.Daybutton daybt = frame2.new Daybutton();
//		daybt.buttonCreate(int day);
    	frame2.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public void setDay(int day) {this.day=day;}
	public Modify(String id, int day, String memo, String place) {
		id1=id;
		this.day=day;
		
		memo1=memo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel DateLabel = new JLabel("\uB0A0\uC9DC : ");
		DateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DateLabel.setFont(new Font("���ʷҵ���", Font.BOLD, 17));
		DateLabel.setBounds(76, 52, 113, 23);
		contentPane.add(DateLabel);
		
		JLabel TimeLabel = new JLabel("\uC2DC\uAC04 : ");
		TimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TimeLabel.setFont(new Font("���ʷҵ���", Font.BOLD, 17));
		TimeLabel.setBounds(76, 112, 113, 23);
		contentPane.add(TimeLabel);
		
		SpinnerDateModel model2 = new SpinnerDateModel();
		model2.setCalendarField(Calendar.MINUTE);
				Timespinner= new JSpinner();
				Timespinner.setBounds(207, 109, 102, 30);
				Timespinner.setFont(new Font("���ʷҵ���", Font.PLAIN, 17));
				contentPane.add(Timespinner);
				Timespinner.setModel(model2);
				Timespinner.setEditor(new JSpinner.DateEditor(Timespinner, "h : mm a"));;
		
		JLabel MemoLabel = new JLabel("\uB0B4\uC6A9 : ");
		MemoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		MemoLabel.setFont(new Font("���ʷҵ���", Font.BOLD, 17));
		MemoLabel.setBounds(76, 170, 113, 23);
		contentPane.add(MemoLabel);
		
		MemoField = new JTextField();
		MemoField.setFont(new Font("���ʷҵ���", Font.PLAIN, 15));
		MemoField.setColumns(15);
		MemoField.setBounds(186, 169, 146, 26);
		contentPane.add(MemoField);
		MemoField.setText(memo);
		
		
		JLabel PlaceLabel = new JLabel("\uC7A5\uC18C : ");
		PlaceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PlaceLabel.setFont(new Font("���ʷҵ���", Font.BOLD, 17));
		PlaceLabel.setBounds(76, 225, 113, 23);
		contentPane.add(PlaceLabel);
		
		PlaceField = new JTextField();
		PlaceField.setFont(new Font("���ʷҵ���", Font.PLAIN, 15));
		PlaceField.setColumns(15);
		PlaceField.setBounds(186, 225, 146, 26);
		contentPane.add(PlaceField);
		PlaceField.setText(place);
		
		HoliCheckBox = new JCheckBox("\uAE30\uB150\uC77C");
		HoliCheckBox.setHorizontalAlignment(SwingConstants.RIGHT);
		HoliCheckBox.setFont(new Font("���ʷҵ���", Font.BOLD, 17));
		HoliCheckBox.setBounds(261, 8, 131, 27);
		contentPane.add(HoliCheckBox);
		
		NoButton = new JButton("취소");
		NoButton.setBounds(227, 280, 105, 27);
		contentPane.add(NoButton);
		
		NoButton.addActionListener(listener);
		
		OkButton = new JButton("확인");
		OkButton.setBounds(84, 280, 105, 27);
		contentPane.add(OkButton);
		OkButton.addActionListener(listener);
		
		DayField = new JTextField();
		DayField.setHorizontalAlignment(SwingConstants.CENTER);
		DayField.setFont(new Font("���ʷҵ���", Font.PLAIN, 17));
		DayField.setEditable(false);
		DayField.setColumns(15);
		DayField.setBounds(186, 52, 146, 26);
		DayField.setText(Year+" / "+(Month+1)+" / "+(this.day-(Calendar.DAY_OF_WEEK)+3));
		day1=(DayField.getText());
		contentPane.add(DayField);
	}
public class ButtonListener implements ActionListener{
		
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==OkButton) {
            	
            	if(!MemoField.getText().equals("")) {
           		 try {
           			String time[] = String.valueOf(Timespinner.getValue()).split(" ");
    				
    				for(int i=0; i<time.length; i++)
    					System.out.println(i+"��° ���� : " +time[i]);
    				System.out.println();
           			 System.out.println("id"+id1);
           			 
 					if(HoliCheckBox.isSelected())
 						DiaryTable.modify(String.valueOf(MemoField.getText()),String.valueOf(PlaceField.getText()),time[3],1,id1 ,day1, memo1);
 					else
 						DiaryTable.modify(String.valueOf(MemoField.getText()),String.valueOf(PlaceField.getText()),time[3],0,id1, day1, memo1);
 					
        			 JOptionPane.showMessageDialog(null, "수정 완료!");
        			 list.add(MemoField.getText());
        			 dispose();
             		Calendar3 frame = new Calendar3(id1,"");
   
                 	frame.setList(list);
                 	Calendar3.Memobutton mebt=frame.new Memobutton();
         			mebt.MemoCreate();
                 	Calendar3.Daybutton daybt = frame.new Daybutton();
         			daybt.buttonCreate();
                 	daybt.setButton("로그아웃");
                 	frame.setVisible(true);
                 	 
                 	
                 	
                 	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "잘못된 이력입니다.");
					e1.printStackTrace(); //�ߺ���

					
				}
            		
                	
            	}
            	else
            		JOptionPane.showMessageDialog(null, "ㅇㅇㅇㅇ.");
            	
            	
            }
       	 if(e.getSource()==NoButton) {
    		 dispose();
    		 Calendar3 frame = new Calendar3(id1,"");
    		 Calendar3.Memobutton mebt=frame.new Memobutton();
 			mebt.MemoCreate();
         	Calendar3.Daybutton daybt = frame.new Daybutton();
 			daybt.buttonCreate();
 			daybt.setButton("로그아웃");
         	frame.setVisible(true);
    	 }
        }
	}
}
