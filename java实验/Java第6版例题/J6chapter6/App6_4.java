//filename��App6_4.java
class Cylinder
{
  double radius;
  int height;
  double pi;
  void setCylinder(double r,int h,double p)
  {
    pi=p;
    radius=r;
    height=h;
  }
  double area()
  {
    return pi* radius* radius;
  }
  double volume()
  {
    return area()*height; 
  }
}
public class App6_4
{
  public static void main(String[] args)
  {
    Cylinder volu=new Cylinder();
    volu.setCylinder(2.5, 5,3.14);
    System.out.println("��Բ�뾶="+volu.radius);
    System.out.println("Բ���ĸ�="+volu.height);
    System.out.println("Բ����pi="+volu.pi);
    System.out.print("Բ��");
    System.out.println("�����="+volu.area());
    System.out.println("Բ�������="+volu.volume());
  }
}
