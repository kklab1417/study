//filename��App12_11.java
import java.util.*;
public class App12_11
{
  public static void main(String[] args)
  {
    Map<String,String> hm=new HashMap<String,String>();
    hm.put("006","��  ɮ");
    hm.put("008","�����");
    hm.put("009","��˽�");
    hm.put("007","ɳ����");
    hm.put("010","������");
    System.out.println("��ϣӳ���е��������£�\n"+hm);
    String str=(String)hm.remove("010");
    Set keys=hm.keySet();
    Iterator it=keys.iterator();
    System.out.println("HashMap��ʵ�ֵ�Mapӳ�䣬����");
    while(it.hasNext())
    {
      String xh=(String)it.next();
      String name=(String)hm.get(xh);
      System.out.println(xh+"  "+ name);
    }
    TreeMap<String,String> tm=new TreeMap<String,String>();
    tm.putAll(hm);
    Iterator iter=tm.keySet().iterator();
    System.out.println("TreeMap��ʵ�ֵ�Mapӳ�䣬��ֵ����");
    while(iter.hasNext())
    {
      String xh=(String)iter.next();
      String name=(String)hm.get(xh);
      System.out.println(xh+"  "+ name);
    }
  }
}
