package cn.ytxu.data_structure_and_algorithm_analysis_learning_notes.guide_01;

/**
 * Created by ytxu on 16/8/23.
 * 计算数字的二进制中的1的个数
 */
public class Parse1CountOfBinaryNumber {


    public static int calculation(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("number must bigger zero, you input " + number);
        }

        if (number == 0) {
            return 0;
        }

        if (number >> 1 == (number - 1) >> 1) {
            return calculation(number / 2) + 1;
        }

        return calculation(number / 2);
    }

}
