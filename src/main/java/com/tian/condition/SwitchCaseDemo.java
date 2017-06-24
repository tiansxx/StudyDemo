package com.tian.condition;

/**
 * 
 * @author tian
 */

public class SwitchCaseDemo {

    public static void main(String[] args) {
        String o = null;
        /**
         * 使用switch...case, 入参不能为null
         */
        switch (o) {
            case "1":
                System.out.println("1");
                break;
            default:
                System.out.println("null");
                break;
        }
    }
}
