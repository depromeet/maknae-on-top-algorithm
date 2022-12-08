package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2309BFS {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> heights = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            heights.add(Integer.parseInt(br.readLine()));
            sum += heights.get(i);
        }

        Collections.sort(heights);

        int noAnswer1 = 0;
        int noAnswer2 = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - heights.get(i) - heights.get(j) == 100) {
                    noAnswer1 = heights.get(i);
                    noAnswer2 = heights.get(j);
                }
            }
        }

        for (Integer height : heights) {
            if (height != noAnswer1 && height != noAnswer2) {
                System.out.println(height);
            }
        }
    }
}
