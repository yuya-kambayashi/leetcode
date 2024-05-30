//import java.math.*;
//import java.util.*;
//import java.util.stream.*;
//public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int m = sc.nextInt();

        long[][] bb = new long[n][m];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                bb[r][c] = sc.nextLong();
            }
        }

        // 列間の差は1
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m - 1; c++) {
                if (bb[r][c + 1] - bb[r][c] != 1) {
                    System.out.println("No");
                    return;
                }
            }
            // 7の倍数が途中に来てはダメ
            for (int c = 0; c < m; c++) {
                if (bb[r][c] % 7 == 0 && c != m - 1) {
                    System.out.println("No");
                    return;
                }
            }
        }
        // 行間の差は7
        for (int r = 0; r < n - 1; r++) {
            for (int c = 0; c < m; c++) {
                if (bb[r + 1][c] - bb[r][c] != 7) {
                    System.out.println("No");
                    return;
                }
            }
        }

        if (m == 7) {
            if (bb[0][0] % 7 != 1) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
//}
import java.util.Scanner;
