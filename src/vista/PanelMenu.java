package src.vista;

import javax.swing.*;
import java.awt.*;

public class PanelMenu extends JPanel {
    //Inicializamos variables
    private JButton btnLocal;
    private JButton btnIA;
    private JButton btnOnline;

    // Colores limpios y modernos (misma paleta que tu panel de juego y tu sudoku)
    private final Color COLOR_FONDO = new Color(245, 246, 248);
    private final Color COLOR_PRIMARIO = new Color(40, 40, 40);
    private final Color COLOR_BOTON = new Color(37, 99, 235);     // Azul moderno

    public PanelMenu() {
        setLayout(null);
        setBackground(COLOR_FONDO);
        setSize(400, 500);

        // ================= TÍTULO Y SUBTÍTULO =================
        JLabel titulo = new JLabel("TRES EN RAYA", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 32));
        titulo.setForeground(COLOR_PRIMARIO);
        titulo.setBounds(50, 60, 300, 50);
        add(titulo);

        JLabel subtitulo = new JLabel("Elige tu modo de juego", SwingConstants.CENTER);
        subtitulo.setFont(new Font("SansSerif", Font.PLAIN, 14));
        subtitulo.setForeground(new Color(100, 100, 100));
        subtitulo.setBounds(50, 115, 300, 25);
        add(subtitulo);

        // ================= BOTONES DE OPCIONES =================

        // 1. Modo Local (1 vs 1)
        btnLocal = new JButton("1 VS 1 Local");
        EstilizarBoton(btnLocal, 170);
        add(btnLocal);

        // 2. Modo contra la Inteligencia Artificial (Minimax)
        btnIA = new JButton("Jugador VS IA");
        EstilizarBoton(btnIA, 235);
        add(btnIA);

        // 3. Modo Online (Preparado y desactivado para el futuro)
        btnOnline = new JButton("Multijugador Online (Pronto)");
        EstilizarBoton(btnOnline, 300);
        btnOnline.setEnabled(false); // Desactivado por ahora
        btnOnline.setBackground(new Color(200, 205, 215)); // Color grisáceo neutral
        add(btnOnline);
    }

    // Método auxiliar para no repetir código de diseño en los botones
    private void EstilizarBoton(JButton boton, int y) {
        boton.setBounds(75, y, 250, 45);
        boton.setFont(new Font("SansSerif", Font.BOLD, 14));
        boton.setForeground(Color.WHITE);
        boton.setBackground(COLOR_BOTON);
        boton.setFocusPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setBorder(BorderFactory.createEmptyBorder());
    }

    // ================= GETTERS PARA EL CONTROLADOR =================
    // Permiten que VentanaPrincipal escuche los clics sin usar 'implements ActionListener'

    public JButton getBtnLocal() {
        return btnLocal;
    }

    public JButton getBtnIA() {
        return btnIA;
    }

    public JButton getBtnOnline() {
        return btnOnline;
    }
}
