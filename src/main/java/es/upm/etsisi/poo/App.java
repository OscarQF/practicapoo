package es.upm.etsisi.poo;

import java.util.Scanner;

public class App {
   static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        startEvent();
    }
    public static void startEvent(){
        int option;
        boolean exit = false;
        int numPlayers = 0;

        while(numPlayers <= 0 || numPlayers >10){
            System.out.println("Introduzca el numero de jugadores a participar: ");
            numPlayers = sc.nextInt();
        }

        Player[] players = new Player[numPlayers];
        Matchmaking[] listMatchmakings = new Matchmaking[Math.round(players.length/2)];

        while(!exit){
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
            option = sc.nextInt();

            if(option != 10){
                runElection(players, listMatchmakings, option);
            } else {
                exit= true;
                sc.close();
            }
        }
    }

    public static  void runElection(Player[] players, Matchmaking[] matchmakings, int option){
        switch (option){
            case 1:
                createPlayer(players);
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

    public static void createPlayer(Player[] players){
        String name = "";
        System.out.println("Introduzca el nombre del jugador: ");
        name = sc.nextLine();
        boolean found = false;
        int index = 0;

        while(!found){
            Player aux = players[index];
            if(aux.getName().equalsIgnoreCase(name)){
                found = true;
            }
            index++;
        }

        if(!found){
            Player player = new Player(name,0.0,false);
            if(addPlayer(player)){
                System.out.println("Jugador añadido cre");
            }
        }

    }

    public static boolean addPlayer(Player player){
        return false;
    }
}
