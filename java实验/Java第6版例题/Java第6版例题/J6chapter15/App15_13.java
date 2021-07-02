//filename��App15_13.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
public class App15_13 extends Application
{
  private TextArea ta=new TextArea("��ϲ����JavaFX���");
  @Override
  public void start(Stage primaryStage)
  {
    BorderPane rootBP=new BorderPane();
    rootBP.setCenter(ta);
    RadioMenuItem rMI=new RadioMenuItem("��ɫ");
    RadioMenuItem gMI=new RadioMenuItem("��ɫ");
    RadioMenuItem bMI=new RadioMenuItem("��ɫ");
    rMI.setOnAction(e->ta.setStyle("-fx-text-fill:red"));
    gMI.setOnAction(e->ta.setStyle("-fx-text-fill:green"));
    bMI.setOnAction(e->ta.setStyle("-fx-text-fill:blue"));
    ToggleGroup rgbG=new ToggleGroup();
    rMI.setToggleGroup(rgbG);
    gMI.setToggleGroup(rgbG);
    bMI.setToggleGroup(rgbG);
    ContextMenu rgbCM=new ContextMenu();
    rgbCM.getItems().addAll(rMI,gMI,bMI);
    ta.setContextMenu(rgbCM);
    Scene scene=new Scene(rootBP,230,100);
    primaryStage.setTitle("����˵�Ӧ�ó���");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
