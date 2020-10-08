package Game;

public class App {

    public static void main(String[] args) {
        Board game = new Board(new String[]{"Silver", "Gold", "Cooper"});
        System.out.println(game);

        ValueCard V = new ValueCard();
        System.out.println(ValueCard.VALUE_CARD.get(1));
    }

}