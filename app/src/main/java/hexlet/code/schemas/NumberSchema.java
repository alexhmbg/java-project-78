package hexlet.code.schemas;

import hexlet.code.Check;

public class NumberSchema extends BaseSchema<Integer> {
    public void positive() {
        Check<Integer> isPositive = i -> i >= 0;
        addCheck(isPositive);
    }

    public void range(int minRange, int maxRange) {
        Check<Integer> isInRange = i -> i >= minRange && i <= maxRange;
        addCheck(isInRange);
    }

}
