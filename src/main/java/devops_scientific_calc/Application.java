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
            System.out.print("Choose an operation: ");
            System.out.println("");

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
				break_flag = true;
			}

			else
            {
                switch(choice)
                {
                    case 1:
                    System.out.println("Square Root");
                    System.out.print("Enter a number : ");
                    num = Double.parseDouble(scanner.nextLine());
                    System.out.println("The square root of " + num + " is " + calculator.sqroot(num) + "\n");
                    break;
                    
                    case 2:
                    System.out.println("Factorial");
                    System.out.print("Enter a number : ");
                    num = Double.parseDouble(scanner.nextLine());
                    System.out.println("The factorial of " + num + " is " + calculator.fact(num) + "\n");
                    break;
                    
                    case 3:
                    System.out.println("Natural Logarithm");
                    System.out.print("Enter a number : ");
                    num = Double.parseDouble(scanner.nextLine());
                    System.out.println("The natural logarithm of " + num + " is " + calculator.natlog(num) + "\n");
                    break;
                    
                    case 4:
                    System.out.println("Power Function");
                    System.out.println("Enter two numbers");
                    System.out.print("Enter base: ");
                    num1 = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter exponent: ");
                    num2 = Double.parseDouble(scanner.nextLine());
                    System.out.println("The value of " + num1 + " raised to " + num2 + " is " + calculator.powerf(num1, num2) + "\n");
                    break;
                    default: System.out.println("Exiting program due to invalid input"); break_flag = false;
                }
            }


		}
		while(!break_flag);
		scanner.close();
	}

	public double sqroot(double x)
    {
        logger.info("SQUARE ROOT "  + "Input " + x);
        if (x < 0) 
        {
            logger.error("Negative input to square root.");
            throw new IllegalArgumentException("Number cannot be negative.");
        }

        else
        {
            double answer = Math.sqrt(x);
            logger.info("SQUARE ROOT "  + "Answer " + answer);
            return answer;
        }

    }

	public double fact(double x)
    {
        double value = 1;
        double n = x;

        logger.info("FACTORIAL "  + "Input " + x);
        
        if (x < 0)
        {
            logger.error("Negative input to factorial.");
            throw new IllegalArgumentException("Number cannot be negative.");
        }

        else
        {
            while(n > 0)
            {
                value = value * n;
                n = n - 1;
            }

            logger.info("FACTORIAL "  + "Answer " + value);
            
            return value;
        }
    }

	public double natlog(double x)
    {
        logger.info("NATURAL LOG "  + "Input " + x);

        if (x <= 0) 
        {
            logger.error("Negative input natural logarithm.");
            throw new IllegalArgumentException("Number cannot be negative/zero.");
        }

        else
        {
            double answer = Math.log(x);
            logger.info("NATURAL LOGARITHM "  + "Answer " + answer);
            return answer;
        }
    }

	public double powerf(double b, double e)
    {
        logger.info("POWER "  + "BASE " + b + "EXPONENT " + e);

        if (b == 0 && e <= 0) 
        {
            logger.error("Illegal base and exponent.");
            throw new IllegalArgumentException("When base is 0 exponent cannot be negative/zero.");
        }
        
        else
        {
            double answer = Math.pow(b, e); 
            logger.info("POWER "  + "Answer " + answer);
            return answer;
        }
    }



}
