package week3.day2;

public class Axisbank extends Bankinfo{
	public void deposit() {
		System.out.println("axis bank(deposit)-30k cash");
	}
	public static void main(String[] args) {
	
		Axisbank amount=new Axisbank();
		amount.deposits();
		amount.fixed();
		amount.saving();
		amount.deposit();
		
	}
	
	

}	

