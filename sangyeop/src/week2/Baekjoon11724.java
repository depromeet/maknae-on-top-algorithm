package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon11724 {
    private static int result;
    private static boolean[][] components;
    private static boolean[] isVisits;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        components = new boolean[N+1][N+1];
        isVisits = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            components[from][to] = true;
            components[to][from] = true;
        }

        for (int i = 1; i < components.length; i++) {
            if (!isVisits[i]) {
                result++;
                dfs(i);
            }
        }
        System.out.println(result);
    }

    private static void dfs(int start) {
        isVisits[start] = true;

        for (int i = 1; i < components.length; i++) {
            if (components[start][i] && !isVisits[i]) {
                dfs(i);
            }
        }
    }

}
