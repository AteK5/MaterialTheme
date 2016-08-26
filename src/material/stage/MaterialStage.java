package material.stage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import material.menu.MaterialMenu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class MaterialStage extends Stage {

    private MaterialStageController controller;

    private MaterialMenu menu;

    private String backgroundcolor = "#DBDBDB";


    public MaterialStage(Parent content) {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/material/stage/stage.fxml"));

            Parent stage = loader.load();

            controller = loader.getController();
            controller.setStage(this);
            content.setStyle("-fx-background-color: " + backgroundcolor);
            controller.root.getChildren().addAll(content);

            this.setScene(new Scene(stage));
            this.initStyle(StageStyle.UNDECORATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MaterialStage(Parent content, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/material/stage/stage.fxml"));

            Parent stage = loader.load();

            controller = loader.getController();
            controller.setStage(this);

            setStageTitle(title);

            content.setStyle("-fx-background-color: " + backgroundcolor);
            controller.root.getChildren().addAll(content);

            this.setScene(new Scene(stage));
            this.initStyle(StageStyle.UNDECORATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MaterialStage(Parent content, String title, String icon) {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/material/stage/stage.fxml"));

            Parent stage = loader.load();

            controller = loader.getController();
            controller.setStage(this);

            setStageTitle(title);
            setLogo(icon);

            content.setStyle("-fx-background-color: " + backgroundcolor);
            controller.root.getChildren().addAll(content);

            this.setScene(new Scene(stage));
            this.initStyle(StageStyle.UNDECORATED);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MaterialStage(Parent content, String icon, String topcolor, String backgroundColor) {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/material/stage/stage.fxml"));
            Parent stage = loader.load();

            controller = loader.getController();
            controller.setStage(this);

            setLogo(icon);
            setBackgroundColor(backgroundColor);
            setTopColor(topcolor);

            content.setStyle("-fx-background-color: " + backgroundcolor);
            controller.root.getChildren().addAll(content);

            this.setScene(new Scene(stage));
            this.initStyle(StageStyle.UNDECORATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //////////////////////////////////GETTER/SETTER////////////////////////////////////////////////


    public void setStageTitle(String title) {
        controller.getTitle().setText(title);
        this.setTitle(title);
    }

    public void setLogo(String path) {
        try {
            controller.logo.setImage(new Image(Files.newInputStream(Paths.get(path))));
            this.getIcons().addAll(new Image(Files.newInputStream(Paths.get(path))));
            controller.logo.setFitHeight(25);
            controller.logo.setFitWidth(25);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addContent(Parent ...parent) {
        for (Parent p : parent)
            p.setStyle("-fx-background-color: " + backgroundcolor);
        controller.root.getChildren().addAll(parent);
    }

    public void setBackgroundColor(String color) {
        this.backgroundcolor = color;
        controller.getBackground().setStyle("-fx-background-color: " + color);
    }

    public void setTopColor(String color) {
        controller.getTop().setStyle("-fx-background-color: " + color);
    }

    public void setTextColor(String color) {
        controller.getTitle().setFill(Paint.valueOf(color));
    }

    public MaterialStageController getController() {
        return controller;
    }

    public void setMenu(MaterialMenu menu) {
        if (this.menu == null) {
            this.menu = menu;

            controller.getAlignmenu().getChildren().add(this.menu);
            controller.getAlignmenu().setStyle("-fx-background-color: #222D32");
        }
    }
}
