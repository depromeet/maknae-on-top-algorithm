package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2606 {
    private static boolean[] isVisits;
    private static boolean[][] virus;
    private static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computer = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());


        isVisits = new boolean[computer+1];
        virus = new boolean[computer+1][computer+1];

        for (int i = 0; i < pair; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            virus[from][to] = true;
            virus[to][from] = true;
        }

        dfs(1);
        System.out.println(result);
    }

    private static void dfs(int from) {
        isVisits[from] = true;

        for (int i = 1; i < virus.length; i++) {
            if (virus[from][i] && !isVisits[i]) {
                result++;
                dfs(i);
            }
        }
    }
}
