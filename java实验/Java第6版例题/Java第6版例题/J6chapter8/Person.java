//filename��Person.java    ��8.9
public class Person
{
  static int count=0;
  protected String name;
  protected int age;
  public Person(String n1,int a1)
  {
    name=n1;
    age=a1;
    this.count++;
  }
  public String toString()
  {
    return this.name+" , "+this.age;
  }
  public void display()
  {
    System.out.print("������="+this.getClass().getName()+"��");
    System.out.println("������="+this.getClass().getSuperclass().getName());
    System.out.print("Person.count="+this.count+ "  ");
    System.out.print("Student.count="+Student.count+ "  ");
    Object obj=this;
    if(obj instanceof Student)    //�ж϶��������ĸ���
      System.out.println(obj.toString()+"��Student�����");
    else if(obj instanceof Person)
      System.out.println(obj.toString()+"��Person�����");
  }
}
class Student extends Person
{
  static int count=0;
  protected String dept;
  protected Student(String n1,int a1,String d1)
  {
    super(n1,a1);
    dept=d1;
    this.count++;
  }
  public String toString()
  {
    return super.toString()+","+dept;
  }
  public void display()
  {
    super.display();
    System.out.print("super.count="+super.count);
    System.out.println("  ��this.count="+this.count);
  }
  public static void main(String[] args)
  {
    Person per=new Person("������",23);
    per.display();
    Student stu=new Student("��С��",22,"�����ϵ");
    stu.display();
  }
}
