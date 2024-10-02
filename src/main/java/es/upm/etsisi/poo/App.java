package es.upm.etsisi.poo;
import java.util.*;
import java.util.Scanner;

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

        while(numPlayers <= 0 || numPlayers > 20){
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
                removePlayer(players);
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

    /*
        Method for obtaining player's name
     */
    private static String getNamePlayer(){
        String name = "";
        System.out.println("Introduce player's name: ");
        name = sc.nextLine();

        return name;
    }

    /*
        Method that you can get the player with the name,
        if the player does not exist, the result is null,
        otherwise it returns the player.
     */
    private static Player getPlayer(ArrayList<Player> players, String name){
        Player playerRes = null;

        for (Player player: players) {
            if(player.getName().equalsIgnoreCase(name)){
                playerRes = player;
            }
        }

        return playerRes;
    }
    public static void createPlayer(ArrayList<Player> players){
       String name = getNamePlayer();
       Player player = getPlayer(players,name);

        if(player == null){
            Player newPlayer = new Player(name,0.0,false);
            if(players.add(newPlayer)){
                System.out.println("Player added");
            }
        } else {
            System.out.println("Player exits");
        }

    }
    public static void removePlayer(ArrayList<Player> players){
        String name = getNamePlayer();
        Player player = getPlayer(players,name);

        if(player != null){
            System.out.println("Players before: "+ players.size());
            if(players.remove(player)){
                System.out.println("Player eliminated");
                System.out.println("Remaining Players: "+ players.size());

            }
        } else {
            System.out.println("The player doesn't exist");
        }
    }

    public static void showPlayers(ArrayList<Player> players){
        for(int i=0;i<players.size();i++){
            System.out.println(players.get(i).getName()+" ("+players.get(i).getScore()+") ");
        }
    }
    public static void rankPlayers(ArrayList<Player> players){
        arrange(players,0,players.size()-1);
        System.out.println("-----RANKING-----");
        for(int i=0;i<players.size();i++){
            System.out.println(players.get(i).getName()+" ("+players.get(i).getScore()+") ");
        }
    }
    public static void arrange(ArrayList<Player> players,int i0, int in){
        if(i0<in){
            //there is more than one player in the arraylist
            for(int i=0;i<in-i0;i++){
            double ele=players.get(i).getScore();
               if(ele < players.get(i+1).getScore()) {
                   Player aux;
                   aux = players.get(i);
                   players.set(i, players.get(i + 1));
                   players.set(i + 1, aux);
               }
            }
           arrange(players,i0+1,in);
        }
    }
    public static void setScore(Player player){
        double score=0.0;
        boolean isDouble=true;
        System.out.println("Introduce new score for the player: ");
        try {
            score = sc.nextDouble();
        }catch (InputMismatchException e){
            System.out.println("Introduce a number");
            isDouble=false;
        }
        if (isDouble) player.setScore(score);
    }
}
