// ================= PanelJuego.java (completo) =================
package src.vista;

import javax.swing.*;
import java.awt.*;

public class PanelJuego extends JPanel {
    private Boton[][] botones;
    private JLabel etiquetaTurno;
    public JButton btnVolverMenu;

    private final Color COLOR_FONDO = new Color(245,246,248);
    private final Color COLOR_PRIMARIO = new Color(40,40,40);
    private final Color COLOR_X = new Color(215, 38, 56);
    private final Color COLOR_O = new Color(37, 99, 235);

    public PanelJuego(){
        setLayout(null);
        setBackground(COLOR_FONDO);
        setSize(400,500);

        etiquetaTurno = new JLabel("Bienvenido al Tres en Raya", SwingConstants.CENTER);
        etiquetaTurno.setFont(new Font("SansSerif", Font.BOLD, 18));
        etiquetaTurno.setForeground(COLOR_PRIMARIO);
        etiquetaTurno.setBounds(50,20,300,30);
        add(etiquetaTurno);

        JPanel panelGrid = new JPanel(new GridLayout(3,3,5,5));
        panelGrid.setBounds(50,70,300,300);
        panelGrid.setBackground(COLOR_FONDO);

        botones = new Boton[3][3];
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j] = new Boton("", i, j);
                panelGrid.add(botones[i][j]);
            }
        }
        add(panelGrid);

        btnVolverMenu = new JButton("Menú Principal");
        btnVolverMenu.setBounds(100, 395, 200, 35);
        btnVolverMenu.setFont(new Font("SansSerif", Font.BOLD, 13));
        btnVolverMenu.setBackground(new Color(220, 225, 230));
        btnVolverMenu.setForeground(COLOR_PRIMARIO);
        btnVolverMenu.setFocusPainted(false);
        btnVolverMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnVolverMenu.setBorder(BorderFactory.createEmptyBorder());
        btnVolverMenu.setVisible(false);
        add(btnVolverMenu);
    }

    // Getter para que el controlador acceda a los botones
    public Boton[][] getBotones(){
        return botones;
    }

    public void CambiarTextoCasilla(int fila, int columna, char texto){
        String textoStr = String.valueOf(texto).toUpperCase();
        botones[fila][columna].setText(textoStr);
        if(textoStr.equals("X")){
            botones[fila][columna].setForeground(COLOR_X);
        }else if(textoStr.equals("O")){
            botones[fila][columna].setForeground(COLOR_O);
        }
    }

    public void ReiniciarVista(){
        LimpiarPanel();
        CambiarMensajeTurno("Bienvenido al Tres en Raya");
        btnVolverMenu.setVisible(false);
    }

    public void CambiarMensajeTurno(String mensaje){
        etiquetaTurno.setText(mensaje);
    }

    public void BloquearTablero(){
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j].setEnabled(false);
                botones[i][j].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }
    }

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