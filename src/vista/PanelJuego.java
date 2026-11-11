package src.vista;

import javax.swing.*;
import java.awt.*;

public class PanelJuego extends JPanel {
    //Iniciamos las variables
    private JButton[][] botones; //Usaremos los botones matriz
    private JLabel etiquetaTurno;
    public JButton btnVolverMenu; // Botón para volver al menú

    //Colores para la estetica
    private final Color COLOR_FONDO = new Color(245,246,248);
    private final Color COLOR_PRIMARIO = new Color(40,40,40);
    private final Color COLOR_X = new Color(215, 38, 56);
    private final Color COLOR_O = new Color(37, 99, 235);

    //Primera vez que lo hago lo de interfaz, devuelve fila y columna
    public interface CasillaListener{
        void onCasillaClicked(int fila, int columna);
    }

    private CasillaListener listener;

    public void setCasillaClickListener(CasillaListener listener){
        this.listener = listener;
    }

    // Interfaz para el botón de volver al menú
    public interface MenuListener{
        void onVolverMenuClicked();
    }

    private MenuListener menuListener;

    public void setMenuClickListener(MenuListener menuListener){
        this.menuListener = menuListener;
    }

    //Constructor
    public PanelJuego(){
        //Posicionamiento junto a color de fondo pantalla
        setLayout(null);
        setBackground(COLOR_FONDO);
        setSize(400,500);

        //================== ETIQUETA DE TURNO ======================
        etiquetaTurno = new JLabel("Bienvenido al Tres en Raya", SwingConstants.CENTER);
        etiquetaTurno.setFont(new Font("SansSerif", Font.BOLD, 18));
        etiquetaTurno.setForeground(COLOR_PRIMARIO);
        etiquetaTurno.setBounds(50,20,300,30);
        add(etiquetaTurno);

        //================= TABLERO 3X3 DE BOTONES =================
        JPanel panelGrid = new JPanel(new GridLayout(3,3,5,5));
        panelGrid.setBounds(50,70,300,300);
        panelGrid.setBackground(COLOR_FONDO);

        botones = new JButton[3][3];

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                JButton casilla = new JButton("");
                casilla.setFont(new Font("SansSerif", Font.BOLD, 52));
                casilla.setFocusPainted(false);
                casilla.setBackground(Color.WHITE);
                casilla.setCursor(new Cursor(Cursor.HAND_CURSOR));
                casilla.setBorder(BorderFactory.createLineBorder(new Color(210, 215, 220), 2));
                final int fila = i;
                final int columna = j;

                //Aqui les agregamos un evento!! Somos el chivato que avisa que alguien ha hecho click
                casilla.addActionListener(e ->{
                    if (listener != null) {
                        listener.onCasillaClicked(fila, columna);
                    }
                });

                botones[i][j] = casilla;
                panelGrid.add(casilla);

            }
        }
        add(panelGrid);

        //================= BOTÓN VOLVER AL MENÚ =================
        btnVolverMenu = new JButton("Menú Principal");
        btnVolverMenu.setBounds(100, 395, 200, 35);
        btnVolverMenu.setFont(new Font("SansSerif", Font.BOLD, 13));
        btnVolverMenu.setBackground(new Color(220, 225, 230));
        btnVolverMenu.setForeground(COLOR_PRIMARIO);
        btnVolverMenu.setFocusPainted(false);
        btnVolverMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnVolverMenu.setBorder(BorderFactory.createEmptyBorder());
        btnVolverMenu.setVisible(false);

        btnVolverMenu.addActionListener(e -> {
            if (menuListener != null) {
                menuListener.onVolverMenuClicked();
            }
        });

        add(btnVolverMenu);
    }

    //========= MÉTODOS DE CONTROL VISUAL ================
    //Pintar la ficha con su color
    public void CambiarTextoCasilla(int fila, int columna, char texto){
        String textoStr = String.valueOf(texto).toUpperCase();
        botones[fila][columna].setText(textoStr);
        if(textoStr.equals("X")){
            botones[fila][columna].setForeground(COLOR_X);
        }else if(textoStr.equals("O")){
            botones[fila][columna].setForeground(COLOR_O);
        }
    }
    //Cambiar la etiqueta de turno
    public void CambiarMensajeTurno(String mensaje){
        etiquetaTurno.setText(mensaje);
    }

    //Bloquear el tablero al acabar partida
    public void BloquearTablero(){
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j].setEnabled(false);
                botones[i][j].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }
    }


    //Meodo para limpiar el tablero
    public void LimpiarPanel(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j].setText("");
                botones[i][j].setEnabled(true);
                botones[i][j].setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        }
    }
}
