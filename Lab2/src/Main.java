import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        long[][] mtrxA = {{1,2,2},
                          {3,1,1}};

        long[][] mtrxB = {{4,2},
                         {3,1},
                         {1,5}};

        long[][] mtrxC =    {{4,2},
                             {3,1},
                             {1,5}};

        long[][] mtrxD =    {{1,2,2},
                             {3,1,1}};

        try {
            long[][] res1 = MatrixSolver.multiply(mtrxA,mtrxB); //Result of multiplication of matrices A and B
            long[][] res2 = MatrixSolver.multiply(mtrxC,mtrxD); //Result of multiplication of matrices C and D

            long sum1 = MatrixSolver.findSum(res1);
            long sum2 = MatrixSolver.findSum(res2);

            System.out.println("Result 1: " + Arrays.deepToString(res1) + " Result 1: " + Arrays.deepToString(res2));
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
