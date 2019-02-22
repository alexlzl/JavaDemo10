package com.test;

import com.sun.scenario.effect.impl.prism.ps.PPSBlend_ADDPeer;

public class Test {
    public static void main(String[] args) {

        System.out.println("ss");
        //声明的时候声明泛型类型为String
        Point<String, String> point = new Point();
        point.setX("xx");
        String s = point.getX();
        //声明的时候未定义类型
        Point point1 = new Point();
        point1.setX(100);
        int a = (int) point1.getX();
        String str = test("a");
        int aa = test(100);
    }

    public static <T> T test(T t) {
        System.out.println(t);
        return t;
    }

    private <T> void test1() {

    }
}
