package example;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import material.button.MaterialButton;
import material.button.MaterialButtonType;
import material.field.MaterialField;
import material.field.MaterialPasswordField;
import material.stage.MaterialStage;
import material.stats.MaterialStats;

public class example extends Application {

    @Override
    public void start(Stage stage) {

        MaterialStats stats = new MaterialStats("Users", "res/userlogo.png");
        stats.setBackgroundColor("#00C0EF");
        stats.setStats(5);
        stats.setTextFill("white");

        MaterialStats stats0 = new MaterialStats("Users", "res/userlogo.png");
        stats0.setStats(10);
        stats0.setBackgroundColor("#DD4B39");
        stats0.setTextFill("white");

        MaterialStats stats1 = new MaterialStats("Users", "res/userlogo.png");
        stats1.setStats(100);
        stats1.setBackgroundColor("#F39C12");
        stats1.setTextFill("white");

        MaterialStats stats2 = new MaterialStats("Users", "res/userlogo.png");
        stats2.setStats(6);
        stats2.setBackgroundColor("#00A65A");
        stats2.setTextFill("white");

        MaterialField user = new MaterialField();
        user.setPrefWidth(200);
        user.setPromptText("username");

        MaterialPasswordField pass = new MaterialPasswordField();
        pass.setPrefWidth(200);
        pass.setPromptText("password");

        MaterialButton btn = new MaterialButton("connect", MaterialButtonType.CHECK);

        MaterialButton btn0 = new MaterialButton("disconnect", MaterialButtonType.CLOSE);

        HBox buttonAlign = new HBox(10);
        buttonAlign.getChildren().addAll(btn, btn0);
        buttonAlign.setAlignment(Pos.CENTER);

        HBox fieldAlign = new HBox(30);
        fieldAlign.setAlignment(Pos.CENTER);
        fieldAlign.getChildren().addAll(user, pass);

        VBox.setVgrow(fieldAlign, Priority.ALWAYS);
        VBox.setVgrow(buttonAlign, Priority.ALWAYS);
        VBox align = new VBox(20, fieldAlign, buttonAlign);

        HBox hBox = new HBox(10, stats, stats0, stats1, stats2);
        hBox.setPadding(new Insets(10));


        BorderPane root = new BorderPane();
        root.setTop(hBox);
        root.setCenter(align);

        MaterialStage materialStage = new MaterialStage(root);
        materialStage.setBackgroundColor("#2E2E2E");
        materialStage.setTopColor("#000000");

        materialStage.setStageTitle("Example");
        materialStage.setPrefWidth(1130);

        materialStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
