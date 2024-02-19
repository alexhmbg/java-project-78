package hexlet.code.schemas;

import hexlet.code.Check;

public final class StringSchema extends BaseSchema<String> {

    @Override
    public StringSchema required() {
        super.required();
        return this;
    }

    public StringSchema minLength(int length) {
        Check<String> isPositive = i -> i.length() >= length;
        addCheck(isPositive);
        return this;
    }

    public StringSchema contains(String string) {
        Check<String> isPositive = i -> i.contains(string);
        addCheck(isPositive);
        return this;
    }
}
