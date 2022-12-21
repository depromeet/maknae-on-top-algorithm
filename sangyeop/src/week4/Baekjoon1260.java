package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1260 {
    static int N;
    static int M;
    static int V;
    static boolean[] visits;
    static boolean[][] isConnected;
    static List<Integer> dfsResults = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static int visitCount;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visits = new boolean[N+1];
        isConnected = new boolean[N+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            isConnected[start][end] = true;
            isConnected[end][start] = true;
        }

        dfs(V);
        sb.append("\n");
        visits = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
    }
    static void bfs(int start) {
        visits[start] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            sb.append(poll)
              .append(" ");

            for (int i = 1; i <= N; i++) {

                if (!visits[i] && (isConnected[poll][i] || isConnected[i][poll])) {
                    visits[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    static void dfs(int start) {
        visits[start] = true;
        sb.append(start)
          .append(" ");

        for (int i = 1; i <= N; i++) {
            if (!visits[i] && (isConnected[start][i] || isConnected[i][start])) {
                dfs(i);
            }
        }
    }
}
