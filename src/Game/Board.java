package Game;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final Deck deck;
    private List<Card> cardPlayed;
    private Card currentCard;

    public Board (List<Player> playerList){
        deck = new Deck();
        deck.shuffle();
        deck.distribueCard(playerList);
        cardPlayed = new ArrayList<>();
        currentCard = null;
    }

    public void start(){

    }

    @Override
    public String toString() {
        return "Board{" +
                "deck=" + deck +
                ", cardPlayed=" + cardPlayed +
                '}';
    }
}
