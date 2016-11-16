package cn.ytxu.data_structure_and_algorithm_analysis_learning_notes.test.tree_04;

import cn.ytxu.data_structure_and_algorithm_analysis_learning_notes.tree_04.MyTreeSet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

/**
 * Created by ytxu on 16/11/15.
 */
public class TestMyTreeSet {
    MyTreeSet<Integer> set;

    @Before
    public void createTreeSet() {
        set = new MyTreeSet<>();
        set.print();
        for (int i = 0; i < 10; i++) {
            set.insert(i);
            i++;
        }
        set.print();
        for (int i = 1; i < 10; i++) {
            set.insert(i);
            i++;
        }
        set.print();
    }

    @Test
    public void findMaxAndMin() {
        Integer min = set.findMin();
        Assert.assertEquals(null, min);
//        Assert.assertEquals(0, set.findMin().intValue());
//        Assert.assertEquals(9, set.findMax().intValue());
    }

    @Test
    public void testContains() {
        Assert.assertEquals(false, set.contains(3));
        Assert.assertEquals(false, set.contains(10));
    }

    @Test
    public void testRemove() {
        Assert.assertEquals(null, set.remove(3));
        Assert.assertEquals(null, set.remove(10));
    }

    @Test
    public void testIterator() {
        Iterator<Integer> ite = set.iterator();
        while(ite.hasNext()) {
            System.out.println("ite:" + ite.next());
        }
    }

}
