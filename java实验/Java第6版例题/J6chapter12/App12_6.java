//filename��App12_6.java
public class App12_6<T>
{
  private T[] array;
  public void setT(T[] array)
  {
    this.array=array;
  }
  public T[] getT()
  {
    return array;
  }
  public static void main(String[] args)
  {
    App12_6<String> a=new App12_6<String>();
    String[] array={"��ɫ","��ɫ","��ɫ","��ɫ","��ɫ","��ɫ","��ɫ"};
    a.setT(array);
    for(int i=0;i<a.getT().length;i++)
      System.out.print(a.getT()[i]+"  ");
  }
}
