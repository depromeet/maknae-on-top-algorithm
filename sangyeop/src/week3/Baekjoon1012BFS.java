package week3;

import org.w3c.dom.Attr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1012BFS {
    static int[][] cabbages;
    static boolean[][] isVisits;

    static int M;
    static int N;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            cabbages = new int[M][N];
            isVisits = new boolean[M][N];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cabbages[x][y] = 1;
            }

            int result = 0;

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (cabbages[j][k] == 1 && !isVisits[j][k]) {
                        result++;
                        bfs(j, k);
                    }
                }
            }
            System.out.println(result);

        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        isVisits[x][y] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int moveX = poll[0] + dx[i];
                int moveY = poll[1] + dy[i];

                if (moveX >= 0 && moveX < M && moveY >= 0 && moveY < N && cabbages[moveX][moveY] == 1 && !isVisits[moveX][moveY]) {
                    queue.offer(new int[]{moveX, moveY});
                    isVisits[moveX][moveY] = true;
                }
            }
        }
    }
}
