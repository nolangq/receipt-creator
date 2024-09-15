package assignment1;

import java.util.Random;
import java.util.Scanner;
import java.lang.Math;
import java.lang.String;

public class Quinn_Nolan {
    // generate random receipt number
    public static int randomReceiptNumber() {
        Random rand = new Random();
        // return random receipt number
        return rand.nextInt(1000) + 1000;
    }
    // generate random date
    public static void dateGeneration() {
        Random rand = new Random();
        // get random year
        int year = rand.nextInt(200) + 1900;
        // get random day
        int day = rand.nextInt(28) + 1;
        // get random month
        int monthNum = rand.nextInt(12) + 1;
        String month = "";
        // check random month number and print correlating month name
        switch(monthNum) {
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
            default:
                month = "Invalid";
                break;
        }
        System.out.println(month + " " + day + " " + year);
    }
    public static double taxCalculation(String item, double price) {
        double taxedPrice = 0.0;
        double localPrice = price;
        // check if the item is food then return original price
        if (item.equals("Food") || item.equals("food")) {
            return localPrice;
        } else {
            // otherwise calculate tax
            taxedPrice = price + (price * 0.3);
            return taxedPrice;
        }
    }
    public static void main(String[] args) {
        // start displaying receipt
        System.out.println("******************************");
        System.out.println("****** S store ***************");
        System.out.println("******************************");

        // generate random receipt number
        int myRandomNum = randomReceiptNumber();
        System.out.println("receipt number      " + myRandomNum);

        // generate random date
        dateGeneration();
        
        // declare scanners and variables
        Scanner itemScanner = new Scanner(System.in);
        Scanner priceScanner = new Scanner(System.in);
        String item = "";
        double price = 0.0;
        double total = 0.0;
        int itemCount = 0;
        do {
            //get item name
            System.out.print("Write item name ");
            item = itemScanner.nextLine();
            if (!item.equals("DONE")) {
                // get item price
                System.out.print("Write price ");
                price = priceScanner.nextDouble();
                // calculate price including tax
                price = taxCalculation(item, price);
                // update variables
                total += price;
                itemCount++;
                // print item summary
                System.out.print("item number " + itemCount + " " + (item.substring(0, 1).toUpperCase() + item.substring(1)) + " ");
                price = Math.round(price);
                System.out.println(String.format("%,.2f", price));
            }
        } while(!item.equals("DONE"));
        // print receipt summary
        System.out.print(itemCount + " items" + "      " + "total ");
        total = Math.round(total);
        System.out.println(String.format("%,.2f", total));
        System.out.println("******************************");
        System.out.println("******************************");
        System.out.println("******************************");
    }
}
