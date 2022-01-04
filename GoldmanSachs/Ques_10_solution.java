// Problem: Find max 10 numbers in a list having 10M entries.

import java.util.PriorityQueue;
import java.util.Scanner;

public class Ques_10_solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<10;i++)
        {
            pq.add(sc.nextInt());
        }
        for(int i=10;i<(int)1e7;i++)
        {
            int x=sc.nextInt();
            if(x>pq.peek())
            {
                pq.poll();
                pq.add(x);
            }
        }

        System.out.println("max 10 numbers from all the entries are:");
        while(!pq.isEmpty())
        {
            System.out.print(pq.poll()+" ");
        }


    }
}
