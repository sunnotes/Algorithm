/**
 * 2014Äê6ÔÂ18ÈÕ
 *
 */
package sort;

/**
 * @author EASON
 * 
 */
public class QuickSorter<E extends Comparable<E>> extends Sorter<E> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see algorithms.Sorter#sort(E[], int, int)
	 */
	@Override
	public void sort(E[] array, int from, int len) {
		q_sort(array, from, from + len - 1);
	}

	private final void q_sort(E[] array, int from, int to) {
		if (to - from < 1)
			return;
		int pivot = selectPivot(array, from, to);

		pivot = partion(array, from, to, pivot);

		q_sort(array, from, pivot - 1);
		q_sort(array, pivot + 1, to);

	}

	private int partion(E[] array, int from, int to, int pivot) {
		E tmp = array[pivot];
		array[pivot] = array[to];// now to's position is available

		while (from != to) {
			while (from < to && array[from].compareTo(tmp) <= 0)
				from++;
			if (from < to) {
				array[to] = array[from];// now from's position is available
				to--;
			}
			while (from < to && array[to].compareTo(tmp) >= 0)
				to--;
			if (from < to) {
				array[from] = array[to];// now to's position is available now
				from++;
			}
		}
		array[from] = tmp;
		return from;
	}

	private int selectPivot(E[] array, int from, int to) {

		return (from + to) / 2;
	}

}
