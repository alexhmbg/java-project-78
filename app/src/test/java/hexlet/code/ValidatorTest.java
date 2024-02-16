package hexlet.code;

import org.junit.jupiter.api.Test;
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

        var expected6 = false;
        var actual6 = schema.isValid("wh at");
        assertEquals(expected6, actual6);

        schema.minLength(5);
        var expected7 = true;
        var actual7 = schema.isValid("whatever");
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

//        schema.required();
//        var expected4 = false;
//        var actual4 = schema.isValid(null);
//        assertEquals(expected4, actual4);

        schema.positive();
        var expected5 = true;
        var actual5 = schema.isValid(10);
        assertEquals(expected5, actual5);

        var expected6 = false;
        var actual6 = schema.isValid(-15);
        assertEquals(expected6, actual6);

        schema.range(15, 30);
        var expected7 = true;
        var actual7 = schema.isValid(15);
        assertEquals(expected7, actual7);

        var expected8 = true;
        var actual8 = schema.isValid(25);
        assertEquals(expected8, actual8);

        schema.range(10, 20);
        var expected9 = false;
        var actual9 = schema.isValid(25);
        assertEquals(expected9, actual9);
    }
}

