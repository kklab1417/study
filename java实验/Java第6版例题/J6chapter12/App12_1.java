//filename:App12_1.java
public class App12_1<T>
{
  private T obj;
  public T getObj()
  {
    return obj;
  }
  public void setObj(T obj)
  {
    this.obj=obj;
  }
  public static void main(String[] args)
  {
    App12_1<String> name=new App12_1<String>();
    App12_1<Integer> age=new App12_1<Integer>();
    name.setObj("��С��"); 
    String newName=name.getObj();
    System.out.println("������"+newName);
    age.setObj(25);
    int newAge=age.getObj();
    System.out.println("���䣺"+newAge);
  }
}
