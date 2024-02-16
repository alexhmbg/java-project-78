package hexlet.code.schemas;

public class NumberSchema<T> extends BaseSchema<T> {
    private boolean needToBePositive = false;
    private boolean isRangeRequired = false;
    private int minRange;
    private int maxRange;

    public void positive() {
        needToBePositive = true;
    }

    public void range(int minRange, int maxRange) {
        isRangeRequired = true;
        this.minRange = minRange;
        this.maxRange = maxRange;
    }

    @Override
    public boolean isValid(T t)  {
        super.isValid(t);

        if (needToBePositive && (Integer) t < 0) {
            return false;
        }

        if (isRangeRequired) {
            return (Integer) t >= minRange && (Integer) t <= maxRange;
        }

        return true;
    }
}
