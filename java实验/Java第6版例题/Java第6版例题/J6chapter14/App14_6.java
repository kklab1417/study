//filename��App14_6.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
public class App14_6 extends Application
{
  Button bt1=new Button("��һ��");
  Button bt2=new Button("��һ��");
  @Override
  public void start(Stage primaryStage)
  {
    HBox hB=new HBox();
    bt1.setPrefSize(160,20);
    hB.setMargin(bt1,new Insets(5,5,5,5));
    bt2.setPrefSize(80,20);
    hB.setMargin(bt2,new Insets(10));
    hB.getChildren().addAll(bt1,bt2);
    Scene scene=new Scene(hB,300,50);
    primaryStage.setTitle("�������");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
