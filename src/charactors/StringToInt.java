/**
 * 2014��6��17��
 *
 */
package charactors;

/**
 * @author EASON
 *
 */
/**
 * ��String����תΪInteger����
 * 
 * @author gongyu.wang
 * 
 */
public class StringToInt {
	private static int radis = 10;

	/**
	 * ��STRING����ת��Ϊint���ͣ������¼������� 1���ж����� 2���жϷ����� 3����321�� תΪ 321 ���Կ����� 3*100 +
	 * 2*10 + 1 �������ÿ��ѭ��ʱ������ǰ��λ����*10���ۼ� 4���ж��Ƿ񳬳�int�����ֵ��Χ(-2^31~2^31-1)
	 * �ж��Ƿ񳬹����ֵ��Χ ����ֱ����ֵ��Integer��max�Ƚ�, ��Ϊ���ܻᷢ����� Ӧ��ʹ�� max/10���Ƚ�
	 */
	public int atoi(String str) {

		if (str == null || "".equals(str)) {
			return 0;
		}
		String s = str.trim();
		int result = 0;
		boolean negative = false;
		int i = 0, len = s.length();
		int limit = -Integer.MAX_VALUE;
		int multmin;
		int digit;
		try {

			if (len > 0) {
				char firstChar = s.charAt(0);
				if (firstChar < '0') { // Possible leading "+" or "-"
					if (firstChar == '-') {
						negative = true;
						limit = Integer.MIN_VALUE;
					} else if (firstChar != '+')
						throw new Exception("char Exception");

					if (len == 1) // Cannot have lone "+" or "-"
						throw new Exception("char Exception");
					i++;
				}
				multmin = limit / radis;

				while (i < len) {
					digit = Character.digit(s.charAt(i++), radis);
					if (digit < 0) {
						return negative ? result : -result;
					}
					if (result < multmin) {
						if (negative) {
							return Integer.MIN_VALUE;
						} else {
							return Integer.MAX_VALUE;
						}
					}
					result = result * radis;
					if (result < limit + digit) {
						if (negative) {
							return Integer.MIN_VALUE;
						} else {
							return Integer.MAX_VALUE;
						}

					}
					result -= digit;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return negative ? result : -result;
	}

}