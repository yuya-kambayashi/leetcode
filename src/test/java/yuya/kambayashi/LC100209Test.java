/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kamba
 */
public class LC100209Test {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        
        int m = queries.length;

        long[] ans = new long[m];
               
        int[] mark = new int[nums.length];
        Arrays.fill(mark, 0);

        for(int i = 0; i < m; i++){
            int[] query = queries[i];

            
            mark[query[0]] = 1;
            
            int cnt = 0;
            
            // 現状で、小さい順に並べる
            int[] sortedNums = Arrays.copyOf(nums, nums.length);
            Arrays.sort(sortedNums);
            
            for(int j = 0; j < nums.length; j++){
                
                if (mark[j] == 1){
                    continue;
                }
                
                
                if (nums[j] <= sortedNums[query[1]] && cnt < query[1]){
                    mark[j] = 1;
                    cnt++;
                }
            }
            
            for(int j = 0; j < nums.length; j++){
                
                if (mark[j] == 0){
                    ans[i] += nums[j];
                }
            }
            
            int a = 0;
                        
        }
        
 
        return ans;
    }

    @Test
    void Case1() {
        
        int[] nums = {1,2,2,1,2,3,1};
        int[][] queries = {{1,2},{3,3},{4,2}};
        
        var actual = unmarkedSumArray(nums, queries);
        
        long[] expected = {8,3,0};
        
        assertThat(actual).containsExactly(expected);
    }
}
