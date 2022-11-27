package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Baekjoon2667 {
    private static int houses[][];
    private static boolean isVisits[][];

    private static int N;
    private static int[] directionX = {0, -1, 0, 1};
    private static int[] directionY = {-1, 0, 1, 0};

    private static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        List<Integer> counts = new ArrayList<>();

        houses = new int[N][N];
        isVisits = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine()
                               .split("");
            for (int j = 0; j < N; j++) {
                houses[i][j] = Integer.parseInt(split[j]);
            }
        }

        int result = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisits[i][j] && houses[i][j] == 1) {
                    count = 1;
                    dfs(i, j);
                    result++;
                    counts.add(count);
                }
            }
        }
        System.out.println(result);
        Collections.sort(counts);
        for (Integer integer : counts) {
            sb.append(integer)
              .append("\n");
        }
        System.out.println(sb);

    }

    private static void dfs(int x, int y) {
        isVisits[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int moveX = x + directionX[i];
            int moveY = y + directionY[i];

            if (moveX >= 0 && moveY >= 0 && moveX < N && moveY < N) {
                if (!isVisits[moveX][moveY] && houses[moveX][moveY] == 1) {
                    count++;
                    dfs(moveX, moveY);
                }
            }
        }
    }
}
