package org.example6;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class IteratorMain {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(30);
        list.add(30);
        list.add(20);
        list.add(20);

        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println(it.hasNext());

        // remove using iterator
        it = list.iterator();
        while(it.hasNext()){
            int element = it.next();
            if(element > 10 && element < 30){
                it.remove();
            }
        }
        System.out.println(list);

        // remove using index, array gets rearranged
        for(int i=0; i< list.size(); i++){
            int element = list.get(i);
            if(element > 20){
                list.remove(i);
            }
        }

        System.out.println(list);

        list.add(10);
        list.add(30);
        System.out.println(list); // 10, 30, 10 , 30
        for(int i=0; i< list.size(); i++){
            int element = list.get(i);
            if(element == 30){
                list.add(i+1, element * 2);
            }
        }
        System.out.println(list);// [10, 30, 60, 10, 30, 60]
        // [10, 30, 60, 10, 30, 60]

        // ConcurrentModificationException

        // use: with new ArrayList<>(); if we use add operation on list and iterate using iterator,
        // it will give ConCurrentModification exception because it compares modCount with expected mod count.
        // modCount of ArrayList increases when add or remove operation is happening,
        // but expectedModCount of its iterator doesnt increase, once the iterator has been created.
        // the next() method of ArrayList's iterator throws ConcurrentModificationException when modCount!=expectedModCount

        // hence to avoid this issue use CopyOnWriteArrayList instead of ArrayList
        list = new CopyOnWriteArrayList<>();// new ArrayList<>();
        list.add(10);
        list.add(40);
        list.add(200);
        list.add(200);
        list.add(30);
        list.remove(new Integer(30));

        // only when you are using CopyOnWriteArrayList
        // it [10, 200] = copy of list ,
        // add operation adds to actual list: [10, 20, 200], modCount = 5
        it = list.iterator();// 4: expectedModCount
        int i = 0;
        while(it.hasNext()){
            int element = it.next(); // no comparison of modCount with expectedModCount
            System.out.println(element);
            if(element == 10){
                list.add(i+1, element * 2); // 4 + 1 = 5 modCount
            }
            i++;
        }
        System.out.println(list);

        list = new ArrayList<>();
        list.add(10);
        list.add(12);
        list.add(13);

        ListIterator<Integer> lit = list.listIterator(list.size());
        while(lit.hasPrevious()){
            int currentIndex = lit.previousIndex();
            int element = lit.previous();
            System.out.println(currentIndex + ":"+ element);
            if(currentIndex == 0){
                lit.set(120);
            }
        }

        System.out.println("----------------------");
//        lit = list.listIterator();
        while(lit.hasNext()){
            int currentIndex = lit.nextIndex();
            int element = lit.next();
            System.out.println(currentIndex + ":"+element);
            // lit.remove();
        }
        System.out.println(list);

        // iterator: hasNext, next, remove
        // only with list implementation listIterator: haxNext, next, nextIndex, hashPrevious, previous, previousIndex,
        // set to last record being accessed (with next or previous)
        // remove last record being accessed (with next or previous)

        list = new ArrayList<>(); // walking on a staircase
        list.add(10);
        list.add(20);
        list.add(10);

        it = list.iterator();
        while(it.hasNext()){
            int element = it.next();
            System.out.println(element);
            System.out.println("hi");
        }

        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(30);

        System.out.println("---- set iterator ---");
        it = set.iterator();
        while(it.hasNext()){
            int element = it.next();
            System.out.println(element);
        }
    }
}
