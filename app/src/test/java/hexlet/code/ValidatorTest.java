package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.HashMap;

import hexlet.code.schemas.BaseSchema;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidatorTest {
    @Test
    public void validatorTestString() {
        var validator = new Validator();
        var schema = validator.string();

        var expected = true;
        var actual = schema.isValid("");
        assertEquals(expected, actual);

        var expected2 = true;
        var actual2 = schema.isValid(null);
        assertEquals(expected2, actual2);

        schema.required();
        var expected3 = false;
        var actual3 = schema.isValid("");
        assertEquals(expected3, actual3);

        var expected4 = false;
        var actual4 = schema.isValid(null);
        assertEquals(expected4, actual4);

        schema.contains("what");
        var expected5 = true;
        var actual5 = schema.isValid("what");
        assertEquals(expected5, actual5);

        var expected6 = true;
        var actual6 = schema.isValid("whatever");
        assertEquals(expected6, actual6);

        schema.minLength(5);
        var expected7 = true;
        var actual7 = schema.isValid("what ");
        assertEquals(expected7, actual7);

        var expected8 = false;
        var actual8 = schema.isValid("what");
        assertEquals(expected8, actual8);
    }

    @Test
    public void validatorTestNumber() {
        var validator = new Validator();
        var schema = validator.number();

        var expected = true;
        var actual = schema.isValid(5);
        assertEquals(expected, actual);

        var expected2 = true;
        var actual2 = schema.isValid(null);
        assertEquals(expected2, actual2);

        schema.required();
        var expected3 = false;
        var actual3 = schema.isValid(null);
        assertEquals(expected3, actual3);

        schema.positive();
        var expected4 = true;
        var actual4 = schema.isValid(10);
        assertEquals(expected4, actual4);

        var expected5 = false;
        var actual5 = schema.isValid(-10);
        assertEquals(expected5, actual5);

        schema.range(5, 10);
        var expected6 = false;
        var actual6 = schema.isValid(4);
        assertEquals(expected6, actual6);

        var expected7 = true;
        var actual7 = schema.isValid(10);
        assertEquals(expected7, actual7);
    }

    @Test
    public void validatorTestMap() {
        var validator = new Validator();
        var schema = validator.map();
        var map = new HashMap<String, String>();
        map.put("key1", "value1");
        var map2 = new HashMap<String, String>();
        map2.put("key1", "value1");
        map2.put("key2", "value2");

        var expected = true;
        var actual = schema.isValid(null);
        assertEquals(expected, actual);

        var expected2 = true;
        var actual2 = schema.isValid(new HashMap<>());
        assertEquals(expected2, actual2);

        var expected3 = true;
        var actual3 = schema.isValid(map);
        assertEquals(expected3, actual3);

        schema.required();
        var expected4 = false;
        var actual4 = schema.isValid(null);
        assertEquals(expected4, actual4);

        schema.sizeof(2);
        var expected5 = false;
        var actual5 = schema.isValid(map);
        assertEquals(expected5, actual5);

        var expected6 = true;
        var actual6 = schema.isValid(map2);
        assertEquals(expected6, actual6);
    }

    @Test
    public void validatorTestMapSchema() {
        var validator = new Validator();
        var schema = validator.map();
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", validator.string().required());
        schemas.put("lastName", validator.string().required().minLength(2));
        schema.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", null);
        human1.put("lastName", "Smith");
        var expected = false;
        var actual = schema.isValid(human1);
        assertEquals(expected, actual);

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", "S");
        var expected2 = false;
        var actual2 = schema.isValid(human2);
        assertEquals(expected2, actual2);

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Brad");
        human3.put("lastName", "Pitt");
        var expected3 = true;
        var actual3 = schema.isValid(human3);
        assertEquals(expected3, actual3);
    }
}

