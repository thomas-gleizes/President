package Game;

import java.util.Scanner;

public class Dialog {

    private final Scanner input;

    public Dialog() {
        input = new Scanner(System.in);
    }

    public void passeTour(Player player) {
        System.out.println("Le joueur " + player.getName() + " a passe son tour");
    }

    public void displayCardPlayed(Player player, int index){
        System.out.println(player.getHand().get(index));
    }

    public int getIndexCard(Player p, Card currentCard) {
        boolean bool = false;
        int index = 0;
        while (!bool) {
            int size;

            System.out.print(p.getName() + " => Choissiez une carte (0 pour passé le tour): ");
            if (currentCard == null) {
                System.out.println("[ ]");
            } else {
                System.out.println(currentCard);
            }

            System.out.println(p.toStringHand(currentCard));
            index = input.nextInt();
            if (index == 0) {
                System.out.println("Le tour est passé !");
                return -1;
            }
            if (currentCard == null) size = p.getHand().size();
            else size = p.getHandPlayable(currentCard).size();
            if (index >= 1 && index <= size) bool = true;
            else System.out.println("Mauvais index");
        }
        return index - 1;
    }

    public boolean wantPlay(Card currentCard){
        while (true){
            System.out.println("Voulez vous jouez votres carte [" + currentCard.getName() + "] (Y/N) : Yes default");
            String value = input.nextLine();

            if (value.equals("") || value.equals("Y")){
                System.out.println("YES");
                return true;
            } else if (value.equals("N")) {
                System.out.println("NO");
                return false;
            } else System.out.println("PAS COMPRIS");
        }
    }

}
