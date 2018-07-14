


class Solution 
{
    public boolean isMatch(String text, String pattern) 
    {
        
        int m=text.length();
        int n= pattern.length();
        char[] ws = text.toCharArray();
        char[] wp = pattern.toCharArray();
        
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i=1;i<=m;i++)
        {
            dp[i][0] = false;
        }
        
        for (int j = 1; j <= n; j++) {
            if (wp[j-1] == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        
        
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(wp[j-1]=='.' || wp[j-1]==ws[i-1])
                    dp[i][j] = dp[i-1][j-1];
                else if(wp[j-1]=='*')
                {
                    dp[i][j] = dp[i][j - 2];
                    if (wp[j-2] == '.' || wp[j - 2] == ws[i - 1]) 
                    {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
                else
                {
                    dp[i][j] = false;
                }
                
            }
        }
        return dp[m][n];
        
    }
}
