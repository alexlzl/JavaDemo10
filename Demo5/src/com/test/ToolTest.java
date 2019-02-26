package com.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型使用
 */
public class ToolTest {


    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>();
        ls.add(23);
        /**
         * 正常情况下，因为泛型的限制，编译器不让下面一行代码编译通过，因为类似不匹配，但是，基于对类型擦除的了解，利用反射，我们可以绕过这个限制
         */
//		ls.add("text");
        try {
            Method method = ls.getClass().getDeclaredMethod("add", Object.class);


            method.invoke(ls, "test");
            method.invoke(ls, 42.9f);
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for (Object o : ls) {
            System.out.println(o);
        }

    }

    private void test() {
//        List<int> li = new ArrayList<>();
//        List<boolean> li = new ArrayList<>();

        String[] args = new String[]{"a", "b"};
        Erasure erasure = new Erasure<Child>();

    }

    /**
     * 这两行代码是无法在编译器中编译通过的。原因还是类型擦除带来的影响。
     * <p>
     * List<Integer>和 List<Boolean>在 jvm 中等同于List<Object>，所有的类型信息都被擦除，程序也无法分辨一个数组中的元素类型具体是 List<Integer>类型还是 List<Boolean>类型。
     * <p>
     * 但是，
     */
    private void test1() {
//        List<Integer>[] li2 = new ArrayList<Integer>[];
//        List<Boolean> li3 = new ArrayList<Boolean>[];
        /**
         * 借助于无限定通配符却可以，前面讲过 ？代表未知类型，所以它涉及的操作都基本上与类型无关，
         * 因此 jvm 不需要针对它对类型作判断，因此它能编译通过，
         * 但是，只提供了数组中的元素因为通配符原因，它只能读，不能写。
         * 比如，上面的 v 这个局部变量，它只能进行 get() 操作，不能进行 add() 操作
         */
        List<?>[] li3 = new ArrayList<?>[10];
        li3[1] = new ArrayList<String>();
        List<?> v = li3[1];


    }

}


