package hexlet.code.schemas;

import hexlet.code.Check;

import java.util.List;
import java.util.ArrayList;

public class BaseSchema<T> {
    private final List<Check<T>> checks = new ArrayList<>();
    private boolean required = false;

    public BaseSchema<T> required() {
        required = true;
        return this;
    }

    public final void addCheck(Check<T> check) {
        checks.add(check);
    }

    public final boolean isValid(T t) {
        if (t == null || t.equals("") || t.equals(0)) {
            return !required;
        }

        for (var check : checks) {
            if (!check.run(t)) {
                return false;
            }
        }

        return true;
    }
}
