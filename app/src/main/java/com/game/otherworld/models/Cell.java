package com.game.otherworld.models;

import android.widget.ImageButton;

public class Cell {
    protected Casilla casilla;
    protected ImageButton imageButton;

    public Cell(Casilla casilla, ImageButton imageButton) {
        this.setCasilla(casilla);
        this.setImageButton(imageButton);
    }

    public Casilla getCasilla() {
        return casilla;
    }
    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }

    public ImageButton getImageButton() {
        return imageButton;
    }
    public void setImageButton(ImageButton imageButton) {
        this.imageButton = imageButton;
    }
}
