package cn.ytxu.data_structure_and_algorithm_analysis_learning_notes.test.guide_01;

import cn.ytxu.data_structure_and_algorithm_analysis_learning_notes.guide_01.GenericCollection;

/**
 * Created by ytxu on 16/8/24.
 * simple array list
 */
public class TestGenericCollection {

    public static void main(String... args) {
        testIsPresentFuntion();
    }

    private static void testIsPresentFuntion() {
        GenericCollection<String> collection = new GenericCollection<>(10);
        for (int i = 0; i < 10; i++) {
            collection.add("" + i);
        }
        printlnSizeAndLength(collection);
        loopPrintCollectionItem(collection);

        System.out.println(collection.isPresent("2"));
        System.out.println(collection.isPresent("22"));

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

        collection.makeEmpty();
        System.out.println("is empty :" + collection.isEmpty());
        printlnSizeAndLength(collection);
        loopPrintCollectionItem(collection);

        collection.add("2");
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
        System.out.println("size:" + collection.size() + ", array length:" + collection.elementData.length);
    }

    private static void loopPrintCollectionItem(GenericCollection collection) {
        for (int i = 0; i < collection.size(); i++) {
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
