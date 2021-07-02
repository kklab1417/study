//filename��App17_23.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
public class App17_23 extends Application
{
  private TextField txtSno=new TextField();
  private TextField txtCno=new TextField();
  private Button but=new Button("�鿴");
  @Override
  public void start(Stage Stage)
  {
    HBox content=new HBox(10);
    final Label lab1=new Label("ѧ�ţ�");
    final Label lab2=new Label("�γ̺ţ�");
    txtSno.setPromptText("����ѧ��");
    txtCno.setPromptText("����γ̺�");
    content.getChildren().addAll(lab1,txtSno,lab2,txtCno,but);
    but.setOnAction(e->
      {
        String sNo=txtSno.getText();
        String cNo=txtCno.getText();
        String url="jdbc:mysql://localhost:3306/StudentScore";
        String user="root";
        String password="";
        String sql="SELECT a.sName,b.cName,c.grade "
              +"FROM Student a,Course b,Score c "
              +"WHERE a.sNo=c.sNo AND b.cNo=c.cNo "
              +"AND c.sNo='"+sNo+"' AND c.cNo='"+cNo+"'";
        try (Connection conn=DriverManager.getConnection(url,user,password); 
             Statement stmt=conn.createStatement();
             ResultSet rs=stmt.executeQuery(sql); )
        {
          Class.forName("com.mysql.jdbc.Driver");
          if(rs.next())
          {
            String sname=rs.getString("sName");
            String cname=rs.getString("cName");
            String grade=rs.getString("grade");
            Alert alert=new Alert(AlertType.INFORMATION);
            alert.setTitle("��ѯ���");
            alert.setHeaderText(null);
            alert.setContentText(sname+" "+cname+" "+grade);
            alert.showAndWait();
          }
        }
        catch (Exception ex)
        { ex.printStackTrace(); }
      }
    );
    Scene scene=new Scene(content,450,40);
    Stage.setTitle("���ݿ��ѯ");
    Stage.setScene(scene);
    Stage.show();
  }
}
