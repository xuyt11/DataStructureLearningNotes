package cn.ytxu.data_structure_and_algorithm_analysis_learning_notes.table_stack_queue_03;

import java.util.*;

/**
 * Created by ytxu on 16/11/6.
 */
public class Question3_06 {


    public static void main(String... args) {

        josephus(5, 1);
    }

    /**
     * @param personNumber  围成圆圈的人的个数
     * @param transferTimes 传递的次数
     */
    public static void josephus(final int personNumber, final int transferTimes) {

        List<Integer> personNumbers = getPersonNumbers(personNumber);
        ListIterator<Integer> personIter = personNumbers.listIterator();

        int transferCount = 0;
        while (personIter.hasNext()) {
            if (transferCount == transferTimes) {// find target element
                Integer currPersonNumber = personIter.next();
                System.out.println("find curr person number:" + currPersonNumber);

                personIter.remove();// remove target element
                System.out.println("list:" + personNumbers.toString());

                transferCount = 0;// reset transfer count
            } else {// it`s must be transferCount < transferTimes
                personIter.next();
                transferCount++;

                if (!personIter.hasNext()) {// move to last element
                    if (personNumbers.size() > 1) {// move to behind element
                        personIter = personNumbers.listIterator();
                    }
                }
            }
        }
        System.out.println("stop this transfer, the last element is " + personNumbers.get(0));
    }

    private static List<Integer> getPersonNumbers(int personNumber) {
        List<Integer> personNumbers = new LinkedList<>();
        for (int i = 0; i < personNumber; i++) {
            personNumbers.add(i + 1);
        }
        return personNumbers;
    }

}
