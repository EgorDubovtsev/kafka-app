package app;

import java.io.Serializable;

public class Order implements Serializable {
    private String text;

    public String getText() {
        return text;
    }

    public Order(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Order{" +
                "text='" + text + '\'' +
                '}';
    }
}
