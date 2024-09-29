package es.upm.etsisi.poo;

import java.util.*;

public class App 
{
   static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        startEvent();
    }
    public static void startEvent(){
        int option;
        boolean exit = false;
        int numPlayers = 0;

        while(numPlayers <= 0 || numPlayers >10){
            System.out.println("Introduce the number of participating players: ");
            numPlayers = sc.nextInt();
        }

        ArrayList<Player> players = new ArrayList<>();
        Matchmaking[] matchmakingList = new Matchmaking[Math.round(players.size()/2)];

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
                executeChoice(players,matchmakingList, option);
            } else {
                exit= true;
                sc.close();
            }
        }
    }

    public static  void executeChoice(ArrayList<Player> players, Matchmaking[] matchmakings, int option){
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
                System.out.println("Wrong choice");
        }
    }

    public static void createPlayer(ArrayList<Player> players){
        String name = "";
        System.out.println("Introduce player's name: ");
        name = sc.nextLine();
        boolean found = false;
        int index = 0;

        while(!found){
            Player aux = players.get(index);
            if(aux.getName().equalsIgnoreCase(name)){
                found = true;
            }
            index++;
        }

        if(!found){
            Player player = new Player(name,0.0,false);
            if(addPlayer(player)){
                System.out.println("Player added");
            }
        }

    }
    public static boolean removePlayer(ArrayList<Player> players, Player player){
        boolean correct = false;
        boolean eliminated = false;
        int numPlayersBefore = players.size();
        int i = 0;
        while(i < numPlayersBefore || eliminated){
            if(player.getName() == players.get(i).getName()){
               players.remove(i);
               eliminated = true;
            }
            i++;
        }
        if(players.size() == numPlayersBefore -1){
            correct = true;
        }
        return correct;
    }

    public static boolean addPlayer(Player player){
        return false;
    }
}
