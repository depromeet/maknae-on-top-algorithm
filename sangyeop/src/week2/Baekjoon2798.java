package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon2798 {
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int M;

    private static int[] cards;
    private static boolean[] isVisits;
    private static List<Integer> results = new ArrayList<>();

    private static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cards = new int[N];
        isVisits = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(max);
    }
    private static void dfs(int at) {
        if (results.size() == 3) {
            int sum = 0;
            for (int result : results) {
                sum += result;
            }

            if (sum <= M) {
                if (max < sum) {
                    max = sum;
                }
            }
            return;
        }

        for (int i = at; i < N; i++) {
            if (!isVisits[i]) {
                isVisits[i] = true;
                results.add(cards[i]);
                dfs(i);
                isVisits[i] = false;
                results.remove(results.size() - 1);
            }
        }

    }
}
