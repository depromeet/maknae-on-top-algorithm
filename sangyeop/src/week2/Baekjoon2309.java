package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baekjoon2309 {

    private static StringBuilder sb = new StringBuilder();
    private static int heights[];

    private static List<Integer> results = new ArrayList();

    private static boolean[] isVisits;
    private static boolean isPrinted;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        heights = new int[9];
        isVisits = new boolean[9];

        for (int i = 0; i < 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }

        dfs(0);
        System.out.println(sb);

    }

    private static void dfs(int at) {
        if (results.size() == 7 && !isPrinted) {
            int sum = 0;
            for (int result : results) {
                sum += result;
            }

            if (sum == 100) {
                Collections.sort(results);
                for (int result : results) {
                    sb.append(result)
                      .append("\n");
                }
                isPrinted = true;
                return;
            }
        }

        for (int i = at; i < 9; i++) {
            if (!isVisits[i]) {
                isVisits[i] = true;
                results.add(heights[i]);
                dfs(i);
                isVisits[i] = false;
                results.remove(results.size() - 1);
            }
        }
    }
}
