package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15650 {

    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int M;

    private static int numbers[];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[M];

        dfs(1, 0);

        System.out.println(sb);

    }

    private static void dfs(int at, int depth) {
        if (depth == M) {
            for (int number : numbers) {
                sb.append(number)
                  .append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = at; i <= N; i++) {
            numbers[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}
