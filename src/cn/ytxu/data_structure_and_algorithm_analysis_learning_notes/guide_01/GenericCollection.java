package cn.ytxu.data_structure_and_algorithm_analysis_learning_notes.guide_01;

import java.util.Arrays;

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
        return size <= 0;
    }

    public void makeEmpty() {
        elementData = EMPTY;
        size = 0;
    }

    public void add(E element) {
        if (elementData.length <= size) {
            elementData = Arrays.copyOf(elementData, elementData.length * 2);
        }
        elementData[size] = element;
        size++;
    }

    public void insert(int index, E element) {
        checkRange4Insert(index);
        if (elementData.length <= size) {
            elementData = Arrays.copyOf(elementData, elementData.length * 2);
        }
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
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

    private E get(int index) {
        checkRange4Remove(index);
        return (E) elementData[index];
    }


    public static void main(String... args) {
        testEmptyFunction();
    }

    private static void testEmptyFunction() {
        GenericCollection<String> collection = new GenericCollection<>(10);
        System.out.println("is empty :" + collection.isEmpty());
        printlnSizeAndLength(collection);
        loopPrintCollectionItem(collection);

        for (int i = 0; i < 10; i++) {
            collection.add("" + i);
        }
        System.out.println("is empty :" + collection.isEmpty());
        printlnSizeAndLength(collection);
        loopPrintCollectionItem(collection);

    }

    private static void testInsertMethod() {
        GenericCollection<String> collection = new GenericCollection<>(10);
        for (int i = 0; i < 10; i++) {
            collection.add("" + i);
        }
        printlnSizeAndLength(collection);
        loopPrintCollectionItem(collection);

        collection.insert(3, "33");
        printlnSizeAndLength(collection);
        loopPrintCollectionItem(collection);
    }

    private static void testRemoveMethod() {
        GenericCollection<String> collection = new GenericCollection<>(10);
        for (int i = 0; i < 10; i++) {
            collection.add("" + i);
        }
        printlnSizeAndLength(collection);
        loopPrintCollectionItem(collection);

        collection.remove("0");
        printlnSizeAndLength(collection);
        loopPrintCollectionItem(collection);

        collection.remove(3);
        printlnSizeAndLength(collection);
        loopPrintCollectionItem(collection);
    }

    private static void printlnSizeAndLength(GenericCollection collection) {
        System.out.println("size:" + collection.size + ", array length:" + collection.elementData.length);
    }

    private static void loopPrintCollectionItem(GenericCollection collection) {
        for (int i = 0; i < collection.size; i++) {
            System.out.print(collection.get(i) + "\t");
        }
        System.out.println("\n==================");
    }

    private static void testAddMethod() {
        GenericCollection<String> collection = new GenericCollection<>(10);
        for (int i = 0; i < 10; i++) {
            collection.add("" + i);
        }
        printlnSizeAndLength(collection);
        loopPrintCollectionItem(collection);

        for (int i = 0; i < 5; i++) {
            collection.add("" + i * i);
        }
        printlnSizeAndLength(collection);
        loopPrintCollectionItem(collection);
    }

    private static void testSize() {
        GenericCollection<String> collection = new GenericCollection<>(10);
        printlnSizeAndLength(collection);
        loopPrintCollectionItem(collection);
    }

    private static void testOutOfBounds() {
        GenericCollection<String> collection = new GenericCollection<>(-1);
    }

}
