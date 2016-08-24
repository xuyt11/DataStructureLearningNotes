package cn.ytxu.data_structure_and_algorithm_analysis_learning_notes.guide_01;

import java.util.Arrays;

/**
 * Created by ytxu on 16/8/24.
 * simple array list
 */
public class GenericCollection<E> {

    public static final Object[] EMPTY = {};
    public static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Object[] elementData;
    private int size;

    public GenericCollection(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        } else if (initialCapacity == 0) {
            elementData = EMPTY;
        } else {
            elementData = new Object[initialCapacity];
        }
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public void makeEmpty() {
        elementData = EMPTY;
        size = 0;
    }

    public void add(E element) {
        ensureCapacity();
        elementData[size] = element;
        size++;
    }

    public void insert(int index, E element) {
        checkRange4Insert(index);
        ensureCapacity();
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    private void ensureCapacity() {
        if (elementData.length <= size) {
            int newLength = Math.max(DEFAULT_INITIAL_CAPACITY, elementData.length) * 2 / 3;
            elementData = Arrays.copyOf(elementData, newLength);
        }
    }

    private void checkRange4Insert(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMessage(index));
        }
    }

    private String outOfBoundsMessage(int index) {
        return "size is " + size + ", but the index is " + index;
    }

    public void remove(int index) {
        checkRange4Remove(index);
        System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
        elementData[size - 1] = null;
        size--;
    }

    private void checkRange4Remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMessage(index));
        }
    }

    public void remove(E element) {
        int index = indexOf(element);
        remove(index);
    }

    public boolean isPresent(E element) {
        return indexOf(element) > 0;
    }

    private int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            Object ele = elementData[i];
            if (element == null) {
                if (element == ele) {
                    return i;
                }
            } else {
                if (element.equals(ele)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public E get(int index) {
        checkRange4Remove(index);
        return (E) elementData[index];
    }

    public int size() {
        return size;
    }


}