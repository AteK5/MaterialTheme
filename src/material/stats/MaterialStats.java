package material.stats;


import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MaterialStats extends StackPane {

    private Rectangle background;

    private Text text;

    private Text valT;

    public MaterialStats(String text, String logo) {

        this.text = new Text();
        this.text.setFont(Font.font(20));
        this.text.setText(text);

        this.valT = new Text();
        this.valT.setFont(Font.font(30));

        this.background = new Rectangle(270, 150);
        this.background.setFill(Paint.valueOf("#DD4B39"));
        this.background.setArcHeight(5);
        this.background.setArcWidth(10);

        HBox root = new HBox(10);
        root.setAlignment(Pos.CENTER);

        VBox align = new VBox(20);
        align.setAlignment(Pos.CENTER_LEFT);
        align.getChildren().addAll(this.valT, this.text);

        ImageView img = null;
        try {
            InputStream is = Files.newInputStream(Paths.get(logo));
            img = new ImageView(new Image(is));
            img.setOpacity(0.2);
            img.setFitHeight(128);
            img.setFitWidth(128);
        } catch (IOException e) {
            e.printStackTrace();
        }

        root.getChildren().addAll(align, img);

        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(background, root);
    }

    public void setBackgroundColor(String color) {
        background.setFill(Paint.valueOf(color));
    }

    public void setStats(int i) {
       this.valT.setText(String.valueOf(i));
    }

    public void setTextFill(String color) {
        this.text.setFill(Paint.valueOf(color));
        this.valT.setFill(Paint.valueOf(color));
    }
}
