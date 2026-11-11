import javax.swing.*;
import java.awt.event.*;
public class TicTacToe extends JFrame implements ActionListener{
	
	//Variables privadas, ya que solo las uso en mi clase
	private boolean juegoTerminado = false; //Estado del juego, si hay ganador o no
	private char[][] tablero; //Matriz de 3x3, !!recuerda que los chars van con ''!!
	private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9; //botones de cogeran cada lugar en matriz
	private JLabel turnoEtiqueta; //Etiqueta de información
	private int turno; //Si es par jugador 2 si es impar jugador 1 y si es turno 9, si no hay ganador hay empate
	
	//Tablero iniciado con 
	public void iniciarTablero(){
		tablero = new char[3][3];
		for (int i = 0; i < tablero.length; i++){
			for (int j = 0; j < tablero[i].length; j++){
				tablero[i][j] = ' ';
			}
		}
	}
	
	//Turno jugador
	public void whoPlays(){
		if (turno % 2 == 0){
			turnoEtiqueta.setText("Jugador 2");
		} else {
			turnoEtiqueta.setText("Jugador 1");
		}
		
	}
	
	//Nos dice si ha ganado
	public boolean whoWin(){
		for (int i = 0; i < 3; i++){
		//Los chars van con ''
		if ((tablero[0][0] != ' ' && tablero[1][1] == tablero[2][2] && tablero[0][0] == tablero [2][2] ) || (tablero[0][2] != ' ' && tablero[1][1] == tablero[0][2] && tablero[2][0] == tablero[0][2])){
			return true;
		}
		if (tablero[i][0] != ' ' && tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]) {
			return true; 
		}
		if (tablero[0][i] != ' ' && tablero[0][i] == tablero[1][i] && tablero[0][i] == tablero[2][i]) {
			return true; 
		}
		}
		//Por si nadie gana (Caso general)
		return false;
	}
	
	//Verificamos si casilla libre antes de colocar x||o
	public boolean casillaLibre(int fila, int columna){
		return tablero[fila][columna] == ' ';
		
	}
	
	//Gestión de eventos
	public void actionPerformed(ActionEvent btn){
		//Si alguien ha ganado pues se para todo
		    if (juegoTerminado) {
        return; 
    }
		//Jugada permitida	
		boolean jugadaValida = false;
		
		//Boton 1
		if (btn.getSource() == b1){
			if(casillaLibre(0, 0)){
				if (turno % 2 == 0){
					tablero[0][0] = 'o';
					b1.setText("o");
				}else{
					tablero[0][0] = 'x';
					b1.setText("x");
				}
				jugadaValida = true;
			}
		}
		//Boton 2
		if (btn.getSource() == b2){
			if(casillaLibre(0, 1)){
				if (turno % 2 == 0){
					tablero[0][1] = 'o';
					b2.setText("o");
				}else{
					tablero[0][1] = 'x';
					b2.setText("x");
				}
				jugadaValida = true;
			}
		}
		//Boton 3
		if (btn.getSource() == b3){
			if(casillaLibre(0, 2)){
				if (turno % 2 == 0){
					tablero[0][2] = 'o';
					b3.setText("o");
				}else{
					tablero[0][2] = 'x';
					b3.setText("x");
				}
				jugadaValida = true;
			}
		}
		//Boton 4
		if (btn.getSource() == b4){
			if(casillaLibre(1,0)){
				if (turno % 2 == 0){
					tablero[1][0] = 'o';
					b4.setText("o");
				}else{
					tablero[1][0] = 'x';
					b4.setText("x");
				}
				jugadaValida = true;
			}
		}
		//Boton 5
		if (btn.getSource() == b5){
			if(casillaLibre(1,1)){
				if (turno % 2 == 0){
					tablero[1][1] = 'o';
					b5.setText("o");
				}else{
					tablero[1][1] = 'x';
					b5.setText("x");
				}
				jugadaValida = true;
			}
		}
		//Boton 6
		if (btn.getSource() == b6){
			if(casillaLibre(1,2)){
				if (turno % 2 == 0){
					tablero[1][2] = 'o';
					b6.setText("o");
				}else{
					tablero[1][2] = 'x';
					b6.setText("x");
				}
				jugadaValida = true;
			}
		}
		//Boton 7
		if (btn.getSource() == b7){
			if(casillaLibre(2,0)){
				if (turno % 2 == 0){
					tablero[2][0] = 'o';
					b7.setText("o");
				}else{
					tablero[2][0] = 'x';
					b7.setText("x");
				}
				jugadaValida = true;
			}
		}
		//Boton 8
		if (btn.getSource() == b8){
			if(casillaLibre(2,1)){
				if (turno % 2 == 0){
					tablero[2][1] = 'o';
					b8.setText("o");
				}else{
					tablero[2][1] = 'x';
					b8.setText("x");
				}
				jugadaValida = true;
			}
		}
		//Boton 9
		if (btn.getSource() == b9){
			if(casillaLibre(2,2)){
				if (turno % 2 == 0){
					tablero[2][2] = 'o';
					b9.setText("o");
				}else{
					tablero[2][2] = 'x';
					b9.setText("x");
				}
				jugadaValida = true;
			}
		}
		//Verificamos si jugada es valida, pasamos a comprobar si ha ganado y si no pues pasamos siguiente jugador o si hay empate
		if (jugadaValida){
			if (whoWin()){
				if (turno % 2 == 0){
					turnoEtiqueta.setText("Ha ganado el jugador 2! ");
					juegoTerminado = true;
				} else {
					turnoEtiqueta.setText("Ha ganado el jugador 1!");
					juegoTerminado = true;
				}
			}else if(turno == 9){
				turnoEtiqueta.setText("Juego terminado, empate");
				juegoTerminado = true;
			}else{
				turno++;
				whoPlays();
			}
		}
	}
	
	//Constructor
	public TicTacToe(){
		setLayout(null);
		turno = 1;
		iniciarTablero();
		//----------------------------------
		//Boton 1,2,3
		//----------------------------------
		b1 = new JButton();
		b1.setBounds(10,100,90,30);
		add(b1);
		b1.addActionListener(this); //Indico que agrego una acción tt, importante
		//----------------------------------
		b2 = new JButton();
		b2.setBounds(110,100,90,30);
		add(b2);
		b2.addActionListener(this);
		//----------------------------------
		b3 = new JButton();
		b3.setBounds(210,100,90,30);
		add(b3);
		b3.addActionListener(this);
		//----------------------------------
		//Boton 4,5,6
		//----------------------------------
		b4 = new JButton();
		b4.setBounds(10,135,90,30);
		add(b4);
		b4.addActionListener(this); //Indico que agrego una acción tt, importante
		//----------------------------------
		b5 = new JButton();
		b5.setBounds(110,135,90,30);
		add(b5);
		b5.addActionListener(this);
		//----------------------------------
		b6 = new JButton();
		b6.setBounds(210,135,90,30);
		add(b6);
		b6.addActionListener(this);
		//----------------------------------
		//Boton 7,8,9
		//----------------------------------
		b7 = new JButton();
		b7.setBounds(10,170,90,30);
		add(b7);
		b7.addActionListener(this); //Indico que agrego una acción tt, importante
		//----------------------------------
		b8 = new JButton();
		b8.setBounds(110,170,90,30);
		add(b8);
		b8.addActionListener(this);
		//----------------------------------
		b9 = new JButton();
		b9.setBounds(210,170,90,30);
		add(b9);
		b9.addActionListener(this);
		//----------------------------------
		turnoEtiqueta = new JLabel("Bienvenido!");
		turnoEtiqueta.setBounds(10,10,300,30);
		add(turnoEtiqueta);
		whoPlays();
		
	}
	
	//Main de toda la vida
	public static void main(String args[]){
		TicTacToe interfaz = new TicTacToe();
		interfaz.setTitle("Tres en raya");
		interfaz.setBounds(0,0,350,250);
		interfaz.setLocationRelativeTo(null);
		interfaz.setVisible(true);
		interfaz.setResizable(false);
		interfaz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}