package calculator;
import java.lang.Math;
public class SquareRoot {
	public static double squareRoot(int a){
		if(a<0){
			throw new ArithmeticException("Square root of negative number is not defined.");
		}
		return Math.sqrt(a);
	}
}
