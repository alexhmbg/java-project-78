package hexlet.code.schemas;

import hexlet.code.Check;

import java.util.List;
import java.util.ArrayList;

class BaseSchema<T> {
    private final List<Check<T>> checks = new ArrayList<>();
    public boolean required;

    public void addCheck(Check<T> check) {
        checks.add(check);
    }

    public void required() {
        required = true;
    }

    public boolean isValid(T t) {
        if (t == null || t.equals("")) {
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
