package ibatest;

import java.util.Arrays;

public class Land {

    public static void main(String[] args) {
        System.out.println(numberOfIslands(new int[][]{
                {5, 4, 4},
                {4, 3, 4},
                {3, 2, 4},
                {2, 2, 2},
                {3, 3, 4},
                {1, 4, 4},
                {4, 1, 1}}
        ));
    }

    public static int numberOfIslands(int[][] A) {
        int sum = 0;
        int N = A.length;
        int M = A[0].length;
        if (M == 0) return 0;
        int[][] B = Arrays.stream(A).map(int[]::clone).toArray(int[][]::new);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (B[i][j] >= 0) {
                    checkNeighbourIsland(A, B, i, j, N, M);
                    sum += 1;
                }
            }
        }

        return sum;
    }

    private static void checkNeighbourIsland(int[][] A, int[][] B, int i, int j, int N, int M) {
        if (B[i][j] == -1) return;
        B[i][j] = -1;
        if (i + 1 < N) {
            if (A[i + 1][j] == A[i][j]) {
                checkNeighbourIsland(A, B, i + 1, j, N, M);
            }
        }
        if (i - 1 >= 0) {
            if (A[i - 1][j] == A[i][j]) {
                checkNeighbourIsland(A, B, i - 1, j, N, M);
            }
        }
        if (j + 1 < M) {
            if (A[i][j + 1] == A[i][j]) {
                checkNeighbourIsland(A, B, i, j + 1, N, M);
            }
        }
        if (j - 1 >= 0) {
            if (A[i][j - 1] == A[i][j]) {
                checkNeighbourIsland(A, B, i, j - 1, N, M);
            }
        }
    }
}
