package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2178 {
    static int[][] miro;
    static boolean[][] visits;
    static int[] dirX = {-1, 0, 1, 0};
    static int[] dirY = {0, -1, 0, 1};

    static int N;
    static int M;

    static int result;

    static class Position {
        int x;
        int y;
        int count;

        public Position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        miro = new int[N+1][M+1];
        visits = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String[] splits = br.readLine()
                               .split("");
            for (int j = 1; j <= M; j++) {
                miro[i][j] = Integer.parseInt(splits[j-1]);
            }
        }

        bfs(1, 1);
    }

    static void bfs(int x, int y) {
        Queue<Position> queue = new ArrayDeque<>();
        queue.offer(new Position(x, y, 1));
        visits[x][y] = true;

        int max = 0;

        List<Integer> temps = new ArrayList<>();
        while (!queue.isEmpty()) {
            Position poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int moveX = poll.x + dirX[i];
                int moveY = poll.y + dirY[i];

                if (moveX >= 1 && moveX <= N && moveY >= 1 && moveY <= M && !visits[moveX][moveY] && miro[moveX][moveY] == 1) {
                    queue.offer(new Position(moveX, moveY, poll.count + 1));
                    visits[moveX][moveY] = true;
                }
            }


            if(poll.x == N && poll.y == M) {
                temps.add(poll.count);
            }
        }
        Collections.sort(temps);

        System.out.println(temps.get(0));
    }
}
