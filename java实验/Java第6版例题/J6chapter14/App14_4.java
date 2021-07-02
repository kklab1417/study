//filename��App14_4.java
import javafx.application.Application; 
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button; 
import javafx.scene.layout.FlowPane;
import javafx.geometry.Orientation;
import javafx.geometry.Insets;
public class App14_4 extends Application
{
  Button[] bt=new Button[6];    //������ť����
  @Override
  public void start(Stage primaryStage)
  {
    FlowPane rootNode=new FlowPane();
    rootNode.setOrientation(Orientation.HORIZONTAL);
    rootNode.setPadding(new Insets(12,13,14,15));
    rootNode.setHgap(8);
    rootNode.setVgap(5);
    for(int i=0;i<bt.length;i++)
    {
      bt[i]=new Button("��ť"+(i+1));
      rootNode.getChildren().add(bt[i]);
    }
    Scene scene=new Scene(rootNode,200,80);
    primaryStage.setTitle("��ʽ���"); 
    primaryStage.setScene(scene); 
    primaryStage.show();
  }
}
