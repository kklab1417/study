//filename��App12_4.java
class GeneralType<T extends Number>
{
  T obj;
  public GeneralType(T obj)
  {
    this.obj=obj;
  }
  public T getObj()
  {
    return obj;
  }
}
public class App12_4 
{
  public static void main(String[] args)
  {
    GeneralType<Integer> num=new GeneralType<Integer>(5);
    System.out.println("�����Ĳ����ǣ�"+num. getObj());
    //���������ǷǷ��ģ���Ϊʵ�ʲ���String����Number��Number������
    //GeneralType<String> s=new GeneralType<String>("Hello"); 
    //System.out.println("�����Ĳ����ǣ�"+s.getObj());
  }
}
