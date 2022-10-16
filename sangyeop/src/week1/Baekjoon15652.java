package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Baekjoon15652 {

    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int M;
    private static int numbers[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Function<String, Integer> parser = s -> Integer.parseInt(s);

        N = parser.apply(st.nextToken());
        M = parser.apply(st.nextToken());

        numbers = new int[M];

        dfs(1,0);
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
            dfs(i, depth + 1);
        }
    }
}
