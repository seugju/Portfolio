import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JSlider;

public class Add extends JFrame {

	private JPanel contentPane;
	public JTextField MemoField;
	private JTextField PlaceField;
	private JSpinner Timespinner;
	private JSpinner Datespinner;
	private JButton OkButton;
	private JButton NoButton;
	private JCheckBox HoliCheckBox;
	private int day;
//	 private JButton MButtons[];
	private String id1="";
	private String day1="";
	
	 private Calendar today = Calendar.getInstance();
//	 Memobutton mebt = new Memobutton();
	ButtonListener listener = new ButtonListener();
	
	ArrayList<String> list= new ArrayList<>();
	public JTextField DayField;
	   int Year = this.today.get(Calendar.YEAR);
		int Month = this.today.get(Calendar.MONTH);
		int Date=today.get(Calendar.DAY_OF_MONTH); 
		int FirstDate = today.get(Calendar.DAY_OF_WEEK);
	//�ϸ� /�� �������� ���ڰ� ����� day[] �迭 �ȿ� ��
	//ex) JSpinner.getValue�� ���� "��/��/��" ��� �ϸ�
	//day[0]="��", day[1]="��", day[2]="��";// �̷���
	public ArrayList<String> getList(){return this.list;}
	public void setList(ArrayList<String> list) {this.list=list;}
//	Daybutton daybt=new Daybutton();
	  
		
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
	public Add(String id, String day) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.day=day;
		
		id1=id;
		
		day1=day;
		System.out.println("day1��"+day1);
		
		setBounds(100, 100, 420, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		System.out.println("ù��¥"+Calendar.DAY_OF_WEEK);
		
		JLabel DateLabel = new JLabel("날짜 : ");
		DateLabel.setBounds(76, 52, 113, 23);
		DateLabel.setFont(new Font("���ʷҵ���", Font.BOLD, 17));
		DateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(DateLabel);
		
//		SpinnerDateModel model = new SpinnerDateModel();
//		model.setCalendarField(Calendar.MONTH);
//		
//		Datespinner = new JSpinner();
//		Datespinner.setBounds(203, 49, 111, 30);
//		Datespinner.setFont(new Font("���ʷҵ���", Font.PLAIN, 17));
//		contentPane.add(Datespinner);
//		Datespinner.setModel(model);
//		
//		
//		Datespinner.setEditor(new JSpinner.DateEditor(Datespinner, "yyyy-MM-dd"));
//		//System.out.println(Datespinner);
//		System.out.println("$"+Datespinner.getValue());
//		

		
		//System.out.println();
		
		
		
		JLabel TimeLabel = new JLabel("시간 : ");
		TimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TimeLabel.setBounds(76, 112, 113, 23);
		TimeLabel.setFont(new Font("���ʷҵ���", Font.BOLD, 17));
		contentPane.add(TimeLabel);
		

		
		SpinnerDateModel model2 = new SpinnerDateModel();
		model2.setCalendarField(Calendar.MINUTE);
				Timespinner= new JSpinner();
				Timespinner.setBounds(207, 109, 102, 30);
				Timespinner.setFont(new Font("���ʷҵ���", Font.PLAIN, 17));
				contentPane.add(Timespinner);
				Timespinner.setModel(model2);
				Timespinner.setEditor(new JSpinner.DateEditor(Timespinner, "h : mm a"));
				
				
		
		JLabel MemoLabel = new JLabel("장소 : ");
		MemoLabel.setBounds(76, 170, 113, 23);
		MemoLabel.setFont(new Font("���ʷҵ���", Font.BOLD, 17));
		MemoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(MemoLabel);
		
		
		MemoField = new JTextField();
		MemoField.setBounds(186, 169, 146, 26);
		MemoField.setFont(new Font("���ʷҵ���", Font.PLAIN, 15));
		contentPane.add(MemoField);
		MemoField.setColumns(15);
		
		//string getText();
		
		JLabel PlaceLabel = new JLabel("내용 : ");
		PlaceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PlaceLabel.setBounds(76, 225, 113, 23);
		PlaceLabel.setFont(new Font("���ʷҵ���", Font.BOLD, 17));
		contentPane.add(PlaceLabel);
		
		PlaceField = new JTextField();
		PlaceField.setBounds(186, 225, 146, 26);
		PlaceField.setFont(new Font("���ʷҵ���", Font.PLAIN, 15));
		contentPane.add(PlaceField);
		PlaceField.setColumns(15);
		
		HoliCheckBox = new JCheckBox("기념일");
		HoliCheckBox.setFont(new Font("���ʷҵ���", Font.BOLD, 17));
		HoliCheckBox.setHorizontalAlignment(SwingConstants.RIGHT);
		HoliCheckBox.setBounds(261, 8, 131, 27);
		contentPane.add(HoliCheckBox);
		
		NoButton = new JButton("취소");
		NoButton.setBounds(227, 280, 105, 27);
		contentPane.add(NoButton);
		NoButton.addActionListener(listener);
		
		OkButton = new JButton("확인");
		OkButton.setBounds(84, 280, 105, 27);
		contentPane.add(OkButton);
		
		DayField = new JTextField();
		DayField.setEditable(false);
		DayField.setHorizontalAlignment(SwingConstants.CENTER);
		DayField.setFont(new Font("���ʷҵ���", Font.PLAIN, 17));
		DayField.setColumns(15);
		DayField.setBounds(186, 52, 146, 26);
		System.out.println("Ȯ�ο�"+this.day);
		System.out.println("��(0~11, 0:1��): " + (today.get(Calendar.MONTH) + 1));

		//Calendar.MONTH=(Month+1);
		DayField.setText(day1);
		System.out.println("�߰��� ��¥"+DayField.getText());
		contentPane.add(DayField);
		
		
		OkButton.addActionListener(listener);
		

	}
//	class Memobutton{
//	public void MemoCreate() {
//		MButtons=new JButton[list.size()];
//		
//	}
//	}
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
 						
 						DiaryTable.insert(id1 ,String.valueOf(DayField.getText()),String.valueOf(MemoField.getText()),String.valueOf(PlaceField.getText()),time[3],1);
 					
 					else
 						DiaryTable.insert(id1 ,day1,String.valueOf(MemoField.getText()),String.valueOf(PlaceField.getText()),time[3],0);
        			 JOptionPane.showMessageDialog(null, "추가 완료!");
        			 list.add(MemoField.getText());
        			 dispose();
             		Calendar3 frame = new Calendar3(id1,"");
   
                 	//frame.setList(list); 
                 	Calendar3.Memobutton mebt=frame.new Memobutton();
         			mebt.MemoCreate();
                 	Calendar3.Daybutton daybt = frame.new Daybutton();
         			daybt.buttonCreate();
                 	daybt.setButton("로그아웃");
                 	frame.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "잘못된 입력입니다.");
					e1.printStackTrace(); //�ߺ���

					
				}
            		
                	
            	}
            	else
            		JOptionPane.showMessageDialog(null, "ㅇㅇㅇ.");
            	
            	
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
