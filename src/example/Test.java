package example;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import material.button.MaterialButton;
import material.button.MaterialButtonType;
import material.field.MaterialField;
import material.field.MaterialPasswordField;
import material.menu.MaterialMenu;
import material.menu.MaterialMenuButton;
import material.stage.MaterialStage;
import material.stats.MaterialStats;

public class Test extends Application {

    @Override
    public void start(Stage stage) throws Exception {

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

        HBox statsAlign = new HBox(10);
        statsAlign.getChildren().addAll(stats, stats0, stats1, stats2);
        statsAlign.setPadding(new Insets(10));

        VBox root = new VBox(20);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(statsAlign, fieldAlign, buttonAlign);


        MaterialStage materialStage = new MaterialStage(root, "res/psyduck.png", "#01A9DB", "white");
        materialStage.setStageTitle("Ma fenêtre");

        MaterialMenu menu = new MaterialMenu(materialStage);

        MaterialMenuButton mb = new MaterialMenuButton("Page 1", "res/user.png");
        mb.setConstantSelected(true);


        MaterialMenuButton mb1 = new MaterialMenuButton("Page 2", "res/mail.png");
        menu.addItem(mb, mb1);

        materialStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
