package cn.ytxu.data_structure_and_algorithm_analysis_learning_notes.test.guide_01;

import cn.ytxu.data_structure_and_algorithm_analysis_learning_notes.guide_01.GenericCollection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

/**
 * Created by ytxu on 16/8/24.
 * simple array list
 */
public class TestGenericCollection {
    private GenericCollection<String> collection;


    @Test
    public void testOutOfBounds() {
        try {
            new GenericCollection<>(-1);
            Assert.assertTrue(false);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            Assert.assertTrue(true);
        }
    }

    @Before
    public void createGenericCollection() {
        collection = new GenericCollection<>(10);
    }

    @Test
    public void testIsPresentFuntion() {
        for (int i = 0; i < 10; i++) {
            collection.add("" + i);
        }
        printlnSizeAndLength(collection);
        loopPrintCollectionItem(collection);

        System.out.println(collection.isPresent("2"));
        System.out.println(collection.isPresent("22"));

    }

    @Test
    public void testEmptyFunction() {
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

    @Test
    public void testInsertMethod() {
        for (int i = 0; i < 10; i++) {
            collection.add("" + i);
        }
        printlnSizeAndLength(collection);
        loopPrintCollectionItem(collection);

        collection.insert(3, "33");
        printlnSizeAndLength(collection);
        loopPrintCollectionItem(collection);
    }

    @Test
    public void testRemoveMethod() {
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

    @Test
    public void testAddMethod() {
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

    @Test
    public void testSize() {
        printlnSizeAndLength(collection);
        loopPrintCollectionItem(collection);
    }

    private void printlnSizeAndLength(GenericCollection collection) {
        System.out.println("size:" + collection.size() + ", array length:" + collection.elementData.length);
    }

    private void loopPrintCollectionItem(GenericCollection collection) {
        for (int i = 0; i < collection.size(); i++) {
            System.out.print(collection.get(i) + "\t");
        }
        System.out.println("\n==================");
    }

}
