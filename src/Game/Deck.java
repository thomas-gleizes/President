package Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> listCard;

    public Deck() {
        listCard = new ArrayList<>();
        char[] signs = new char[]{'♥', '♦', '♣', '♠'};
        for (char c : signs) {
            for (int value = 0; value < 13; value++) {
                listCard.add(new Card(value, c));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(listCard);
    }

    public void distribueCard(List<Player> playerList) {
        int length = playerList.size();
        int n = 0;
        for (Card c : listCard){
            playerList.get(n).addCardHand(c);
            n++;
            if (n == length) n = 0;
        }
    }
}
