class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int maxArea=0;

        while(left<right){
            int width=right-left;
            int minheight=Math.min(height[left],height[right]);
            int currArea=width*minheight;
            maxArea=Math.max(currArea,maxArea);

            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }

        }
        return maxArea;
    }
}