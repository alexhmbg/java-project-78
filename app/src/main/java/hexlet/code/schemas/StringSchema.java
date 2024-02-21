package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        super.required = true;
        return this;
    }

    public StringSchema minLength(int length) {
        Predicate<String> isPositive = i -> i.length() >= length;
        addCheck(isPositive);
        return this;
    }

    public StringSchema contains(String string) {
        Predicate<String> isPositive = i -> i.contains(string);
        addCheck(isPositive);
        return this;
    }
}
