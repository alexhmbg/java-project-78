package hexlet.code.schemas;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

public class BaseSchema<T> {
    private final List<Predicate<T>> checks = new ArrayList<>();
    protected boolean required = false;

    public final void addCheck(Predicate<T> check) {
        checks.add(check);
    }

    public final boolean isValid(T t) {
        if (t == null || t.equals("") || t.equals(0)) {
            return !required;
        }

        for (var check : checks) {
            if (!check.test(t)) {
                return false;
            }
        }

        return true;
    }
}
