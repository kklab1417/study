//filename��App8_1.java
class Person
{
  private String name;
  private int age;
  public Person()
  {
     System.out.println("�����˸�����Ĺ��췽��Person()");
  }
  public void setNameAge(String name, int age)
  {
    this.name=name;
    this.age=age;
  }
  public void show()
  {
    System.out.println("������"+name+"  ���䣺"+age);
  }
}
class Student extends Person
{
  private String department;
  public Student()
  {
    System.out.println("������ѧ����Ĺ��췽��Student()");
  }
  public void setDepartment(String dep)
  {
    department=dep;
    System.out.println("����"+department +"��ѧ��");
  }
}
public class App8_1
{
  public static void main(String[] args)
  {
    Student stu=new Student();
    stu.setNameAge("��С��",21);
    stu.show();
    stu.setDepartment("�����ϵ");
  }
}
