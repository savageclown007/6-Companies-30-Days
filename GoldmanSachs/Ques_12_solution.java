import java.util.Scanner;

// Problem: Find total number of Squares in a N*N chessboard

public class Ques_12_solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int NumOfSquares=0;
        while(n>0)
        {
            NumOfSquares+=(n*n);
            n--;
        }

        System.out.println("Total number of squares in a N*N chessboard: "+NumOfSquares);
    }
}
