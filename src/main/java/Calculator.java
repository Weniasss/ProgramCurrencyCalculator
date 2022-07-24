import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Calculator program implements an application for
 * currency calculations and prints output on the console
 *
 * @author  Volodymyr Zaikovskyi
 * @version JDK 1.8
 * @since   2022-07-24
 */
public class Calculator extends CalculatorMethods {
    public static void main(String[] args) {
        double count;                                          /* selected amount   */
        String currency;                                       /* selected currency */
        int    choice;                                         /* selected choice   */
        int    flag;                                           /* flag for check    */

        ArrayList<Currency> currencyArrayList = parseXmlFile();
        Scanner input = new Scanner(System.in);

        while (true) {
            displayMenu();

            choice = input.nextInt();

            switch (choice) {
                case 1:                                          /* works only for count */
                    flag = 0;

                    System.out.println("Сhoose the amount : ");
                    count = input.nextDouble();

                    if (count <= 0) {
                        String warning = "count is less than or equal to 0: ".concat(String.valueOf(count));
                        throw new IllegalArgumentException(warning);
                    }
                    input.nextLine();

                    System.out.println("Choose a currency : ");
                    currency = input.nextLine();

                    for (Currency item : currencyArrayList) {
                        if (currency.equalsIgnoreCase(item.getCurrencyName())) {
                            System.out.println("Result : " + calculateCurrency(count, item) + " EUR");
                            flag = 1;
                        }
                    }
                    if(flag == 0){
                        System.out.println("Wrong currency name , try again ");
                    }
                    break;

                case 2:                                           /* works only for show list of currency */
                    for (Currency item : currencyArrayList) {
                        System.out.println(item.getCurrencyName() + " " + item.getRate());
                    }
                    break;

                case 3:                                           /* works only for exit */
                    return;

                default:                                          /* works only for wrong choice */
                    System.out.println("Wrong choice,try again");
                    break;
            }
        }
    }
}
