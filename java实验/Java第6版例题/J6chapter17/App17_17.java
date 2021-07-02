//filename:App17_17.java
import java.sql.*;
public class App17_17
{
  private static String driver="com.mysql.jdbc.Driver";
  private static String url="jdbc:mysql://localhost/StudentScore?useSSL=false";
  private static String user="root";
  private static String password="";	
  public static void main(String[] args) 
  {
    Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    String selectSql="SELECT * FROM Student WHERE dept=?";
    String insertSql="INSERT INTO Student(sNo,sName,sex,age,dept)"+
                   "VALUES(?,?,?,?,?);";
    String updateSql="UPDATE Student SET dept='����' WHERE sNo=?";
    String deleteSql="DELETE FROM Student WHERE sNo=?";
    try 
    {
      Class.forName(driver);	
      conn=DriverManager.getConnection(url,user,password);
      ps=conn.prepareStatement(selectSql);
      ps.setString(1, "�����");
      rs=ps.executeQuery();
      while(rs.next())
      {
        String no=rs.getString("sNo");
        String name=rs.getString("sName");
        String sex=rs.getString("sex");
        int age=rs.getInt("age");
        String dept=rs.getString("dept");
        System.out.println(no+"  "+name+"  "+sex+"  "+age+"  "+dept);
      }
      ps=conn.prepareStatement(insertSql);
      ps.setString(1, "201201009");
      ps.setString(2, "����");
      ps.setString(3, "��");
      ps.setInt(4, 18);
      ps.setString(5, "����");
      int count=ps.executeUpdate();
      System.out.println("���"+ count+"����¼��Student����");
      ps=conn.prepareStatement(updateSql);
      ps.setString(1, "201201009");
      count=ps.executeUpdate();
      System.out.println("�޸���Student���"+count+"����¼");
      ps=conn.prepareStatement(deleteSql);
      ps.setString(1, "201201009");
      count=ps.executeUpdate();
      System.out.println("ɾ����Student���"+count+"����¼");
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        if(rs!=null) rs.close();
        if(ps!=null) ps.close();
        if(conn!=null) conn.close();
      }
      catch(Exception e) 
      {
        e.printStackTrace();
      }
    }
  }
}
