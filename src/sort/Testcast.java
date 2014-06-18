/**
 * 2014Äê6ÔÂ18ÈÕ
 *
 */
package sort;


/**
 * @author EASON
 *
 */
public class Testcast {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    Integer[] array={5,6,2,7,1};
	    QuickSorter<Integer> sorter = new QuickSorter<Integer>();
	    sorter.sort(array);
	    for(int var : array){
	    	System.out.println(var);
	    }

	}

}
