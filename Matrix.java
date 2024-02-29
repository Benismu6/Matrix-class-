/**
 * Benis Munezero, Alexander Roth, and Legendre Cooper
 * COSC 237 Sec 001
 * Assignment 2, Task 2, Matrix class
 */
import java.util.Scanner;
import java.util.Random;

public class Matrix {
    public final int MAX = 20;
    private int size;
    private int[][] matrix = new int[MAX][MAX];

    public Matrix() {
        size = 0;
    }

    public Matrix(int s) {
        size = s;
    }

    public int getSize() {
        return size;
    }

    public int getElement(int r, int c) {
        return matrix[r][c];
    }

    public void setElement(int r, int c, int value) {
        matrix[r][c] = value;
    }

    public void init(int low, int up) {
        Random rand = new Random();
        for (int i = 0; i < matrix.length; i++) {
          for (int j = 0; j < matrix[i].length; j++) {
            matrix[i][j] = rand.nextInt(up - low) + low;
          }
        }
    }

    public void print() {
        for (int i = 0; i < size; i++) {
          for (int j = 0; j < size; j++) {
            System.out.printf("%5d", matrix[i][j]);
          }
          System.out.println();
        }
    }

    public Matrix add(Matrix m) {
        Matrix result = new Matrix(size);
        for (int i = 0; i < size; i++) {
          for (int j = 0; j < size; j++) {
            result.matrix[i][j] = matrix[i][j] + m.matrix[i][j];
          }
        }
        return result;

    }

    public Matrix subtract(Matrix m) {
        Matrix result = new Matrix(size);
        for (int i = 0; i < size; i++) {
          for (int j = 0; j < size; j++)
            result.matrix[i][j] = matrix[i][j] - m.matrix[i][j];
        }
        return result;

    }

    public Matrix multiply(Matrix m) {
        Matrix result = new Matrix(size);
        for (int i = 0; i < size; i++) {
          for (int j = 0; j < size; j++) {
            for (int k = 0; k < size; k++) {
              result.matrix[i][j] += matrix[i][k] * m.matrix[k][j];
            }
          }  
        }
        return result;

    }

    public Matrix multiplyConst(int constant) {
        Matrix result = new Matrix(size);
        for (int i = 0; i < size; i++) {
          for (int j = 0; j < size; j++)
            result.matrix[i][j] = matrix[i][j] * constant;
        }
        return result;

    }

    public Matrix transpose() {
        Matrix result = new Matrix(size);
        for (int i = 0; i < size; i++) {
          for (int j = 0; j < size; j++) {
            result.matrix[j][i] = matrix[i][j];
          }
        }
        return result;

    }

    public int trace() {
        int trace = 0;
        for (int i = 0; i < size; i++) {
          for (int j = 0; j < size; j++) {
            if (i == j) {
              trace = trace + matrix[i][j];
            }
          }
        }
        return trace;
    }

    public Matrix copy(Matrix m) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
              matrix[i][j] = m.getElement(i, j);
            }
        }
        return m;
    }

    public Matrix getCopy() {
        Matrix m = new Matrix();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
              m.setElement(i, j, matrix[i][j]);
            }
        }
        return m;

    }

    public boolean equals(Matrix m){
        for (int i = 0; i < size; i++) {
          for (int j = 0; j < size; j++) {
             if(m.getElement(i, j) != matrix[i][j]){
                return false;
              }
          }
        }
        return true;
    }

}
