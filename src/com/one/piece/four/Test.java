package com.one.piece.four;

import java.util.*;

public class Test {
    private HashMap map;
    private Hashtable table;//线程安全
    private StringBuffer StringBuffer;//线程安全
    private StringBuilder StringBuilder;
    private ArrayList ArrayList;
    private Vector Vector;//线程安全

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = Collections.synchronizedList(list);
    }

}
