package devops_scientific_calc;
import java.util.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Application {

    public Application() {
    }

    private static final Logger logger = LogManager.getLogger(Application.class);

	public static void main(String[] args) 
	{

        Application calculator = new Application();
		Scanner scanner = new Scanner(System.in);
        
        System.out.println("Scientific Calculator");
        
        logger.info("Application started!");

		Integer choice = 0;
		boolean break_flag = false;
		double num,num1,num2;
		

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
                logger.info("Integer scanned!");
            } 
            catch (NumberFormatException e) 
            {
                logger.error("Invalid choice!");
                e.printStackTrace();
            }

			if(choice == 5)
			{
				break_flag = true;
			}

			else
            {
                switch(choice)
                {
                    case 1:
                    logger.info("Square Root operation selected.");
                    System.out.println("Square Root");
                    System.out.print("Enter a number : ");
                    num = Double.parseDouble(scanner.nextLine());
                    System.out.println("The square root of " + num + " is " + calculator.sqroot(num) + "\n");
                    break;
                    
                    case 2:
                    logger.info("Factorial operation selected.");
                    System.out.println("Factorial");
                    System.out.print("Enter a number : ");
                    num = Double.parseDouble(scanner.nextLine());
                    System.out.println("The factorial of " + num + " is " + calculator.fact(num) + "\n");
                    break;
                    
                    case 3:
                    logger.info("Natural Logarithm operation selected.");
                    System.out.println("Natural Logarithm");
                    System.out.print("Enter a number : ");
                    num = Double.parseDouble(scanner.nextLine());
                    System.out.println("The natural logarithm of " + num + " is " + calculator.natlog(num) + "\n");
                    break;
                    
                    case 4:
                    logger.info("Power operation selected.");
                    System.out.println("Power Function");
                    System.out.println("Enter two numbers");
                    System.out.print("Enter base: ");
                    num1 = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter exponent: ");
                    num2 = Double.parseDouble(scanner.nextLine());
                    System.out.println("The value of " + num1 + " raised to " + num2 + " is " + calculator.powerf(num1, num2) + "\n");
                    break;
                    default: System.out.println("Exiting program due to invalid input"); break_flag = false;
                            logger.info("Invalid input - exit program ");
                }
            }


		}
		while(!break_flag);
		scanner.close();
	}

	public double sqroot(double x)
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

	public double fact(double x)
    {
        double value = 1;
        double n = x;
        
        if (x < 0)
        {
            logger.error("Illegal argument.");
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

	public double natlog(double x)
    {
        if (x <= 0) 
        {
            logger.error("Illegal argument.");
            throw new IllegalArgumentException("Number cannot be negative/zero.");
        }

        else
        {
            return Math.log(x);
        }
    }

	public double powerf(double b, double e)
    {
        if (b == 0 && e <= 0) 
        {
            logger.error("Illegal arguments.");
            throw new IllegalArgumentException("When base is 0 exponent cannot be negative/zero.");
        }
        
        else
        {
            return Math.pow(b, e);
        }
    }



}
