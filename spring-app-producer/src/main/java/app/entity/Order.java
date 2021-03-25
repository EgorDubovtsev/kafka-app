package app.entity;

import java.io.Serializable;

public class Order implements Serializable {
    private String text;
    private int id;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "text='" + text + '\'' +
                ", id=" + id +
                '}';
    }
}
