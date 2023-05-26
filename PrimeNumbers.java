package week1.day2;

public class PrimeNumbers{
		public static void main(String[] args) {
		int num=13;
		int c=0;
		for(int i=1;i<=num;i++) {                     
			if(num%i==0) {
				c++;
			}
		}
		if(c==2) {
			System.out.println(num+" "+"is a prime number");
		}
		else {
			System.out.println(num+" "+"is not prime number");
		}
		}}

