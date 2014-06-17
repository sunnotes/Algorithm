/**
 * 2014年6月17日
 *
 */
package charactors;

/**
 * @author EASON
 * 
 * 
 * 给定一个字符串，要求把字符串前面的若干个字符移动到字符串的尾部，如把字符串“abcdef”前面的2个字符“ab” 移动到字符串的尾部，
 * 即变成“cdefab”。请写一个函数完成此功能，要求对长度为n的字符串操作的时间复杂度为 O(n)，空间复杂度为 O(1)。
 *
 */
public class LeftRotatingString {
    
    // Version 1
    public void leftShiftV1 (char[] s, int m) {
        while (m > 0) {
            leftShiftOne(s);
            m--;
        }
    }

    private void leftShiftOne (char[] s) {
        int len = s.length;
        int i = 0;
        char c = s[0];
        while (i < len - 1) {
            s[i] = s[i + 1];
            i++;
        }
        s[len - 1] = c;
    }


    // Version2
    public void leftShiftV2(char[] s, int m) {
        int len = s.length;
        m = m % len;
        reverse(s, 0, m - 1);
        reverse(s, m, len - 1);
        reverse(s, 0, len - 1);
    }

    private void reverse (char[] s, int from, int to) {
        while(from < to) {
            char c = s[from];
            s[from] = s[to];
            s[to] = c;
            from++;
            to--;
        }
    }

    public static void main (String[] args) {
    	LeftRotatingString leftRotatingString = new LeftRotatingString();
        
        String str = "asdfghjkl";
        System.out.println("Original String:");
        System.out.println(str);
        char[] arr1 = str.toCharArray();
        char[] arr2 = str.toCharArray();

        leftRotatingString.leftShiftV1(arr1, 2);
        leftRotatingString.leftShiftV2(arr2, 2);
        
        System.out.println("Left shift V1:");
        System.out.println(new String(arr1));
        System.out.println("left Shift V2:");
        System.out.println(new String(arr2));
    }
}