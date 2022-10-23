package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon15663 {
    private static int N;
    private static int M;

    private static int numbers[];
    private static int combinations[];
    private static boolean isVisit[];

    private static Set<String> set = new LinkedHashSet<>();

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
        isVisit = new boolean[N];

        dfs(0);

        for (String s : set) {
            System.out.println(s);
        }
    }

    private static void dfs(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int combination : combinations) {
                sb.append(combination)
                  .append(' ');
            }
            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isVisit[i]) {
                isVisit[i] = true;
                combinations[depth] = numbers[i];
                dfs(depth + 1);
                isVisit[i] = false;
            }
        }
    }
}
