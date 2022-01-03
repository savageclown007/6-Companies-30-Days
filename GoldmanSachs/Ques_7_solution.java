// Question Link: https://www.geeksforgeeks.org/distributing-m-items-circle-size-n-starting-k-th-position/

import java.util.Scanner;

public class Ques_7_solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();

        System.out.println(lastPosition(n, m, k));
        sc.close();
    }

    static int lastPosition(int n, int m, int k)
    {

        if (m <= n - k + 1)
            return m + k - 1;
        m = m - (n - k + 1);
        return (m % n == 0) ? n : (m % n);
    }

}
