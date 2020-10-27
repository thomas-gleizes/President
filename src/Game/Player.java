package Game;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final int id;
    private final String name;
    private List<Card> hand;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public List<Card> getHand() {
        return hand;
    }

    public void addCardHand(Card c) {
        hand.add(c);
    }

    public String toStringHand(Card currentCard) {
        if (currentCard == null) return toString();
        StringBuilder str = new StringBuilder("{");
        int index = 0;
        for (int i = 0; i < hand.size(); i++) {
            Card c = hand.get(i);
            if (c.getValue() >= c.getValue()) {
                str.append(index).append(": ").append(c);
            } else {
                str.append(c);
            }
            if (i + 1 != hand.size()) str.append(", ");
        }
        return str + "}";
    }

    public void sortHand() {
        hand.sort((Card c1, Card c2) -> (Integer.compare(c1.getValue(), c2.getValue())));
    }

    public List<Card> getHandPlayable(Card currentCard){
        if (currentCard == null) return hand;
        List<Card> cardPlayable = new ArrayList<>();
        for (Card c : hand){
            if (c.getValue() >= currentCard.getValue()){
                cardPlayable.add(c);
            }
        }
        return cardPlayable;
    }

    public void getPlayCard(int index, Card CurrentCard){
        List<Card> cardsPlayable = getHandPlayable(CurrentCard);
        Card cardPlayed = cardsPlayable.get(index);
        hand.remove(cardPlayed);
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Main du Joueur : {");
        for (int i = 0; i < hand.size(); i++) {
            str.append(i).append(": ").append(hand.get(i));
            if (hand.size() != i + 1) str.append(", ");
        }
        return str + "}\n";
    }

}
