//filename:App17_19.java
import java.sql.*;
public class App17_19
{
  private static String driver="com.mysql.jdbc.Driver";
  private static String url="jdbc:mysql://localhost/StudentScore?useSSL=false";
  private static String user="root";
  private static String password="";
	
  public static void main(String[] args) 
  {
    try(Connection conn=DriverManager.getConnection(url,user,password);)
    {
      Class.forName(driver);
      DatabaseMetaData dmd=conn.getMetaData();
      System.out.println("���ݿ�����"+dmd.getDatabaseProductName());
      System.out.println("���ݿ�汾��"+dmd.getDatabaseProductVersion());
      System.out.println("������������"+dmd.getDriverName());
      System.out.println("���ݿ�URL��"+dmd.getURL());
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
