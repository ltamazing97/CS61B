public class ArrayDeque<Item> {

	private Item[] items;
	private int size;
	private int nextFirst;
	private int nextLast;

	public ArrayDeque() {
		items = (Item[]) new Object[8];
		size = 0;
		nextFirst = 0;
		nextLast = 1;
	}

	public int pulsOne(int index) {
		return (index + 1) % items.length;
	}

	public int minusOne(int index) {
		return (index - 1 + items.length) % items.length;
	}

	public boolean isSparse() {
		return items.length >= 16 && size < items.length / 4;
	}

	public void resize(int capacity) {
		Item[] a = (Item[]) new Object[capacity];
		System.arraycopy(items, pulsOne(nextFirst), a, 0, size);
		items = a;
		nextFirst = capacity - 1;
		nextLast = size;
	}

	public void addFirst(Item x) {
		if (size == items.length) {
			resize(size * 2);
		}
		items[nextFirst] = x;
		minusOne(nextFirst);
		size += 1;
	}

	public void addLast(Item x) {
		if (size == items.length) {
			resize(size * 2);
		}
		items[nextLast] = x;
		pulsOne(nextLast);
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

	public Item removeFirst() {
		if (isSparse()) {
			resize(items.length / 2);
		}
		Item p = items[pulsOne(nextFirst)];
		items[pulsOne(nextFirst)] = null;
		nextFirst = pulsOne(nextFirst);
		return p;
	}

	public Item removeLast() {
		if (isSparse()) {
			resize(items.length / 2);
		}
		Item p = items[minusOne(nextLast)];
		items[minusOne(nextLast)] = null;
		nextLast = minusOne(nextLast);
		return p;
	}

	public Item get(int index) {
		return items[index];
	}
	
}