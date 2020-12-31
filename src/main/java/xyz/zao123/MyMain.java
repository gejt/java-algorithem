package xyz.zao123;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MyMain {
    public static void main(String[] args){
        // list oper
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        Vector<String> vector = new Vector<>();
        Stack<String> stack = new Stack<>();

        //Map oper
        Map<String,String> hashMap = new HashMap<>();
        Map<String,String> hashTable = new Hashtable<>();
        Map<String,String> linkedHashMap = new LinkedHashMap<>();

        //Set oper
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();

        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();

        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        AtomicInteger atomicInteger = new AtomicInteger(0);
    }
}
