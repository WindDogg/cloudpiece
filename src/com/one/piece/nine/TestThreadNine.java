package com.one.piece.nine;

import java.util.concurrent.atomic.AtomicInteger;

public class TestThreadNine {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        int i = atomicInteger.decrementAndGet();
        int j = atomicInteger.incrementAndGet();
        int k = atomicInteger.addAndGet(3);
    }
}
