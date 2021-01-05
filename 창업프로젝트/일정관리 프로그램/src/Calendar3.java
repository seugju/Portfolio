import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Calendar3 extends JFrame {
	
	ArrayList<String> list= new ArrayList<>();
	ArrayList<JButton> btn_list = new ArrayList<>();
	
	//final Component MemoFiled = null;
	public ArrayList<String> getList(){return this.list;}
	public ArrayList<JButton> getBtnList(){return this.btn_list;}
	
	public void setList(ArrayList<String> list) {this.list=list;}
	private JPanel contentPane;
	private JPanel contentPanel;
	   private JButton buttons[];
	   private JButton DButtons[];
	   private JButton btn[];
	   
	   private Calendar today = Calendar.getInstance();
	   private JButton bfmButton;
	   private JLabel YmLabel;
	   private JLabel TodayLabel;
	   private JButton afmButton;
	   private JPanel ButtonPanel;
	   private JPanel MemoPanel;
	   private JButton afyButton;
	   private JButton bfyButton;
	   private JButton addButton;
	   private JButton modbutton;
	   private JButton delbutton;
	   private JButton allButton;
	   private JButton Loginbutton;
	   private JButton Joinbutton;
	   private String id1= "";
	   private String day1="";
	   private String day2="";
	   private String memo1="";
//	   public JTextArea MemoArea;
	   DefaultTableModel model;
	 //  private String x = "";
	   
	   int Year = this.today.get(Calendar.YEAR);
		int Month = this.today.get(Calendar.MONTH);
		int Date=today.get(Calendar.DAY_OF_MONTH); 
		int FirstDate = today.get(Calendar.DAY_OF_WEEK);
		
		//�� ��¥
		int check=0;
		int check2=0;
		int check3= 0;
		int check4=0;
		int day=0;
		
		
		
		Calendar cal;
		Daybutton daybt=new Daybutton();
		Memobutton mebt = new Memobutton();
		ButtonListener listener = new ButtonListener();
		private JTable table;
		ArrayList<String> places;
	public Calendar3(String id, String memo) {
		setTitle("\uC77C\uC815\uAD00\uB9AC \uD504\uB85C\uADF8\uB7A8");

		id1=id;
		memo1=memo;
		
		
		
		
		
		
		
		
			
	      this.today.set(Year,Month, 1);
	      System.out.println("qwds"+Calendar.DAY_OF_WEEK);
	     
	      System.out.println("����ð� " + this.today.getTime());
	      System.out.println("�̹���" + today.get(Calendar.MONTH));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		MemoPanel = new JPanel();
		MemoPanel.setBounds(517, 33, 346, 430);
		contentPane.add(MemoPanel);
		MemoPanel.setLayout(null);
		
//		MemoArea = new JTextArea("");
//		MemoArea.setBounds(14, 0, 318, 379);
//		MemoPanel.add(MemoArea);
		//MemoArea.getText();
	//	MemoArea.getColumns();

		addButton = new JButton("추가");
		addButton.setEnabled(false);
		addButton.setBounds(14, 391, 85, 27);
		MemoPanel.add(addButton);
		addButton.addActionListener(listener);
		
		modbutton = new JButton("수정");
		modbutton.setEnabled(false);
		modbutton.setBounds(131, 392, 85, 27);
		MemoPanel.add(modbutton);
		modbutton.addActionListener(listener);
		
		delbutton = new JButton("삭제");
		delbutton.setEnabled(false);
		delbutton.setBounds(247, 391, 85, 27);
		MemoPanel.add(delbutton);
		delbutton.addActionListener(listener);
		
		contentPanel = new JPanel();
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBounds(14, 49, 318, 323);
		MemoPanel.add(contentPanel);
		contentPanel.setLayout(null);
		
		table = new JTable(model);
		table.setShowGrid(false);
		table.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 17));
		table.setBounds(0, 1, 318, 322);
		table.setModel(new DefaultTableModel(
			new Object[][] {

			},
			new String[] {
				"Memo"
			}
		));
		contentPanel.add(table);
		model = new DefaultTableModel();
		table.setRowHeight(25);

		
		TodayLabel = new JLabel("");
		TodayLabel.setFont(new Font("경기천년제목 Medium", Font.BOLD, 15));
		TodayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TodayLabel.setBounds(14, 19, 318, 18);
		MemoPanel.add(TodayLabel);
		TodayLabel.setText(Year+" / "+(Month+1)+" / "+Date);
		
		
		JPanel CalPanel = new JPanel();
		CalPanel.setBounds(0, 33, 518, 430);
		contentPane.add(CalPanel);
		CalPanel.setLayout(null);
		
		bfmButton = new JButton("<");
		
		bfmButton.setBounds(103, 10, 65, 27);
		CalPanel.add(bfmButton);

		bfmButton.addActionListener(listener);
		
		 afmButton = new JButton(">");
		 afmButton.setBounds(347, 10, 65, 27);
		 CalPanel.add(afmButton);

		 afmButton.addActionListener(listener);
		
		bfyButton = new JButton("<<");
		
		bfyButton.setBounds(0, 10, 90, 27);
		CalPanel.add(bfyButton);
		bfyButton.addActionListener(listener);
		
		afyButton = new JButton(">>");
		afyButton.setBounds(426, 10, 90, 27);
		CalPanel.add(afyButton);
		afyButton.addActionListener(listener);
		
		JPanel WeekPanel = new JPanel();
		WeekPanel.setBounds(0, 61, 518, 42);
		CalPanel.add(WeekPanel);
		WeekPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 58, 5));
		
		JLabel SunLabel = new JLabel("일");
		SunLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SunLabel.setFont(new Font("경기천년제목 Light", Font.BOLD, 17));
		SunLabel.setForeground(Color.RED);
		WeekPanel.add(SunLabel);
		
		JLabel MonLabel = new JLabel("월");
		MonLabel.setFont(new Font("경기천년제목 Light", Font.BOLD, 17));
		WeekPanel.add(MonLabel);
		
		JLabel TueLabel = new JLabel("화");
		TueLabel.setFont(new Font("경기천년제목 Light", Font.BOLD, 17));
		WeekPanel.add(TueLabel);
		
		JLabel WedLabel = new JLabel("수");
		WedLabel.setFont(new Font("경기천년제목 Light", Font.BOLD, 17));
		WeekPanel.add(WedLabel);
		
		JLabel ThrLabel = new JLabel("목");
		ThrLabel.setFont(new Font("경기천년제목 Light", Font.BOLD, 17));
		WeekPanel.add(ThrLabel);
		
		JLabel FriLabel = new JLabel("금");
		FriLabel.setFont(new Font("경기천년제목 Light", Font.BOLD, 17));
		WeekPanel.add(FriLabel);
		
		JLabel SatLabel = new JLabel("토");
		SatLabel.setFont(new Font("경기천년제목 Light", Font.BOLD, 17));
		SatLabel.setForeground(Color.BLUE);
		WeekPanel.add(SatLabel);
		
		
		ButtonPanel = new JPanel();
		ButtonPanel.setBounds(-1, 103, 518, 265);
		CalPanel.add(ButtonPanel);
		
		 ButtonPanel.setLayout(new GridLayout(0,7,10,10));
		 
		 allButton = new JButton("모든 일정 보기");
		 allButton.setEnabled(false);

		 allButton.setBounds(189, 391, 149, 27);
		 CalPanel.add(allButton);
		 allButton.addActionListener(listener);


		 YmLabel = new JLabel("2019년 11월");
		 YmLabel.setText(Year+"년 "+(Month+1)+"월");
		 YmLabel.setFont(new Font("경기천년제목V Bold", Font.BOLD, 19));
		 YmLabel.setBounds(0, 10, 518, 27);
		 YmLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 CalPanel.add(YmLabel);
		 
		 JPanel TodayPanel = new JPanel();
		 TodayPanel.setBounds(0, 0, 863, 34);
		 contentPane.add(TodayPanel);
		 TodayPanel.setLayout(null);
		 
		 
		 Loginbutton = new JButton("로그인");
		 Loginbutton.setForeground(Color.BLUE);
		 Loginbutton.setBounds(707, 5, 89, 27);
		 TodayPanel.add(Loginbutton);
		 Loginbutton.setContentAreaFilled(false);
		 Loginbutton.setBorderPainted(false);
		 Loginbutton.setFocusPainted(false);
		 Font font = Loginbutton.getFont();
		 Map attributes = font.getAttributes();
		 attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		 Loginbutton.setFont(font.deriveFont(attributes));
		 Loginbutton.addActionListener(listener);
		 
		 
		 Joinbutton = new JButton("회원가입");
		 Joinbutton.setForeground(Color.BLUE);
		 Joinbutton.setBounds(774, 5, 89, 27);
		 TodayPanel.add(Joinbutton);
		 Joinbutton.setContentAreaFilled(false);
		 Joinbutton.setBorderPainted(false);
		 Joinbutton.setFocusPainted(false);
		 font = Joinbutton.getFont();
		 attributes = font.getAttributes();
		 attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		 Joinbutton.setFont(font.deriveFont(attributes));
		 Joinbutton.addActionListener(listener);
		 
		 
		
	}
	

