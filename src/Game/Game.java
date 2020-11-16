package Game;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Player> playerList;
    private Board board;
    private static Dialog dialog;
    private List<Player> leaderBoard;

    public Game(String[] playerNames) {
        playerList = new ArrayList<>();
        for (int i = 0; i < playerNames.length; i++) {
            playerList.add(new Player(i, playerNames[i]));
        }
        board = new Board(playerList);
        dialog = new Dialog();
        leaderBoard = new ArrayList<>();
    }

    public void start() {

        for (Player p: playerList){
            System.out.println(p.getName() + " => " + p.getHand());
        }

        Player currentPlayer = playerList.get(0);

        while (!isFinish()) {
            if (board.getOccurenceCount() < 2 || board.isPassed()){
                int index = dialog.getIndexCard(currentPlayer, board.getCurrentCard());
                if (index != -1) {
                    dialog.displayCardPlayed(currentPlayer, index);
                    board.play(currentPlayer, index);
                } else {
                    dialog.passeTour(currentPlayer);
                    currentPlayer.setHasSkipped(true);
                }
                board.setPassed(false);
                if (board.getCurrentCard() != null && board.getCurrentCard().getValue() == 12) board.reset(playerList);
                else currentPlayer = getNextPlayer(currentPlayer);
            } else if (board.getOccurenceCount() >= 2) {
                int index = currentPlayer.indexCard(board.getCurrentCard());
                if (index != -1 && dialog.wantPlay(currentPlayer, board.getCurrentCard())) {
                    board.play(currentPlayer, index);
                } else {
                    board.setPassed(true);
                    dialog.passeTour(currentPlayer);
                }
                currentPlayer = getNextPlayer(currentPlayer);
            }
            if (board.getOccurenceCount() == 4) board.reset(playerList);
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
                leaderBoard.add(p);
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
