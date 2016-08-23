package cn.ytxu.data_structure_and_algorithm_analysis_learning_notes.guide_01;

/**
 * Created by ytxu on 16/8/23.
 * 计算数字的二进制中的1的个数
 */
public class Parse1CountOfBinaryNumber {


    public static void main(String... args) {
        System.out.println("<<:" + (3>>1));
        System.out.println("<<:" + (2>>1));


        System.out.println("binary count:" + calculation(0));
        System.out.println("binary count:" + calculation(1));
        System.out.println("binary count:" + calculation(3));
        System.out.println("binary count:" + calculation(7));
        System.out.println("binary count:" + calculation(15));
        System.out.println("binary count:" + calculation(31));
        System.out.println("binary count:" + calculation(62));
        System.out.println("binary count:" + calculation(125));
        System.out.println("binary count:" + calculation(251));
        System.out.println("binary count:" + calculation(503));
        System.out.println("binary count:" + calculation(1007));
    }

    private static int calculation(int number) {
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
