//App9_5.java
public class App9_5
{
  static void check(String str1) throws NullPointerException
  {
    if(str1.length()>2)
    {
      str1=null;
      System.out.println(str1.length());
    }
    char ch;
    for (int i=0;i<str1.length();i++)
    {
      ch=str1.charAt(i);
      if(!Character.isDigit(ch))
        throw new NumberFormatException();
    }
  }
  public static void main(String[] args) throws Exception
  {
    int num;
    try
    {
      check(args[0]);
      num=Integer.parseInt(args[0]);
      if (num>60)
        System.out.println("�ɼ�Ϊ��"+num+"  ����");
      else 
        System.out.println("�ɼ�Ϊ��"+num+"  ������");
    }
    catch(NullPointerException e)
    {
      System.out.println("��ָ���쳣��"+e.toString());
    }    	
    catch (NumberFormatException ex)
    {
      System.out.println("����Ĳ���������ֵ����");
    }
    catch (Exception e)
    {
      System.out.println("��������û���ṩ����");
    }
  }
}
