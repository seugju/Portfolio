import java.awt.CheckboxGroup;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import java.awt.Color;


public class Search extends JFrame {

	private JPanel contentPane;
	private JTextField SearchField;
	private JButton SearchButton;
	private JRadioButton DayRadioButton;
	private JRadioButton MemoradioButton;
	private JPanel panel;
	private JButton Okbutton;
	
	private String day1="";
	   private String id1= "";
	   private String memo2="";
	   private String memo1="";
	ButtonListener listener = new ButtonListener();
	CheckboxGroup cbg=new CheckboxGroup();
	ButtonGroup group=new ButtonGroup();
	private JTable table;
	DefaultTableModel model;
//	private CheckboxGroup group;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Search(String id, String memo) {
		id1=id;
		memo1=memo;
		//amemo2=memo;
		System.out.println("id3"+id1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		SearchField = new JTextField();
		
		SearchField.setToolTipText("yyyy / mm / dd");
		SearchField.setFont(new Font("����", Font.PLAIN, 17));
		SearchField.setBounds(14, 43, 250, 27);
		contentPane.add(SearchField);
		SearchField.setColumns(20);
		//SearchField.setText(day1);
		
		SearchButton = new JButton("검색");
		SearchButton.setBounds(278, 43, 90, 27);
		contentPane.add(SearchButton);
		SearchButton.addActionListener(listener);
		
		Okbutton = new JButton("확인");
		Okbutton.setBounds(147, 364, 90, 27);
		contentPane.add(Okbutton);
		Okbutton.addActionListener(listener);
		
		DayRadioButton = new JRadioButton("\uB0A0\uC9DC");
		DayRadioButton.setFont(new Font("����", Font.PLAIN, 17));
		DayRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		DayRadioButton.setBounds(45, 9, 68, 27);
		contentPane.add(DayRadioButton);
		
		MemoradioButton = new JRadioButton("\uB0B4\uC6A9");
		
		MemoradioButton.setHorizontalAlignment(SwingConstants.CENTER);
		MemoradioButton.setFont(new Font("����", Font.PLAIN, 17));
		MemoradioButton.setBounds(169, 9, 68, 27);
		contentPane.add(MemoradioButton);

		group.add(DayRadioButton);
		group.add(MemoradioButton);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(14, 81, 354, 270);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable(model);
		table.setFont(new Font("���õ������ Medium", Font.PLAIN, 17));
		table.setBounds(0, 1, 354, 322);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column"
			}
		));
		panel.add(table);
		model = new DefaultTableModel();
		table.setRowHeight(25);


	}




	public class ButtonListener implements ActionListener{
		
        public void actionPerformed(ActionEvent e) {
        	int j=0;
            if(e.getSource()==SearchButton) {
        		System.out.println("Ŭ����12222");
                
                try {
                	DefaultTableModel model = (DefaultTableModel) table.getModel();
                 ResultSet rs = DiaryTable.selectid(id1);
                
                 panel.removeAll();
                   panel.add(table);
                   
                   
                   panel.repaint();
                   model.fireTableRowsDeleted(0, table.getRowCount());
	       			model.setNumRows(0);
                 while(rs.next()) {
                      String memo1 = rs.getString("memo");
                      String day1 = rs.getString("day");
                      //if(memo1.contains(SearchField.getText())) {
                    	  System.out.println(id1+"�� memo ���� : "+memo1);
                          model.addRow(new Object[] {null});
                          table.setValueAt(day1+" : "+memo1, j, 0);
                          
                          
                          j++;
                      
                 }
                 } catch (SQLException e1) {
                     // TODO Auto-generated catch block
                     e1.printStackTrace();
                  }
            	
        		if(DayRadioButton.isSelected()) {
        			System.out.println("Ŭ����");
        			
        			day1=SearchField.getText();
//        			String day2[] = String.valueOf(SearchField.getText()).split("/");
//        			
//        			for(int i=0; i<day2.length; i++)
//    					System.out.println(i+"��° ���� : " +day2[i]);
//        			System.out.println(SearchField.getText());
//        			SearchField.setText(day2[0]+" / "+day2[1]+" / "+day2[3]);
//        			System.out.println(SearchField.getText());
        			
        			try {
        			
						DefaultTableModel model = (DefaultTableModel) table.getModel();
		                 ResultSet rs = DiaryTable.selectday(SearchField.getText(), id1);
		                
		                 panel.removeAll();
		                   panel.add(table);
		                   
		                   
		                   panel.repaint();
		                   model.fireTableRowsDeleted(0, table.getRowCount());
			       			model.setNumRows(0);
						while(rs.next()) {
        					String memo1 = rs.getString("memo");
        					System.out.println(id1+"�� memo ���� : "+memo1);
        					//textArea.append(memo1);
        					model.addRow(new Object[] {null});
        					table.setValueAt(memo1, j, 0);
        					
        					
        					j++;
						}
                        
                            
                            
                  
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

        		}
        		if(MemoradioButton.isSelected()) {
        			System.out.println("Ŭ����1111");
                    memo1=SearchField.getText();
                    try {
                    
                     DefaultTableModel model = (DefaultTableModel) table.getModel();
	                 ResultSet rs = DiaryTable.selectid(id1);
	                
	                 panel.removeAll();
	                   panel.add(table);
	                   
	                   
	                   panel.repaint();
	                   model.fireTableRowsDeleted(0, table.getRowCount());
		       			model.setNumRows(0);
                     while(rs.next()) {
                          String memo1 = rs.getString("memo");
                          String day1 = rs.getString("day");
                          if(memo1.contains(SearchField.getText())) {
                        	  System.out.println(id1+"�� memo ���� : "+memo1);
                              model.addRow(new Object[] {null});
                              table.setValueAt(day1+" : "+memo1, j, 0);
                              
                              
                              j++;
                          }
                             
                              
                          else
                             System.out.println("���ڿ�����");
                          //textArea.append(memo1);

                     }
                  } catch (SQLException e1) {
                     // TODO Auto-generated catch block
                     e1.printStackTrace();
                  }
        		}

        		
        		
            }
            if(e.getSource()==Okbutton) {
            	 dispose();
          		Calendar3 frame = new Calendar3(id1,"");

              	//frame.setList(list); 
              	Calendar3.Memobutton mebt=frame.new Memobutton();
      			mebt.MemoCreate();
              	Calendar3.Daybutton daybt = frame.new Daybutton();
      			daybt.buttonCreate();
              	daybt.setButton("로그아웃");
              	frame.setVisible(true);
            }

        }
	}
	public static void main(String[] args) {
		Search frame=new Search("","");
	}
}
