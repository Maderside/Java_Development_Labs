
/**
 * Used to perform specific matrix operations
 */
public class MatrixSolver {

    /**
     * Used to multiply two matrices with long element type.
     * @param mtrxA First matrix.
     * @param mtrxB Second matrix.
     * @return The result of multiplication - another matrix.
     */
    static public long[][] multiply(long[][] mtrxA, long[][] mtrxB){
        int rowA = mtrxA.length;
        int colA = mtrxA[0].length;

        int rowB = mtrxB.length;
        int colB = mtrxB[0].length;

        if (rowA!=colB || colA!=rowB){  //If number of rows and columns in matrix A and B is not suitable for multiplication
            throw new IllegalArgumentException("Number of rows in matrix A and number of columns in matrix B should be equal");
        }

        long[][] res = new long[rowA][colB];    //result matrix

        //loop through matrix A and B
        for (int i = 0; i < rowA; i++) {
            for (int q = 0; q < colB; q++) {
                long sum = 0;   //sum of multiplication of matrix A row by matrix B column

                for (int j = 0; j < colA; j++) {
                    sum += mtrxA[i][j]*mtrxB[j][q];
                }

                res[i][q] = sum;
            }
        }
        return res;
    }

    /**
     * Returns max value item in long[] array
     * @param arr Array to find max value in.
     * @return Maximum element.
     */
    static public long findMax(long[] arr){
        long max = arr[0];
        for (long item: arr) {
            if (item > max) {
                max = item;
            }
        }
        return max;
    }

    /**
     * Returns min value item in long[] array
     * @param arr Array to find min value in.
     * @return Minimum element.
     */
    static public long findMin(long[] arr){
        long min = arr[0];
        for (long item: arr) {
            if (item < min) {
                min = item;
            }
        }
        return min;
    }

    /**
     * Calculates the sum of the largest elements in the matrix rows with even numbers and the smallest elements in the matrix rows with odd numbers
     * @param mtrxA Matrix, on which calculation is performed
     * @return The result of calculation.
     */
    static public long findSum(long[][] mtrxA){
        int m = mtrxA.length;
        long sum = 0;
        for (int i = 0; i <m ; i++) {

            if (i%2==0){
                sum += MatrixSolver.findMax(mtrxA[i]);
            }
            else {
                sum += MatrixSolver.findMin(mtrxA[i]);
            }
        }
        return sum;
    }
}
