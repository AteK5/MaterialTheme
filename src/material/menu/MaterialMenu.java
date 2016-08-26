package material.menu;


import javafx.scene.Parent;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import material.stage.MaterialStage;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class MaterialMenu extends Parent {

    private String selectedColor = "#1E282C";
    private String textcolor = "#FFFFFF";
    private String cursorcolor = "#3C8DBC";

    private MaterialStage stage;

    private ArrayList<MaterialMenuButton> buttonList = new ArrayList<>();
    private VBox root;

    public MaterialMenu(MaterialStage stage) {
        this.stage = stage;
        this.stage.setMenu(this);

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

        root = new VBox();
        root.setPrefHeight(d.getHeight());
        root.setStyle("-fx-background-color: #222D32");
        this.getChildren().addAll(root);
    }

    public void setSelectedBackgroundColor(String color) {
        this.selectedColor = color;
        for (MaterialMenuButton button : buttonList)
            button.setSelectedColor(color);
    }

    public void setTextColor(String color) {
        this.textcolor = color;
        for (MaterialMenuButton button : buttonList)
            button.setTextColor(color);
    }

    public void setCursorColor(String color) {
        this.cursorcolor = color;
        for (MaterialMenuButton button : buttonList)
            button.setBarColor(color);
    }

    public void setBackgroundColor(String color) {
        root.setStyle("-fx-background-color: " + color);
    }

    public void addItem(MaterialMenuButton... buttons) {
        for (MaterialMenuButton b : buttons) {
            b.setBarColor(cursorcolor);
            b.setTextColor(textcolor);
            b.setSelectedColor(selectedColor);
        }
        Collections.addAll(buttonList, buttons);
        root.getChildren().addAll(buttons);
    }

    public void setPrefHeight(double height) {
        root.setPrefHeight(height);
    }

    public double getWidth() {
        return root.getWidth();
    }

    public double getHeigth() {
        return root.getHeight();
    }
}
