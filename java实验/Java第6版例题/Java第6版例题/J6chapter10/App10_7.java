//filename��App10_7.java
import java.io.*;
public class App10_7
{
  public static void main(String[] args) throws IOException
  {
    String thisLine;
    int count=0;
    try(
      FileReader fr=new FileReader("D:/java/test.txt");
      BufferedReader bfr=new BufferedReader(fr);
    )
    {
      while ((thisLine=bfr.readLine())!=null)
      {
        count++;
        System.out.println(thisLine);
      }
      System.out.println("����ȡ��"+count+"��");
    }
    catch (IOException ioe)
    {
      System.out.println("����! "+ioe);
    }
  }
}
