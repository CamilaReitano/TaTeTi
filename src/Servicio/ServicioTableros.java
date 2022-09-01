/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidad.TaTeTi;
import java.util.Scanner;

/**
 *
 * @author camir
 */
public class ServicioTableros {

    Scanner leer = new Scanner(System.in);

    public TaTeTi creartablero() {
        boolean turno = true;
        String jugador = "x";
        String computadora = "o";
        int progresoJuego = 0;
        int contadorProgreso = 0;
        String[] cuadro = new String[9];

        for (int i = 0; i < 9; i++) {
            cuadro[i] = "-";
            System.out.print(cuadro[i]);
            if (i == 2 || i == 5 || i == 8) {
                System.out.println();
            }

        }
        return new TaTeTi(cuadro, jugador, computadora, progresoJuego, turno, contadorProgreso);
    }

    public void jugar(TaTeTi t) {
        int lugar = -1;

        do {
            if (t.isTurno()) {
                System.out.println("....Turno Computadora....");
                do {
                    lugar = (int) (Math.random() * 9);
                } while (!t.getTablero()[lugar].equals("-"));
                t.getTablero()[lugar] = t.getComputadora();
                mostrarTablero(t);
                t.setTurno(false);
                progJuego(t);

            } else {
                System.out.println("Elejir un lugar");
                do {
                    lugar = leer.nextInt();
                } while (!t.getTablero()[lugar].equals("-"));
                t.getTablero()[lugar] = t.getJugador();
                // t.tablero[lugar] = t.getJugador();
                mostrarTablero(t);
                t.setTurno(true);
                progJuego(t);

            }

        } while (t.getProgresoJuego() == 0);

    }

    public void mostrarTablero(TaTeTi t) {
        for (int i = 0; i < 9; i++) {
            System.out.print(t.getTablero()[i]);
            if (i == 2 || i == 5 || i == 8) {
                System.out.println();
            }
        }
    }

    public void progJuego(TaTeTi t) {

        t.setContadorProgreso(t.getContadorProgreso() + 1);

        for (int i = 0; i < 9; i += 3) {  //Evalua las lineas orizontales
            if (t.getTablero()[i].equals("o") & t.getTablero()[(i + 1)].equals("o") & t.getTablero()[(i + 2)].equals("o")) {
                t.setProgresoJuego(-1);
                System.out.println("Has Perdido");

            } else if (t.getTablero()[i].equals("x") & t.getTablero()[(i + 1)].equals("x") & t.getTablero()[(i + 2)].equals("x")) {
                t.setProgresoJuego(1);
                System.out.println("Has ganado");
            }
        }

        for (int i = 0; i < 3; i++) {  //Evalua las lineas verticales
            if (t.getTablero()[i].equals("o") & t.getTablero()[(i + 3)].equals("o") & t.getTablero()[(i + 6)].equals("o")) {
                t.setProgresoJuego(-1);
                System.out.println("Has Perdido");

            } else if (t.getTablero()[i].equals("x") & t.getTablero()[(i + 3)].equals("x") & t.getTablero()[(i + 6)].equals("x")) {
                t.setProgresoJuego(1);
                System.out.println("Has ganado");
            }
        }

        // Evalua diagonal principal
        if (t.getTablero()[0].equals("o") & t.getTablero()[4].equals("o") & t.getTablero()[8].equals("o")) {
            t.setProgresoJuego(-1);
            System.out.println("Has perdido");
        } else if (t.getTablero()[0].equals("x") & t.getTablero()[4].equals("x") & t.getTablero()[8].equals("x")) {
            t.setProgresoJuego(1);
            System.out.println("Has ganado");

        }

        //Evalua segunda diagonal
        if (t.getTablero()[2].equals("o") & t.getTablero()[4].equals("o") & t.getTablero()[6].equals("o")) {
            t.setProgresoJuego(-1);
            System.out.println("Has perdido");
        } else if (t.getTablero()[2].equals("x") & t.getTablero()[4].equals("x") & t.getTablero()[6].equals("x")) {
            t.setProgresoJuego(1);
            System.out.println("Has ganado");

        }

        if (t.getContadorProgreso() == 9) {  //Evalua un empate
            t.setProgresoJuego(2);
            System.out.println("Has empatado");
        }
    }
}

