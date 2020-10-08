package Game;

public class Card {

    private final int value;
    private final char name;
    private final String color;
    private final char sign;

    public Card(int value, char sign) {
        this.value = value;
        this.name = ValueCard.VALUE_CARD.get(value);
        this.color = (sign == '♥' || sign == '♦') ? "\u001B[31m" : "\u001B[34m";
        this.sign = sign;
    }

    @Override
    public String toString() {
        return this.color + "[" + this.name + "|" + this.sign + "]\u001B[0m";
    }
}
