package com.volkodav4ik;

/*
Реализовать класс IntLinkedList который имплементит интерфейс IntList
И имплементит еще 2 интерфейса: IntQueue и IntStack
*/
public class Main {

    public static void main(String[] args) {

        IntList list = new IntLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);
        list.add(80);
        list.add(90);
        System.out.println(list.toString());
        list.add(3,100);
        System.out.println(list.toString());
        list.remove(8);
        System.out.println(list.toString());
        System.out.println(list.get(8));
        list.removeByValue(100);
        System.out.println(list.toString());
        list.removeByValue(90);
        System.out.println(list.toString());
        list.set(2,300);
        System.out.println(list.toString());
        System.out.println(list.size());
        System.out.println(list.subList(0,3));
        System.out.println(list.subList(2,4));
        System.out.println(list.subList(5,7));
        System.out.println(list.toString());
        list.clear();
        System.out.println(list.isEmpty());

        IntStack listStack = new IntLinkedList();
        listStack.push(10);
        listStack.push(20);
        listStack.push(30);
        System.out.println(listStack.toString());
        System.out.println(listStack.pop());
        System.out.println(listStack.toString());
        System.out.println(listStack.peek());
        System.out.println(listStack.toString());

        IntQueue listQueue = new IntLinkedList();
        listQueue.add(10);
        listQueue.add(20);
        listQueue.add(30);
        System.out.println(listQueue.toString());
        listQueue.remove();
        System.out.println(listQueue.toString());
        System.out.println(listQueue.element());
        System.out.println(listQueue.toString());
    }
}
