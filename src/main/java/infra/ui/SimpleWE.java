package infra.ui;

public class SimpleWE extends BaseWE {

    public SimpleWE(String description, LocateBy selectBy, String selector) {
        super(description, selectBy, selector);
    }

    public SimpleWE replaceId(String val) {
        val = val.replace("error-message-", "");
        String x = this.getSelector().replace("x", val);
        this.setSelector(x);
        return this;
    }
}
