package com.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> inputArray = new ArrayList<>();
        inputArray.add("a.b.c=1");
        inputArray.add("a.d=2");
        inputArray.add("e=3");
        inputArray.add("a.f=1");
        inputArray.add("a.b.d=1");
        convert(inputArray);
    }

    public static void convert(List<String> inputs) {

        Tree.Builder builder = new Tree.Builder();
        for (String input: inputs) {
            String[] splitArray = input.split("=");
            String value = splitArray[1];
            String[] keys = splitArray[0].split("\\.");
            builder.add(keys, value);
        }
        Tree tree = builder.create();
        System.out.println(tree.toJson());
    }

}
