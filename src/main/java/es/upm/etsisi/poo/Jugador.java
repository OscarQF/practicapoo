package es.upm.etsisi.poo;

public class Jugador {
    private String nombre;
    private double puntuacion;
    private boolean emparejamiento;

    public Jugador(){
        this.nombre = "";
        this.puntuacion = 0.0;
        this.emparejamiento = false;
    }

    public Jugador(String nombre, double puntuacion, boolean emparejamiento) {
        this.nombre = nombre;
        this.puntuacion = puntuacion;
        this.emparejamiento = emparejamiento;
    }

    // METODOS
    public Jugador[] rankingJugadores(Jugador[] arrayJugadores){
        return null;
    }
    // GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public boolean isEmparejamiento() {
        return emparejamiento;
    }

    public void setEmparejamiento(boolean emparejamiento) {
        this.emparejamiento = emparejamiento;
    }
}
