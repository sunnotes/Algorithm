/**
 * 2014��6��17��
 *
 */
package charactors;

/**
 * @author EASON
 *
 *���ģ�Ӣ��palindrome��ָһ��˳�Ŷ��ͷ���������һ�����ַ�����
 *����madam���Ұ��ң������Ķ̾��������ԡ�Ȥζ�Ժ��������϶�������ɫ��
 *�й���ʷ�ϻ��кܶ���Ȥ�Ļ���ʫ��
 */
public class Palindrome
{
	// Solution 1, from sides to middle
	public static boolean isPalindromeV1(String str)
	{
		if(null == str || 0 == str.length())
		{
			return false;
		}

		int length = str.length();
		if(1 == length)
		{
			return true;
		}

		for(int leftFlag = 0, rightFlag = length - 1 ; leftFlag < rightFlag; leftFlag ++, rightFlag --)
		{
			if(str.charAt(leftFlag) != str.charAt(rightFlag))
				return false;
		}

		return true;
	}

	// Solution 2, from middle to sides
	public static boolean isPalindromeV2(String str)
	{
		if(null == str || 0 == str.length())
		{
			return false;
		}

		int length = str.length();
		if(1 == length)
		{
			return true;
		}

		int leftFlag = 0;
		int rightFlag = length;
		leftFlag = length / 2 - 1;
		if(0 == length % 2)
		{
			rightFlag = leftFlag + 1;
		}
		else
		{
			rightFlag = leftFlag + 2;
		}

		for( ; leftFlag >= 0; leftFlag --, rightFlag ++)
		{
			if(str.charAt(leftFlag) != str.charAt(rightFlag))
				return false;
		}

		return true;
	}
	
	
	public static void main(String[] args) {
		System.out.println(Palindrome.isPalindromeV1(new String("abcba")));
		System.out.println(Palindrome.isPalindromeV1(new String("abcbad")));
		System.out.println(Palindrome.isPalindromeV2(new String("abcba")));
		System.out.println(Palindrome.isPalindromeV2(new String("abcbad")));
	}

}