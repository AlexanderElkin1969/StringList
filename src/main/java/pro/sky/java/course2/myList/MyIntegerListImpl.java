package pro.sky.java.course2.myList;

import org.apache.commons.lang3.StringUtils;
import pro.sky.java.course2.myList.exception.InvalidIndexException;
import pro.sky.java.course2.myList.exception.NotFoundElementException;
import pro.sky.java.course2.myList.exception.NullItemException;
import pro.sky.java.course2.myList.exception.StorageIsFullException;

import java.util.Arrays;

public class MyIntegerListImpl implements MyIntegerList {

    private final Integer[] storage;

    private int size;

    public MyIntegerListImpl() {
        storage = new Integer[10];
    }

    public MyIntegerListImpl(int initSize) {
        storage = new Integer[initSize];
    }

    @Override
    public Integer add(Integer item) {
        validateSize();
        validateItem(item);
        storage[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateSize();
        validateItem(item);
        validateIndex(index);
        if (index == size) {
            storage[index] = item;
            size++;
            return item;
        }
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        storage[index] = item;
        return item;
    }

    @Override
    public Integer removeItem(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new NotFoundElementException();
        }
        if (index != size - 1) {
            System.arraycopy(storage, index + 1, storage, index, size - index - 1);
        }
        size--;
        return item;
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer item = storage[index];
        if (index != size - 1) {
            System.arraycopy(storage, index + 1, storage, index, size - index - 1);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] arr = Arrays.copyOf(storage, size);
        return binarySearch(arr, item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (storage[i].equals(item)) return i;
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return storage[index];
    }

    @Override
    public boolean equals(MyIntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    private boolean binarySearch(Integer[] arr, Integer item) {
        sort(arr);
        int min = 0;
        int max = arr.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (item.equals(arr[mid])) {
                return true;
            }
            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    private void sort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Integer temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullItemException();
        }
        if (!StringUtils.isNumeric(item.toString())) {
            throw new IllegalArgumentException();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
    }

    private void validateSize() {
        if (size == storage.length) {
            throw new StorageIsFullException();
        }
    }

}
