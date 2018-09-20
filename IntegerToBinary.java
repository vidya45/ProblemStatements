import java.util.Scanner;

public class IntegerToBinary {

	    public static void main(String[] args) 
	    {
	    	int nextNumber;
	        String string = "";
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Please enter the a number : ");
	        nextNumber = scanner.nextInt();
	        while(nextNumber > 0)
	        {
	           int y = nextNumber % 2;
	           string = y + string;
	           nextNumber = nextNumber / 2;
	        }
	        System.out.println("The binary conversion is : " + string);
	        scanner.close();
	    }

}