//--------------------------OTRO MODO DE EVALUAR EL PROGRESO DEL JUEGO-----------------------------------------------------

//    public int progresoJuego(TaTeTi t) {
//        t.setContadorProgreso(t.getContadorProgreso() + 1);
//
//        if (t.getTablero()[0].equals("o") & t.getTablero()[1].equals("o") & t.getTablero()[2].equals("o")) {
//            t.setProgresoJuego(1);
//            System.out.println("Has Perdido");
//        } else if (t.getTablero()[3].equals("o") & t.getTablero()[4].equals("o") & t.getTablero()[5].equals("o")) {
//            t.setProgresoJuego(1);
//            System.out.println("Has Perdido");
//        } else if (t.getTablero()[6].equals("o") & t.getTablero()[7].equals("o") & t.getTablero()[8].equals("o")) {
//            t.setProgresoJuego(1);
//            System.out.println("Has Perdido");
//        } else if (t.getTablero()[0].equals("o") & t.getTablero()[3].equals("o") & t.getTablero()[6].equals("o")) {
//            t.setProgresoJuego(1);
//            System.out.println("Has Perdido");
//        } else if (t.getTablero()[1].equals("o") & t.getTablero()[4].equals("o") & t.getTablero()[7].equals("o")) {
//            t.setProgresoJuego(1);
//            System.out.println("Has Perdido");
//        } else if (t.getTablero()[2].equals("o") & t.getTablero()[5].equals("o") & t.getTablero()[8].equals("o")) {
//            t.setProgresoJuego(1);
//            System.out.println("Has Perdido");
//        } else if (t.getTablero()[0].equals("o") & t.getTablero()[4].equals("o") & t.getTablero()[8].equals("o")) {
//            t.setProgresoJuego(1);
//            System.out.println("Has Perdido");
//        } else if (t.getTablero()[2].equals("o") & t.getTablero()[4].equals("o") & t.getTablero()[6].equals("o")) {
//            t.setProgresoJuego(1);
//            System.out.println("Has Perdido");
//        } else if (t.getTablero()[0].equals("x") & t.getTablero()[1].equals("x") & t.getTablero()[2].equals("x")) {
//            t.setProgresoJuego(1);
//            System.out.println("Has ganado");
//        } else if (t.getTablero()[3].equals("x") & t.getTablero()[4].equals("x") & t.getTablero()[5].equals("x")) {
//            t.setProgresoJuego(1);
//            System.out.println("Has ganado");
//        } else if (t.getTablero()[6].equals("x") & t.getTablero()[7].equals("x") & t.getTablero()[8].equals("x")) {
//            t.setProgresoJuego(1);
//            System.out.println("Has ganado");
//        } else if (t.getTablero()[0].equals("x") & t.getTablero()[3].equals("x") & t.getTablero()[6].equals("x")) {
//            t.setProgresoJuego(1);
//            System.out.println("Has ganado");
//        } else if (t.getTablero()[1].equals("x") & t.getTablero()[4].equals("x") & t.getTablero()[7].equals("x")) {
//            t.setProgresoJuego(1);
//            System.out.println("Has ganado");
//        } else if (t.getTablero()[2].equals("x") & t.getTablero()[5].equals("x") & t.getTablero()[8].equals("x")) {
//            t.setProgresoJuego(1);
//            System.out.println("Has ganado");
//        } else if (t.getTablero()[0].equals("x") & t.getTablero()[4].equals("x") & t.getTablero()[8].equals("x")) {
//            t.setProgresoJuego(1);
//            System.out.println("Has ganado");
//        } else if (t.getTablero()[2].equals("x") & t.getTablero()[4].equals("x") & t.getTablero()[6].equals("x")) {
//            t.setProgresoJuego(1);
//            System.out.println("Has ganado");
//        } else if (t.getContadorProgreso() == 9) {
//            t.setProgresoJuego(2);
//            System.out.println("Has empatado");
//        }
//
//        return t.getProgresoJuego();
//    }
