package cn.ytxu.util;

/**
 * Created by ytxu on 16/11/6.
 */
public class PrintBufferHelper {
    private static final int PrintBufferCount = 50;
    private int count = 0;

    private StringBuffer buffer = new StringBuffer();

    public void printDelay(String content) {
        addContent2Buffer(content);

        if (count == PrintBufferCount) {
            printBuffer();
            clearBuffer();
        }
    }

    private void addContent2Buffer(String content) {
        count++;
        buffer.append(content);
    }

    private void printBuffer() {
        System.out.println(buffer.toString());
    }

    private void clearBuffer() {
        count = 0;
        buffer = new StringBuffer();
    }

    public void flush() {
        printBuffer();
        clearBuffer();
    }

}
