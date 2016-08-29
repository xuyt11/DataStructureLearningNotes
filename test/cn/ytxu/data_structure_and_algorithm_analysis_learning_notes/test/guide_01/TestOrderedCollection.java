package cn.ytxu.data_structure_and_algorithm_analysis_learning_notes.test.guide_01;

import cn.ytxu.data_structure_and_algorithm_analysis_learning_notes.guide_01.GenericCollection;
import cn.ytxu.data_structure_and_algorithm_analysis_learning_notes.guide_01.OrderedCollection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ytxu on 16/8/29.
 */
public class TestOrderedCollection {

    private OrderedCollection<Integer> orderedCollection;

    @Before
    public void init() {
        orderedCollection = new OrderedCollection<>(10);
        for (int i = 0; i < 20; i++) {
            orderedCollection.add(i);
        }
        print(orderedCollection);

    }

    @Test
    public void testFindMax() {
        Integer max = orderedCollection.findMax();
        System.out.println(max);
        Assert.assertTrue(19 == max);
    }

    @Test
    public void testFindMin() {
        Integer min = orderedCollection.findMin();
        System.out.println(min);
        Assert.assertTrue(0 == min);
    }


    @Test
    public void testFindMaxAfterAddMoreMax() {
        orderedCollection.insert(10, 33);
        Integer max = orderedCollection.findMax();
        System.out.println(max);
        Assert.assertTrue(33 == max);
    }

    @Test
    public void testFindMinAfterAddMoreMin() {
        orderedCollection.insert(10, -2);
        Integer min = orderedCollection.findMin();
        System.out.println(min);
        Assert.assertTrue(-2 == min);
    }

    @Test
    public void testFindMaxAndMinAfterInsert() {
        orderedCollection.insert(10, 33);
        orderedCollection.insert(10, -2);
        print(orderedCollection);
        Integer max = orderedCollection.findMax();
        Integer min = orderedCollection.findMin();
        System.out.println("max:" + max + ", min:" + min);
        Assert.assertTrue(33 == max);
        Assert.assertTrue(-2 == min);
    }


    private void print(GenericCollection collection) {
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
