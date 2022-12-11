package week3;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2606BFS {
    static int computer;
    static int pair;
    static boolean[][] pairs;
    static boolean[] visits;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computer = Integer.parseInt(br.readLine());
        pair = Integer.parseInt(br.readLine());

        pairs = new boolean[computer+1][computer+1];
        visits = new boolean[computer+1];

        for (int i = 0; i < pair; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            pairs[first][second] = true;
            pairs[second][first] = true;
        }

        bfs(1);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visits[start] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (int i = 1; i <= computer; i++) {
                if ((pairs[poll][i] || pairs[i][poll]) && !visits[i]) {
                    queue.offer(i);
                    visits[i] = true;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
