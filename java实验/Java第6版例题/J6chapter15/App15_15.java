//filename:App15_15.java
import java.io.*;
import java.util.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
public class App15_15 extends Application
{ 
  private Button bOpen,bSave;
  private TextArea ta=new TextArea();
  private BorderPane rootBP=new BorderPane(); 
  private HBox hB=new HBox(30);
  @Override
  public void start(Stage primaryStage)
  {
    bOpen=new Button("ѡȡ");
    bSave=new Button("����");
    hB.getChildren().addAll(bOpen,bSave);
    hB.setAlignment(Pos.CENTER);
    rootBP.setBottom(hB);
    rootBP.setCenter(ta);
    bOpen.setOnAction(new EventHandler<ActionEvent>()
      {
        @Override
        public void handle(ActionEvent e)
        {
          FileChooser fC=new FileChooser();
          fC.setTitle("�ļ�ѡ��Ի���");
          fC.setInitialDirectory(new File("."));
          FileChooser.ExtensionFilter filter=
            new FileChooser.ExtensionFilter("����.java�ļ�","*.java");
          fC.getExtensionFilters().add(filter);
          File file=fC.showOpenDialog(primaryStage);
          if(file!=null)
          {
            try
            {
              Scanner scan=new Scanner(file);
              String info="";
              while(scan.hasNext())
              {
                String str = scan.nextLine(); 
                info+=str+"\r\n";
              }
              ta.setText(info);
            }
            catch(FileNotFoundException ioe){};
          }
          else
            ta.setText("û��ѡ���ļ�");
        }
      });
    bSave.setOnAction(new EventHandler<ActionEvent>()
      {
        @Override
        public void handle(ActionEvent e)
        {
          FileChooser fC=new FileChooser();
          fC.setTitle("�ļ�����Ի���");
          fC.setInitialDirectory(new File("."));
          FileChooser.ExtensionFilter filter=
            new FileChooser.ExtensionFilter(".java","*.java");
          fC.getExtensionFilters().add(filter);
          File file=fC.showSaveDialog(primaryStage);
          if(file!=null)
          {
            try
            {
              FileOutputStream f=new FileOutputStream(file);
              BufferedOutputStream out=new BufferedOutputStream(f);
              byte[] b=(ta.getText()).getBytes();
              out.write(b,0,b.length);
              out.close();
            }
            catch(IOException ioe){};
          }
        }
      });
    Scene scene=new Scene(rootBP);
    primaryStage.setTitle("�ļ�ѡ��Ի���Ӧ�ó���");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
