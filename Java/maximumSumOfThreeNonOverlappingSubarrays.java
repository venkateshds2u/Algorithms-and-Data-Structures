class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        
        int bestSeq = 0;
        int[] bestTwoSeq ={0, k};
        int[] bestThreeSeq= {0, k, 2*k};
        
        // sums of each window
        
        int seqSum = 0;
        for(int i=0;i<k;i++)
        {
            seqSum += nums[i];
        }
        
        int seqTwoSum = 0;
        for(int i=k;i<2*k;i++)
        {
            seqTwoSum += nums[i]; 
        }
        
        int seqThreeSum = 0;
        for(int i=2*k;i<3*k;i++)
        {
            seqThreeSum += nums[i]; 
        }
        
        // sums of combined best windows
        
        int bestSeqSum = seqSum;
        int bestTwoSum = seqSum + seqTwoSum;
        int bestThreeSum = seqSum + seqTwoSum + seqThreeSum;
        
        //current window position
        
        
        int seqIndex = 1;
        int twoSeqIndex = k+1;
        int threeSeqIndex = 2*k+1;
        
        while(threeSeqIndex <= nums.length-k)
        {
            seqSum = seqSum - nums[seqIndex-1] + nums[seqIndex+k-1];
            seqTwoSum = seqTwoSum - nums[twoSeqIndex-1] + nums[twoSeqIndex+k-1];
            seqThreeSum = seqThreeSum - nums[threeSeqIndex-1] + nums[threeSeqIndex+k-1];
            
            //update the best single window
            
            if(bestSeqSum<seqSum)
            {
                bestSeq = seqIndex;
                bestSeqSum = seqSum;
            }
            
            //update the two best window
            
            if(seqTwoSum+bestSeqSum > bestTwoSum)
            {
                bestTwoSeq[0] = bestSeq;
                bestTwoSeq[1] = twoSeqIndex;
                bestTwoSum = seqTwoSum+bestSeqSum;
            }
            
            //update the best three window
            
            if(seqThreeSum+bestTwoSum>bestThreeSum)
            {
                bestThreeSeq[0] = bestTwoSeq[0];
                bestThreeSeq[1] = bestTwoSeq[1];
                bestThreeSeq[2] = threeSeqIndex;
                bestThreeSum = seqThreeSum + bestTwoSum;
                
            }
            
            //update the current positions
            seqIndex++;
            twoSeqIndex++;
            threeSeqIndex++;
        }
        
        return bestThreeSeq;
    }
}
