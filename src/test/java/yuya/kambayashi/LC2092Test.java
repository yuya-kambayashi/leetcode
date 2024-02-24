package yuya.kambayashi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LC2092Test {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson){

        Map<Integer, List<int[]>> graph = new HashMap<>();
        
        for (int[] meeting : meetings) {
            int x = meeting[0], y = meeting[1], t = meeting[2];
            graph.computeIfAbsent(x, k -> new ArrayList<>()).add(new int[]{t, y});
            graph.computeIfAbsent(y, k -> new ArrayList<>()).add(new int[]{t, x});
        }

        // Earliest time at which a person learned the secret 
        // as per current state of knowledge. If due to some new information, 
        // the earliest time of knowing the secret changes, we will update it
        // and again process all the people whom he/she meets after the time
        // at which he/she learned the secret.
        int[] earliest = new int[n];
        Arrays.fill(earliest, Integer.MAX_VALUE);
        earliest[0] = 0;
        earliest[firstPerson] = 0;
        
        // Queue for BFS. It will store (person, time of knowing the secret)
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        q.offer(new int[]{firstPerson, 0});

        // Do BFS
        while (!q.isEmpty()) {
            int[] personTime = q.poll();
            int person = personTime[0], time = personTime[1];
            for (int[] nextPersonTime : graph.getOrDefault(person, new ArrayList<>())) {
                int t = nextPersonTime[0], nextPerson = nextPersonTime[1];
                if (t >= time && earliest[nextPerson] > t) {
                    earliest[nextPerson] = t;
                    q.offer(new int[]{nextPerson, t});
                }
            }
        }
        
        // Since we visited only those people who know the secret,
        // we need to return indices of all visited people.
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (earliest[i] != Integer.MAX_VALUE) {
                ans.add(i);
            }
        }
        return ans;
    }
    void doTest(int n, int[][] meetings, int firstPerson, List<Integer> expected) {

        //var actual = new LC2092().findAllPeople(n, meetings, firstPerson);
        var actual = findAllPeople(n, meetings, firstPerson);

        assertThat(actual).containsAnyElementsOf(expected);
        
    }

    @Test
    void Case1() {
        int n = 6;
        int[][] mettings = {{1,2,5},{2,3,8},{1,5,10}};
        int firstPerson = 4;
        
        List<Integer> expected = Arrays.asList(0,1,2,3,5);
        
        doTest(n, mettings, firstPerson, expected);
    }
    @Test
    void Case2() {
        int n = 4;
        int[][] mettings = {{3,1,3},{1,2,2},{0,3,3}};
        int firstPerson = 3;
        
        List<Integer> expected = Arrays.asList(0,1,3);
        
        doTest(n, mettings, firstPerson, expected);
    }
    @Test
    void Case3() {
        int n = 5;
        int[][] mettings = {{3,4,2},{1,2,1},{2,3,1}};
        int firstPerson = 1;
        
        List<Integer> expected = Arrays.asList(0,1,2,3,4);
        
        doTest(n, mettings, firstPerson, expected);
    }
}
