package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon15654 {
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int M;

    private static int numbers[];

    private static int combinations[];
    private static boolean isVisits[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        combinations = new int[M];
        isVisits = new boolean[N];

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int combination : combinations) {
                sb.append(combination)
                  .append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isVisits[i]) {
                isVisits[i] = true;
                combinations[depth] = numbers[i];
                dfs(depth + 1);
                isVisits[i] = false;
            }
        }
    }
}
