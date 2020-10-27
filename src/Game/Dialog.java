package Game;

import java.util.Scanner;

public class Dialog {

    private final Scanner input;

    public Dialog() {
        input = new Scanner(System.in);
    }

    public int getIndexCard(Player p, Card currentCard) {
        Boolean bool = false;
        int index = 0;
        while (!bool){
            int size;

            System.out.println("Choissiez une carte (0 pour passé le tour):");
            System.out.println(p.toStringHand(currentCard));
            index = input.nextInt();
            if (index == 0) return 0;
            if (currentCard == null) size = p.getHand().size();
            else size = p.getHandPlayable(currentCard).size();
            if (index > 1 && index < size + 1) bool = true;
            else System.out.println("Mauvais index");
        }
        return index;
    }

}
