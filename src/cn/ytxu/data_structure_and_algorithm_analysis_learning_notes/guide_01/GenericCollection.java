package cn.ytxu.data_structure_and_algorithm_analysis_learning_notes.guide_01;

/**
 * Created by ytxu on 16/8/24.
 * simple array list
 */
public class GenericCollection<E> {

    public static final Object[] EMPTY = {};
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
        return elementData.length <= 0;
    }

    public void makeEmpty() {
        elementData = EMPTY;
        size = 0;
    }

    public boolean insert(int index, E element) {
        checkRange4Insert(index);

        return false;
    }

    private void checkRange4Insert(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMessage(index));
        }
    }

    private String outOfBoundsMessage(int index) {
        return "size is " + size + ", but the index is " + index;
    }

    public boolean remove(int index) {
        checkRange4Remove(index);
        return false;
    }

    private void checkRange4Remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMessage(index));
        }
    }

    public boolean remove(E element) {
        return false;
    }

    public boolean isPresent(E element) {
        for (int i = 0; i < size; i++) {
            Object ele = elementData[i];
            if (element == null) {
                if (element == ele) {
                    return true;
                }
            } else {
                if (element.equals(ele)) {
                    return true;
                }
            }
        }
        return false;
    }

}
