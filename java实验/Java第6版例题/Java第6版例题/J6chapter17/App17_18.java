//filename:App17_18.java
import java.sql.*;
public class App17_18
{
  private static String driver="com.mysql.jdbc.Driver";
  private static String url="jdbc:mysql://localhost/StudentScore?useSSL=false";
  private static String user="root";
  private static String password="";	
  public static void main(String[] args) 
  {
    Connection conn=null;
    CallableStatement cs=null;
    ResultSet rs=null;
    String callSql1="{call addStudent(?,?,?,?,?)}";
    String callSql2="{call getCount(?)}";
    String callSql3="{call addSub(?,?)}";
    try 
    {
      Class.forName(driver);
      conn=DriverManager.getConnection(url,user,password);
      cs=conn.prepareCall(callSql1);
      cs.setString(1,"201201009");
      cs.setString(2,"����");
      cs.setString(3,"��");
      cs.setInt(4, 18);
      cs.setString(5,"����");
      cs.execute();
      cs=conn.prepareCall(callSql2);
      //�������ע��getCount�洢����OUT����������
      cs.registerOutParameter(1, java.sql.Types.INTEGER);
      cs.execute();
      int total=cs.getInt(1);
      System.out.println("������Ϊ��"+total);
      int a=5;
      int b=3;
      cs=conn.prepareCall(callSql3);
      cs.setInt(1,a);
      cs.setInt(2,b);
      cs.registerOutParameter(1, java.sql.Types.INTEGER);
      cs.registerOutParameter(2, java.sql.Types.INTEGER);
      cs.execute();
      int sum=cs.getInt(1);
      int sub=cs.getInt(2);
      System.out.println(a+"��"+b+"�ĺͣ�"+sum+" , �"+sub);
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        if(cs!=null) cs.close();
        if(conn!=null) conn.close();
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
    }
  }
}
