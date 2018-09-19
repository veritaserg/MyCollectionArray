package collections;

import java.util.OptionalDouble;

public interface MyList  {
    void add(int i);
    void delete(int index);
    int get(int index);
    boolean contains(Object o);
    int maxElement();
    int minElement();
   OptionalDouble sqrt();

}
