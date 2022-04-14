package devops_scientific_calc;
import java.util.*;

public class Application {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
        System.out.println("Scientific Calculator");
		Integer choice = 0;
		boolean break_flag = false;
		// double num,num1,num2;
		do
		{
			System.out.println("Function Menu");
            System.out.println("");
            System.out.println("1. Square Root");
            System.out.println("2. Factorial");
            System.out.println("3. Natural Logarithm");
            System.out.println("4. Power Function");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

			try 
            {
                choice = Integer.parseInt(scanner.nextLine());
            } 
            catch (NumberFormatException e) 
            {
                e.printStackTrace();
            }

			if(choice == 5)
			{
				break_flag = false;
			}

			else
            {
                
            }


		}
		while(break_flag);



		scanner.close();
	}

	public static double sqroot(double x)
    {
        if (x < 0) 
        {
            throw new IllegalArgumentException("Number cannot be negative.");
        }

        else
        {
            return Math.sqrt(x);
        }
    }

	public static double fact(double x)
    {
        double value = 1;
        double n = x;
        
        if (x < 0) 
        {
            throw new IllegalArgumentException("Number cannot be negative.");
        }

        else
        {
            while(n > 0)
            {
                value = value * n;
                n = n - 1;
            }
            
            return value;
        }
    }


}
