//filename��App8_17.java
enum Direction
{
  EAST("��"),SOUTH("��"),WEST("��"),NORTH("��");
  private String name;
  private Direction(String name)
  {
    this.name=name;
  }
  public String toString()
  {
    return name;
  }
}
public class App8_17
{
  public static void main(String[] args)
  {
    Direction dir=Enum.valueOf(Direction.class,"NORTH");
    System.out.println(dir);
    for(Direction d:Direction.values())
      System.out.println(d.name()+" �������� ("+d.toString()+")");
  }
}
