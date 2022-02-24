package com.company;

import data.structers.DArray;

public class Main {

    public static void main(String[] args) {
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
    }
}
