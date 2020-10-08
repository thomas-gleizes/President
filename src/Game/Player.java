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

    public List<Card> getHand(){
        return hand;
    }

    public void addCardHand(Card c){
        hand.add(c);
    }

    @Override
    public String toString() {
        return "\nPlayer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hand(" + hand.size() + ")=" + hand +
                "}";
    }
}
