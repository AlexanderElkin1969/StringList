package pro.sky.java.course2.stringlist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringListImplTest {

    private final String[] testStringList = {"One", "Two", "Three"};

    private final StringListImpl out = new StringListImpl();

    @BeforeEach
    void setUp() {
        out.add("One");
        out.add("Two");
        out.add("Three");
    }

    @AfterEach
    void tearDown() {
        out.clear();
    }

    @Test
    void add() {
        Assertions.assertEquals("Four", out.add("Four"));
        Assertions.assertEquals("Four", out.get(3));
        Assertions.assertEquals(4, out.size());
    }

    @Test
    void testAdd() {
        Assertions.assertEquals("Four", out.add(2, "Four"));
        Assertions.assertEquals("Two", out.get(1));
        Assertions.assertEquals("Four", out.get(2));
        Assertions.assertEquals("Three", out.get(3));
        Assertions.assertEquals(4, out.size());
        Assertions.assertEquals("Five", out.add(4, "Five"));
        Assertions.assertEquals(5, out.size());
        Assertions.assertEquals("Three", out.get(3));
        Assertions.assertEquals("Five", out.get(4));
    }

    @Test
    void set() {
        Assertions.assertEquals("Four", out.set(1, "Four"));
        Assertions.assertEquals("One", out.get(0));
        Assertions.assertEquals("Four", out.get(1));
        Assertions.assertEquals("Three", out.get(2));
        Assertions.assertEquals(3, out.size());
    }

    @Test
    void remove() {
        Assertions.assertEquals("One", out.remove(0));
        Assertions.assertEquals("Two", out.get(0));
        Assertions.assertEquals("Three", out.get(1));
        Assertions.assertEquals(2, out.size());
    }

    @Test
    void testRemove() {
        Assertions.assertEquals("One", out.remove("One"));
        Assertions.assertEquals("Two", out.get(0));
        Assertions.assertEquals("Three", out.get(1));
        Assertions.assertEquals(2, out.size());
    }

    @Test
    void contains() {
        Assertions.assertTrue(out.contains("Two"));
    }

    @Test
    void indexOf() {
        Assertions.assertEquals(1, out.indexOf("Two"));
    }

    @Test
    void lastIndexOf() {
        Assertions.assertEquals(1, out.indexOf("Two"));
    }

    @Test
    void get() {
        Assertions.assertEquals("Two", out.get(1));
    }

    @Test
    void size() {
        Assertions.assertEquals(3, out.size());
    }

    @Test
    void isEmptyAndClear() {
        Assertions.assertFalse(out.isEmpty());
        out.clear();
        Assertions.assertTrue(out.isEmpty());
    }

    @Test
    void toArray() {
        Assertions.assertArrayEquals(testStringList, out.toArray());
    }

    @Test
    public void shouldThrowException() {
        Assertions.assertThrows(InvalidIndexException.class, () -> out.remove(-1));
        Assertions.assertThrows(NotFoundElementException.class, () -> out.remove("Four"));
        Assertions.assertThrows(NullItemException.class, () -> out.add(null));
        out.add("Four");
        out.add("Five");
        Assertions.assertThrows(StorageIsFullException.class, () -> out.add("Six"));
    }
}