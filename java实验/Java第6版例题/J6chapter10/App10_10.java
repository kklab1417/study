//App10_10.java      RandomAccessFile���Ӧ��
import java.io.*;
public class App10_10
{
  public static void main(String args[]) throws IOException
  {
    StringBuffer stfDir=new StringBuffer();
    System.out.println("�������ļ����ڵ�·��");
    char ch;
    while((ch=(char)System.in.read())!='\r')
      stfDir.append(ch);
    File dir=new File(stfDir.toString());
    System.out.println("����������ȡ���ļ���");
    StringBuffer stfFileName=new StringBuffer();
    char c;
    while((c=(char)System.in.read())!='\r')
      stfFileName.append(c);
    stfFileName.replace(0,1,"");
    File readFrom=new File(dir,stfFileName.toString());
    if(readFrom.isFile() && readFrom.canWrite() && readFrom.canRead())
    {
      RandomAccessFile rafFile=new RandomAccessFile(readFrom,"rw");
      while(rafFile.getFilePointer()<rafFile.length())
        System.out.println(rafFile.readLine());
      rafFile.close();
    }
    else
      System.out.println("�ļ����ɶ���");
  }
}
