/**
 * LinkedListDeque implemented in doubly linked list (circular way).
 * @param <T>
 * @author Tao Liu
 */
public class LinkedListDeque<T> {

    private class ListNode {
        private T item;
        private ListNode prev;
        private ListNode next;

        private ListNode (ListNode p, T i, ListNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private ListNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new ListNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        sentinel.next = new ListNode(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    public void addLast(T item) {
        sentinel.prev.next = new ListNode(sentinel.prev, item, sentinel);
        sentinel.prev = sentinel.prev.next;
        size += 1;
    }

    public boolean isEmpty() {
        if (sentinel.next == sentinel) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        ListNode p = sentinel;
        p = p.next;
        while (p != sentinel) {
            System.out.println(p.item + " ");
            p = p.next;
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        ListNode p = sentinel.next;
        T value = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        p.prev = null;
        p.next = null;
        size -= 1;
        return value;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        ListNode p = sentinel.prev;
        T value = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        p.prev = null;
        p.next = null;
        size -= 1;
        return value;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        ListNode p = sentinel;
        p = p.next;
        while (index-- != 0) {
            p = p.next;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return traverse(sentinel.next, index);
    }

    private T traverse(ListNode n, int index) {
        if (index == 0) {
            return n.item;
        }
        return traverse(n.next, index - 1);
    }
}
