//filename��App15_12.java
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
public class App15_12 extends Application
{ 
  @Override
  public void start(Stage primaryStage)
  {
    MenuBar menuB=new MenuBar();
    Text t=new Text("����һ������Ա��\n��ϲ����JavaFX���");
    BorderPane rootBP=new BorderPane();
    rootBP.setTop(menuB);
    rootBP.setCenter(t);
    Menu fileM=new Menu("(_F)�ļ�");
    fileM.setMnemonicParsing(true);
    Image inew=new Image("icon/new.png");
    ImageView ivnew=new ImageView(inew);
    MenuItem newMI=new MenuItem("�½�",ivnew);
    MenuItem openMI=new MenuItem("��");
    openMI.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));
    openMI.setGraphic(new ImageView(new Image("icon/open.png")));
    MenuItem saveMI=new MenuItem("����");
    MenuItem exitMI=new MenuItem("�˳�");
    exitMI.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
    EventHandler<ActionEvent> MEHandler=new EventHandler<ActionEvent>()
    {
      public void handle(ActionEvent ae)
      {
        String name=((MenuItem)ae.getTarget()).getText();
        if(name.equals("�˳�")) Platform.exit();  //���ѡ�С��˳����˵���
        t.setText(name+"����ѡ��");
      }
    };
    exitMI.setOnAction(MEHandler);
    newMI.setOnAction(MEHandler);
    openMI.setOnAction(MEHandler);
    saveMI.setOnAction(MEHandler);
    fileM.getItems().addAll(newMI,openMI,saveMI,exitMI);
    Menu styleM=new Menu("��ʽ");
    Menu fontM=new Menu("����");
    CheckMenuItem boldMI=new CheckMenuItem("����");
    boldMI.setGraphic(new ImageView(new Image("icon/bold.png")));
    boldMI.setSelected(true);
    CheckMenuItem italicMI=new CheckMenuItem("б��");
    italicMI.setGraphic(new ImageView(new Image("icon/italic.png")));
    fontM.getItems().addAll(boldMI,italicMI);
    Menu rgbM=new Menu("��ɫ");
    RadioMenuItem rMI=new RadioMenuItem("��ɫ");
    RadioMenuItem gMI=new RadioMenuItem("��ɫ");
    RadioMenuItem bMI=new RadioMenuItem("��ɫ");
    rMI.setOnAction(e->t.setFill(Color.RED));
    gMI.setOnAction(e->t.setFill(Color.GREEN));
    bMI.setOnAction(e->t.setFill(Color.BLUE));
    bMI.setSelected(true);
    ToggleGroup rgbG=new ToggleGroup();
    rMI.setToggleGroup(rgbG);
    gMI.setToggleGroup(rgbG);
    bMI.setToggleGroup(rgbG);
    rgbM.getItems().addAll(rMI,gMI,bMI);
    styleM.getItems().addAll(fontM,new SeparatorMenuItem(),rgbM);
    menuB.getMenus().addAll(fileM,styleM);
    Scene scene=new Scene(rootBP,230,100);
    primaryStage.setTitle("�˵�Ӧ�ó���");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
