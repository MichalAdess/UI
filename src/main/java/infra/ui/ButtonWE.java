package infra.ui;

public class ButtonWE extends BaseWE {

    public ButtonWE(String description, LocateBy selectBy, String selector) {
        super(description, selectBy, selector);
    }

    public ButtonWE click() {
        this.findElement().click();
        return this;
    }
}
