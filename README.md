### Hexlet tests and linter status:
[![Actions Status](https://github.com/alexhmbg/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/alexhmbg/java-project-78/actions)
[![Actions Status](https://github.com/alexhmbg/java-project-78/actions/workflows/gradle.yml/badge.svg)](https://github.com/alexhmbg/java-project-78/actions)
<a href="https://codeclimate.com/github/alexhmbg/java-project-78/maintainability"><img src="https://api.codeclimate.com/v1/badges/09f8b57f387208777d46/maintainability" /></a>
<a href="https://codeclimate.com/github/alexhmbg/java-project-78/test_coverage"><img src="https://api.codeclimate.com/v1/badges/09f8b57f387208777d46/test_coverage" /></a>

Data Validator is a library designed to verify the accuracy of various types of data.
The validator operates as follows:

First, a validator object is created.
Next, a data validation schema is created and configured.
Subsequently, data validation is performed using the established schema.

Usage example:

Validator v = new Validator();

// String
StringSchema schema = v.string();
schema.isValid(null); // true
schema.required().isValid(null); // false
schema.minLength(5).isValid("hello"); // true

// Number
NumberSchema schema = v.number().required().positive();
schema.isValid(-5); // true
schema.positive().isValid(-5); // false
schema.range(5, 10).isValid(7); // true

// Map
Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("firstName", v.string().required());
schemas.put("age", v.number().range(5, 50));
MapSchema schema = v.map().sizeof(2).shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("firstName", "Alex");
human1.put("age", 30);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("firstName", "");
human2.put("age", 45);
schema.isValid(human1); // false