package com.volkodav4ik;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class IntLinkedList implements IntList, IntQueue, IntStack {

    private static class Entry {
        int value;
        Entry previous;
        Entry next;

        public Entry(int value) {
            this.value = value;
        }
    }

    private int size = 0;
    private Entry first;
    private Entry last;

    public IntLinkedList() {
    }

    public IntLinkedList(int size, Entry first, Entry last) {
        this.size = size;
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean add(int value) {
        Entry newElement = new Entry(value);
        if (size == 0) {
            first = newElement;
            last = newElement;
        } else {
            last.next = newElement;
            newElement.previous = last;
            last = newElement;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index should be on range from 0 to " + size);
        }
        Entry newElement = new Entry(value);
        if (size == 0) {
            first = newElement;
            last = newElement;
        } else {
            if (index == 0) {
                first.previous = newElement;
                newElement.next = first;
                first = newElement;
            } else {
                if (index == size) {
                    last.next = newElement;
                    newElement.previous = last;
                    last = newElement;
                } else {
                    Entry tmp = getEntry(index);
                    tmp.previous.next = newElement;
                    newElement.next = tmp;
                    newElement.previous = tmp.previous;
                    tmp.previous = newElement;
                }
            }
        }
        size++;
        return true;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];
        Entry tmp = first;
        for (int i = 0; i < size; i++) {
            result[i] = tmp.value;
            tmp = tmp.next;
        }
        return result;
    }

    @Override
    public int get(int index) {
        return getEntry(index).value;
    }

    private Entry getEntry(int index) {
        if (index <= (size / 2)) {
            Entry tmp = first;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
            return tmp;
        } else {
            Entry tmp = last;
            for (int i = size - 1; i > index; i--) {
                tmp = tmp.previous;
            }
            return tmp;
        }
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index should be on range from 0 to " + (size - 1));
        }
        if (index == 0) {
            first.next.previous = null;
            first = first.next;
        } else {
            if (index == (size - 1)) {
                last.previous.next = null;
                last = last.previous;
            } else {
                Entry tmp = getEntry(index);
                tmp.next.previous = tmp.previous;
                tmp.previous.next = tmp.next;
             /*   tmp.previous = null;
                tmp.next = null;*/
            }
        }
        size--;
        return true;
    }

    @Override
    public boolean removeByValue(int value) {
        Entry tmp = first;
        for (int i = 0; i < size; i++) {
            if (tmp.value == value) {
                this.remove(i);
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    @Override
    public boolean set(int index, int element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index should be on range from 0 to " + (size - 1));
        }
        Entry tmp = getEntry(index);
        tmp.value = element;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Index should be on range from 0 to " + size
                    + "and start index can't equal or more than final index");
        }
        int newSize = toIndex - fromIndex;
        Entry from = getEntry(fromIndex);
        Entry to = getEntry(toIndex - 1);
        return new IntLinkedList(newSize, from, to);
    }

    @Override
    public boolean push(int value) {
        Entry newElement = new Entry(value);
        if (size == 0) {
            first = newElement;
            last = newElement;
        } else {
            first.previous = newElement;
            newElement.next = first;
            first = newElement;
        }
        size++;
        return true;
    }

    @Override
    public int pop() {
        if (size == 0) {
            throw new NoSuchElementException("This list is empty");
        }
        int result = first.value;
        first.next.previous = null;
        first = first.next;
        size--;
        return result;
    }

    @Override
    public int peek() {
        if (size == 0) {
            return 0;
        }
        return first.value;
    }

    @Override
    public int remove() {
        if (size == 0) {
            throw new NoSuchElementException("This list is empty");
        }
        int result = first.value;
        first.next.previous = null;
        first = first.next;
        size--;
        return result;
    }

    @Override
    public int element() {
        if (size == 0) {
            throw new NoSuchElementException("This list is empty");
        }
        return first.value;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
