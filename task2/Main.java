import mypac.SortedIntegerList;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        SortedIntegerList a = new SortedIntegerList(true);
        SortedIntegerList b = new SortedIntegerList(true);
        Random random = new Random();

        for (int i = 0; i < 15; i++) {
            a.add(random.nextInt(10));
            b.add(random.nextInt(10));
        }
        System.out.println(a);
        System.out.println(b);
        a.remove(6);
        b.remove(3);
        System.out.println(a);
        System.out.println(b);
        a.add(12);
        b.add(15);
        System.out.println(a);
        System.out.println(b);
        a.remove(100);
        b.remove(100);
        System.out.println(a);
        System.out.println(b);
        
    }
}

