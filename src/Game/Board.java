package Game;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final Deck deck;
    private List<Card> cardsPlayed;
    private Card currentCard;
    private int occurenceCount;

    public Board(List<Player> playerList) {
        deck = new Deck();
        deck.shuffle();
        deck.distribueCard(playerList);
        cardsPlayed = new ArrayList<>();
        currentCard = null;
        for (Player p : playerList) {
            p.sortHand();
        }
        occurenceCount = 0;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public int getOccurenceCount() {
        return occurenceCount;
    }

    public void play(Player p, int indexCard) {
        Card cardPlayed = p.getCardPlayed(indexCard, currentCard);
        if (currentCard != null) {
            cardsPlayed.add(currentCard);
            if (currentCard.getValue() == cardPlayed.getValue()){
                incrementOccurence();
                System.out.println("Occurence de : "+currentCard+" = "+occurenceCount);
            }
            else resetOccurence();
        }
        currentCard = cardPlayed;
        p.removeCard(currentCard);
    }

    public void reset(List<Player> playerList) {
        currentCard = null;
        for (Player p : playerList){
            p.setHasSkipped(false);
        }
        occurenceCount = 0;

    }

    public void incrementOccurence(){
        occurenceCount++;
    }

    public void resetOccurence(){
        occurenceCount = 1;
    }

    @Override
    public String toString() {
        return "Board{" +
                "deck=" + deck +
                ", cardPlayed=" + cardsPlayed +
                '}';
    }
}