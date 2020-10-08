package Game;

import java.util.HashMap;
import java.util.Map;

public class ValueCard {

    public static final Map<Integer, Character> VALUE_CARD = new HashMap<>();
    static {
        VALUE_CARD.put(0, '3');
        VALUE_CARD.put(1, '4');
        VALUE_CARD.put(2, '5');
        VALUE_CARD.put(3, '6');
        VALUE_CARD.put(4, '7');
        VALUE_CARD.put(5, '8');
        VALUE_CARD.put(6, '9');
        VALUE_CARD.put(7, 'X');
        VALUE_CARD.put(8, 'V');
        VALUE_CARD.put(9, 'D');
        VALUE_CARD.put(10, 'R');
        VALUE_CARD.put(11, 'A');
        VALUE_CARD.put(12, '2');
    }

}