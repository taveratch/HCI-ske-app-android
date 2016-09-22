package com.example.taweesoft.hci_ske_app.models;

/**
 * Created by TAWEESOFT on 9/19/16 AD.
 */
public class Item {
    private int image;
    private String label;
    private boolean isClick;

    public Item(int image, String label) {
        this.image = image;
        this.label = label;
        this.isClick = false;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isClick() {
        return isClick;
    }

    public void setClick(boolean click) {
        isClick = click;
    }
}
