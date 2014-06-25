/**
 * 2014年6月25日
 *
 */
package ml;

/**
 * @author EASON
 *
 */
public class SteepestDescend {
	public static double alpha = 0.5;// 迭代步长  
    public static double e = 0.00001;// 收敛精度  
  
    public double x0;  
    public double y0;  
  
    public double getY(double x) {  
        return (x * x - 3 * x + 2);  
    }  
  
    public double getDerivative(double x) {  
        return (2 * x - 3);  
    }  
  
    public void init() {  
        x0 = 0;  
        y0 = this.getY(x0);  
    }  
  
    public double getSteepestDescend() {  
        double min = 0;  
        double x = x0;  
        double y = y0;  
        double y1;  
        double temp = 0;  
        /* 
         * 做梯度运算 
         */  
        while (true) {  
            temp = this.getDerivative(x);  
            x = x - alpha * temp;  
            y1 = this.getY(x);  
            if (Math.abs(y1 - y) <= e) {  
                break;  
            }  
            y = y1;  
            min = y;  
        }  
        return min;  
    }  
    
    
    public static void main(String args[]) {  
        double min;  
        SteepestDescend sd = new SteepestDescend();  
        sd.init();  
        min = sd.getSteepestDescend();  
        System.out.println("最小值："+ min );  
    }  
}
