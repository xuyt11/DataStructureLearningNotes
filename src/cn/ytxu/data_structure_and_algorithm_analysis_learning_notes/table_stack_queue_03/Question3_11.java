package cn.ytxu.data_structure_and_algorithm_analysis_learning_notes.table_stack_queue_03;

/**
 * Created by ytxu on 16/11/6.
 */
public class Question3_11 {

    public static void main(String... args) {

        MySingleLinkedList<Integer> list = new MySingleLinkedList<>();

        for (int i = 0; i < 10; i++) {
            list.addElementIfNotCantains(i*2);
        }
        list.removeElementIfCantains(3);
        list.print();
        System.out.println("============================== size:" + list.size());
        list.removeElementIfCantains(3);
        list.print();
        System.out.println("============================== size:" + list.size());
        list.removeElementIfCantains(5);
        list.print();
        System.out.println("============================== size:" + list.size());
        list.addElementIfNotCantains(9);
        list.print();
        System.out.println("============================== size:" + list.size());
        list.addElementIfNotCantains(5);
        list.print();
        System.out.println("============================== size:" + list.size());

    }


    public static class MySingleLinkedList<Element extends Comparable> implements MyList<Element> {
        private int size = 0;
        private Node<Element> begin;
        private int modifyCount = 0;

        public MySingleLinkedList() {
            doClear();
        }

        private void doClear() {
            size = 0;
            begin = new Node<>(null, null);
            modifyCount++;
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public void print() {
            Node<Element> node = begin;
            while (node.next != null) {
                node = node.next;
                System.out.println(node.toString());
            }
        }

        @Override
        public boolean cantains(Element e) {
            if (e == null) {
                return false;
            }
            Node<Element> node = begin;
            while (node.next != null) {
                node = node.next;
                if (e.equals(node.data)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public void addElementIfNotCantains(Element e) {
            if (e == null) {
                return;
            }
            if (!cantains(e)) {
//                add(e);
                addWitSort(e);
            }
        }

        private void addWitSort(Element e) {
            Node<Element> preNode = begin;
            Node<Element> node = preNode.next;
            while (node != null) {
                if (e.compareTo(node.data) < 0) {
                    break;
                }
                preNode = node;
                node = preNode.next;
            }
            Node<Element> newNode = new Node<Element>(e, node);
            preNode.next = newNode;
            modifyCount++;
            size++;
        }

        private void add(Element e) {
            Node<Element> lastNode = getPreNode(size());
            Node<Element> newNode = new Node<>(e, null);
            lastNode.next = newNode;
            modifyCount++;
            size++;
        }

        private Node<Element> getPreNode(int index) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException();
            }

            Node<Element> element = begin;// index==0
            for (int i = 0; i < index; i++) {
                element = element.next;
            }
            return element;
        }

        @Override
        public void removeElementIfCantains(Element e) {
            if (cantains(e)) {
                remove(e);
            }
        }

        private void remove(Element e) {
            Node<Element> preNode = findPreNode(e);
            Node<Element> currNode = preNode.next;
            Node<Element> nextNode = currNode.next;
            preNode.next = nextNode;

            currNode.next = null;// clear

            modifyCount++;
            size--;
        }

        private Node<Element> findPreNode(Element e) {
            Node<Element> preNode = begin;
            Node<Element> node = preNode.next;
            while (node != null) {
                if (e.equals(node.data)) {
                    break;
                }
                preNode = node;
                node = preNode.next;
            }
            return preNode;
        }

        private Node<Element> findNode(Element e) {
            Node<Element> preNode = begin;
            Node<Element> node = preNode.next;
            while (node != null) {
                if (e.equals(node.data)) {
                    break;
                }
                preNode = node;
                node = preNode.next;
            }
            return node;
        }
    }

    public static class Node<Element> {
        private Element data;
        private Node<Element> next;

        public Node(Element data, Node<Element> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" + "data=" + data + '}';
        }
    }

    public interface MyList<Element extends Comparable> {
        int size();

        void print();

        boolean cantains(Element e);

        void addElementIfNotCantains(Element e);

        void removeElementIfCantains(Element e);
    }
}
