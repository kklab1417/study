//filename��App10_1.java
import java.io.*;
class App10_1
{
  public static void main(String[] args)
  {
    char ch;
    int data;
    try(
      FileInputStream fin =new FileInputStream(FileDescriptor.in);
      FileOutputStream fout =new FileOutputStream("D:/cgj/myfile.txt");
    )
    {
      System.out.println("������һ���ַ������� # ������");
      while ((ch=(char)fin.read())!='#')
        fout.write(ch);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("�ļ�û�ҵ���");
    }
    catch (IOException e) { }
    try(
     FileInputStream fin=new FileInputStream("D:/cgj/myfile.txt "); 
     FileOutputStream fout=new FileOutputStream(FileDescriptor.out);
    )
    {
      while (fin.available()>0)
      {
        data=fin.read();
        fout.write(data);
      }
    }
   catch (IOException e) { }
  }
}
