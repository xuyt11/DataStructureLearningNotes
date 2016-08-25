package cn.ytxu.data_structure_and_algorithm_analysis_learning_notes.guide_01;

/**
 * Created by ytxu on 16/8/25.
 */
public class OrderedCollection<E extends Comparable<E>> extends GenericCollection<E> implements Ordered<E> {


    public OrderedCollection(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    public E findMax() {
        return null;
    }

    @Override
    public E findMin() {
        return null;
    }

}

interface Ordered<E> {
    E findMax();

    E findMin();
}
