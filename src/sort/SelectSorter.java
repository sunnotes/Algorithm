/**
 * 2014Äê6ÔÂ18ÈÕ
 *
 */
package sort;

/**
 * @author EASON
 *
 */
public class SelectSorter<E extends Comparable<E>> extends Sorter<E> {

    /* (non-Javadoc)
     * @see algorithms.Sorter#sort(E[], int, int)
     */
    @Override
    public void sort(E[] array, int from, int len) {
        for(int i=0;i<len;i++)
        {
            int smallest=i;
            int j=i+from;
            for(;j<from+len;j++)
            {
                if(array[j].compareTo(array[smallest])<0)
                {
                    smallest=j;
                }
            }
            swap(array,i,smallest);
                   
        }

    }
  
}