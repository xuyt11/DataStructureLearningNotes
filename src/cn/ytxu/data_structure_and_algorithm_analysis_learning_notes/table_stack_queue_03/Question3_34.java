package cn.ytxu.data_structure_and_algorithm_analysis_learning_notes.table_stack_queue_03;

import cn.ytxu.util.TimeHelper;

/**
 * Created by ytxu on 16/11/6.
 */
public class Question3_34 {

    public static void main(String... args) {
        judgeRecyclerQueue(99999, 13, 14, 15, 16, 17, 18);
        judgeRecyclerQueue(100000, 13, 14, 15, 16, 17, 18);
        judgeRecyclerQueue(100001, 13, 14, 15, 16, 17, 18);
    }

    private static void judgeRecyclerQueue(int queueSize, int... recyclerIndexs) {
        MySingleLinkedQueue<Integer> queue = getQueue(queueSize);
        for (int recyclerIndex : recyclerIndexs) {
            queue.setRecyclerQueue(recyclerIndex);
            System.out.println("recyclerIndex:" + recyclerIndex + ", isRecycler:" + queue.isRecycler());
        }
        System.out.println("==================================================");
    }

    private static MySingleLinkedQueue<Integer> getQueue(int count) {
        TimeHelper timeHelper = new TimeHelper();
        MySingleLinkedQueue<Integer> queue = new MySingleLinkedQueue<>();
        for (int i = 0; i < count; i++) {
            timeHelper.cpp();
            queue.add(i);
        }
        timeHelper.end().printLog();
        return queue;
    }

    public static class MySingleLinkedQueue<Element extends Comparable> {
        private int size = 0;
        private Node<Element> begin;
        private int modifyCount = 0;

        public MySingleLinkedQueue() {
            doClear();
        }

        private void doClear() {
            size = 0;
            begin = new Node<>(null, null);
            modifyCount++;
        }

        public void print() {
            Node<Element> node = begin;
            while (node.next != null) {
                node = node.next;
                System.out.println(node.toString());
            }
        }

        private void add(Element e) {
            Node<Element> newNode = new Node<>(e, null);
            newNode.next = begin.next;
            begin.next = newNode;
            modifyCount++;
            size++;
        }

        public Node<Element> getLastNode() {
            return getPreNode(size);
        }

        private Node<Element> getPreNode(int index) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException();
            }

            Node<Element> node = begin;// index==0
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }

        public void setRecyclerQueue(int index) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException();
            }

            Node<Element> node = getPreNode(index);
            Node<Element> lastNode = getLastNode();
            lastNode.next = node;

            System.out.println("node:" + node.toString());
            System.out.println("lastNode:" + lastNode.toString());
        }

        public boolean isRecycler() {
            TimeHelper timeHelper = new TimeHelper();
            try {
                Node<Element> firstPointer = getPreNode(0);
                Node<Element> secondPrePointer = firstPointer.next;
                Node<Element> secondPointer = secondPrePointer.next;

                while (true) {
                    timeHelper.cpp();
                    if (secondPointer == firstPointer) {
                        return true;
                    }

                    firstPointer = firstPointer.next;
                    secondPrePointer = secondPointer.next;
                    secondPointer = secondPrePointer.next;
                }
            } catch (NullPointerException ignore) {// it is not recycler queue
                return false;
            } finally {
                timeHelper.end().printLog();
            }
        }

    }

}
