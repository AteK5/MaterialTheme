package material.button;


import com.sun.javafx.scene.control.skin.ButtonSkin;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;


public class MaterialButtonSkin extends ButtonSkin {

    public MaterialButtonSkin(MaterialButton button) {
        super(button);

        button.setStyle("-fx-background-color: #0080FF");
        button.setTextFill(Color.WHITE);
    }

    public MaterialButtonSkin(MaterialButton button, MaterialButtonType type) {
        super(button);

        switch (type) {
            case CHECK:
                button.setStyle("-fx-background-color: #04B404");
                button.setTextFill(Color.WHITE);

                final ImageView imageView = new ImageView(new Image("/material/res/checked.png"));
                imageView.setFitHeight(15);
                imageView.setFitWidth(15);

                button.setGraphic(imageView);

                break;
            case CLOSE:
                button.setStyle("-fx-background-color: #DF0101");
                button.setTextFill(Color.WHITE);

                final ImageView imageView0 = new ImageView(new Image("/material/res/close.png"));
                imageView0.setFitHeight(15);
                imageView0.setFitWidth(15);

                button.setGraphic(imageView0);

                break;
            case DEFAULT:
                button.setStyle("-fx-background-color: #0080FF");
                button.setTextFill(Color.WHITE);
        }
    }
}
