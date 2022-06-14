package project;

import project.entity.MyHashMap;

public class Main {

    public static void main(final String[] args) {
        final MyHashMap<Integer, String> myMap = new MyHashMap<>();
        myMap.put(1, "one");
        myMap.put(2, "two");
        myMap.put(3, "three");
        myMap.put(17, "one_second");
        myMap.put(18, "two_second");
        myMap.put(19, "three_second");

        System.out.println("myMap = " + myMap);

        System.out.println("myMap.put(17, \"one_second_replace\") = " + myMap.put(17, "one_second_replace"));
        System.out.println("myMap.get(18) = " + myMap.get(18));
        System.out.println("myMap.remove(3) = " + myMap.remove(3));

        System.out.println("myMap = " + myMap);
    }
}
