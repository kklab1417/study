//filename��App14_5.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
public class App14_5 extends Application
{
  @Override
  public void start(Stage primaryStage)
  {
    BorderPane rootPane=new BorderPane();
    rootPane.setPadding(new Insets(10));
    Button bt=new Button("����������");
    bt.setPrefSize(280,20);
    rootPane.setTop(bt);
    rootPane.setBottom(new Button("�ײ�״̬��"));
    rootPane.setLeft(new Button("�󲿵����˵�"));
    rootPane.setRight(new Button("��ʾ��Ϣ"));
    rootPane.setCenter(new Button("�м乤����"));
    Scene scene=new Scene(rootPane,280,130);
    primaryStage.setTitle("�߽�ʽ���");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
