package material.field;

import com.sun.javafx.scene.control.skin.TextFieldSkin;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;


public class MaterialFieldSkin extends TextFieldSkin {

    private Region loupe;
    private Region crossButon;

    private MaterialField field;
    private MaterialPasswordField passfield;

    private Separator sp;

    public MaterialFieldSkin(final MaterialField CONTROL) {
        super(CONTROL);

        this.field = CONTROL;
        initGraphic();
        //registerListener();
    }

    public MaterialFieldSkin(final MaterialPasswordField CONTROL) {
        super(CONTROL);

        this.passfield = CONTROL;
        initPassGraphic();
        //registerListener();
    }

    private void initGraphic() {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.BOTTOM_CENTER);
        vBox.setPadding(new Insets(-5));

        field.setStyle("-fx-background-color: transparent");


        sp = new Separator();
        sp.setStyle("-fx-background: grey;");
        vBox.getChildren().addAll(sp);

        this.getChildren().addAll(vBox);
    }

    private void initPassGraphic() {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.BOTTOM_CENTER);
        vBox.setPadding(new Insets(-5));

        passfield.setStyle("-fx-background-color: transparent");


        sp = new Separator();
        sp.setStyle("-fx-background: grey;");
        vBox.getChildren().addAll(sp);

        this.getChildren().addAll(vBox);
    }

    public void setBarColor(String color) {
        sp.setStyle("-fx-background: " + color + ";");
    }

    //private void registerListener() {
    // crossButon.setOnMouseClicked(event -> this.getSkinnable().setText(""));
    // this.getSkinnable().textProperty().addListener(observable ->
    //     crossButon.setVisible(this.getSkinnable().getText().isEmpty() ? false : true)
    // );

    // this.getSkinnable().focusedProperty().addListener(observable -> {
    //      loupe.setVisible(!this.getSkinnable().isFocused() && this.getSkinnable().getText().isEmpty());
    //    crossButon.setVisible(this.getSkinnable().isFocused() && !this.getSkinnable().getText().isEmpty());
    // });

    // this.getSkinnable().widthProperty().addListener(observable -> {
    //     double size = loupe.getMaxWidth() < 0 ? 20.8 : loupe.getWidth();

    //      loupe.setTranslateX(-this.getSkinnable().getWidth() * 0.5 + size * 0.7);
    //      crossButon.setTranslateX(-this.getSkinnable().getWidth() * 0.5 + size * 0.7);
    //  });

    // this.getSkinnable().heightProperty().addListener(observable -> {
        //      crossButon.setMaxSize(this.getSkinnable().getHeight() * 0.8, this.getSkinnable().getMaxHeight() * 0.8);
    //      loupe.setMaxSize(this.getSkinnable().getHeight() * 0.8, this.getSkinnable().getMaxHeight() * 0.8);
    //  });

    //  this.getSkinnable().sceneProperty().addListener(observable -> {
        //      loupe.setTranslateX(-this.getSkinnable().getWidth() * 0.5 + crossButon.getWidth() * 0.7);
    //      crossButon.setTranslateX(this.getSkinnable().getWidth() * 0.5 - loupe.getWidth() * 0.7);
    //  });
    //}
}
