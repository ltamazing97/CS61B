public class ArrayDeque<T> {

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
		System.arraycopy(items, pulsOne(nextFirst), a, 0, size);
		items = a;
		nextFirst = capacity - 1;
		nextLast = size;
	}

	public void addFirst(T x) {
		if (size == items.length) {
			resize(size * 2);
		}
		items[nextFirst] = x;
		nextFirst = minusOne(nextFirst);
		size += 1;
	}

	public void addLast(T x) {
		if (size == items.length) {
			resize(size * 2);
		}
		items[nextLast] = x;
		nextLast = pulsOne(nextLast);
		size += 1;
	}

	public boolean isEmpty() {
		return pulsOne(nextFirst) == nextLast;
	}

	public int size() {
		return size;
	}

	public void printDeque() {
		int i = pulsOne(nextFirst);
		for (; i == minusOne(nextLast); pulsOne(i)) {
			System.out.println(items[i] + " ");
		}
	}

	public T removeFirst() {
		if (isSparse()) {
			resize(items.length / 2);
		}
		T p = items[pulsOne(nextFirst)];
		items[pulsOne(nextFirst)] = null;
		nextFirst = pulsOne(nextFirst);
		return p;
	}

	public T removeLast() {
		if (isSparse()) {
			resize(items.length / 2);
		}
		T p = items[minusOne(nextLast)];
		items[minusOne(nextLast)] = null;
		nextLast = minusOne(nextLast);
		return p;
	}

	public T get(int index) {
		return items[index];
	}
	
}