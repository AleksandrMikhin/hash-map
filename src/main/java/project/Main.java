package project;

import project.entity.MyHashMap;
import project.entity.MyMap;
import project.proxy.ProxyMyMap;

public class Main {

    public static void main(final String[] args) {
        final MyMap<Integer, String> myMap = new MyHashMap<>();

        final MyMap<Integer, String> myProxyMap = new ProxyMyMap<>(myMap);

        myProxyMap.put(1, "one");
        myProxyMap.put(2, "two");
        myProxyMap.put(3, "three");
        myProxyMap.put(17, "one_second");
        myProxyMap.put(18, "two_second");
        myProxyMap.put(19, "three_second");

        System.out.println("myProxyMap = " + myProxyMap);

        System.out.println("myProxyMap.put(17, \"one_second_replace\") = " + myProxyMap.put(17, "one_second_replace"));
        System.out.println("myProxyMap.get(18) = " + myProxyMap.get(18));
        System.out.println("myProxyMap.remove(3) = " + myProxyMap.remove(3));

        System.out.println("myProxyMap = " + myProxyMap);
    }
}
