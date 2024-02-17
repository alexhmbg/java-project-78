package hexlet.code.schemas;

import hexlet.code.Check;

public class StringSchema extends BaseSchema<String> {
    public void minLength(int length) {
        Check<String> isPositive = i -> i.length() >= length;
        addCheck(isPositive);
    }

    public void contains(String string) {
        Check<String> isPositive = i -> i.contains(string);
        addCheck(isPositive);
    }
}
