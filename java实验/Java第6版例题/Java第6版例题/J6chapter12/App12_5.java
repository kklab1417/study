//filename��App12_5.java
class GeneralType<T>
{
  T obj;
  public void setObj(T obj)
  {
    this.obj=obj;
  }
  public T getObj()
  {
    return obj;
  }
  public static void showObj(GeneralType<? extends String> o) 
  {
    System.out.println("������ֵ�ǣ�"+o.getObj());
  }
}
public class App12_5
{
  public static void main(String[] args)
  {
    GeneralType<String> n=new GeneralType<String>();
    n.setObj("��  ��");
    GeneralType.showObj(n);
    GeneralType<Double> num=new GeneralType<Double>();
    num.setObj(25.0);
    System.out.println("��ֵ��ֵ��"+num.getObj());
  }
}
