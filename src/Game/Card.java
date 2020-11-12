package Game;

import java.util.Objects;

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

    public char getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return value == card.value &&
                name == card.name &&
                sign == card.sign;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, name, sign);
    }

    @Override
    public String toString() {
        return this.color + "[" + this.name + "|" + this.sign + "]\u001B[0m";
    }

}