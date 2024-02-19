package hexlet.code.schemas;

import hexlet.code.Check;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        super.required = true;
        return this;
    }

    public NumberSchema positive() {
        Check<Integer> isPositive = i -> i >= 0;
        addCheck(isPositive);
        return this;
    }

    public NumberSchema range(int minRange, int maxRange) {
        Check<Integer> isInRange = i -> i >= minRange && i <= maxRange;
        addCheck(isInRange);
        return this;
    }

}
