package calculator;


public class Division {
	public static double divide(int a,int b){
		if(b==0){
			throw new ArithmeticException("Division by zero is not allowed.");
		}
		return (double)a/b; 
	}
    
}
