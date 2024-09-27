package es.upm.etsisi.poo;

public class Emparejamiento {
    private Jugador jugador1;
    private Jugador jugador2;

    public Emparejamiento(){
        this.jugador1 = null;
        this.jugador2 = null;
    }

    public Emparejamiento(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    //GETTERS Y SETTERS
    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }
}
