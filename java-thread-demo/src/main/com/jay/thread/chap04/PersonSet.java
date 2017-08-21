package com.jay.thread.chap04;

import net.jcip.annotations.ThreadSafe;

import java.util.HashSet;
import java.util.Set;

@ThreadSafe
public class PersonSet {
    private final Set<Person> mySet = new HashSet<>();

    public synchronized  void addPerson(Person person) {
        mySet.add(person);
    }

    public synchronized boolean containPerson(Person person) {
        return mySet.contains(person);
    }

//    public static void main(String[] args) {
//        ArrayList<String> strings = new ArrayList<>();
//        List list =Collections.synchronizedList(strings);
//        synchronized (list) {
//           Iterator i = list.iterator(); // Must be in synchronized block
//           while (i.hasNext()){
//
//           }
////               foo(i.next());
//       }
//    }
 }
