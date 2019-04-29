import java.util.ArrayList;
import java.util.List;

public class PalPrime {

	public static void main(String[] args) {
		Prime prime = new Prime();
		Palindromic pal = new Palindromic();
		List<Integer> palPrimeList = new ArrayList<Integer>();

		for (int i = 1; i <= 100_000; i++) {
			if (prime.isPrime(i) && pal.isPal(i))
				palPrimeList.add(i);
		}
		for (int i = 0; i < palPrimeList.size(); i++) {
			if (i%4 == 0)
				System.out.println();
			System.out.print(palPrimeList.get(i) + "\t");
		}
		
	}
}

class Palindromic {
	public static boolean isPal(int num) {
		//reverse the number
		int reverse=0;
		int origNum = num; //need to store original number to compare with reversed num
		
		while (num != 0) {
			reverse = reverse * 10;
			reverse = reverse + num%10;
			num = num/10;
		}
		//check to see if reversed num is the same as num we passed
		if (reverse != origNum)
			return false;

		return true;
	}
}

class Prime {
	public static boolean isPrime(int num) {
		// catch the number one as it is not a prime
		if (num == 1)
			return false;
		// if dividing num by i has no remainder, then number is not a prime as there is
		// more than one divisible number.
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public void printPrime(int p) {
		System.out.println(p + " is a Prime number");
	}
}
