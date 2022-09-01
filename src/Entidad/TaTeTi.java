
package Entidad;

public class TaTeTi {
   private String[] tablero;
   private String jugador;
   private String computadora;
   private int progresoJuego;
   private int contadorProgreso;
   private boolean turno;

    public TaTeTi() {
    }

    public TaTeTi(String[] tablero, String jugador, String computadora, int progresoJuego, boolean turno, int contadorProgreso) {
        this.tablero = tablero;
        this.jugador = jugador;
        this.computadora = computadora;
        this.progresoJuego = progresoJuego;
        this.turno = turno;
        this.contadorProgreso = contadorProgreso;
    }

    public String[] getTablero() {
        return tablero;
    }

    public void setTablero(String[] tablero) {
        this.tablero = tablero;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public String getComputadora() {
        return computadora;
    }

    public void setComputadora(String computadora) {
        this.computadora = computadora;
    }

    public int getProgresoJuego() {
        return progresoJuego;
    }

    public void setProgresoJuego(int progresoJuego) {
        this.progresoJuego = progresoJuego;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public int getContadorProgreso() {
        return contadorProgreso;
    }

    public void setContadorProgreso(int contadorProgreso) {
        this.contadorProgreso = contadorProgreso;
    }
    
    

    @Override
    public String toString() {
        return "TaTeTi{" + "tablero=" + tablero + ", jugador=" + jugador + ", computadora=" + computadora + ", progresoJuego=" + progresoJuego + '}';
    }

   
   
}
