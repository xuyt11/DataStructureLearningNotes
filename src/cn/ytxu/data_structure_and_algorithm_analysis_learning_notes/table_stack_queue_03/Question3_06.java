package cn.ytxu.data_structure_and_algorithm_analysis_learning_notes.table_stack_queue_03;

import cn.ytxu.util.PrintBufferHelper;
import cn.ytxu.util.TimeHelper;

import java.util.*;

/**
 * Created by ytxu on 16/11/6.
 */
public class Question3_06 {


    public static void main(String... args) {

//        compare(15, 0);
//        compare(15, 1);
//        compare(15, 9);
//        compare(155, 9);
//        compare(155, 999);
//        compare(155, 5555);
//        compare(1545, 55523);
//        compare(15455, 55523);
//        compare(45155, 999);
//        compare(45155, 55523);
//        compare(145155, 5233);
//        compare(145155, 52334);
        compare(145155, 32334);
    }

    private static void compare(int personNumber, int transferTimes) {
        pass(personNumber, transferTimes);
//        pass2(personNumber, transferTimes);
//        josephus(personNumber, transferTimes);
        josephus2(personNumber, transferTimes);
        josephus3(personNumber, transferTimes, false);
        josephus3(personNumber, transferTimes, true);
        System.out.println("=================");
    }

