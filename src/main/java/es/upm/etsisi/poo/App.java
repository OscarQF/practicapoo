package es.upm.etsisi.poo;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
   static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        iniciarEvento();
    }
    public static void iniciarEvento(){
        int opcion;
        boolean salir = false;
        int numJugadores = 0;

        while(numJugadores <= 0 || numJugadores >10){
            System.out.println("Introduzca el numero de jugadores a participar: ");
            numJugadores = sc.nextInt();
        }

        Jugador[] jugadores = new Jugador[numJugadores];
        Emparejamiento[] listaEmparejamientos = new Emparejamiento[Math.round(jugadores.length/2)];

        while(!salir){
            System.out.println(
                    "1.> create [player]\n" +
                    "2.> remove [player]\n" +
                    "3.> show\n" +
                    "4.> rank\n" +
                    "5.> score [player];[score]\n" +
                    "6.> show_matchmake\n" +
                    "7.> clear_matchmake\n" +
                    "8.> matchmake [player1];[player2]\n" +
                    "9.> random_matchmake\n" +
                    "10.> end");
            sc.nextLine();
            opcion = sc.nextInt();

            if(opcion != 10){
                ejecutarEleccion(jugadores,listaEmparejamientos, opcion);
            } else {
                salir= true;
                sc.close();
            }
        }
    }

    public static  void ejecutarEleccion(Jugador[] jugadores, Emparejamiento[] emparejamientos, int opcion){
        switch (opcion){
            case 1:
                crearJugador(jugadores);
                break;
            case 2:
                //eliminarJugador();
                break;
            case 3:
                //mostrarJugadores();
                break;
            case 4:
                //mostrarRanking();
                break;
            case 5:
                //establecerPuntuacion();
                break;
            case 6:
                //mostrarEmparejamiento();
                break;
            case 7:
                //borrarEmparejamiento();
                break;
            case 8:
                //crearEmparejamiento();
                break;
            case 9:
                //emparejamientoRandom();
                break;

            default:
                System.out.println("Eleccion incorrecta");
        }
    }

    public static void crearJugador(Jugador[] jugadores){
        String nombre = "";
        System.out.println("Introduzca el nombre del jugador: ");
        nombre = sc.nextLine();
        boolean encontrado = false;
        int indice = 0;

        while(!encontrado){
            Jugador aux = jugadores[indice];
            if(aux.getNombre().equalsIgnoreCase(nombre)){
                encontrado = true;
            }
            indice++;
        }

        if(!encontrado){
            Jugador jugador = new Jugador(nombre,0.0,false);
            if(aniadirJugador(jugador)){
                System.out.println("Jugador añadido cre");
            }
        }

    }

    public static boolean aniadirJugador(Jugador jugador){
        return null;
    }
}
