package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema<Map<String, String>> {

    public MapSchema required() {
        super.required = true;
        return this;
    }

    public MapSchema sizeof(int size) {
        Predicate<Map<String, String>> isSameSize = i -> i.size() == size;
        addCheck(isSameSize);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> schemas) {
        Predicate<Map<String, String>> isValidValues = map -> {
            for (var mapKey : map.keySet()) {
                if (!schemas.get(mapKey).isValid(map.get(mapKey))) {
                    return false;
                }
            }
            return true;
        };

        addCheck(isValidValues);
        return this;
    }
}
