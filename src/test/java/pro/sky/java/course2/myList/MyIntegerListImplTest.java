package pro.sky.java.course2.myList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.myList.exception.*;

public class MyIntegerListImplTest {

    private final Integer[] testList = {35, 2, 10, 17, 5};

    private final MyIntegerListImpl out = new MyIntegerListImpl();

    @BeforeEach
    void setUp() {
        out.add(35);
        out.add(2);
        out.add(10);
    }

    @AfterEach
    void tearDown() {
        out.clear();
    }

    @Test
    public void addAndAddAndSizeAndToArrayTest() {
        Assertions.assertEquals(5, out.add(5));
        Assertions.assertEquals(4, out.size());
        Assertions.assertEquals(17, out.add(3, 17));
        Assertions.assertEquals(5, out.size());
        Assertions.assertArrayEquals(testList, out.toArray());
    }

    @Test
    public void removeAndRemoveAndGet() {
        Assertions.assertEquals(35, out.removeItem(35));
        Assertions.assertEquals(2, out.remove(0));
        Assertions.assertEquals(10, out.get(0));
    }

    @Test
    public void setAndContainsAndIndexOfTest() {
        Assertions.assertEquals(5, out.add(5));
        Assertions.assertEquals(17, out.add(3, 17));
        Assertions.assertEquals(777, out.set(0, 777));
        Assertions.assertEquals(0, out.lastIndexOf(777));
        Assertions.assertEquals(4, out.indexOf(5));
        Assertions.assertTrue(out.contains(2));
    }

    @Test
    void isEmptyAndClear() {
        Assertions.assertFalse(out.isEmpty());
        out.clear();
        Assertions.assertTrue(out.isEmpty());
    }

    @Test
    public void shouldThrowException() {
        Assertions.assertThrows(NotFoundElementException.class, () -> out.removeItem(777));
        Assertions.assertThrows(InvalidIndexException.class, () -> out.remove(-1));
        Assertions.assertThrows(NullItemException.class, () -> out.add(null));
        for (int i = 0; i < 7; i++) {
            out.add((i * 3));
        }
        Assertions.assertThrows(StorageIsFullException.class, () -> out.add(777));
    }

}
