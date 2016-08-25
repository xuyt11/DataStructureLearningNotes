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
        return find(new Callback<E>() {
            @Override
            public boolean isNotTargetElement(E element, int i) {
                return isNotMax(element, i);
            }
        });
    }

    private boolean isNotMax(E element, int i) {
        if (element == null) return true;
        return element.compareTo(get(i)) < 0;
    }

    @Override
    public E findMin() {
        return find(new Callback<E>() {
            @Override
            public boolean isNotTargetElement(E element, int i) {
                return isNotMin(element, i);
            }
        });
    }

    private boolean isNotMin(E element, int i) {
        if (element == null) return false;

        return element.compareTo(get(i)) > 0;
    }

    private E find(Callback callback) {
        if (size() <= 0) {
            return null;
        }

        E element = get(0);
        for (int i = 1; i < size(); i++) {
            if (callback.isNotTargetElement(element, i)) {
                element = get(i);
            }
        }
        return element;
    }

    private interface Callback<E> {
        boolean isNotTargetElement(E element, int i);
    }

}

interface Ordered<E> {
    E findMax();

    E findMin();
}
