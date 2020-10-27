package Game;

import java.util.Scanner;

public class Dialog {

    private final Scanner input;

    public Dialog() {
        input = new Scanner(System.in);
    }

    public int getCard(Player p, Card currentCard) {
        Boolean bool = false;
        System.out.println("Choissiez une carte (0 pour passé le tour):");
        System.out.println(p.toStringHand(currentCard));
        if (currentCard == null) {
            int index = input.nextInt();
        } else {

        }
        return 1;


    }

}
