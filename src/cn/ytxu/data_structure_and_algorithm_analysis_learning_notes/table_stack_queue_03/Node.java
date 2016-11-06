package cn.ytxu.data_structure_and_algorithm_analysis_learning_notes.table_stack_queue_03;

public class Node<Element> {
    public Element data;
    public Node<Element> next;

    public Node(Element data, Node<Element> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" + "data=" + data + '}';
    }
}