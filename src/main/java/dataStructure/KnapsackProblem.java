package dataStructure;

import java.util.Scanner;

public class KnapsackProblem {
    public static void main(String[] args) {

        int n;
        float[] p = new float[15];
        float[] w = new float[15];
        float m;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Knapsack Problem Implementation");
        System.out.println("(using Greedy algorithm)");

        System.out.print("Enter number of object: ");
        n = scanner.nextInt();
        System.out.println("Enter weights: ");
        for (int i = 0; i < n; i++) {
            System.out.print("For object [" + (i+1) + "]: ");
            w[i] = scanner.nextFloat();
        }

        System.out.println("Enter profits: ");
        for (int i = 0; i < n; i++) {
            System.out.print("For object [" + (i+1) + "]: ");
            p[i] = scanner.nextFloat();
        }

        System.out.print("Enter knapsack size: ");
        m = scanner.nextInt();

        knapsack(n,m,w,p);

    }

    static void  knapsack(int n, float m, float[] w, float[] p){
        float[] x = new float[15];
        float[] c = new float[15];
        float U, profit = 0.0f, weight = 0.0f, temp;

        int i,j;

        U = m;

        for (i = 0; i < n; i++)
            c[i] = p[i] / w[i];

        for (i = 0; i < n; i++) {
            for (j = 0; j < n-1; j++) {
                if (c[j]<c[j+1]){
                    temp = c[j];
                    c[j] = c[j+1];
                    c[j+1] = temp;

                    temp = w[j];
                    w[j] = w[j+1];
                    w[j+1] = temp;

                    temp = p[j];
                    p[j] = p[j+1];
                    p[j+1] = temp;
                }
            }
        }

        System.out.println("The items are arranged as ...");
        System.out.println();
        System.out.println("___________________________________");
        System.out.println(String.format("|%-9s|\t|%-9s|\t|%-9s|","Items","Weights","Profits"));
        System.out.println("===================================");
        for (i = 0; i < n; i++)
            System.out.println(String.format("| x[ %02d ] |\t|%-9f|\t|%-9f|",i,w[i],p[i]));
        System.out.println("===================================");
        for (i = 0; i < n; i++)
            x[i] = 0.0f;

        for (i = 0; i < n; i++) {
            if (w[i] > U)
                break;
            x[i] = 1.0f;
            U = U - w[i];
        }

        if (i < n)
            x[i]= U / w[i];

        System.out.println();
        System.out.println("The solition vector is:");

        for ( i = 0; i < n ; i++)
            System.out.println("    "+i + " --> " + x[i]);

        for ( i = 0; i < n ; i++){
            w[i] = w[i] * x[i];
            p[i] = p[i] * x[i];
        }

        // calculate of total profit & weight

        for ( i = 0; i < n ; i++){
            profit = profit + p[i];
            weight = weight + w[i];
        }

        System.out.println("Maximum profit is: " + profit);
        System.out.println("Maximum weight is: " + weight);
    }
}
