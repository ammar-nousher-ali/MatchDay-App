package com.example.tynicfilter;

public class Item {
    int index;
    String numberText;
    boolean found;

    public Item(int index, String numberText,boolean found) {
        this.index = index;
        this.numberText = numberText;
        this.found = found;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public Item() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getNumberText() {
        return numberText;
    }

    public void setNumberText(String numberText) {
        this.numberText = numberText;
    }
}
