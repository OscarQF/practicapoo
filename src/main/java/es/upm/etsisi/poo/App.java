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
            System.out.println("Introduce the number of players to participate: ");
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
                create(players);
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
                System.out.println("Incorrect election");
        }
    }

    public static void create(Player[] players){
        String name = "";
        System.out.println("Introduce the player's name: ");
        name = sc.nextLine();
        boolean found = false;
        int i = 0;

        while(!found){
            Player aux = players[i];
            if(aux.getName().equalsIgnoreCase(name)){
                found = true;
            }
            i++;
        }

        if(!found){
            Player player = new Player(name,0.0,false);
            if(addPlayer(player,players)){
                System.out.println("Player added");
            }
        }

    }

    public static boolean addPlayer(Player player,Player[] players){
        int i=0;
        while(){

        }
        return false;
    }

    public static void remove(Player player, Player[] players){
        boolean found=false;
        int i=0;
        while(!found && i< players.length){
            if(player.getName().equals(players[i].getName())){
                found=true;
                for(int j=i;j< players.length-1;j++){
                    players[j]=players[j+1];
                }
                players[players.length-1]=null;
            }else{
                i++;
            }
        }

    }
}
