package cn.ytxu.data_structure_and_algorithm_analysis_learning_notes.table_stack_queue_03;

import cn.ytxu.util.PrintBufferHelper;
import cn.ytxu.util.TimeHelper;

import java.util.*;

/**
 * Created by ytxu on 16/11/6.
 */
public class Question3_06 {


    public static void main(String... args) {

//        pass(1, 0);
//        josephus(1, 0);
//        System.out.println("=================");
//        pass(5, 0);
//        josephus(5, 0);
//        System.out.println("=================");
//        pass(5, 1);
//        josephus(5, 1);
//        System.out.println("=================");
//        pass(5, 5);
//        josephus(5, 5);
        System.out.println("=================");
        pass(155, 1555555);
        josephus(155, 1555555);
        josephus2(155, 1555555);
//        System.out.println("=================");
//        pass(1555, 1555555);
//        josephus(1555, 1555555);
//        System.out.println("=================");
//        pass(15555, 1555555);
//        josephus(15555, 1555555);
//        System.out.println("=================");
//        pass(155555, 1555555);
//        josephus(155555, 1555555);
    }

    public static void pass(int n, int m) {
        TimeHelper timeHelper = new TimeHelper();
        PrintBufferHelper printHelper = new PrintBufferHelper();

        int i, j, mPrime, numLeft;
        ArrayList<Integer> L = new ArrayList<>();
        for (i = 1; i <= n; i++)
            L.add(i);
        ListIterator<Integer> iter = L.listIterator();
        Integer item = 0;
        numLeft = n;
        mPrime = m % n;
        for (i = 0; i < n; i++) {
            timeHelper.cpp();
            mPrime = m % numLeft;
            if (mPrime <= numLeft / 2) {
                timeHelper.cpp();
                if (iter.hasNext())
                    item = iter.next();
                for (j = 0; j < mPrime; j++) {
                    timeHelper.cpp();
                    if (!iter.hasNext())
                        iter = L.listIterator();
                    item = iter.next();
                }
            } else {
                for (j = 0; j < numLeft - mPrime; j++) {
                    timeHelper.cpp();
                    if (!iter.hasPrevious())
                        iter = L.listIterator(L.size());
                    item = iter.previous();
                }
            }
            printHelper.printDelay(item + ",\t");
            iter.remove();
            if (!iter.hasNext())
                iter = L.listIterator();
//            System.out.println();
//            for (Integer x : L)
//                System.out.print(x + " ");
//            System.out.println();
            numLeft--;
        }
        printHelper.flush();
        timeHelper.end().printLog();
    }

    /**
     * @param personNumber  围成圆圈的人的个数
     * @param transferTimes 传递的次数
     */
    public static void josephus(final int personNumber, final int transferTimes) {
        TimeHelper timeHelper = new TimeHelper();
        PrintBufferHelper printHelper = new PrintBufferHelper();

        List<Integer> personNumbers = getPersonNumbers(personNumber);
        ListIterator<Integer> personIter = personNumbers.listIterator();

        int transferCount = 0;
        int realTimes = getRealTransferTimes(personNumbers, transferTimes);
        while (personIter.hasNext()) {
            timeHelper.cpp();
            if (personNumbers.size() == 1) {// find end...
                break;
            }

            // must have two element in list
            if (transferCount == realTimes) {// find target element
                Integer currPersonNumber = personIter.next();
                printHelper.printDelay(currPersonNumber + ",\t");
                personIter.remove();// remove target element
//                System.out.println("list:" + personNumbers.toString());
                transferCount = 0;// reset transfer count
                realTimes = getRealTransferTimes(personNumbers, transferTimes);
            } else {// it`s must be transferCount < transferTimes
                personIter.next();
                transferCount++;
            }

            if (!personIter.hasNext()) {// it`s last element, so move to behind element
                personIter = personNumbers.listIterator();
            }
        }
        printHelper.flush();
        timeHelper.end().printLog();
        System.out.println("stop this transfer, the last element is " + personNumbers.toString());
    }

    private static List<Integer> getPersonNumbers(int personNumber) {
        List<Integer> personNumbers = new LinkedList<>();
        for (int i = 0; i < personNumber; i++) {
            personNumbers.add(i + 1);
        }
        return personNumbers;
    }

    /**
     * 获取当前，实际需要执行的传递次数
     *
     * @param personNumbers
     * @param transferTimes
     * @return
     */
    private static int getRealTransferTimes(List<Integer> personNumbers, int transferTimes) {
        return transferTimes % personNumbers.size();
    }



}
