package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Baekjoon15664 {
    private static int N;
    private static int M;
    private static int numbers[];
    private static int permutations[];

    private static Set<String> set = new LinkedHashSet<>();

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

        for (String s : set) {
            System.out.println(s);
        }
    }

    private static void dfs(int at, int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int permutation : permutations) {
                sb.append(permutation)
                  .append(' ');
            }
            set.add(sb.toString());
            return;
        }

        for (int i = at; i < N; i++) {
            permutations[depth] = numbers[i];
            dfs(i + 1, depth + 1);
        }
    }
}
