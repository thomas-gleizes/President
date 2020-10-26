package Game;

import java.util.Scanner;

public class Dialog {

    private final Scanner input;

    public Dialog() {
        input = new Scanner(System.in);
    }

    public short getCard(Player p) {
        boolean bool = false;
        short valueCard = -1;
        while (!bool) {
            System.out.println("Choissiez une card");
            valueCard = input.nextShort();
            if (valueCard > 0 && valueCard < p.getHand().size()) bool = true;
            else System.out.println("Valeur incorrect !");
        }
        return valueCard;
    }

}
