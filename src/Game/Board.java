package Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {

    private final List<Player> playerList;
    private final List<Card> deck;

    public Board(String[] playerNames) {
        playerList = new ArrayList<>();
        for (int i = 0; i < playerNames.length; i++) {
            playerList.add(new Player(i, playerNames[i]));
        }
        deck = new ArrayList<>();
        char[] signs = new char[]{'♥', '♦', '♣', '♠'};
        for (char c : signs) {
            for (int value = 0; value < 13; value++) {
                deck.add(new Card(value, c));
            }
        }
        Collections.shuffle(deck);
        distributeCards();
    }

    public void distributeCards (){
        int length = playerList.size();
        int n = 0;
        for (Card c : deck){
            playerList.get(n).addCardHand(c);
            n++;
            if (n == length) n = 0;
        }
    }

    @Override
    public String toString() {
        return "Board{" +
                "playerList=" + playerList +
                '}';
    }
}
