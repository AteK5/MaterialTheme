package material.stage;


import com.sun.glass.ui.Application;
import com.sun.glass.ui.Screen;
import javafx.fxml.FXML;
import javafx.geometry.BoundingBox;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.geom.Area;


public class MaterialStageController {

    @FXML
    private Button minimize;

    @FXML
    private Button resizeButton;

    @FXML
    private Text title;

    @FXML
    private Button maximize;

    @FXML
    protected ImageView logo;

    @FXML
    private Button close;

    @FXML
    private AnchorPane background;

    @FXML
    private HBox top;


    private Stage stage;

    private BoundingBox boundingBox;

    private boolean isMaximized = false;

    @FXML
    void initialize() {
        final Image image = new Image("/material/res/mini.png");
        final ImageView icon = new ImageView(image);
        icon.setFitWidth(15);
        icon.setFitHeight(5);

        minimize.setGraphic(icon);

        final Image image1 = new Image("/material/res/max.png");
        final ImageView icon1 = new ImageView(image1);
        icon1.setFitHeight(15);
        icon1.setFitWidth(15);

        maximize.setGraphic(icon1);
        maximize.setAlignment(Pos.CENTER);

        final Image image2 = new Image("/material/res/close.png");
        final ImageView icon2 = new ImageView(image2);
        icon2.setFitHeight(15);
        icon2.setFitWidth(15);
        close.setGraphic(icon2);
        close.setAlignment(Pos.CENTER);

        final Image image3 = new Image("/material/res/resize.png");
        final ImageView resize = new ImageView(image3);
        resize.setFitHeight(15);
        resize.setFitWidth(15);

        resizeButton.setGraphic(resize);
        resizeButton.setAlignment(Pos.BASELINE_RIGHT);

    }


    @FXML
    private void closeW() {
        System.exit(0);
    }

    @FXML
    private void maximize() {
        if (!isMaximized) {
            boundingBox = new BoundingBox(stage.getX(), stage.getY(), stage.getWidth(), stage.getHeight());

            stage.setX(0);
            stage.setY(0);
            stage.setWidth(safeBounds().getBounds().getWidth());
            stage.setHeight(safeBounds().getBounds().getHeight());

            isMaximized = true;
        } else {
            stage.setWidth(boundingBox.getWidth());
            stage.setHeight(boundingBox.getHeight());
            stage.setX(boundingBox.getMinX());
            stage.setY(boundingBox.getMinY());

            isMaximized = false;
        }
    }

    @FXML
    private void minimize() {
        stage.setIconified(true);
    }

    @FXML
    private void onMouseDraggedOnTop(MouseEvent event) {
        stage.setX(event.getScreenX());
        stage.setY(event.getScreenY());

        event.consume();
    }

    @FXML
    private void onResizeDragged(MouseEvent event) {
        resize(event.getScreenX(), event.getScreenY());
        event.consume();
    }

    private void resize(double x, double y) {
        stage.setWidth(Math.max(400, x - stage.getX()));
        stage.setHeight(Math.max(300, y - stage.getY()));
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }


    private Area safeBounds() {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        Rectangle bounds = gd.getDefaultConfiguration().getBounds();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(gd.getDefaultConfiguration());

        Rectangle safeBounds = new Rectangle(bounds);
        safeBounds.x += insets.left;
        safeBounds.y += insets.top;
        safeBounds.width -= (insets.left + insets.right);
        safeBounds.height -= (insets.top + insets.bottom);

        return new Area(safeBounds);
    }

    public Text getTitle() {
        return title;
    }

    public AnchorPane getBackground() {
        return background;
    }

    public HBox getTop() {
        return top;
    }
}
