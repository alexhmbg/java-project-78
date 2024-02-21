package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        super.required = true;
        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> isPositive = i -> i >= 0;
        addCheck(isPositive);
        return this;
    }

    public NumberSchema range(int minRange, int maxRange) {
        Predicate<Integer> isInRange = i -> i >= minRange && i <= maxRange;
        addCheck(isInRange);
        return this;
    }

}
