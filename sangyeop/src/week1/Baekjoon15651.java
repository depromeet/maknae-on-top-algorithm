package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15651 {
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

        dfs(0);

        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int number : numbers) {
                sb.append(number)
                  .append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            numbers[depth] = i + 1;
            dfs(depth + 1);
        }
    }
}
