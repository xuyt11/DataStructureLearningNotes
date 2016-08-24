package cn.ytxu.data_structure_and_algorithm_analysis_learning_notes.test.guide_01;

import cn.ytxu.data_structure_and_algorithm_analysis_learning_notes.guide_01.Parse1CountOfBinaryNumber;

/**
 * Created by ytxu on 16/8/23.
 * 计算数字的二进制中的1的个数
 */
public class TestParse1CountOfBinaryNumber {


    public static void main(String... args) {
        System.out.println("<<:" + (3 >> 1));
        System.out.println("<<:" + (2 >> 1));


        System.out.println("binary count:" + Parse1CountOfBinaryNumber.calculation(0));
        System.out.println("binary count:" + Parse1CountOfBinaryNumber.calculation(1));
        System.out.println("binary count:" + Parse1CountOfBinaryNumber.calculation(3));
        System.out.println("binary count:" + Parse1CountOfBinaryNumber.calculation(7));
        System.out.println("binary count:" + Parse1CountOfBinaryNumber.calculation(15));
        System.out.println("binary count:" + Parse1CountOfBinaryNumber.calculation(31));
        System.out.println("binary count:" + Parse1CountOfBinaryNumber.calculation(62));
        System.out.println("binary count:" + Parse1CountOfBinaryNumber.calculation(125));
        System.out.println("binary count:" + Parse1CountOfBinaryNumber.calculation(251));
        System.out.println("binary count:" + Parse1CountOfBinaryNumber.calculation(503));
        System.out.println("binary count:" + Parse1CountOfBinaryNumber.calculation(1007));
    }

}
