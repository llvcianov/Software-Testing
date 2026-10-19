package calculator;

public class Main2 {

	public static void main(String[] args) {
		Calculator c=new Calculator();
		int somma=c.add(3, -39);
		int atteso=-36;
		if (somma==atteso)
			System.out.println("OK");
		else
			System.out.println("Failure");
	}

}
