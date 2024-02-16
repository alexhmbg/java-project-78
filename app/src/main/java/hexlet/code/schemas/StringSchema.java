package hexlet.code.schemas;

public class StringSchema<T> extends BaseSchema<T> {
    private int minLength;
    private String substring;

    public void minLength(int length) {
        minLength = length;
    }

    public void contains(String string) {
        substring = string;
    }

    @Override
    public boolean isValid(T t) {
        super.isValid(t);

        boolean isMinLengthAndContains = t.toString().contains(substring) && t.toString().length() >= minLength;

        return isMinLengthAndContains;
    }
}
