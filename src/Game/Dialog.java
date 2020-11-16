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
        System.out.println("Carte jouée: " + player.getHand().get(index));
    }

    public int getIndexCard(Player p, Card currentCard) {
        boolean bool = false;
        int index = 0;
        while (!bool) {
            System.out.print(p.getName() + " => Choissiez une carte (0 pour passé le tour): ");
            System.out.println(currentCard == null ? "[]" : currentCard);
            System.out.println(p.toStringHand(currentCard));

            index = input.nextInt();
            if (index == 0) {
                System.out.println("Le tour est passé !");
                return -1;
            }
            int size = currentCard == null ? p.getHand().size() : p.getHand().size();
            if (index >= 1 && index <= size) bool = true;
            else System.out.println("Mauvais index");
        }
        return index - 1;
    }

    public boolean wantPlay(Player p, Card currentCard){
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.print(p.getName() + " => Voulez vous jouez votres carte [" + currentCard.getName() + "] (1:Yes/0:Non) : Yes default");
            int value = input.nextInt();

            if (value == 1){
                System.out.println("YES");
                return true;
            } else {
                System.out.println("NO");
                return false;
            }
        }
    }

}