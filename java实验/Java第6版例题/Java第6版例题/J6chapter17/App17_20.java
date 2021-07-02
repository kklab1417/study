//filename:App17_20.java
import java.sql.*;
public class App17_20
{
  private static String driver="com.mysql.jdbc.Driver";
  private static String url="jdbc:mysql://localhost/StudentScore?useSSL=false";
  private static String user="root";
  private static String password="";	
  public static void main(String[] args)
  {
    Connection conn=null;
    Statement stmt=null;
    ResultSet rs=null;
    try
    {
      Class.forName(driver);
      conn=DriverManager.getConnection(url,user,password);
      String sql="SELECT * FROM Student WHERE dept='�����'";  
      stmt=conn.createStatement();
      rs=stmt.executeQuery(sql);
      ResultSetMetaData rsMetaData=rs.getMetaData();
      System.out.println("�ܹ��У�"+rsMetaData.getColumnCount()+"��");
      for(int i=1;i<=rsMetaData.getColumnCount();i++)
      {
        System.out.println("��"+i+":"+rsMetaData.getColumnName(i)+","+
                      rsMetaData.getColumnTypeName(i)+"("+
                      rsMetaData.getColumnDisplaySize(i)+")");
      }
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
        if(stmt!=null) stmt.close();
        if(conn!=null) conn.close();
      }
      catch(Exception e) 
      {
        e.printStackTrace();
      }
    }
  }
}
