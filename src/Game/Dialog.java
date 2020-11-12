package Game;

import java.util.Scanner;

public class Dialog {

    private final Scanner input;

    public Dialog() {
        input = new Scanner(System.in);
    }

    public int getIndexCard(Player p, Card currentCard) {
        boolean bool = false;
        int index = 0;
        while (!bool){
            System.out.println(p.getName() +  " => Choissiez une carte (0 pour passé le tour): " + currentCard);
            System.out.println(p.toStringHand(currentCard));
            index = input.nextInt();
            if (index == 0){
                System.out.println("Le tour est passé !");
                return -1;
            }

            int size = currentCard == null ? size = p.getHand().size() : p.getHandPlayable(currentCard).size();
            if (index >= 1 && index <= size) bool = true;
            else System.out.println("Mauvais index");
        }
        return index - 1;
    }

    public void displayCardPlayed(Player currentPlayer, int index) {
        System.out.println(currentPlayer.getHand().get(index));
    }

}
