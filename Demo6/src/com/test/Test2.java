package com.test;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args){
        Object[] a=new String[9];
        List<?> list=new ArrayList<Number>();
        List<? super Number> list1 = new ArrayList<Object>();
    }
}
