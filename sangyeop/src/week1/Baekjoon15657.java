package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon15657 {
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int M;
    private static int numbers[];
    private static int permutations[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        permutations = new int[M];

        dfs(0, 0);
        System.out.println(sb);
    }

    private static void dfs(int at, int depth) {
        if (depth == M) {
            for (int permutation : permutations) {
                sb.append(permutation)
                  .append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = at; i < N; i++) {
            permutations[depth] = numbers[i];
            dfs(i, depth + 1);
        }
    }
}
