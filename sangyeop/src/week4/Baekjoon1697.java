package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1697 {

    static int N;
    static int K;

    static int[] check = new int[100001];


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
        } else {
            bfs(N);
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        check[start] = 1;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = poll + 1;
                } else if (i == 1) {
                    next = poll - 1;
                } else {
                    next = poll * 2;
                }

                if (next == K) {
                    System.out.println(check[poll]);
                    return;
                }

                if (next >= 0 && next <= 100000 && check[next] == 0) {
                    queue.add(next);
                    check[next] = check[poll] + 1;
                }
            }
        }


    }
}
