//filename��App7_1.java
class Cylinder
{
  private double radius;
  private int height;
  private double pi=3.14;
  double area()
  {
    return pi*radius*radius;
  }
  double volume()
  {
    return area()*height;
  }
}
public class App7_1
{
  public static void main(String[] args)
  {
    Cylinder volu;
    volu=new Cylinder();
    volu.radius=2.8;
    volu.height=-5;
    System.out.println("��Բ�뾶="+volu.radius);
    System.out.println("Բ���ĸ�="+volu.height);
    System.out.print("Բ��");
    System.out.println("�����="+volu.area());
    System.out.println("Բ�������="+volu.volume());
  }
}
