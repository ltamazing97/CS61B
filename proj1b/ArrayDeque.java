/**
 * ArrayDeque implemented in circular way.
 * @param <T>
 * @author Tao Liu
 */

public class ArrayDeque<T> implements Deque<T>{
	private T[] items;
	private int size;
	private int nextFirst;
	private int nextLast;

	public ArrayDeque() {
		items = (T[]) new Object[8];
		size = 0;
		nextFirst = 0;
		nextLast = 1;
	}

	private int pulsOne(int index) {
		return (index + 1) % items.length;
	}

	private int minusOne(int index) {
		return (index - 1 + items.length) % items.length;
	}

	private boolean isSparse() {
		return (items.length >= 16) && (size < (items.length / 4));
	}

	private void resize(int capacity) {
		T[] a = (T[]) new Object[capacity];
		int oldIndex = pulsOne(nextFirst);
		for (int newIndex = 0; newIndex < size; newIndex++) {
			a[newIndex] = items[oldIndex];
			oldIndex = pulsOne(oldIndex);
		}
		items = a;
		nextFirst = capacity - 1;
		nextLast = size;
	}

	@Override
	public void addFirst(T x) {
		if (size == items.length) {
			resize(size * 2);
		}
		items[nextFirst] = x;
		nextFirst = minusOne(nextFirst);
		size += 1;
	}

	@Override
	public void addLast(T x) {
		if (size == items.length) {
			resize(size * 2);
		}
		items[nextLast] = x;
		nextLast = pulsOne(nextLast);
		size += 1;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void printDeque() {
		int i = pulsOne(nextFirst);
		for (; i != nextLast; i = pulsOne(i)) {
			System.out.print(items[i] + " ");
		}
		System.out.println();
	}

	@Override
	public T removeFirst() {
		if (isSparse()) {
			resize(items.length / 2);
		}
		T p = items[pulsOne(nextFirst)];
		items[pulsOne(nextFirst)] = null;
		nextFirst = pulsOne(nextFirst);
		if (size != 0) {
			size -= 1;
		}
		return p;
	}

	@Override
	public T removeLast() {
		if (isSparse()) {
			resize(items.length / 2);
		}
		T p = items[minusOne(nextLast)];
		items[minusOne(nextLast)] = null;
		nextLast = minusOne(nextLast);
		if (size != 0) {
			size -= 1;
		}
		return p;
	}

	@Override
	public T get(int index) {
		if (index > size) {
			return null;
		}
		int start = pulsOne(nextFirst);
		return items[(start + index) % items.length];
	}
}
