package hexlet.code.schemas;

import hexlet.code.Check;

import java.util.Map;

public class MapSchema extends BaseSchema<Map> {
    public void sizeof(int size) {
        Check<Map> isSameSize = i -> i.size() == size;
        addCheck(isSameSize);
    }
}
