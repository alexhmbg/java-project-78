package hexlet.code.schemas;

public class StringSchema {
    private boolean required = false;
    private int minLength = 0;
    private String substring = "";

    public void required() {
        required = true;
    }

    public void minLength(int length) {
        minLength = length;
    }

    public void contains(String string) {
        substring = string;
    }

    public boolean isValid(String string) {
        if (string == null || string.isEmpty()) {
            return !required;
        }

        boolean isMinLengthAndContains = string.contains(substring) && string.length() >= minLength;

        return isMinLengthAndContains;
    }
}
