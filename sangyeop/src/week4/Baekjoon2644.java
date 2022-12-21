package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2644 {
    static int n;
    static int p1;
    static int p2;
    static int m;

    static boolean[][] relations;
    static int[] values;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        relations = new boolean[n+1][n+1];
        values = new int[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            relations[x][y] = true;
            relations[y][x] = true;
        }
        bfs(p1, p2);
        if (values[p2] == 0) {
            System.out.println(-1);

        } else {
            System.out.println(values[p2]);
        }

    }
    static void bfs(int start, int end) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (poll == end) {
                break;
            }

            for (int i = 1; i <= n; i++) {
                if ((relations[poll][i] || relations[i][poll]) && values[i] == 0) {
                    queue.offer(i);
                    values[i] = values[poll] + 1;
                }
            }
        }
    }
}