//	public void textAreaAppend() {
//		MButtons[list.size()].setText("");
//		Iterator<String> itr= list.iterator();
//		
//		while(itr.hasNext()) {
//			String data=itr.next();
//			MemoArea.append("- "+data+"\n");
//			
//		}
//	}
	
	
	class Daybutton {
		 public void buttonCreate() {
			 int TempDate;
			 Calendar calendar = Calendar.getInstance();
			 int FirstDate = today.get(Calendar.DAY_OF_WEEK);
			 int MaxDate = today.getActualMaximum(Calendar.DAY_OF_MONTH); 
			 int Month = today.get(Calendar.MONTH);
			 int Year=today.get(Calendar.YEAR);
			 System.out.println("222/"+Calendar.DAY_OF_WEEK);
			 
			 int Months = calendar.get(Calendar.MONTH);
			 int Dates=calendar.get(Calendar.DATE);
			 int Years=calendar.get(Calendar.YEAR);
//			 FirstDate = today.get(Calendar.DAY_OF_WEEK);
//			 MaxDate = today.getActualMaximum(Calendar.DAY_OF_MONTH);
//			 Month = today.get(Calendar.MONTH);
			 
			 Dates=calendar.get(Calendar.DATE); 
			 Months = calendar.get(Calendar.MONTH);
			 Years=calendar.get(Calendar.YEAR);
			 
			 System.out.println("f/"+FirstDate);
		 buttons = new JButton[ MaxDate + ( FirstDate-1 ) ]; //��ü ��¥ + (1���� ����(0-6)�� ���ڿ��� 1�� �A ��)
		 
		 System.out.println("/"+FirstDate);
		 

		 
		 
		 
	      for(int i = 0;i < buttons.length;i++) {
	    	  
	    	  TempDate = i - (FirstDate-2);
	    	  day=TempDate;
		         buttons[i] = new JButton(TempDate + "");
		         ButtonPanel.add(buttons[i]);
		         buttons[i].setFont(new Font("경기천년제목 Light", Font.PLAIN, 17));
		         buttons[i].addActionListener(listener);
		       //  buttons[i].getText();
		        // buttons[i].setBackground(Color.WHITE);
		        // ResultSet rs;
		  		try {
		  			ResultSet rs = DiaryTable.selectid(id1);
		  			
		  			while(rs.next()) {
		  				String day1= rs.getString("day");
		  				String memo1 = rs.getString("memo");
		  				Integer anniver1=rs.getInt("anniver");

		  				System.out.println("����"+day1+memo1+anniver1);
		 				TodayLabel.setText(Year+" / "+(Month+1)+" / "+buttons[i].getText());
		 				//System.out.println(day1+"//"+TodayLabel.getText());
		 				String day2[] = String.valueOf(day1).split("/",2);
//	         			
	         			for(int j=0; j<day2.length; j++)
	     					System.out.println(j+"��° ���� : " +day2[j]);
	         			
	         			String day3[] = String.valueOf(TodayLabel.getText()).split("/",2);
//	         			
	         			for(int z=0; z<day3.length; z++)
	     			//		System.out.println(z+"��° ���� fff: " +day3[z]);
		 				 if(day2[1].equals(day3[1])&&anniver1==1) {
		 					 System.out.println("����� ǥ��");
		 					buttons[i].setFont(new Font("경기천년제목 Light", Font.BOLD, 17));
		 					buttons[i].setForeground(Color.MAGENTA);
		 					
		 				 }
		 				
//	         			sql = "select * from diary where day like ?"
//	         			rs.setString(1, "%"+"11/28");
		 				
		 				
//		 				
//	         			System.out.println(TodayLabel.getText());
	         		//	DayField.setText(day2[0]+" / "+day2[1]+" / "+day2[3]);
	         			//System.out.println(DayField.getText());
		 				
		 				
		 				if(day1.equals(TodayLabel.getText())) {
		 					System.out.println("dddddd"+TodayLabel.getText()+"////"+day1);
		 					buttons[i].setFont(new Font("경기천년제목 Light", Font.BOLD, 17));
		 					//buttons[i].setForeground(Color.MAGENTA);
							
		 					TodayLabel.setText(Year+" / "+(Month+1)+" / "+Date);	
						}
		 				
		 				
		  			}
		  			

		  		} catch (SQLException e) {
		  			// TODO Auto-generated catch block
		  			e.printStackTrace();
		  		}
					


		         
		         
		         
		         
	    	  if(i==0) {
	    	      Color color = new Color(255,0,0);
	    	      buttons[i].setForeground(color);
	    	  }
	    	  if(i%7==0) {
	    		  Color color = new Color(255,0,0);
	    	      buttons[i].setForeground(color);
	    	  }
	    	  if(i==6||i==13||i==20||i==27||i==34) {
	    		  
	    		  Color color = new Color(0,0,255);
	    	      buttons[i].setForeground(color);
	    	  }
	    	  if(TempDate <= 0) {
		            buttons[i].setVisible(false);
		         	}
	    	  if(Years==Year&&Months==Month) {
	    	  if(i==(Dates+FirstDate-2)) {
	    		  buttons[i].setFont(new Font("경기천년제목 Light", Font.BOLD, 17));
	    		 // buttons[i].setText("*"+(i-FirstDate+2));
	    		  //buttons[i].setForeground(Color.MAGENTA);
	    		 buttons[i].setContentAreaFilled(false);
	    		
	    		 //buttons[i].setBorderPainted(false);
	    	  }

	    	  }
	    	  }




		 }

		public void setButton(String string) {
			// TODO Auto-generated method stub
			Loginbutton.setText(string);
			System.out.println(Loginbutton.getText());
			if(Loginbutton.getText().equals("로그아웃")) {
				
					addButton.setEnabled(true);
					 modbutton.setEnabled(true);
					 delbutton.setEnabled(true);
					 allButton.setEnabled(true);
				
				 
			 }
			else {
			addButton.setEnabled(false);
			modbutton.setEnabled(false);
			 delbutton.setEnabled(false);
			 allButton.setEnabled(false);
			}
		}
	 }
	
	class Memobutton{
	
	public void MemoCreate() {
		DButtons=new JButton[list.size()];
		int i=0;
		Iterator<String> itr= list.iterator();
		
		while(itr.hasNext()) {
			String data=itr.next();
			//MemoArea.append("- "+data+"\n");
			
		     DButtons[i] = new JButton("- "+data);
		     DButtons[i].setContentAreaFilled(false);
		     DButtons[i].setBorderPainted(false);
		     contentPanel.add(DButtons[i]);
		     DButtons[i].setHorizontalAlignment(SwingConstants.LEFT);
		     DButtons[i].setFont(new Font("���ʷҵ���", Font.BOLD, 15));
		     DButtons[i].addActionListener(listener);
		     i++;
		}
			
	}
		
			//MemoPanel.add(MButtons[list.size()]);
			
		}
	


	public void setDay(int day) {this.day=day;}
	public int getDay() {return this.day;}
	public class ButtonListener implements ActionListener{
        
        public void actionPerformed(ActionEvent e) {
           for(int i=0; i<buttons.length; i++) {
        	   int j=0;
        	   if(e.getSource()==buttons[i]) {
        		  // model.setNumRows(0);
        		   setDay(i);
        		   System.out.println("��ư Ŭ�� ��¥"+TodayLabel);
                   TodayLabel.setText(Year+" / "+(Month+1)+" / "+buttons[i].getText());
                  
                  if(check>0 ||check==1 && check2==0 && check2>1) {
                       TodayLabel.setText((Year+check3-check4)+" / "+((Month-check)+1)+" / "+buttons[i].getText());

            if(check==1 && check2==1) {      
                  TodayLabel.setText((Year+check3-check4)+" / "+(Month+1)+" / "+buttons[i].getText());
            }
//               if(check==1 && check2==0 && check2>1) {
//
//                   YmLabel.setText((Year+check3-check4)+"�� "+((Month+check)+1)+"��");
//                   
//                } 
               if(check>1) {
                TodayLabel.setText((Year+check3-check4)+" / "+((Month-check+check2)+1)+" / "+buttons[i].getText());
               }                
            }
           if(check2>0 ||check2==1 && check==0 ) {
                 TodayLabel.setText((Year+check3-check4)+" / "+((Month+check2)+1)+" / "+buttons[i].getText());
              if(check==1 && check2==1 ) {

                  TodayLabel.setText((Year+check3-check4)+" / "+((Month)+1)+" / "+buttons[i].getText());
               }
//              if(check2==1 && check==0) {
//              
//               YmLabel.setText((Year+check3-check4)+"�� "+((Month+check2)+1)+"��");
//               
//               
//              }
              if(check2>=1 && check >1) {
              TodayLabel.setText((Year+check3-check4)+" / "+((Month-check+check2)+1)+" / "+buttons[i].getText());

              }
              
              
           }  
    	   if(check3>0) {
    		   TodayLabel.setText((Year+check3-check4)+" / "+(Month+1)+" / "+buttons[i].getText());
	   				

	   				if(check>=0) {
	     
  	   			TodayLabel.setText((Year+check3-check4)+" / "+((Month-check)+1)+" / "+buttons[i].getText());
  	   			
  	  		   		if(check==1 && check2==1 ) {

  			   			TodayLabel.setText((Year+check3-check4)+" / "+(Month+1)+" / "+buttons[i].getText());
  	
  			   				
  			   			}
  	  		   		if(check2==1 && check==0) {

  		   			TodayLabel.setText((Year+check3-check4)+" / "+((Month+check2)+1)+" / "+buttons[i].getText());
	
  	  		   		}
  	  		   		if(check2>=1 && check >1) {

  		   			TodayLabel.setText((Year+check3-check4)+" / "+((Month-check+check2)+1)+" / "+buttons[i].getText());
  		   				
  	  		   		}
	   				}
	   			if(check2>0  ) {
     		   
		   			
		   				TodayLabel.setText((Year+check3-check4)+" / "+((Month+check2)+1)+" / "+buttons[i].getText());
		   				
		   		if(check==1 && check2==1 ) {

		   				TodayLabel.setText((Year+check3-check4)+" / "+((Month)+1)+" / "+buttons[i].getText());
		   			
		   				
		   			}
		   		if(check2==1 && check==0) {
		   			TodayLabel.setText((Year+check3-check4)+" / "+((Month+check2)+1)+" / "+buttons[i].getText());

	   				
		   		}
		   		if(check2>=1 && check >1) {
		   			TodayLabel.setText((Year+check3-check4)+" / "+((Month-check+check2)+1)+" / "+buttons[i].getText());
	   	
	   				
		   		}
	   			}
	   				
    	   }
    	   if(check3>0) {

	   				TodayLabel.setText((Year+check3-check4)+" / "+(Month+1)+" / "+buttons[i].getText());
	   				if(check>=0) {
	     		   		
	   				TodayLabel.setText((Year+check3-check4)+" / "+((Month-check)+1)+" / "+buttons[i].getText());
 	   				
 	  		   		if(check==1 && check2==1 ) {

 	  		   		TodayLabel.setText((Year+check3-check4)+" / "+(Month+1)+" / "+buttons[i].getText());

 			   				
 			   			}
 	  		   		if(check2==1 && check==0) {

 		   				
 		   			TodayLabel.setText((Year+check3-check4)+" / "+((Month+check2)+1)+" / "+buttons[i].getText());

 		   				
 	  		   		}
 	  		   		if(check2>=1 && check >1) {
 	  		 
 		   			TodayLabel.setText((Year+check3-check4)+" / "+((Month-check+check2)+1)+" / "+buttons[i].getText());
 		   				
 	  		   		}
	   				}
	   			if(check2>0  ) {

		   				TodayLabel.setText((Year+check3-check4)+" / "+((Month+check2)+1)+" / "+buttons[i].getText());

		   		if(check==1 && check2==1 ) {

	   				TodayLabel.setText((Year+check3-check4)+" / "+((Month)+1)+" / "+buttons[i].getText());
	   				
	   				
	   			}
		   		if(check2==1 && check==0) {
		   	
   				TodayLabel.setText((Year+check3-check4)+" / "+((Month+check2)+1)+" / "+buttons[i].getText());
 
		   		}
		   		if(check2>=1 && check >1) {

   				TodayLabel.setText((Year+check3-check4)+" / "+((Month-check+check2)+1)+" / "+buttons[i].getText());
   				
   				
		   		}
	   			}
	   				
  	   }
    	   if(check4>0) {
		   		
	   				TodayLabel.setText((Year+check3-check4)+" / "+(Month+1)+" / "+buttons[i].getText());
	   				if(check>0) {
	     		
 	   			TodayLabel.setText((Year+check3-check4)+" / "+((Month-check)+1)+" / "+buttons[i].getText());
 	  		   		if(check==1 && check2==1 ) {
 	  		   			TodayLabel.setText((Year+check3-check4)+" / "+((Month)+1)+" / "+buttons[i].getText());
 			   	
 			   			}
 	  		   		if(check2==1 && check==0) {
 	  		   		TodayLabel.setText((Year+check3-check4)+" / "+((Month+check2)+1)+" / "+buttons[i].getText());
 		   		
 		   				
 	  		   		}
 	  		   		if(check2>=1 && check >1) {
 	  		   		TodayLabel.setText((Year+check3-check4)+" / "+((Month-check+check2)+1)+" / "+buttons[i].getText());
 		   				
 		   				
 	  		   		}
	   				}
	   			if(check2>0  ) {
	   				TodayLabel.setText((Year+check3-check4)+" / "+((Month+check2)+1)+" / "+buttons[i].getText());
		   		


		   		if(check==1 && check2==1 ) {

		   			TodayLabel.setText((Year+check3-check4)+" / "+((Month)+1)+" / "+buttons[i].getText());
	   				
	   				
	   			}
		   		if(check2==1 && check==0) {
		   			TodayLabel.setText((Year+check3-check4)+" / "+((Month+check2)+1)+" / "+buttons[i].getText());
	   			
		   		}
		   		if(check2>=1 && check >1) {
		   			TodayLabel.setText((Year+check3-check4)+" / "+((Month-check+check2)+1)+" / "+buttons[i].getText());
   			
		   		}
	   			}
	   				
   	   }
       


   				try {
   				 day1=TodayLabel.getText();
   				 
	   				DefaultTableModel model = (DefaultTableModel) table.getModel();
					//int row1=table.getSelectedRow();
					//String memo1 = (String) table.getValueAt(row1, 0);
					//DiaryTable.delete(memo1, id1);
					//String memo1 = rs.getString("memo");
					System.out.println(memo1);
		        	   int row=table.getSelectedRow();
		       			int column=table.getSelectedColumn();
		       			Search frame=new Search(id1,"");
			        	ResultSet rs = DiaryTable.selectday(day1, id1);
			        	model.fireTableRowsDeleted(0, table.getRowCount());
		       			model.setNumRows(0);
		       			int row11=0;
		       		 places=new ArrayList<>();

			        	while(rs.next()) {
			        		System.out.println("while ans");
			        		System.out.println("row 11 :"+row11);
			        		String memo = rs.getString("memo");
			        		String place = rs.getString("place");
			        		Integer anniver1=rs.getInt("anniver");
			        		
			        		 String day2[] = String.valueOf(day1).split("/",2);
		                     
		                     for(int w=0; w<day2.length; w++)
		                       System.out.println(w+"��° ���� : " +day2[w]);

			        		
			        		if(row11==table.getRowCount())
			        			model.addRow(new Object[] {null});
			        		if(day1.contains(day2[1])&&anniver1==1) {
			        			model.addRow(new Object[] {null});
			        		}
			        		table.setValueAt(memo, row11, 0);
			        		places.add(place);
			        		
		                       
		                       j++;
		                       

			        		row11++;
			        	}
			        //	System.out.println("Ŭ���� ��¥�� �˷���"+day1);
			        	
		   				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
        		   System.out.println(day1);
        		   
               }

            	   
        		   
        	   }
           
           
           if(e.getSource()==bfmButton) {
        	   afmButton.setVisible(true);
        	   ButtonPanel.removeAll();
        	   check++;
        	   if(check>0 ) {
                   ButtonPanel.removeAll();
                        today.set((Year+check3-check4), (Month-check),1);
                         daybt.buttonCreate();
                         YmLabel.setText((Year+check3-check4)+"년 "+((Month-check)+1)+"월");
                         TodayLabel.setText((Year+check3-check4)+" / "+((Month-check)+1)+" / "+Date);
                         repaint();
                     
                      
        	   if(check==1 && check2==1) {
        		   ButtonPanel.removeAll();
       			   	today.set((Year+check3-check4), Month,1);
  		   				daybt.buttonCreate();
  		   				YmLabel.setText((Year+check3-check4)+"년 "+(Month+1)+"월");
  		   			
  		   				repaint();
  		   			if(Month==0) {
  		   			bfmButton.setVisible(false);
  		   			}
        	   }
  		   		if(check==1 && check2==0 && check2>1) {

 		   			ButtonPanel.removeAll();
 	        		 today.set((Year+check3-check4), (Month+check),1);
		   				daybt.buttonCreate();
		   				YmLabel.setText((Year+check3-check4)+"년 "+((Month+check)+1)+"월");
		   				
		   				repaint();
		   				if((Month+check)==0) {
		   					bfmButton.setVisible(false);
		  		   			}
		   			}
  		   		if(check>1) {
  		   		ButtonPanel.removeAll();
	        		 today.set((Year+check3-check4), (Month-check+check2),1);
	   				daybt.buttonCreate();
	   				YmLabel.setText((Year+check3-check4)+"년 "+((Month-check+check2)+1)+"월");
	   				
	   				repaint();
	   				if((Month-check+check2)==0) {
	   					bfmButton.setVisible(false);
	  		   			}
  		   		} 		   		
        	   }
           }
           
           if(e.getSource()==afmButton) {
        	   bfmButton.setVisible(true);
        	   ButtonPanel.removeAll();
        	   check2++;
        	   if(check2>0  ) {
        		   ButtonPanel.removeAll();
       			   	today.set((Year+check3-check4), (Month+check2),1);
  		   				daybt.buttonCreate();
  		   				YmLabel.setText((Year+check3-check4)+"년 "+((Month+check2)+1)+"월");
  		   			
  		   			
  		   				repaint();


  		   		if(check==1 && check2==1 ) {

 		   			ButtonPanel.removeAll();
 	        		 today.set((Year+check3-check4), (Month),1);
		   				daybt.buttonCreate();
		   				YmLabel.setText((Year+check3-check4)+"년 "+((Month)+1)+"월");
		   				
		   				repaint();
		   				if(Month==11) {
		   					afmButton.setVisible(false);
		  		   			}
		   				
		   			}
  		   		if(check2==1 && check==0) {
  		   		ButtonPanel.removeAll();
	        		 today.set((Year+check3-check4), (Month+check2),1);
	   				daybt.buttonCreate();
	   				YmLabel.setText((Year+check3-check4)+"년 "+((Month+check2)+1)+"월");
	   				
	   				repaint();
	   				if((Month+check2)==11) {
	   					afmButton.setVisible(false);
	  		   			}
	   				
  		   		}
  		   		if(check2>=1 && check >1) {
  		   		ButtonPanel.removeAll();
		   			
	        		 today.set((Year+check3-check4), (Month-check+check2),1);
	   				daybt.buttonCreate();
	   				YmLabel.setText((Year+check3-check4)+"년 "+((Month-check+check2)+1)+"월");
	   				
	   				repaint();
	   				if((Month-check+check2)==11) {
	   					afmButton.setVisible(false);
	  		   			}
	   				
  		   		}
  		   		
        	   }
           }
           
           if(e.getSource()==afyButton) {

        	   check3++;
        	   ButtonPanel.removeAll();
        	   if(check3>0) {
     		   		ButtonPanel.removeAll();
     		   		
   	        		 today.set((Year+check3-check4), Month,1);
   	   				daybt.buttonCreate();
   	   				YmLabel.setText((Year+check3-check4)+"년 "+(Month+1)+"월");
   	   			
   	   				repaint();
   	   				if(check>=0) {
   	     		   		ButtonPanel.removeAll();
   	     		   		
      	        		 today.set((Year+check3-check4), (Month-check),1);
      	   				daybt.buttonCreate();
      	   				YmLabel.setText((Year+check3-check4)+"년 "+((Month-check)+1)+"월");
      	   			
      	   				repaint();
      	  		   		if(check==1 && check2==1 ) {

      	 		   			ButtonPanel.removeAll();
      	 	        		 today.set((Year+check3-check4), (Month),1);
      			   				daybt.buttonCreate();
      			   				YmLabel.setText((Year+check3-check4)+"년 "+((Month)+1)+"월");
      			   			
      			   				repaint();
      			   				if(Month==11) {
      			   					afmButton.setVisible(false);
      			  		   			}
      			   				
      			   			}
      	  		   		if(check2==1 && check==0) {
      	  		   		ButtonPanel.removeAll();
      		        		 today.set((Year+check3-check4), (Month+check2),1);
      		   				daybt.buttonCreate();
      		   				YmLabel.setText((Year+check3-check4)+"년 "+((Month+check2)+1)+"월");
      		   			
      		   				repaint();
      		   				if((Month+check2)==11) {
      		   					afmButton.setVisible(false);
      		  		   			}
      		   				
      	  		   		}
      	  		   		if(check2>=1 && check >1) {
      	  		   		ButtonPanel.removeAll();
      		        		 today.set((Year+check3-check4), (Month-check+check2),1);
      		   				daybt.buttonCreate();
      		   				YmLabel.setText((Year+check3-check4)+"년 "+((Month-check+check2)+1)+"월");
      		   			
      		   				repaint();
      		   				if((Month-check+check2)==11) {
      		   					afmButton.setVisible(false);
      		  		   			}
      		   				
      	  		   		}
   	   				}
   	   			if(check2>0  ) {
         		   ButtonPanel.removeAll();
        			   	today.set((Year+check3-check4), (Month+check2),1);
   		   				daybt.buttonCreate();
   		   				YmLabel.setText((Year+check3-check4)+"년 "+((Month+check2)+1)+"월");
   		   			
   		   				repaint();


   		   		if(check==1 && check2==1 ) {

  		   			ButtonPanel.removeAll();
  	        		 today.set((Year+check3-check4), (Month),1);
 		   				daybt.buttonCreate();
 		   				YmLabel.setText((Year+check3-check4)+"년 "+((Month)+1)+"월");
 		   			
 		   				repaint();
 		   				if(Month==11) {
 		   					afmButton.setVisible(false);
 		  		   			}
 		   				
 		   			}
   		   		if(check2==1 && check==0) {
   		   		ButtonPanel.removeAll();
 	        		 today.set((Year+check3-check4), (Month+check2),1);
 	   				daybt.buttonCreate();
 	   				YmLabel.setText((Year+check3-check4)+"년 "+((Month+check2)+1)+"월");
 	   			
 	   				repaint();
 	   				if((Month+check2)==11) {
 	   					afmButton.setVisible(false);
 	  		   			}
 	   				
   		   		}
   		   		if(check2>=1 && check >1) {
   		   		ButtonPanel.removeAll();
 	        		 today.set((Year+check3-check4), (Month-check+check2),1);
 	   				daybt.buttonCreate();
 	   				YmLabel.setText((Year+check3-check4)+"년 "+((Month-check+check2)+1)+"월");
 	   			
 	   				repaint();
 	   				if((Month-check+check2)==11) {
 	   					afmButton.setVisible(false);
 	  		   			}
 	   				
   		   		}
   	   			}
   	   				
        	   }
        	   if(check3>0) {
    		   		ButtonPanel.removeAll();
    		   		
  	        		 today.set((Year+check3-check4), Month,1);
  	   				daybt.buttonCreate();
  	   				YmLabel.setText((Year+check3-check4)+"년 "+(Month+1)+"월");
  	   			
  	   				repaint();
  	   				if(check>=0) {
  	     		   		ButtonPanel.removeAll();
  	     		   		
     	        		 today.set((Year+check3-check4), (Month-check),1);
     	   				daybt.buttonCreate();
     	   				YmLabel.setText((Year+check3-check4)+"년 "+((Month-check)+1)+"월");
     	   			
     	   				repaint();
     	  		   		if(check==1 && check2==1 ) {

     	 		   			ButtonPanel.removeAll();
     	 	        		 today.set((Year+check3-check4), (Month),1);
     			   				daybt.buttonCreate();
     			   				YmLabel.setText((Year+check3-check4)+"년 "+((Month)+1)+"월");
     			   			
     			   				repaint();
     			   				if(Month==11) {
     			   					afmButton.setVisible(false);
     			  		   			}
     			   				
     			   			}
     	  		   		if(check2==1 && check==0) {
     	  		   		ButtonPanel.removeAll();
     		        		 today.set((Year+check3-check4), (Month+check2),1);
     		   				daybt.buttonCreate();
     		   				YmLabel.setText((Year+check3-check4)+"년 "+((Month+check2)+1)+"월");
     		   			
     		   				repaint();
     		   				if((Month+check2)==11) {
     		   					afmButton.setVisible(false);
     		  		   			}
     		   				
     	  		   		}
     	  		   		if(check2>=1 && check >1) {
     	  		   		ButtonPanel.removeAll();
     		        		 today.set((Year+check3-check4), (Month-check+check2),1);
     		   				daybt.buttonCreate();
     		   				YmLabel.setText((Year+check3-check4)+"년 "+((Month-check+check2)+1)+"월");
     		   			
     		   				repaint();
     		   				if((Month-check+check2)==11) {
     		   					afmButton.setVisible(false);
     		  		   			}
     		   				
     	  		   		}
  	   				}
  	   			if(check2>0  ) {
        		   ButtonPanel.removeAll();
       			   	today.set((Year+check3-check4), (Month+check2),1);
  		   				daybt.buttonCreate();
  		   				YmLabel.setText((Year+check3-check4)+"년 "+((Month+check2)+1)+"월");
  		   			
  		   				repaint();

  		   		if(check==1 && check2==1 ) {

 		   			ButtonPanel.removeAll();
 	        		 today.set((Year+check3-check4), (Month),1);
		   				daybt.buttonCreate();
		   				YmLabel.setText((Year+check3-check4)+"년 "+((Month)+1)+"월");
		   				
		   				repaint();
		   				if(Month==11) {
		   					afmButton.setVisible(false);
		  		   			}
		   				
		   			}
  		   		if(check2==1 && check==0) {
  		   		ButtonPanel.removeAll();
	        		 today.set((Year+check3-check4), (Month+check2),1);
	   				daybt.buttonCreate();
	   				YmLabel.setText((Year+check3-check4)+"년 "+((Month+check2)+1)+"월");
	   				
	   				
	   				repaint();
	   				if((Month+check2)==11) {
	   					afmButton.setVisible(false);
	  		   			}
	   				
  		   		}
  		   		if(check2>=1 && check >1) {
  		   		ButtonPanel.removeAll();
	        		 today.set((Year+check3-check4), (Month-check+check2),1);
	   				daybt.buttonCreate();
	   				YmLabel.setText((Year+check3-check4)+"년 "+((Month-check+check2)+1)+"월");
	   				
	   				repaint();
	   				if((Month-check+check2)==11) {
	   					afmButton.setVisible(false);
	  		   			}
	   				
  		   		}
  	   			}
  	   				
       	   }
           }
           if(e.getSource()==bfyButton) {

        	   check4++;
        	   ButtonPanel.removeAll();
        	   if(check4>0) {
     		   		ButtonPanel.removeAll();
     		   		
   	        		 today.set((Year+check3-check4), Month,1);
   	   				daybt.buttonCreate();
   	   				YmLabel.setText((Year+check3-check4)+"년 "+(Month+1)+"월");
   	   				repaint();
   	   				if(check>0) {
   	     		   		ButtonPanel.removeAll();
   	     		   		
      	        		 today.set((Year+check3-check4), (Month-check),1);
      	   				daybt.buttonCreate();
      	   				YmLabel.setText((Year+check3-check4)+"년 "+((Month-check)+1)+"월");
      	   				repaint();
      	  		   		if(check==1 && check2==1 ) {

      	 		   			ButtonPanel.removeAll();
      	 	        		 today.set((Year+check3-check4), (Month),1);
      			   				daybt.buttonCreate();
      			   				YmLabel.setText((Year+check3-check4)+"년 "+((Month)+1)+"월");
      			   				repaint();
      			   				if(Month==11) {
      			   					afmButton.setVisible(false);
      			  		   			}
      			   				
      			   			}
      	  		   		if(check2==1 && check==0) {
      	  		   		ButtonPanel.removeAll();
      		        		 today.set((Year+check3-check4), (Month+check2),1);
      		   				daybt.buttonCreate();
      		   				YmLabel.setText((Year+check3-check4)+"년 "+((Month+check2)+1)+"월");
      		   				repaint();
      		   				if((Month+check2)==11) {
      		   					afmButton.setVisible(false);
      		  		   			}
      		   				
      	  		   		}
      	  		   		if(check2>=1 && check >1) {
      	  		   		ButtonPanel.removeAll();
      		        		 today.set((Year+check3-check4), (Month-check+check2),1);
      		   				daybt.buttonCreate();
      		   				YmLabel.setText((Year+check3-check4)+"년 "+((Month-check+check2)+1)+"월");
      		   				repaint();
      		   				if((Month-check+check2)==11) {
      		   					afmButton.setVisible(false);
      		  		   			}
      		   				
      	  		   		}
   	   				}
   	   			if(check2>0  ) {
         		   ButtonPanel.removeAll();
        			   	today.set((Year+check3-check4), (Month+check2),1);
   		   				daybt.buttonCreate();
   		   				YmLabel.setText((Year+check3-check4)+"년 "+((Month+check2)+1)+"월");
   		   				repaint();


   		   		if(check==1 && check2==1 ) {

  		   			ButtonPanel.removeAll();
  	        		 today.set((Year+check3-check4), (Month),1);
 		   				daybt.buttonCreate();
 		   				YmLabel.setText((Year+check3-check4)+"년 "+((Month)+1)+"월");
 		   				repaint();
 		   				if(Month==11) {
 		   					afmButton.setVisible(false);
 		  		   			}
 		   				
 		   			}
   		   		if(check2==1 && check==0) {
   		   		ButtonPanel.removeAll();
 	        		 today.set((Year+check3-check4), (Month+check2),1);
 	   				daybt.buttonCreate();
 	   				YmLabel.setText((Year+check3-check4)+"년 "+((Month+check2)+1)+"월");
 	   				repaint();
 	   				if((Month+check2)==11) {
 	   					afmButton.setVisible(false);
 	  		   			}
 	   				
   		   		}
   		   		if(check2>=1 && check >1) {
   		   		ButtonPanel.removeAll();
 	        		 today.set((Year+check3-check4), (Month-check+check2),1);
 	   				daybt.buttonCreate();
 	   				YmLabel.setText((Year+check3-check4)+"년 "+((Month-check+check2)+1)+"월");
 	   				repaint();
 	   				if((Month-check+check2)==11) {
 	   					afmButton.setVisible(false);
 	  		   			}
 	   				
   		   		}
   	   			}
   	   				
        	   }
           }
           if(e.getSource()==addButton) {
        	   dispose();
        	   Add frame = new Add(id1, day1);
        	   
        	   frame.setList(list);
        	   
        	   System.out.println(getDay());
        	   
        	   
        	   frame.setVisible(true);
        	  // day=day+FirstDate-3;
           }

          // int i=1;

           if(e.getSource()==Loginbutton) {
        	   
        	   if(Loginbutton.getText().equals("로그아웃")) {
        		   dispose();
       			Calendar3 frame = new Calendar3("","");//�������ȿ��������޾Ƽ��ҷ�����
    			Calendar3.Daybutton daybt = frame.new Daybutton();
    			Calendar3.Memobutton mebt = frame.new Memobutton();
    			
    			mebt.MemoCreate();
    			daybt.buttonCreate();
    			addButton.setEnabled(true);
    			
    			
    			frame.setVisible(true);
    			daybt.setButton("로그인");
    			
    			
        	   }
        	   else {
        		   dispose();
            	   Login frame = new Login();
            	   frame.setVisible(true);
            	   
            	 //  addButton.setEnabled(false);
            	   
            	   
        	   }
           }
           if(e.getSource()==Joinbutton) {
        	   dispose();
        	   Join frame = new Join();
        	   frame.setVisible(true);
           }
           
	           if(e.getSource()==modbutton) {
	        	 if(table.getSelectedRow()<0) {
	        		 System.out.println("e�����;���");
	        		 Calendar3 frame = new Calendar3("","");//�������ȿ��������޾Ƽ��ҷ�����
	     			Calendar3.Daybutton daybt = frame.new Daybutton();
	     			Calendar3.Memobutton mebt = frame.new Memobutton();
	     			
	     			mebt.MemoCreate();
	     			daybt.buttonCreate();
	     			
	     			frame.setVisible(true);
	        	 }
	        	 else {
	        		 dispose();
		        	   int row=table.getSelectedRow();
		       			int column=table.getSelectedColumn();
		       			
		       			String memo=(String)table.getValueAt(row, column);
		        	   
		        	   Modify frame = new Modify(id1,getDay(), memo,places.get(row));

		       		   frame.setList(list);
		        	   
		        	   System.out.println(getDay());
		        	   System.out.println(memo);
		        	   
		        	   frame.setVisible(true);
		        	   
	        	 }
	        	   
	           }
	           if(e.getSource()==allButton) {
	        	   dispose();
	        	   Search frame=new Search(id1,"");
	        	   System.out.println("id2"+id1+memo1);
	        	   frame.setVisible(true);
	           }
	           if(e.getSource()==delbutton) {
	        	   
				try {

	   				DefaultTableModel model = (DefaultTableModel) table.getModel();
					int row1=table.getSelectedRow();
					String memo1 = (String) table.getValueAt(row1, 0);
					DiaryTable.delete(memo1, id1);
					//String memo1 = rs.getString("memo");
					System.out.println(memo1);
		        	   int row=table.getSelectedRow();
		       			int column=table.getSelectedColumn();
		       			Search frame=new Search(id1,"");
			        	ResultSet rs = DiaryTable.selectday(day1, id1);
			        	model.fireTableRowsDeleted(0, table.getRowCount());
		       			model.setNumRows(0);
		       			int row11=0;
			        	while(rs.next()) {
			        		System.out.println("while ans");
			        		System.out.println("row 11 :"+row11);
			        		String memo = rs.getString("memo");
			        		if(row11==table.getRowCount())
			        			model.addRow(new Object[] {null});
			        		table.setValueAt(memo, row11, 0);
			        		row11++;
			        	}
		   				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
   				



	       			
	           }
           for(int i=0; i<DButtons.length; i++) {
           if(e.getSource()==DButtons[i]) {
        	  System.out.println(DButtons[i].getText());

//        	   if(DButtons[i]!=null) {
//        		   DButtons[i].setBorderPainted(false);
//        	   }

        	 //  DButtons[i].setBorderPainted(true);
           }
           }


           
        }
	}
	public static void main(String[] args) {
			
			Calendar3 frame = new Calendar3("","");//�������ȿ��������޾Ƽ��ҷ�����
			Calendar3.Daybutton daybt = frame.new Daybutton();
			Calendar3.Memobutton mebt = frame.new Memobutton();
			
			mebt.MemoCreate();
			daybt.buttonCreate();
			
			frame.setVisible(true);
			

	}
}

