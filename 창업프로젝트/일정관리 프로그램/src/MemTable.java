
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MemTable {
   static Scanner scan = new Scanner(System.in);
   
   public static Connection makeConnection() { //172.29.148.139 �� ������  //172.29.190.49 ���� ������ ��� 0109
      //String url = "jdbc:mysql://172.29.190.49:3306/���ֽ�Ű��?serverTimezone=UTC";
      String url = "jdbc:mysql://localhost:3306/승주스키마?serverTimezone=UTC";
      final String id = "root";
      final String password = "0109";
      Connection con = null;
      
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         System.out.println("����̹� ���� ����");
         con = DriverManager.getConnection(url, id, password);
         System.out.println("�����ͺ��̽� ���� ����");
      } catch(ClassNotFoundException e) {
         System.out.println("JDBC ����̹� �ε� ����");
      } catch(SQLException e) {
         System.out.println("DB ���� ����");
      }
      return con;
   }
   
   public static void insert(String IdField, String PwField, String NicField) throws SQLException {

      Connection con = makeConnection();
      String sql = "INSERT mem_ber (id, pw, nic_name) VALUES(?, ?, ?)";
      PreparedStatement stmt = con.prepareStatement(sql);

          
      stmt.setString(1, IdField);
      stmt.setString(2, PwField);
      stmt.setString(3, NicField);

   //   selectAll(stmt);
      searchTuple(stmt,IdField);
      
      
      int rs = stmt.executeUpdate(); 
           
      stmt.close();
      con.close();
      System.out.println("���������� �߰��Ͽ����ϴ�.");
   }
   public static ResultSet selectAll() throws SQLException {
	   Connection con = makeConnection();
	   String sql = "select * from mem_ber";
	   PreparedStatement stmt=con.prepareStatement(sql);
	   ResultSet rs = stmt.executeQuery(sql);
	   
	   return rs;
	   
   }
   
   private static void searchTuple(PreparedStatement stmt, String IdField) throws SQLException{
	   ResultSet rs= stmt.executeQuery("select*from mem_ber where id="+"'"+IdField+"'");
	   
	   while (rs.next()) {
		   System.out.print(new String(rs.getString("id")));
		   System.out.print("\t|\t" + rs.getString("pw"));
		   System.out.println("\t|\t" + new String(rs.getString("nic_name")));
	   }
   }	
   public static void main(String[] args) throws SQLException {
//      insert(null, null, null);
//      //selectAll();
   }
}

