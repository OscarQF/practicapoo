package es.upm.etsisi.poo;
import java.util.*;
import java.util.Scanner;

public class App {
   static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        startEvent();
    }

    private static void loadData(ArrayList<Player> players){
        Player Luisa = new Player("Luisa",4.5,false);
        Player Manuel = new Player("Manuel",2.7,false);
        Player Kurt = new Player("Kurt",4.0,false);
        Player Sofia = new Player("Sofia",3.8,false);
        Player Robert = new Player("Robert",3.8,false);
        players.add(Luisa);
        players.add(Manuel);
        players.add(Kurt);
        players.add(Sofia);
        players.add(Robert);

    }
    public static void startEvent(){
        int option;
        boolean exit = false;

        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Matchmaking> matchmakingList = new ArrayList<>();

        loadData(players);

        while(!exit){
            System.out.println(
                    "---------------------------------------\n"+
                    "1.> create [player]\n" +
                    "2.> remove [player]\n" +
                    "3.> show\n" +
                    "4.> rank\n" +
                    "5.> score [player];[score]\n" +
                    "6.> show_matchmake\n" +
                    "7.> clear_matchmake\n" +
                    "8.> matchmake [player1];[player2]\n" +
                    "9.> random_matchmake\n" +
                    "10.> end\n" +
                    "---------------------------------------");
            option = sc.nextInt();
            sc.nextLine();

            if(option != 10){
                executeChoice(players,matchmakingList, option);
            } else {
                exit= true;
                sc.close();
            }
        }
    }

    public static  void executeChoice(ArrayList<Player> players, ArrayList<Matchmaking> matchmakings, int option){
        switch (option){
            case 1:
                createPlayer(players);
                break;
            case 2:
                removePlayer(players);
                break;
            case 3:
                showPlayers(players);
                break;
            case 4:
                rankPlayers(players);
                break;
            case 5:
                setScore(getPlayer(players,getNamePlayer()));
                break;
            case 6:
                showMatchmaking(matchmakings);
                break;
            case 7:
                deleteMatchmakings(matchmakings);
                break;
            case 8:
                String nameFirstPlayer = getNamePlayer();
                Player firstPlayer = getPlayer(players,nameFirstPlayer);

                String nameSecondPlayer = getNamePlayer();
                Player secondPlayer = getPlayer(players,nameSecondPlayer);

                makeMatchmaking(matchmakings,firstPlayer,secondPlayer);
                break;
            case 9:
                randomMatchmaking(players,matchmakings);
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
        do{
            System.out.println("Introduce player's name: ");
            name = sc.nextLine();
        } while(name.isEmpty());

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
    public static void makeMatchmaking(ArrayList<Matchmaking> matchmakings,Player firstPlayer,Player secondPlayer){
        if(firstPlayer == null || secondPlayer == null){
            System.out.println("One of the players doesn't exist");
        } else {
            if(!firstPlayer.getMatchmaked() && !secondPlayer.getMatchmaked()) {
                if(!firstPlayer.equals(secondPlayer)) {
                    Matchmaking match = new Matchmaking(firstPlayer, secondPlayer);
                    firstPlayer.setMatchmaking(true);
                    secondPlayer.setMatchmaking(true);
                    matchmakings.add(match);
                    System.out.println("Matchmaking added");
                }else{
                    System.out.println("You can not matchmake the same person with its-self");
                }
            }else{
                System.out.println("One player has already been matchmaked");
            }
        }
    }
    public static void setScore(Player player){
        double score=0.0;
        boolean isDouble=true;
        boolean correct=false;
        if(player==null){
            System.out.println("Player does not exist");
        }else {
            do {
                System.out.println("Introduce new score for the player: ");
                try {
                    score = sc.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Introduce a number");
                    isDouble = false;

                }
                if(isDouble){
                    player.setScore(score);
                    correct=true;
                }else{
                    sc.next();
                    isDouble=true;
                }
            }while(!correct);
        }
    }
    public static void showMatchmaking(ArrayList<Matchmaking> matchmakings){

        if(!matchmakings.isEmpty()){
            for (Matchmaking match: matchmakings){
                System.out.println(match.getPlayer1().getName() + " vs " + match.getPlayer2().getName());
            }
        } else {
            System.out.println("Empty");
        }


    }
    public static void deleteMatchmakings(ArrayList<Matchmaking> matchmakings){
        for (int i = matchmakings.size()-1; i >= 0; i--){
            matchmakings.get(i).getPlayer1().setMatchmaking(false);
            matchmakings.get(i).getPlayer2().setMatchmaking(false);
            matchmakings.remove(matchmakings.get(i));
        }
        System.out.println("All matchmakings have been deleted ");
    }
    public static void randomMatchmaking(ArrayList<Player> players, ArrayList<Matchmaking> matchmakings){
        if(players.size() % 2 != 0){
            System.out.println("Not available. Number of players is not even");
        } else {
            while (matchmakings.size() != players.size()/2){
                int random1 = (int) (Math.random() * players.size());
                Player player1 = players.get(random1);

                int random2 = random1;

                do {
                    random2 = (int) (Math.random() * players.size());
                } while(random2 == random1);

                Player player2 = players.get(random2);
                makeMatchmaking(matchmakings,player1,player2);

            }
        }
    }
}

