package material.stage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
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

    private Parent parent;


    public MaterialStage(Parent content) {
        this.parent = content;
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/material/stage/stage.fxml"));

            Parent stage = loader.load();

            controller = loader.getController();
            controller.setStage(this);

            AnchorPane.setTopAnchor(content, 40.0);
            AnchorPane.setBottomAnchor(content, 0.0);
            AnchorPane.setLeftAnchor(content, 0.0);
            AnchorPane.setRightAnchor(content, 0.0);
            controller.getBackground().getChildren().add(content);

            this.setScene(new Scene(stage));
            this.initStyle(StageStyle.UNDECORATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MaterialStage(Parent content, String title) {
        this.parent = content;
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/material/stage/stage.fxml"));

            Parent stage = loader.load();

            controller = loader.getController();
            controller.setStage(this);

            setStageTitle(title);

            AnchorPane.setTopAnchor(content, 40.0);
            AnchorPane.setBottomAnchor(content, 0.0);
            AnchorPane.setLeftAnchor(content, 0.0);
            AnchorPane.setRightAnchor(content, 0.0);
            controller.getBackground().getChildren().add(content);

            this.setScene(new Scene(stage));
            this.initStyle(StageStyle.UNDECORATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MaterialStage(Parent content, String title, String icon) {
        this.parent = content;
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/material/stage/stage.fxml"));

            Parent stage = loader.load();

            controller = loader.getController();
            controller.setStage(this);

            setStageTitle(title);
            setLogo(icon);

            AnchorPane.setTopAnchor(content, 40.0);
            AnchorPane.setBottomAnchor(content, 0.0);
            AnchorPane.setLeftAnchor(content, 0.0);
            AnchorPane.setRightAnchor(content, 0.0);
            controller.getBackground().getChildren().add(content);

            this.setScene(new Scene(stage));
            this.initStyle(StageStyle.UNDECORATED);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MaterialStage(Parent content, String icon, String topcolor, String backgroundColor) {
        this.parent = content;
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/material/stage/stage.fxml"));
            Parent stage = loader.load();

            controller = loader.getController();
            controller.setStage(this);

            setLogo(icon);
            setBackgroundColor(backgroundColor);
            setTopColor(topcolor);

            AnchorPane.setTopAnchor(content, 40.0);
            AnchorPane.setBottomAnchor(content, 0.0);
            AnchorPane.setLeftAnchor(content, 0.0);
            AnchorPane.setRightAnchor(content, 0.0);
            controller.getBackground().getChildren().add(content);

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

    public void setBackgroundColor(String color) {
        this.parent.setStyle("-fx-background-color: " + color);
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
            AnchorPane.setLeftAnchor(menu, 0.0);
            AnchorPane.setTopAnchor(menu, 40.0);
            AnchorPane.setBottomAnchor(menu, 0.0);
            AnchorPane.setLeftAnchor(parent, 220.0);
            controller.getBackground().getChildren().add(menu);
        }
    }

    public void setPrefWidth(double width) {
        this.setWidth(width);
    }

    public void setPrefHeight(double height) {
        this.setHeight(height);
    }
}
