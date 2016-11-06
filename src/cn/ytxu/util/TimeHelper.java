package cn.ytxu.util;

import java.util.ArrayList;
import java.util.List;

public class TimeHelper {
    private long count = 0;
    private long start, end;

    private List<Long> times = new ArrayList<>(10);// 每次调用的时间
    private List<String> durations = new ArrayList<>(10);// 每次调用的间隔

    public TimeHelper() {
        start = System.nanoTime();
    }

    public TimeHelper cpp() {
        count++;
        return this;
    }

    public TimeHelper cpp(int times) {
        count += times;
        return this;
    }

    public void duration() {
        long curr = System.nanoTime();
        durations.add("" + (curr - start));
        times.add(curr);
    }

    public TimeHelper end() {
        end = System.nanoTime();
        return this;
    }

    public void printLog() {
        System.out.println(durations.toString());
        System.out.println("count:" + count + ", total duration:" + (end - start));
    }

}