package hexlet.code.schemas;

import hexlet.code.Check;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map<String, String>> {

    @Override
    public MapSchema required() {
        super.required();
        return this;
    }

    public MapSchema sizeof(int size) {
        Check<Map<String, String>> isSameSize = i -> i.size() == size;
        addCheck(isSameSize);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> schemas) {
        Check<Map<String, String>> isValidValues = map -> {
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
