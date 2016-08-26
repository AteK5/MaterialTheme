package material.button;


import javafx.scene.control.Button;

public class MaterialButton extends Button {

    public MaterialButton() {
        super();
        this.setSkin(new MaterialButtonSkin(this));
    }

    public MaterialButton(String text) {
        super(text);
        this.setSkin(new MaterialButtonSkin(this));
    }

    public MaterialButton(MaterialButtonType type) {
        super();
        this.setSkin(new MaterialButtonSkin(this, type));
    }

    public MaterialButton(String text, MaterialButtonType type) {
        super(text);
        this.setSkin(new MaterialButtonSkin(this, type));
    }
}
