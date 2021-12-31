package com.example.study.chapter.six.higherorderfunction;

/**
 * Higher-Level function of principle
 */
public class HigherLevelFunction {

    public static int num1Andnum2(int num1, int num2, Function func) {
        int result = (int) func.invoke(num1, num2);
        return result;
    }

    public static void main() {
        int num1 = 100;
        int num2 = 80;
        //By anonymous classes, increase overhead, so use inline.
        int result = num1Andnum2(num1, num2, new Function() {
            @Override
            public Integer invoke(int num1, int num2) {
                return num1 + num2;
            }
        });
    }

    /**
     * Higher-Level function will be create interface
     */
    interface Function {
        Integer invoke(int num1, int num2);
    }
}
