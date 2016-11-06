package cn.ytxu.data_structure_and_algorithm_analysis_learning_notes.table_stack_queue_03;

import java.util.*;

/**
 * Created by ytxu on 16/11/5.
 */
public class Question3_01 {


    public static <AnyType> void printLots2(List<AnyType> L, List<Integer> P) {
        Iterator<AnyType> iterL = L.iterator();
        Iterator<Integer> iterP = P.iterator();
        AnyType itemL = null;
        int itemP;
        int startL = 0;
        while (iterL.hasNext() && iterP.hasNext()) {
            itemP = iterP.next();
            System.out.println("Looking for position " + itemP);

            while (startL - 1 < itemP && iterL.hasNext()) {
                startL++;
                itemL = iterL.next();
            }
            if (startL - 1 == itemP) {
                System.out.println(itemL);
            }
        }
    }

    public static void main(String... args) {

        printLots2(Arrays.asList(1, 3, 5, 7, 9, 11), Arrays.asList(0, 1, 2, 8));
    }
}
