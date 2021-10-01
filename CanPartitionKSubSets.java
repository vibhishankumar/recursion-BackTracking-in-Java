class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int tsum=0;
      //finding total sum
        for(int el:nums)
        {
            tsum+=el;
        }
      //checking if total sum is divisible by k or not if not then
      //not posible to devide into equal sum subArray
        if(tsum%k!=0)
        {
            return false;
        }
        if(nums.length<k) return false;
        //target sum
        int subSetSum=tsum/k;
        boolean[] visited=new boolean[nums.length];
        return canPartition(nums,visited,0,k,0,subSetSum);
        
    }
    private boolean canPartition(int[] nums,boolean[] visited,int start,int k, int curSum,int subSetSum)
    {
      //if k is itself is 0 them no partition required
        if(k==0) return true;
      //checking currentSum only should be equal to target sum
        if(curSum>subSetSum) return false;
        //recursive call if curSum has same value as target sum
        if(curSum==subSetSum)
        {
            return canPartition(nums,visited,0,k-1,0,subSetSum);
        }
      //storing visited element
        for(int i=start;i<nums.length;i++)
        {
            if(visited[i]) continue;
            visited[i]= true;
            if(canPartition(nums,visited,i+1,k,curSum+nums[i],subSetSum)) return true;
            visited[i]=false; 
        }
        return false;
    }
}
