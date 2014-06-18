/**
 * 2014Äê6ÔÂ18ÈÕ
 *
 */
package sort;

/**
 * @author EASON
 *
 */
public class ShellSorter<E extends Comparable<E>> extends Sorter<E>  {

    /* (non-Javadoc)
     * Our delta value choose 2^k-1,2^(k-1)-1,.7,3,1.
     * complexity is O(n^1.5)
     * @see algorithms.Sorter#sort(E[], int, int)
     */
    @Override
    public void sort(E[] array, int from, int len) {
        
        //1.calculate  the first delta value;
        int value=1;
        while((value+1)*2<len)
        {
            value=(value+1)*2-1;
        
        }
    
        for(int delta=value;delta>=1;delta=(delta+1)/2-1)
        {
            for(int i=0;i<delta;i++)
            {
                modify_insert_sort(array,from+i,len-i,delta);
            }
        }

    }
    
    private final  void modify_insert_sort(E[] array, int from, int len,int delta) {
          if(len<=1)return;
          E tmp=null;
          for(int i=from+delta;i<from+len;i+=delta)
          {
              tmp=array[i];
              int j=i;
              for(;j>from;j-=delta)
              {
                  if(tmp.compareTo(array[j-delta])<0)
                  {
                      array[j]=array[j-delta];
                  }
                  else break;
              }
              array[j]=tmp;
          }

    }
}