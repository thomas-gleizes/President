package Game;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Player> playerList;
    private Board board;
    private boolean isFinish;
    private static Dialog command;

    public Game(String[] playerNames) {
        playerList = new ArrayList<>();
        for (int i = 0; i < playerNames.length; i++) {
            playerList.add(new Player(i, playerNames[i]));
        }
        board = new Board(playerList);
        isFinish = false;
        command = new Dialog();
    }

    public void start(){
        Player currentPlayer = getStarter();

        while (!isFinish){
            int index = command.getCard(currentPlayer, board.getCurrentCard());

        }
    }

    public Player getStarter (){
        Card dameCoeur = new Card(9, '♥');
        for (Player p : playerList){
            for (Card c : p.getHand()){
                if (c.equals(dameCoeur)) return p;
            }
        }
        return playerList.get(0);
    }


    @Override
    public String toString() {
        return "Game{playerList=\n" + playerList + '}';
    }
}
