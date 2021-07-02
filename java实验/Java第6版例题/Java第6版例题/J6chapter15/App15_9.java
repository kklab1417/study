//filename��App15_9.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.collections.FXCollections;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;
import javafx.collections.ObservableList;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
public class App15_9 extends Application
{
  private String[] my={"��ȵ","��٢","��˼��","��ʱ��","���پ�","���"};
  private ImageView[] iv={new ImageView("��ȵ.jpg"),new ImageView("��٢.jpg"),
                new ImageView("��˼��.jpg"),new ImageView("��ʱ��.jpg"),
                new ImageView("���پ�.jpg"),new ImageView("���.jpg")};
  private ObservableList<String> items=FXCollections.observableArrayList(my);
  private ListView<String> lv=new ListView<String>(items);
  private FlowPane fp=new FlowPane(5,5);
  @Override
  public void start(Stage primaryStage)
  {
    lv.setPrefSize(80,100);
    lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    BorderPane bp=new BorderPane();
    bp.setLeft(new ScrollPane(lv));
    bp.setCenter(fp);
    lv.getSelectionModel().selectedItemProperty().addListener(new IListener());
    Scene scene=new Scene(bp,360,130);
    primaryStage.setTitle("�б���ͼ��Ӧ��");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  class IListener implements InvalidationListener
  {
    @Override
    public void invalidated(Observable ov)
    {
       fp.getChildren().clear();
       for(Integer i:lv.getSelectionModel().getSelectedIndices())
         fp.getChildren().add(iv[i]);
    }
  }
}
