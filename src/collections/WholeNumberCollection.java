package collections;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class WholeNumberCollection implements MyList {
    private int[] element;

    public WholeNumberCollection() {
        element = new int[0];
    }

    @Override
    public void add(int i) {
        if (i == 666) {
            try {
                throw new NumberOfDemonException(i);
            } catch (NumberOfDemonException e) {
                //  e.printStackTrace();
                System.out.println("FATAL ERROR " + e);
            }
        }
        if (element.length == 0) {
            element = new int[1];
            element[0] = i;
        } else if (element.length > 0) {
            int[] temp = element;
            for (int j = 0; j < temp.length; j++) {
                temp[j] = temp[j] + i;
            }
            element = new int[temp.length + 1];
            System.arraycopy(temp, 0, element, 0, temp.length);
            element[element.length - 1] = i;
        }
    }

    @Override
    public void delete(int index) {
        if (index < 0 || index > element.length - 1) {
            throw new IndexOutOfBoundsException();
        }
        int[] temp = element;
        int el = temp[index];
        element = new int[temp.length - 1];
        System.arraycopy(temp, 0, element, 0, index);
        System.arraycopy(temp, index + 1, element, index, temp.length - index - 1);
        for (int j = 0; j < element.length; j++) {
            element[j] = element[j] - el;
        }
    }

    @Override
    public int get(int index) {
        if (index < 0 || index > element.length - 1) {
            throw new IndexOutOfBoundsException();
        }
        return element[index];
    }

    @Override
    public boolean contains(Object o) {
        if (o != null) {
            for (int i = 0; i < element.length; i++) {
                if (o.equals(element[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int maxElement() {
        int max = element[0];
        for (int i = 0; i < element.length - 1; i++) {
            if (element[i] < element[i + 1]) {
                max = element[i + 1];
            }
        }
        return max;
    }

    @Override
    public int minElement() {
        Arrays.sort(element);
        return element[0];
    }

    @Override
    public OptionalDouble sqrt() {
        return IntStream.of(element).average();
    }
}
