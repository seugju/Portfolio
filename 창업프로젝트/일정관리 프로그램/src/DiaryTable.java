import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DiaryTable {
	   static Scanner scan = new Scanner(System.in);
	   
	   public static Connection makeConnection() { 
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
	   
	   public static void insert(String id, String DayField, String MemoField, String PlaceField, String Timespinner, Integer HoliCheckBox) throws SQLException {

	      Connection con = makeConnection();
	      String sql = "INSERT INTO diary (id, day, memo, place, time, anniver) VALUES(?, ?, ?, ?, ?, ?)";
	      PreparedStatement stmt = con.prepareStatement(sql);
	          
	      stmt.setString(1, id);
	      stmt.setString(2, DayField);
	      stmt.setString(3, MemoField);
	      stmt.setString(4, PlaceField);
	      stmt.setString(5, Timespinner);
	      stmt.setInt(6, HoliCheckBox);

	      searchTupled(stmt,DayField);
	      searchTuplem(stmt,MemoField);
	      
	      int rs = stmt.executeUpdate();
	           
	      stmt.close();
	      con.close();
	      System.out.println("���������� �߰��Ͽ����ϴ�.");
	   }
	   public static void modify(String MemoField, String PlaceField, String Timespinner, Integer HoliCheckBox,String id1, String day1, String memo1) throws SQLException {
		   Connection con = makeConnection();
		   String sql = "update diary set memo="+"'"+MemoField+"',place="+"'"+PlaceField+"',time="+"'"+Timespinner+"',anniver="+""+HoliCheckBox+" where id = "+"'"+id1+"'and day="+"'"+day1+"'and memo="+"'"+memo1+"'";
//		   String sql = "update diary set memo=?, place=?, time=?, anniver=? where id = ? and day=? and memo=?";
		   System.out.println(sql);
		   PreparedStatement stmt=con.prepareStatement(sql);

//		      stmt.setString(1, DayField);
//		      stmt.setString(1, MemoField); 
//		      stmt.setString(2, PlaceField);
//		      stmt.setString(3, Timespinner);
//		      stmt.setInt(4, HoliCheckBox);
//		      stmt.setString(5, id1);
//		      stmt.setString(6, day1);
//		      stmt.setString(7, memo1);
		      
//		      stmt.setString(6, id);
//		      stmt.setString(7, day1);
//		      stmt.setString(8, memo1);
		      int rs= stmt.executeUpdate();
		   //return rs;
		      stmt.close();
		      con.close();
		      System.out.println("���������� �����Ͽ����ϴ�.");
		   
	   }
	   public static void delete(String MemoField,String id) throws SQLException {

		      Connection con = makeConnection();
		      String sql = "delete from diary where memo= "+"'"+MemoField+"'and id = "+"'"+id+"'";
		  
		      PreparedStatement stmt = con.prepareStatement(sql);
		          
//		      stmt.setString(1, id);
//		      stmt.setString(2, DayField);
//		      stmt.setString(1, MemoField);
//		      stmt.setString(4, PlaceField);
//		      stmt.setString(5, Timespinner);
//		      stmt.setInt(6, HoliCheckBox);
//
//		      searchTupled(stmt,DayField);
//		      searchTuplem(stmt,MemoField);
		    int rs =stmt.executeUpdate();
		        
		      stmt.close();
		      con.close();	
		      System.out.println("���������� �����Ͽ����ϴ�.");
		   }
	   
	   public static ResultSet selectAll() throws SQLException {
		   Connection con = makeConnection();
		   String sql = "select * from diary";
		   PreparedStatement stmt=con.prepareStatement(sql);
		   ResultSet rs = stmt.executeQuery(sql);
		   
		   return rs;
		   
	   }

	   public static ResultSet selectid(String id) throws SQLException {
		   Connection con = makeConnection();
		   String sql = "select * from diary where id = "+"'"+id+"'";
		   System.out.println("select * from diary where id = "+"'"+id+"'");
		   PreparedStatement stmt=con.prepareStatement(sql);
		   
		   ResultSet rs = stmt.executeQuery(sql);
		   
		   return rs;
		   
	   }
	   
	   public static ResultSet selectday(String day, String id) throws SQLException {
		   Connection con = makeConnection();
		   String sql = "select * from diary where day = "+"'"+day+"'and id = "+"'"+id+"'";
		   System.out.println(sql);
		   PreparedStatement stmt=con.prepareStatement(sql);
		   
		   ResultSet rs1 = stmt.executeQuery(sql);
		   
		   return rs1;
		   
	   }
	   
	   public static ResultSet selectmemo(String memo, String id) throws SQLException {
		   Connection con = makeConnection();
		   String sql = "select * from diary where memo = "+"'"+memo+"'and id = "+"'"+id+"'";
		   System.out.println(sql);
		   PreparedStatement stmt=con.prepareStatement(sql);
		   
		   ResultSet rs = stmt.executeQuery(sql);
		   
		   return rs;
		   
	   }
	   
	   private static void searchTupled(PreparedStatement stmt, String DayField) throws SQLException{
		   ResultSet rs= stmt.executeQuery("select*from diary where day="+"'"+DayField+"'");
		   
//		   while (rs.next()) {
//			   System.out.print(new String(rs.getString("id")));
//			   System.out.print("\t|\t" + new String(rs.getString("day")));
//			   System.out.println("\t|\t" + new String(rs.getString("memo")));
//			   System.out.println("\t|\t" + new String(rs.getString("place")));
//			   System.out.println("\t|\t" + new String(rs.getString("time")));
//		   }
	   }	
	   private static void searchTuplem(PreparedStatement stmt, String MemoField) throws SQLException{
		   ResultSet rs= stmt.executeQuery("select*from diary where memo="+"'"+MemoField+"'");
//		   
//		   while (rs.next()) {
//			   System.out.print(new String(rs.getString("id")));
//			   System.out.print("\t|\t" + new String(rs.getString("day")));
//			   System.out.println("\t|\t" + new String(rs.getString("memo")));
//			   System.out.println("\t|\t" + new String(rs.getString("place")));
//			   System.out.println("\t|\t" + new String(rs.getString("time")));
//		   }
	   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
