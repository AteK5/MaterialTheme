package material.field;


import javafx.scene.AccessibleAttribute;
import javafx.scene.AccessibleRole;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MaterialPasswordField extends PasswordField {

    private MaterialFieldSkin skin;

    public MaterialPasswordField() {
        super();
        skin = new MaterialFieldSkin(this);
        this.setSkin(skin);
        this.setSkin(skin);
    }

    public void setBarColor(String color) {
        skin.setBarColor(color);
    }
}
