package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.HashMap;

import hexlet.code.schemas.BaseSchema;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    @Test
    public void validatorTestString() {
        var validator = new Validator();
        var schema = validator.string();


        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));

        schema.required();
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));

        schema.contains("what");
        assertTrue(schema.isValid("what"));
        assertTrue(schema.isValid("whatever"));

        schema.minLength(5);
        assertTrue(schema.isValid("what "));
        assertFalse(schema.isValid("what"));
    }

    @Test
    public void validatorTestNumber() {
        var validator = new Validator();
        var schema = validator.number();

        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(null));

        schema.required();
        assertFalse(schema.isValid(null));

        schema.positive();
        assertFalse(schema.isValid(-10));
        assertFalse(schema.isValid(0));

        schema.range(5, 10);
        assertFalse(schema.isValid(4));
        assertTrue(schema.isValid(10));
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
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));
        assertTrue(schema.isValid(map));

        schema.required();
        assertFalse(schema.isValid(null));

        schema.sizeof(2);
        assertFalse(schema.isValid(map));
        assertTrue(schema.isValid(map2));
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
        assertFalse(schema.isValid(human1));

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", "S");
        assertFalse(schema.isValid(human2));

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Brad");
        human3.put("lastName", "Pitt");
        assertTrue(schema.isValid(human3));
    }
}

