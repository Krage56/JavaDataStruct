package com.company;

import data.structers.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Dynamic array test");
        DArray<Integer> test = new DArray<>(10);

        for (int i = 0; i < 9; ++i){
            test.addToEnd(i);
        }
        test.add(9, 9);
        test.add(10, 0);
        System.out.println(test.getSize());
        System.out.println(test.getCap());
        for (int i = 0; i < test.getSize(); ++i){
            System.out.println(test.get(i));
        }
        test.remove(5);
        System.out.println(test.getSize());
        test.removeFromEnd();
        System.out.println(test.getSize());
        test.reserve(2);
        for (int i = 0; i < test.getSize(); ++i){
            System.out.println(test.get(i));
        }
        System.out.println(test.getSize());
        System.out.println(test.getCap());
        test.resize(100);
        for (int i = 0; i < test.getSize(); ++i){
            System.out.println(test.get(i));
        }
        System.out.println("Forward list test");
        ForwardList<Integer> testList = new ForwardList<>();
        testList.addToHead(0);
        testList.addToHead(1);
        testList.addToHead(2);
        for (int i = 3; i < 5; ++i){
            testList.add(i, 1);
        }
        testList.removeFront();
        testList.remove(2);
        System.out.println(testList.get(1));
        testList.clear();

    }
}
