//filename��App14_11.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ScrollPane;
import javafx.geometry.Insets;
public class App14_11 extends Application
{
  final Label lab1=new Label("�û�����");
  final Label lab2=new Label("��  �룺");
  final PasswordField pf=new PasswordField();
  final TextField tf=new TextField();
  final TextArea ta=new TextArea("��ã������ı���");
  @Override
  public void start(Stage primaryStage)
  {
    GridPane rootGP=new GridPane();
    rootGP.setPadding(new Insets(10,8,10,8));
    rootGP.setHgap(5);
    rootGP.setVgap(5);
    tf.setPromptText("�����û���");
    rootGP.add(lab1,0,0);
    rootGP.add(tf,1,0);
    pf.setPromptText("��������");
    rootGP.add(lab2,0,1);
    rootGP.add(pf,1,1);
    Button bt1=new Button("ȷ������");
    Button bt2=new Button("�༭�ı�");
    rootGP.add(bt1,0,2);
    rootGP.add(bt2,1,2);
    final ScrollPane scro=new ScrollPane(ta);
    ta.setPrefColumnCount(12);
    ta.setEditable(false);
    rootGP.add(scro,2,0,4,3);
    Scene scene=new Scene(rootGP,400,120);
    primaryStage.setTitle("�������ı��ؼ�");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
