package Game;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final Deck deck;
    private List<Card> cardPlayed;
    private Card currentCard;

    public Board(List<Player> playerList) {
        deck = new Deck();
        deck.shuffle();
        deck.distribueCard(playerList);
        cardPlayed = new ArrayList<>();
        currentCard = null;
        for (Player p : playerList) {
            p.sortHand();
        }
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public void play(Player p, int indexCard) {
        if (currentCard != null) cardPlayed.add(currentCard);
        currentCard = p.getCardPlayed(indexCard, currentCard);
        p.removeCard(currentCard);
    }

    public void reset() {
        currentCard = null;
    }

    @Override
    public String toString() {
        return "Board{" +
                "deck=" + deck +
                ", cardPlayed=" + cardPlayed +
                '}';
    }
}