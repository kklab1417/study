//filename��App15_3.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
public class App15_3 extends Application
{
  Button bt=new Button("����������ɫ");
  TextArea ta=new TextArea("������ɫ");
  @Override
  public void start(Stage primaryStage)
  {
    BorderPane bPane=new BorderPane();
    bPane.setCenter(ta);
    bPane.setBottom(bt);
    BorderPane.setAlignment(bt,Pos.CENTER);
    bt.setOnAction(e->ta.setStyle("-fx-text-fill:red"));
    Scene scene=new Scene(bPane,180,100);
    primaryStage.setTitle("�����¼�");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
