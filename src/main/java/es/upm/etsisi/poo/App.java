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
                removePlayer(players,choosePlayer(players));
                break;
            case 3:
                showPlayers(players);
                break;
            case 4:
                rankPlayers(players);
                break;
            case 5:
                setScore(choosePlayer(players));
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
            if(addPlayer(player,players)){
                System.out.println("Player added");
            }
        }

    }
    public static boolean removePlayer(ArrayList<Player> players, Player player){
        if (player!=null) {
            boolean correct = false;
            boolean eliminated = false;
            int numPlayersBefore = players.size();
            int i = 0;
            while (i < numPlayersBefore || eliminated) {
                if (player.getName().equals(players.get(i).getName())) {
                    players.remove(i);
                    eliminated = true;
                }
                i++;
            }
            if (players.size() == numPlayersBefore - 1) {
                correct = true;
            }
            return correct;
        }else return false;
    }

    public static Player choosePlayer(ArrayList<Player> players){
        System.out.println("Introduce player's name: ");
        String name=sc.nextLine();
        Player chosen = null;
        int i=0;
        boolean found=false;
        while (i<players.size()&&!found){
            if (players.get(i).getName().equals(name)){
                chosen=players.get(i);
                found=true;
            }
            i++;
        }
        return chosen;
    }

    public static boolean addPlayer(Player player,ArrayList<Player> players){
        boolean c=false;
       if(players.add(player)){
           c=true;
        }
        return c;
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
        }
        arrange(players,i0+1,in);
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
