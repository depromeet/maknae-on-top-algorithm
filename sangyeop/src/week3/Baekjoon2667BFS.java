package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2667BFS {
    static int[][] map;
    static boolean[][] visits;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int N;
    static StringBuilder sb = new StringBuilder();
    static List<Integer> counts = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visits = new boolean[N][N];

        int totalHouse = 0;

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine()
                               .split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visits[i][j]) {
                    totalHouse++;
                    bfs(i, j);
                }
            }
        }
        System.out.println(totalHouse);
        Collections.sort(counts);
        for (Integer count : counts) {
            sb.append(count)
              .append("\n");
        }
        System.out.println(sb);
    }
    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visits[x][y] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int moveX = poll[0] + dx[i];
                int moveY = poll[1] + dy[i];
                if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < N && map[moveX][moveY] == 1 && !visits[moveX][moveY]) {
                    queue.offer(new int[]{moveX, moveY});
                    visits[moveX][moveY] = true;
                    count++;
                }
            }
        }
        counts.add(count);
    }
}
