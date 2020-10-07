package Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private List<Player> playerList;
    private List<Card> deck;

    public Board(String[] playerNames) {
        playerList = new ArrayList<>();
        for (int i = 0; i < playerNames.length; i++) {
            playerList.add(new Player(i, playerNames[i]));
        }
        deck = new ArrayList<>();
        String[] signs = new String[]{"♥", "♦", "♣", "♠"};
        for (int i = 0; i < signs.length; i++) {
            for (int j = 0; j < 13; j++) {
                deck.add(new Card("j",j,signs[i]));
            }
        }
        Collections.shuffle(deck);
    }

    @Override
    public String toString() {
        return "Board{" +
                "playerList=" + playerList +
                ", deck=" + deck +
                '}';
    }
}
