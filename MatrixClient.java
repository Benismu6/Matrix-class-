/**
 * Benis Munezero, Alexander Roth, and Legendre Cooper
 * COSC 237 Sec 001
 * Assignment 2, Task 2, Client for Matrix class
 */
import java.util.Scanner;

public class MatrixClient {
    public static final int MAX = 20;
    public static final int MIN = 1;
    public static final int LOW = 1;
    public static final int UP = 10;
    public static final int OPTMAX = 8;
    public static final int OPTMIN = 0;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int command = 1;
        int choice;
        int size;
        int value;
        int tr;
        Scanner sc = new Scanner(System.in);
        size = getInt(sc, "Enter the size of the square matrices: ", MAX, MIN);
        Matrix first = new Matrix(size);
        Matrix second = new Matrix(size);
        Matrix result = new Matrix(size);
      
        do {
          choice = menu(OPTMAX, OPTMIN);
          if (choice == 0) {
            break;
          }
          
            switch (choice) {
              case 1:
                  System.out.println("First matrix is "); 
                  first.init(LOW, UP);
                  first.print();
                  System.out.println("Second matrix is ");
                  second.init(LOW, UP);
                  second.print();
                  result = first.add(second);
                  System.out.println("Result: ");
                  result.print();
                break;
                
              case 2:
                  System.out.println("First matrix is ");
                  first.init(LOW, UP);
                  first.print();
                  System.out.println("Second matrix is ");
                  second.init(LOW, UP);
                  second.print();
                  result = first.subtract(second);
                  System.out.println("Result: ");
                  result.print();
                break;
                
              case 3:
                  System.out.println("First matrix is ");
                  first.init(LOW, UP);
                  first.print();
                  System.out.println("Second matrix is ");
                  second.init(LOW, UP);
                  second.print();
                  result = first.multiply(second);
                  System.out.println("Result: ");
                  result.print();
                break;
               
              case 4:                   
                  System.out.println("Enter the multiplication constant: ");
                  value = getInt(sc, "Enter the multiplication constant");
                  System.out.println("Original matrix is ");
                  first.init(LOW, UP);
                  first.print();
                  result = first.multiplyConst(value);
                  System.out.println("Result: ");
                  result.print();
                break;
                
              case 5:
                  System.out.println("Original matrix is ");
                  first.init(LOW, UP);
                  first.print();
                  System.out.println("Result: ");
                  result = first.transpose();
                  result.print();                
                break;
                
              case 6:
                  System.out.println("Original matrix is ");
                  first.init(LOW, UP);
                  first.print();
                  tr = first.trace();
                  System.out.println("The trace for this matrix is: " + tr);
                break;
                
              case 7:
                  System.out.println("Original matrix is ");
                  first.init(LOW, UP);
                  first.print();
                  second = second.copy(first);
                  System.out.println("Copied! The copy of the matrix is: ");
                  second.print();
                  System.out.println("Testing for Equality....");
                  if (!first.equals(second)) {
                     System.out.println("The matrices are NOT equal!!");
                  } else {
                      System.out.println("The matrices are equal!!");
                    }
                break;
                
              case 8:
                  System.out.println("First matrix is ");
                  first.init(LOW, UP);
                  first.print();
                  System.out.println("Second matrix is ");
                  second.init(LOW, UP);
                  second.print();
                  if (!first.equals(second)) {
                    System.out.println("The matrices are NOT equal!!");
                  } else {
                     System.out.println("The matrices are equal!!");
                    }
                break;

              default:
                  System.out.println("Invalid option!");
                break;
                            
            }
            System.out.println("          Command number " + command++ + " completed\n");
        } while (true);
      System.out.println("\n      Testing completed! ");
    }

    public static int getInt(Scanner sc, String prompt) {
          System.out.println(prompt);
          while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Not an integer! try again: ");
          }
          return sc.nextInt();

    }

    public static int menu(int max, int min) {
            System.out.println("Your options are:\n-----------------\n 1) Add 2 matrices\n 2) Subtract 2 matrices\n 3) Multiply 2 matrices\n 4) Multiply matrix by a constant\n 5) Transpose matrix\n 6) Matrix trace\n 7) Make a copy\n 8) Test for equality\n 0) EXIT");
            Scanner sc = new Scanner(System.in);
            int choice;
            do {
              choice = getInt(sc, "Please enter your option:");
              if (choice < min || choice > max) {
              System.out.println("Invalid option! ");
              }
            } while (choice < min || choice > max);
        return choice;
          
    }

    public static int getInt(Scanner sc, String prompt, int max, int min) {
          int size;
          boolean isValid = false;
          do {
              System.out.println(prompt);
              while (!sc.hasNextInt()) {
                 sc.next();
                 System.out.print("Not an integer! try again: ");
              }
              size = sc.nextInt();
              if (size < min || size > max) {
                 System.out.println("INPUT ERROR!!! Invalid size. Positive and <= " + max);
              }
              else {
                isValid = true;
              }
          } while(!isValid);
        return size;

    }
}
