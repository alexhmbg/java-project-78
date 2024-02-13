package hexlet.code.schemas;

public class StringSchema {
    private boolean required = false;
    private int minLength = 0;
    private String substring = "";

    public StringSchema required() {
        required = true;
        return this;
    }

    public StringSchema minLength(int length) {
        minLength = length;
        return this;
    }

    public StringSchema contains(String string) {
        substring = string;
        return this;
    }

    public boolean isValid(String string) {
        if (string == null || string.isEmpty()) {
            return !required;
        }

        boolean isMinLengthAndContains = string.contains(substring) && string.length() >= minLength;

        return isMinLengthAndContains;
    }
}
