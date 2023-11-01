package yuya.kambayashi;

public class LC011 {
    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;

        int left = 0;
        int right = height.length - 1;

        while(left < right){
            int width = right - left;

            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * width);

            if (height[left] <= height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxArea;
    }
}
