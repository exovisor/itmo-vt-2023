import java.util.Arrays;
import java.util.Random;

public class Lab1 {
    private final static int LONG_ARR_FROM = 6;
    private final static int LONG_ARR_TO = 20;
    private final static int FLOAT_ARR_SIZE = 16;
    private final static float FLOAT_ARR_ORIGIN = -7f;
    private final static float FLOAT_ARR_BOUND = 9f;
    private final static int DIM_ARR_SIZE_X = 15;
    private final static int DIM_ARR_SIZE_Y = 16;
    private final static long[] DIM_ARR_CONDITION = { 6, 7, 11, 12, 17, 18, 19 };
    private final static double PRECISION = 0.01d;


    public static void main(String[] args) {
        var longArr = createLongArr(LONG_ARR_FROM, LONG_ARR_TO);
        var floatArr = createFloatArr(FLOAT_ARR_SIZE, FLOAT_ARR_ORIGIN, FLOAT_ARR_BOUND);
        var dimArray = create2DimArray(DIM_ARR_SIZE_X, DIM_ARR_SIZE_Y, longArr, floatArr);

        System.out.println("Полученный массив:");
        System.out.print('|');
        for (int j = 0; j < DIM_ARR_SIZE_Y; j++) {
            System.out.print("------------|");
        }
        System.out.print('\n');
        for (int i = 0; i < DIM_ARR_SIZE_X; i++) {
            System.out.print('|');
            for (int j = 0; j < DIM_ARR_SIZE_Y; j++) {
                if (Math.abs(dimArray[i][j] - 1.0d) <= PRECISION) {
                    System.out.printf(" %10s |", "ОДИН");
                } else {
                    System.out.printf(" %10.3f |", dimArray[i][j]);
                }
            }
            System.out.print('\n');
            System.out.print('|');
            for (int j = 0; j < DIM_ARR_SIZE_Y; j++) {
                System.out.print("------------|");
            }
            System.out.print('\n');
        }
    }

    private static long[] createLongArr(int from, int to) {
        var size = (to - from) + 1;
        var arr = new long[size];

        for (int i = 0; i < size; i++) {
            arr[i] = from + i;
        }

        return arr;
    }

    private static float[] createFloatArr(int size, float origin, float bound) {
        var arr = new float[size];

        var rnd = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rnd.nextFloat(origin, bound);
        }

        return arr;
    }

    private static double[][] create2DimArray(int sizeX, int sizeY, long[] c, float[] x) {
        var arr = new double[sizeX][sizeY];
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (c[i] == 8) {
                    arr[i][j] = Math.pow((Math.log(Math.pow((3 * (Math.PI / 2 + Math.abs(x[j]))), x[j])) + 1), 3);
                } else if (Arrays.asList(DIM_ARR_CONDITION).contains(c[i])) {
                    arr[i][j] = Math.log(Math.pow(Math.tan(Math.sin(Math.log(Math.abs(x[j])))), 2));
                } else {
                    arr[i][j] = Math.pow(
                            Math.pow(Math.exp(Math.pow(.25d / x[j], 2)), Math.log(Math.acos((x[j] + 1) / 16)) / 12),
                            Math.tan(1 - Math.sin(x[j])) + 1
                    );
                }
            }
        }
        return arr;
    }
}
