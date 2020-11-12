package Game;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Player> playerList;
    private Board board;
    private static Dialog command;
    private List<Player> classement;

    public Game(String[] playerNames) {
        playerList = new ArrayList<>();
        for (int i = 0; i < playerNames.length; i++) {
            playerList.add(new Player(i, playerNames[i]));
        }
        board = new Board(playerList);
        command = new Dialog();
        classement = new ArrayList<>();
    }

    public void start() {
        Player currentPlayer = getStarter();

        while (!isFinish()) {
            if (board.getOccurenceCount() < 2 ){
                int index = command.getIndexCard(currentPlayer, board.getCurrentCard());
                if (index != -1) {
                    System.out.println(currentPlayer.getHand().get(index));
                    board.play(currentPlayer, index);
                } else {
                    currentPlayer.setHasSkipped(true);
                }

                if (board.getCurrentCard() != null && board.getCurrentCard().getValue() == 12)  board.reset(playerList);
                else currentPlayer = getNextPlayer(currentPlayer);
            } else if (board.getOccurenceCount() >= 2 && currentPlayer.indexCard(board.getCurrentCard()) != -1) {

            } else {
                //Le tour est passé car il ne peut pas jouer
            }

        }
    }



    public Player getStarter() {
        Card dameCoeur = new Card(9, '♥');
        for (Player p : playerList) {
            for (Card c : p.getHand()) {
                if (c.equals(dameCoeur)) return p;
            }
        }
        return playerList.get(0);
    }

    public Player getNextPlayer(Player currentPlayer) {
        if (currentPlayer.getId() + 1 == playerList.size()) return playerList.get(0);
        else return playerList.get(currentPlayer.getId() + 1);
    }

    public boolean isFinish() {
        for (Player p : playerList) {
            if (p.getHand().size() == 0) {
                classement.add(p);
                playerList.remove(p);
            }
        }
        return playerList.size() == 0;
    }


    @Override
    public String toString() {
        return "Game{playerList=\n" + playerList + '}';
    }
}
