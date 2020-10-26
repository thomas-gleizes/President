package Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private final List<Player> playerList;
    private final Deck deck;

    public Game(String[] playerNames) {
        playerList = new ArrayList<>();
        for (int i = 0; i < playerNames.length; i++) {
            playerList.add(new Player(i, playerNames[i]));
        }
        deck = new Deck();
        deck.shuffle();
        deck.distribueCard(playerList);
    }

    @Override
    public String toString() {
        return "Game{playerList=" + playerList + '}';
    }
}
