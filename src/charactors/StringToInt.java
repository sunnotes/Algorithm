/**
 * 2014年6月17日
 *
 */
package charactors;

/**
 * @author EASON
 *
 */
/**
 * 将String类型转为Integer类型
 * 
 * @author gongyu.wang
 * 
 */
public class StringToInt {
	private static int radis = 10;

	/**
	 * 将STRING类型转化为int类型，有如下几个步骤 1、判断正负 2、判断非整数 3、“321” 转为 321 可以看做是 3*100 +
	 * 2*10 + 1 这等于是每次循环时，都对前几位数字*10再累加 4、判断是否超出int的最大值范围(-2^31~2^31-1)
	 * 判断是否超过最大值范围 不能直接拿值和Integer的max比较, 因为可能会发生溢出 应该使用 max/10来比较
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