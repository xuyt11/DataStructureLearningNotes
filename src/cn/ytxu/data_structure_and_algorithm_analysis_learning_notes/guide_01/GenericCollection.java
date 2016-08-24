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
        size = initialCapacity;
    }

    public boolean isEmpty() {
        return elementData.length <= 0;
    }

    public void makeEmpty() {
        elementData = EMPTY;
    }

    public boolean insert(int index, E element) {
        return false;
    }

    public boolean remove(int index) {

        return false;
    }

    public boolean remove(E element) {
        return false;
    }

    public boolean isPresent(E element) {
        for (int i = 0; i < elementData.length; i++) {
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
