//filename��App12_9.java
import java.util.*;
public class App12_9
{
  public static void main(String[] args)
  {
    HashSet<String> hs=new HashSet<String>();
    for(String a:args)
      if(!hs.add(a))
        System.out.println("Ԫ��"+a+"�ظ�");
    System.out.println("���ϵ�����Ϊ��"+hs.size()+"����Ԫ��Ϊ��");
    Iterator it=hs.iterator();
    while(it.hasNext())
      System.out.print(it.next()+"  ");
  }
}
