//filename��App6_2.java
class Cylinder
{
  double radius;
  int height;
  double pi=3.14;
  void area()
  {
    System.out.println("�����="+pi* radius* radius);
  }
  double volume()
  {
    return (pi* radius* radius)*height;
  }
}
public class App6_2
{
  public static void main(String[] args)
  {
    Cylinder volu1,volu2;
    volu1=new Cylinder();
    volu2=new Cylinder();
    volu1.radius= volu2.radius=2.5;
    volu2.pi=3;
    System.out.println("Բ��1�װ뾶="+volu1.radius);
    System.out.println("Բ��2�װ뾶="+volu2.radius);
    System.out.println("Բ��1��piֵ="+volu1.pi);
    System.out.println("Բ��2��piֵ="+volu2.pi);
    System.out.print("Բ��1");
    volu1.area();
    System.out.print("Բ��2");
    volu2.area();
  }
}
