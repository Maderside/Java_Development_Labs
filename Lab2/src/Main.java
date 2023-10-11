import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        long[][] mtrxA = MatrixGenerator.generateMatrix(3,2, 10);
        long[][] mtrxB = MatrixGenerator.generateMatrix(2,3, 10);

        long[][] mtrxC= MatrixGenerator.generateMatrix(4,5, 10);
        long[][] mtrxD = MatrixGenerator.generateMatrix(5,3, 10);


        System.out.println("Matrix A: " + Arrays.deepToString(mtrxA) + " Matrix B " + Arrays.deepToString(mtrxB));
        System.out.println("Matrix C: " + Arrays.deepToString(mtrxC) + " Matrix D " + Arrays.deepToString(mtrxD));

        try {
            long[][] res1 = MatrixSolver.multiply(mtrxA,mtrxB); //Result of multiplication of matrices A and B
            long[][] res2 = MatrixSolver.multiply(mtrxC,mtrxD); //Result of multiplication of matrices C and D

            //Calculate the sum of the largest elements in the matrix rows with even numbers and the smallest elements in the matrix rows with odd numbers
            long sum1 = MatrixSolver.findSum(res1);
            long sum2 = MatrixSolver.findSum(res2);

            System.out.println("Result 1: " + Arrays.deepToString(res1) + " Result 2: " + Arrays.deepToString(res2));
            System.out.println("Sum of min and max elements, found in result arrays: " + sum1  + " and " + sum2);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Arrays are not matrices");
        }
        catch (NullPointerException e){
            System.out.println("Cant multiply null matrix");
        }

    }
}