    public static void pass(int n, int m) {
        TimeHelper timeHelper = new TimeHelper();
        PrintBufferHelper printHelper = new PrintBufferHelper();

        int i, j, mPrime, numLeft;
        ArrayList<Integer> L = new ArrayList<>(n);
        for (i = 1; i <= n; i++)
            L.add(i);
        timeHelper.duration();
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

    public static void pass2(int n, int m) {
        TimeHelper timeHelper = new TimeHelper();
        PrintBufferHelper printHelper = new PrintBufferHelper();

        int i, j, mPrime, numLeft;
        LinkedList<Integer> L = new LinkedList<>();
        for (i = 1; i <= n; i++)
            L.add(i);
        timeHelper.duration();
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

        List<Integer> personNumbers = getLinkedPersonNumbers(personNumber);
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

    private static List<Integer> getArrayPersonNumbers(int personNumber) {
        List<Integer> personNumbers = new ArrayList<>(personNumber);
        for (int i = 0; i < personNumber; i++) {
            personNumbers.add(i + 1);
        }
        return personNumbers;
    }

    private static List<Integer> getLinkedPersonNumbers(int personNumber) {
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

    /**
     * @param personNumber  围成圆圈的人的个数
     * @param transferTimes 传递的次数
     */
    public static void josephus2(final int personNumber, final int transferTimes) {
        TimeHelper timeHelper = new TimeHelper();
        PrintBufferHelper printHelper = new PrintBufferHelper();

        List<Integer> personNumbers = getLinkedPersonNumbers(personNumber);
        ListIterator<Integer> personIter = personNumbers.listIterator();

        int currIndex = 0;// iterator index

        while (personNumbers.size() > 1) {
            timeHelper.cpp();
            final int currSize = personNumbers.size();
            final int realTimes = getRealTransferTimes(personNumbers, transferTimes);
            final int targetIndex = (realTimes + currIndex) % currSize;

            if (targetIndex == currIndex) {
                Integer currPersonNumber = personIter.next();
                printHelper.printDelay(currPersonNumber + ",\t");
                personIter.remove();
            } else if (targetIndex > currIndex) {// c:3, t:100
                // do next for non recycler
                while (true) {
                    timeHelper.cpp();
                    Integer currPersonNumber = personIter.next();
                    if (targetIndex == currIndex) {// find
                        printHelper.printDelay(currPersonNumber + ",\t");
                        personIter.remove();
                        break;
                    } else {
                        currIndex++;
                    }
                }
            } else {
                if (targetIndex < currIndex - targetIndex) {// t:3, c:100
                    personIter = personNumbers.listIterator();
                    currIndex = 0;
                    while (true) {
                        timeHelper.cpp();
                        Integer currPersonNumber = personIter.next();
                        if (targetIndex == currIndex) {// find
                            printHelper.printDelay(currPersonNumber + ",\t");
                            personIter.remove();
                            break;
                        } else {
                            currIndex++;
                        }
                    }
                } else {// t:90, c:100
                    // do previous for non recycler
                    while (true) {
                        timeHelper.cpp();
                        if (targetIndex == currIndex) {// find
                            Integer currPersonNumber = personIter.next();
                            printHelper.printDelay(currPersonNumber + ",\t");
                            personIter.remove();
                            break;
                        } else {
                            personIter.previous();
                            currIndex--;
                        }
                    }
                }
            }
        }

        printHelper.flush();
        timeHelper.end().printLog();
        System.out.println("stop this transfer, the last element is " + personNumbers.toString());
    }

    /**
     * @param personNumber  围成圆圈的人的个数
     * @param transferTimes 传递的次数
     */
    public static void josephus3(final int personNumber, final int transferTimes, boolean isArray) {
        TimeHelper timeHelper = new TimeHelper();
        PrintBufferHelper printHelper = new PrintBufferHelper();

        List<Integer> personNumbers = isArray ? getArrayPersonNumbers(personNumber) : getLinkedPersonNumbers(personNumber);
        ListIterator<Integer> personIter = personNumbers.listIterator();

        int currIndex = 0;// iterator index

        while (personNumbers.size() > 1) {
            timeHelper.cpp();
            final int currSize = personNumbers.size();
            final int realTimes = getRealTransferTimes(personNumbers, transferTimes);
            final int targetIndex = (realTimes + currIndex) % currSize;

            if (targetIndex == currIndex) {
                Integer currPersonNumber = personIter.next();
                printHelper.printDelay(currPersonNumber + ",\t");
                personIter.remove();
            } else if (targetIndex > currIndex) {// c:3, t:100
                // do next for non recycler
                if (realTimes <= targetIndex) {
                    while (true) {
                        timeHelper.cpp();
                        Integer currPersonNumber = personIter.next();
                        if (targetIndex == currIndex) {// find
                            printHelper.printDelay(currPersonNumber + ",\t");
                            personIter.remove();
                            break;
                        } else {
                            currIndex++;
                        }
                    }
                } else {
                    personIter = personNumbers.listIterator(personNumbers.size());
                    currIndex = personNumbers.size() - 1;
                    while (true) {
                        timeHelper.cpp();
                        Integer currPersonNumber = personIter.previous();
                        if (targetIndex == currIndex) {// find
                            printHelper.printDelay(currPersonNumber + ",\t");
                            personIter.remove();
                            break;
                        } else {
                            currIndex--;
                        }
                    }
                }
            } else {
                if (targetIndex < currIndex - targetIndex) {// t:3, c:100
                    personIter = personNumbers.listIterator();
                    currIndex = 0;
                    while (true) {
                        timeHelper.cpp();
                        Integer currPersonNumber = personIter.next();
                        if (targetIndex == currIndex) {// find
                            printHelper.printDelay(currPersonNumber + ",\t");
                            personIter.remove();
                            break;
                        } else {
                            currIndex++;
                        }
                    }
                } else {// t:90, c:100
                    // do previous for non recycler
                    while (true) {
                        timeHelper.cpp();
                        if (targetIndex == currIndex) {// find
                            Integer currPersonNumber = personIter.next();
                            printHelper.printDelay(currPersonNumber + ",\t");
                            personIter.remove();
                            break;
                        } else {
                            personIter.previous();
                            currIndex--;
                        }
                    }
                }
            }
        }

        printHelper.flush();
        timeHelper.end().printLog();
        System.out.println("stop this transfer, the last element is " + personNumbers.toString());
    }


}
