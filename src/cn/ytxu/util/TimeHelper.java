package cn.ytxu.util;

public class TimeHelper {
    private long count = 0;
    private long start, end;

    public TimeHelper() {
        start = System.currentTimeMillis();
    }

    public TimeHelper cpp() {
        count++;
        return this;
    }

    public TimeHelper end() {
        end = System.currentTimeMillis();
        return this;
    }

    public void printLog() {
        System.out.println("count:" + count + ", duration:" + (end - start));
    }
}