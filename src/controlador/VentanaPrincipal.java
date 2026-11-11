package src.controlador;
import src.modelo.*;
import src.vista.*;
import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame{
    //Inicializamos variables
    private CardLayout cardLayout;
    private JPanel contenedor;
    private PanelMenu panelMenu;
    private PanelJuego panelJuego;

    //Inicializamos tablero y la ia
    private Tablero tablero;
    private MinimaxIA minimaxIA;

    //Estado del juego
    private String modoJuego; //Si local o ia
    private char turnoActual; // Las fichas X o O
    private boolean juegoTerminado; //Variable de control

    //Constructor
    public VentanaPrincipal(){
        //Configuración inicial de la ventana
        super("Tres en Raya");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400,500);
        setResizable(false);
        setLocationRelativeTo(null);

        // 1. Inicializar Modelo
        tablero = new Tablero();
        minimaxIA = new MinimaxIA();
        turnoActual = 'X';
        juegoTerminado = false;

        //2. Configurar el contenedor con CardLayout
        cardLayout = new CardLayout();
        contenedor = new JPanel(cardLayout);

        panelMenu = new PanelMenu();
        panelJuego = new PanelJuego();

        //Registra donde se hace click
        panelJuego.setCasillaClickListener((fila, columna) -> {
            GestionarJugada(fila, columna);
        });

        //Registra el click del botón "Menú Principal" (antes no estaba registrado)
        panelJuego.setMenuClickListener(() -> VolverAlMenu());

        contenedor.add(panelMenu, "MENU");
        contenedor.add(panelJuego, "JUEGO");
        add(contenedor);

        //3. Configurar los eventos de los botones del Menú
        panelMenu.getBtnLocal().addActionListener(e -> IniciarPartida("Local"));
        panelMenu.getBtnIA().addActionListener(e -> IniciarPartida("IA"));

        //4. Mostrar el menú
        cardLayout.show(contenedor, "MENU");
    }

    //Metodo para preparar una nueva partida según el modo elegido
    private void IniciarPartida(String modo){
        this.modoJuego = modo;
        tablero.IniciarTablero();
        panelJuego.LimpiarPanel();
        turnoActual = 'X';
        juegoTerminado = false;

        panelJuego.btnVolverMenu.setVisible(false); //Se oculta hasta que acabe la partida
        panelJuego.CambiarMensajeTurno("Turno del jugador: X");
        cardLayout.show(contenedor, "JUEGO");
    }

    //Metodo principal cuando se hace clic en casilla del tablero
    public void GestionarJugada(int fila, int columna){
        if(juegoTerminado){
            return;
        }

        //Intentamos colocar la ficha
        if(tablero.ColocarFicha(fila, columna, turnoActual)){
            panelJuego.CambiarTextoCasilla(fila, columna, turnoActual);

            //Comprobar si hay victoria o empate
            if(tablero.ComprobarGanador()){
                FinalizarPartida("¡Ha ganado el jugador " + turnoActual + "!");
                return;
            } else if (tablero.esEmpate()){
                FinalizarPartida("¡Juego terminado en empate!");
                return;
            }

            //Cambiar el turno
            CambiarTurno();

            //Si estamos en modo IA y le toco a la 'O' que mueva la ia
            if(modoJuego.equals("IA") && turnoActual == 'O' && !juegoTerminado){
                EjecutarTurnoIA();
            }
        }
    }

    //Se encarga de actualizar el turno y la etiquetaTurno
    private void CambiarTurno(){
        if (turnoActual == 'X') {
            turnoActual = 'O';
        } else {
            turnoActual = 'X';
        }
        panelJuego.CambiarMensajeTurno("Turno del jugador: " + turnoActual);
    }

    //Cierra la partida: mensaje, bloqueo del tablero y botón para volver al menú
    private void FinalizarPartida(String mensaje){
        panelJuego.CambiarMensajeTurno(mensaje);
        panelJuego.BloquearTablero();
        panelJuego.btnVolverMenu.setVisible(true);
        panelJuego.btnVolverMenu.setEnabled(true);
        juegoTerminado = true;
    }

    //Volver al menu
    public void VolverAlMenu(){
        cardLayout.show(contenedor, "MENU");
    }

    //Se encarga de hacer jugar a la ia
    private void EjecutarTurnoIA(){
        int[] movimiento = minimaxIA.obtenerMejorMovimiento(tablero, 'O', 'X');
        int fila = movimiento[0];
        int col = movimiento[1];
        if(fila != -1 && col != -1){
            tablero.ColocarFicha(fila, col, 'O');
            panelJuego.CambiarTextoCasilla(fila, col, 'O');

            if(tablero.ComprobarGanador()){
                FinalizarPartida("¡Ha ganado la IA!");
            } else if(tablero.esEmpate()){
                FinalizarPartida("¡Empate!");
            } else {
                CambiarTurno();
            }
        }
    }

    //Main de toda la vida
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            VentanaPrincipal app = new VentanaPrincipal();
            app.setVisible(true);
        });
    }
}
