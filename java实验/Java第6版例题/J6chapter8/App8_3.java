//filename��App8_3.java 
class Person
{
  protected String name;
  protected int age;
  public Person() {}
  public Person(String name, int age)
  {
    this.name=name;
    this.age=age;
  }
  protected void show()
  {
    System.out.println("������"+name+"  ���䣺"+age);
  }
}
class Student extends Person
{
  private String department;
  int age=20;
  public Student (String xm,String dep)
  {
    name=xm;
    department=dep;
    super.age=25;
    System.out.println("����Student�еĳ�Ա����age="+age);
    super.show();
    System.out.println("ϵ��"+ department );
  }
}
public class App8_3
{
  public static void main(String[] args)
  {
    Student stu=new Student("��С��","��Ϣϵ");
  }
}
