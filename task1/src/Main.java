import mypac.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Matrix a = new Matrix(4, 4);
        SquareMatrix b = new SquareMatrix(4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                a.setElement(i, j, random.nextInt(10));
                b.setElement(i, j, random.nextInt(10));
            }
        }
        a.toString();
        System.out.println(b);
        System.out.println(a.product(b));
        System.out.println(a.sum(b));
        System.out.println(a.equals(b));
    }
}
