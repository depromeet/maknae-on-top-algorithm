package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon11724BFS {
    static boolean[][] components;
    static boolean[] visits;
    static int N;
    static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        components = new boolean[N + 1][N + 1];
        visits = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            components[first][second] = true;
            components[second][first] = true;
        }

        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (!visits[i]) {
                count++;
                bfs(i);
            }
        }

        System.out.println(count);
    }
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visits[start] = true;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int i = 1; i <= N; i++) {
                if ((components[poll][i] || components[i][poll]) && !visits[i]) {
                    queue.offer(i);
                    visits[i] = true;
                }
            }
        }
    }
}
