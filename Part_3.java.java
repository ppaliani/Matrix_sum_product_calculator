import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Part_3 {

  public static void main(String[] args) {

    // Declaring File objects
    File file = null;
    File outputFile = null;

    // File input and output names
    file = new File("C:\\Users\\Paul\\Desktop\\Program1\\Part3\\file6.txt");
    outputFile = new File("C:\\Users\\Paul\\Desktop\\Program1\\Part3\\Output.txt");

    // Declaring input and output objects
    FileWriter fw = null;
    PrintWriter pw = null;

    FileInputStream fis = null;

    try {
      fw = new FileWriter(outputFile);
    } catch (IOException e1) {
      System.out.println("Could not find file");
      e1.printStackTrace();
    }

    pw = new PrintWriter(fw);


    try {
      fis = new FileInputStream(file);
    } catch (FileNotFoundException e) {
      System.out.println("Could not find file");
      e.printStackTrace();
    }

    Scanner input = new Scanner(fis);

    // m is the length of matrix 1 and matrix x is size m*m
    int m = input.nextInt();
    int[][] x = new int[m][m];

    // Enter values of matrix 1 into matrix x
    for (int i = 0; i < x.length; i++) {
      for (int j = 0; j < x.length; j++) {
        x[i][j] = input.nextInt();
      }
    }

    // n is the length of matrix 2 and matrix y is size n*n
    int n = input.nextInt();
    int[][] y = new int[n][n];

    // Enter values of matrix 2 into matrix y
    for (int i = 0; i < y.length; i++) {
      for (int j = 0; j < y.length; j++) {
        y[i][j] = input.nextInt();
      }
    }

    // ====================Calculate the sum of the matrices====================
    // Create a matrix u of size m*m
    int[][] u = new int[m][m];

    // Loop through each row and column of matrix x and add to the
    // respective value in matrix y
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < m; j++) {
        u[i][j] = x[i][j] + y[i][j];
      }
    }

    // Return m and matrix u (the sum of the matrices)
    pw.println("m: " + m);
    for (int i = 0; i < u.length; i++) {
      for (int j = 0; j < u[i].length; j++) {
        pw.print(u[i][j] + " ");
      }
      pw.println();
    }

    // formatting
    pw.println();
    pw.println();

    // ====================Calculate the product of the matrices====================
    // Create a matrix v of size m*m
    int[][] v = new int[m][m];

    // Loop through each row and column of matrix x and multiply by the
    // respective value in matrix y
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < m; j++) {
        int temp = 0;
        for (int k = 0; k < m; k++) {
          temp = temp + x[i][k] * y[k][j];
          v[i][j] = temp;
        }
      }
    }

    // Return m and matrix v (the product of the matrices)
    pw.println("m: " + m);
    for (int i = 0; i < v.length; i++) {
      for (int j = 0; j < v[i].length; j++) {
        pw.print(v[i][j] + " ");
      }
      pw.println();
    }


    pw.close();
    input.close();
  }
}
