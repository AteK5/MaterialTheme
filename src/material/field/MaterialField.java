package material.field;


import javafx.scene.control.TextField;

public class MaterialField extends TextField {

    private MaterialFieldSkin skin;

    public MaterialField() {
        super();
        skin = new MaterialFieldSkin(this);
        this.setSkin(skin);
    }

    public MaterialField(String text) {
        super(text);
        skin = new MaterialFieldSkin(this);
        this.setSkin(skin);
    }

    public void setBarColor(String color) {
        skin.setBarColor(color);
    }
}
