package src.modelo;

public class MinimaxIA{
    //Algoritmo de minimax aplicado para el tictactoe

    //Buscamos el mejor movimiento posible
    public int[] obtenerMejorMovimiento(Tablero tablero, char fichaAI, char fichaJugador){
        int mejorPuntuacion = -1000;
        int[] mejorMovimiento = {-1, -1};

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(tablero.CasillaLibre(i,j)){
                    //Simulamos el movimiento de la ia
                    tablero.ColocarFicha(i,j,fichaAI);

                    //Llamamos a minimax para que nos de la puntuación
                    int puntuacionMovimiento = Minimax(tablero, false, fichaAI, fichaJugador);

                    //Reseteamos el movimiento
                    tablero.ResetearCasilla(i,j);

                    //Nos quedamos con la jugada que da mayor puntuación
                    if(puntuacionMovimiento > mejorPuntuacion){
                        mejorPuntuacion = puntuacionMovimiento;
                        mejorMovimiento[0] = i;
                        mejorMovimiento[1] = j;
                    }
                }
            }
        }
        return mejorMovimiento;
    }

    //El algoritmo recursivo de minimax
    private int Minimax(Tablero tablero, boolean esMaximizador, char fichaAI, char fichaJugador){
        //Comprobamos el estado de la partida, es decir si hay ganador o si el ultimo en mover fue la ia
        if(tablero.ComprobarGanador()){
            if(esMaximizador){
                return -10;
            }else {
                return 10;
            }
        }else if(tablero.esEmpate()){
            return 0;
        }
        //Es el humano que juega, va a asumir que el humano va a jugar perfecto
        if(esMaximizador){
            int maxPuntuacion = -1000;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if(tablero.CasillaLibre(i, j)){
                        tablero.ColocarFicha(i, j, fichaAI);
                        int puntuacion = Minimax(tablero, false, fichaAI, fichaJugador);
                        tablero.ResetearCasilla(i,j);
                        maxPuntuacion = Math.max(maxPuntuacion, puntuacion);
                    }
                }
            }
            return maxPuntuacion;
        }else{
            //Aqui es la IA que va a jugar intentando buscar el mejor movimiento
            int minPuntuacion = 1000;
            for(int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(tablero.CasillaLibre(i,j)){
                        tablero.ColocarFicha(i,j,fichaJugador);
                        int puntuacion = Minimax(tablero, true, fichaAI, fichaJugador);
                        tablero.ResetearCasilla(i,j);
                        minPuntuacion = Math.min(minPuntuacion, puntuacion);
                    }
                }
            }
            return minPuntuacion;
        }
    }
}

