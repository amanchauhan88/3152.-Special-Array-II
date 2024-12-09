class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] parityMismatch = new int[n - 1]; // Array to store mismatch info between adjacent elements
        
        // Compute parity mismatch array
        for (int i = 0; i < n - 1; i++) {
            parityMismatch[i] = (nums[i] % 2 == nums[i + 1] % 2) ? 1 : 0;
        }
        
        // Prefix sum array for parityMismatch
        int[] prefixSum = new int[n];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + (i - 1 < parityMismatch.length ? parityMismatch[i - 1] : 0);
        }
        
        // Process queries
        boolean[] answer = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            // Check if there is any mismatch in the range [from, to - 1]
            answer[i] = (prefixSum[to] - prefixSum[from] == 0);
        }
        
        return answer;
    }
}
