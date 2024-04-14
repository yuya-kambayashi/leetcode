package yuya.kambayashi;

import java.util.*;
import java.util.stream.Collectors;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class LC100280 {

    public int minRectanglesToCoverPoints(int[][] points, int w) {

        List<Integer> list = new ArrayList<>();
        for (int[] point : points) {
            if (!list.contains(point[0])) {
                list.add(point[0]);
            }
        }
        if (list.size() == 1) {
            return 1;
        }

        Collections.sort(list);

        int ans = 0;

        int skipedIndex = 0;
        int skipedValue = 0;

        while (true) {
            if (skipedIndex == list.size()) {

                break;
            }

            int start = list.get(skipedIndex);
            int end = start + w;

            for (int j = 0; j < list.size(); j++) {

                int x = list.get(j);

                if (x <= skipedValue) {
                    continue;
                }

                if (start <= x && x <= end) {
                    skipedIndex = j + 1;
                    skipedValue = x;
                }
            }
            ans++;
        }
        return ans;
    }

    // @Test
    void Case1() {

        int[][] points = {{2, 1}, {1, 0}, {1, 4}, {1, 8}, {3, 5}, {4, 6}};
        int w = 1;
        var expected = 2;

        var actual = minRectanglesToCoverPoints(points, w);

        assertThat(actual).isEqualTo(expected);
    }

    //@Test
    void Case2() {

        int[][] points = {{0, 0}, {1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 6}};
        int w = 2;
        var expected = 3;

        var actual = minRectanglesToCoverPoints(points, w);

        assertThat(actual).isEqualTo(expected);
    }

    //@Test
    void Case3() {

        int[][] points = {{2, 3}, {1, 2}};
        int w = 0;
        var expected = 2;

        var actual = minRectanglesToCoverPoints(points, w);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void Case4() {

        int[][] points = {{0, 0}};
        int w = 0;
        var expected = 1;

        var actual = minRectanglesToCoverPoints(points, w);

        assertThat(actual).isEqualTo(expected);
    }

}
