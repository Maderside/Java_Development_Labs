import java.util.Random;
public class MatrixGenerator {
    public static long[][] generateMatrix(int n, int m, long max){
        long[][] mtrx = new long[n][m];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mtrx[i][j] = rand.nextLong(max+1);
            }
        }
        return mtrx;
    }
}
