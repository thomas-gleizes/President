package Game;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int id;
    private String name;
    private List<Card> hand;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        this.hand = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hand=" + hand +
                '}';
    }
}
