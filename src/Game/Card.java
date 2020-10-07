package Game;

public class Card {
    private String name;
    private int val;
    private String color;
    private String sign;

    public Card(String name, int val, String sign) {
        this.name = name;
        this.val = val;
        this.color = ((sign == "♥") || (sign == "♦")) ? "\u001B[31m" : "\u001B[34m";
        this.sign = sign;
    }


    @Override
    public String toString() {
        return color + " [" + name + "|" + sign + "] \u001B[0m";
    }
}
