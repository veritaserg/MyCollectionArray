package collections;


public class NumberOfDemonException extends Exception {
    private int i;

    public NumberOfDemonException(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "NumberOfDemonException " + i;
    }
}
