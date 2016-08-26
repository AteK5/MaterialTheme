package material.menu;


import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class MaterialMenuButton extends StackPane implements Action {

    private Action onAction;

    private static ArrayList<MaterialMenuButton> buttonsList = new ArrayList<>();

    private HBox root;
    private ImageView logo;
    private Text title;

    private String color = "#1E282C";

    private Rectangle rect;

    private boolean isSelected = false;

    public MaterialMenuButton(String name, String logoPath) {
        onAction = new MaterialMenuButton();

        root = new HBox(20);
        root.setPrefSize(220, 40);
        root.setAlignment(Pos.CENTER_LEFT);
        title = new Text();
        title.setFill(Color.WHITE);
        title.setText(name);
        title.setFont(Font.font(15));

        rect = new Rectangle(5, 40);
        rect.setFill(Paint.valueOf("#3C8DBC"));
        rect.setVisible(false);

        try {
            InputStream is = Files.newInputStream(Paths.get(logoPath));
            logo = new ImageView(new Image(is));
            logo.setFitWidth(24);
            logo.setFitHeight(24);
        } catch (IOException e) {
            e.printStackTrace();
        }

        root.setStyle("-fx-background-color: transparent");
        root.getChildren().addAll(rect, logo, title);


        this.setOnMouseClicked(event -> {
            onAction.onAction();
            deselectAll();
            setConstantSelected(true);
        });
        this.setOnMouseEntered(event -> {
            this.setCursor(Cursor.HAND);
            setSelected(true);
        });
        this.setOnMouseExited(event -> {
            this.setCursor(Cursor.DEFAULT);
            setSelected(false);
        });

        registButton(this);
        setSelected(false);

        this.getChildren().addAll(root);
    }

    private MaterialMenuButton() {

    }

    public void setOnAction(Action onAction) {
        this.onAction = onAction;
    }

    private void setBackgroundColor(String color) {
        this.root.setStyle("-fx-background-color: " + color);
    }

    public void setBackgroundTransparent() {
        root.setStyle("-fx-background-color: transparent");
    }

    public void setSelectedColor(String color) {
        this.color = color;
        if (isSelected)
            setBackgroundColor(color);
    }

    public void setBarColor(String color) {
        rect.setFill(Paint.valueOf(color));
    }

    public void setTextColor(String color) {
        title.setFill(Paint.valueOf(color));
    }

    public void setLogo(Image image) {
        this.logo.setImage(image);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setGlobalOpacity(double opacity) {
        this.root.setOpacity(opacity);
    }

    public void setSelected(boolean bool) {
        if (!isSelected) {
            if (bool) {
                rect.setVisible(true);
                setBackgroundColor(color);
                this.setOpacity(1);
            } else {
                rect.setVisible(false);
                setBackgroundColor("transparent");
                this.setOpacity(0.6);
            }
        }
    }

    public void setConstantSelected(boolean bool) {
        if (!isSelected) {
            setSelected(bool);
            this.isSelected = bool;
        } else {
            this.isSelected = bool;
            setSelected(bool);
        }
    }

    public static void registButton(MaterialMenuButton... btn) {
        Collections.addAll(buttonsList, btn);
    }

    public static void deselectAll() {
        if (buttonsList.size() != 0) {
            for (MaterialMenuButton button : buttonsList)
                button.setConstantSelected(false);
        }
    }

    @Override
    public void onAction() {

    }
}
