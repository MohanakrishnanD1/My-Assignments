package week1.day2;

public class Palindrome {
		public static void main(String[] args) {
			int num=34343;
			int n=num;
			int rev=0;
			int bal=0;
				
				for(;num>0;) 
					{
					bal=num%10;                                
					rev=rev*10+bal;                           
					num=num/10;
					
					}
				
				 if (n==rev) {
				System.out.println(rev+" "+"is a palindrome number");
				}
				 else {
					 System.out.println(n+" "+" is not palindrome number");
		}

				}}
