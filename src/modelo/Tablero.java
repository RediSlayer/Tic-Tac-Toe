package src.modelo;

public class Tablero{

    //Variables
    private char[][] tablero; //Tablero del juego
    private int movimientosRealizados; //Moviemientos Realizados en la partida

    //Constructor
    public Tablero(){
        tablero = new char[3][3];
        IniciarTablero();
    }

    //Inicia el juego
    public void IniciarTablero(){
        movimientosRealizados = 0;
        //Llenamos el tablero de ''
        for(int i = 0; i < tablero.length; i++){
            for(int j = 0 ; j < tablero[i].length; j++){
                tablero[i][j] = ' ';
            }
        }
    }

    //Verificar si hay casilla libre
    public boolean CasillaLibre(int fila, int columna){
        //Verificamos de que no se depase por si alguien se pasa de gracioso
        if(fila < 0 || fila > 2 || columna < 0 || columna > 2){
            return false;
        }else {
            return tablero[fila][columna] == ' ';
        }
    }

    //Coloca una ficha en la casilla
    public boolean ColocarFicha(int fila, int columna, char ficha){
        //Si la casilla esta libre, procedemos a colocar la ficha
        if(CasillaLibre(fila, columna)){
            tablero[fila][columna] = ficha;
            movimientosRealizados++;
            return true;
        } else{
            return false;
        }

    }

    //Comprobar si hay victoria
    public boolean ComprobarGanador(){
        //Revisamos las filas y columnas
        for(int i = 0; i < 3; i++){
            if(tablero[i][0] != ' ' && tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]){
                return true;
            }else if(tablero[0][i] != ' ' && tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i]){
                return true;
            }
        }
        //Revisamos las diagonales
        if(tablero[0][0] != ' ' && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]){
            return true;
        } else if(tablero[0][2] != ' ' && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]){
            return true;
        }

        //Por si nadie gana
        return false;
    }

    //Verificamos si hay empate y no hay ganador
    public boolean esEmpate(){
        //Verificamos si hay empate y no hay ganador
        if(movimientosRealizados == 9 && !ComprobarGanador()){
            return true;
        } else{
            return false;
        }
    }

    //Función getter para la ia
    public char getCasilla(int fila, int columna){
        return tablero[fila][columna];
    }

    //Metodo para bactracking de la ia
    public void ResetearCasilla(int fila, int columna){
        if(tablero[fila][columna] != ' '){
            tablero[fila][columna] = ' ';
            movimientosRealizados--;
        }
    }
}
