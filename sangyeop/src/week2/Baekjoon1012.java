package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1012 {
    private static int M;
    private static int N;
    private static int K;

    private static int[] directionX = {0, -1, 0, 1};
    private static int[] directionY = {1, 0, -1, 0};
    private static int[][] map;

    private static boolean[][] isVisits;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[M][N];
            isVisits = new boolean[M][N];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st.nextToken());
                int column = Integer.parseInt(st.nextToken());
                map[row][column] = 1;
            }


            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] == 1 && !isVisits[j][k]) {
                        dfs(j, k);
                        result++;
                    }
                }
            }
            sb.append(result)
              .append("\n");
        }

        System.out.println(sb);

    }

    private static void dfs(int x, int y) {
        isVisits[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int moveX = x + directionX[i];
            int moveY = y + directionY[i];

            if (moveX >= 0 && moveY >= 0 && moveX < M && moveY < N) {
                if (!isVisits[moveX][moveY] && map[moveX][moveY] == 1) {
                    dfs(moveX, moveY);
                }
            }
        }
    }
}
