package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7576 {
    static int N;
    static int M;
    static int[][] tomatoes;

    static int[] dirX = {-1, 0, 1, 0};
    static int[] dirY = {0, -1, 0, 1};

    static int result;

    static Queue<Tomato> queue = new ArrayDeque<>();


    static class Tomato {
        int x;
        int y;
        int day;

        public Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomatoes = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if (tomatoes[i][j] == 1) {
                    queue.offer(new Tomato(i, j, 0));
                }
            }
        }

        bfs();
    }

    static void bfs() {
        int day = 0;

        while (!queue.isEmpty()) {
            Tomato poll = queue.poll();
            day = poll.day;

            for (int i = 0; i < 4; i++) {
                int moveX = poll.x + dirX[i];
                int moveY = poll.y + dirY[i];

                if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < M  && tomatoes[moveX][moveY] == 0) {
                    tomatoes[moveX][moveY] = 1;
                    queue.offer(new Tomato(moveX, moveY, day + 1));
                }
            }
        }

        if (check()) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }

    static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatoes[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
