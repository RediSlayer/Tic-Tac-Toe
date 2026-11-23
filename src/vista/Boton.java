package src.vista;

import javax.swing.*;
import java.awt.*;

public class Boton extends JButton {
    private final int fila;
    private final int columna;

    //Constructor de la clase Botón
    public Boton(String txt, int fila, int columna){
        super(txt); //Texto X o O
        this.fila = fila;
        this.columna = columna;

        //Configuración visual
        this.setFont(new Font("SansSerif", Font.BOLD, 52));
        this.setFocusPainted(false);
        this.setBackground(Color.WHITE);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setBorder(BorderFactory.createLineBorder(new Color(210, 215, 220), 2));
    }

    //Getter para la fila
    public int getFila(){return this.fila;}

    //Getter para la columna
    public int getColumna(){return this.columna;}
}
