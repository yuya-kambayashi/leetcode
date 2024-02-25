/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kamba
 */
public class LC2709Test {
    Map<Integer, List<Integer>> prime2index = new HashMap<>();
    Map<Integer, List<Integer>> index2prime = new HashMap<>();

    public boolean canTraverseAllPairs(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            for (int j = 2; j * j <= nums[i]; j++) {
                if (temp % j == 0) {
                    prime2index.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
                    index2prime.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                    while (temp % j == 0)
                        temp /= j;
                }
            }
            if (temp > 1) {
                prime2index.computeIfAbsent(temp, k -> new ArrayList<>()).add(i);
                index2prime.computeIfAbsent(i, k -> new ArrayList<>()).add(temp);
            }
        }

        boolean[] visitedIndex = new boolean[nums.length];
        Map<Integer, Boolean> visitedPrime = new HashMap<>();
        dfs(0, visitedIndex, visitedPrime);

        for (boolean b : visitedIndex)
            if (!b)
                return false;
        return true;
    }
    public void dfs(int index, boolean[] visitedIndex, Map<Integer, Boolean> visitedPrime) {
        
        if (visitedIndex[index])
            return;
        visitedIndex[index] = true;

        for (int prime : index2prime.get(index)) {
            if (visitedPrime.getOrDefault(prime, false))
                continue;
            visitedPrime.put(prime, true);
            for (int index1 : prime2index.get(prime)) {
                if (visitedIndex[index1])
                    continue;
                dfs(index1, visitedIndex, visitedPrime);
            }
        }
    }

    @Test
    void Case1() {
        int[] nums = {2,3,6};
        var actual = canTraverseAllPairs(nums);
        
        var expected = true;
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void Case2() {
        int[] nums = {3,9,5};
        var actual = canTraverseAllPairs(nums);
        
        var expected = false;
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void Case3() {
        int[] nums = {4,3,12,8};
        var actual = canTraverseAllPairs(nums);
        
        var expected = true;
        assertThat(actual).isEqualTo(expected);
    }
}
