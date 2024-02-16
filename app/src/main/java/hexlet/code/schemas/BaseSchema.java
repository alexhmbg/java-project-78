package hexlet.code.schemas;

class BaseSchema <T> {
    boolean required;
    private T item;

    public void required() {
        required = true;
    }

    public boolean isValid(T item) {
        if (item == null) {
            return !required;
        } 
        
        return false;
    }
}
