package growthOfFunctions;

public class Fibonacci {
	public static void main(String...args){
		testFib(20);
	}
	public static int fib(int i){
		if (i == 0) return 1;
		if (i == 1) return 1;
		else return (fib(i-1) + fib (i-2));
	}
	public static void testFib(int x){
		for(int i = 0; i < x; i ++){
			System.out.println(fib(i));
			float phi = (float) fib(i+1) / ((float) fib(i));
			System.out.println("phi ~= " + phi);
		}
	}
}
