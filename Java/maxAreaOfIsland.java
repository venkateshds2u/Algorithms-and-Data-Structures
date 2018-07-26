
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:
[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.


class Solution 
{
    
    public int maxAreaOfIsland(int[][] grid) 
    {
        int count =0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    count = Math.max(helper(i,j,grid), count);
                }
            }
        }
        return count;
    }
    
    public int helper(int i, int j, int[][] grid)
    {
        Queue<Integer> x = new LinkedList<Integer>();
        Queue<Integer> y = new LinkedList<Integer>();
        x.add(i);
        y.add(j);
        int count = 0;
        while(x.size()>0)
        {
            int elem1 = x.remove();
            int elem2 = y.remove();
            grid[elem1][elem2]=0;
            System.out.println("elem1 and elem2 values are "+elem1+" "+elem2);
            if((elem1+1)<grid.length && grid[elem1+1][elem2]==1)
            {
                x.add(elem1+1);
                y.add(elem2);
                grid[elem1+1][elem2]=0;
            }
            if((elem1-1)>=0 && grid[elem1-1][elem2]==1)
            {
                
                x.add(elem1-1);
                y.add(elem2);
                grid[elem1-1][elem2]=0;
            }
            if((elem2+1)<grid[0].length && grid[elem1][elem2+1]==1)
            {
                
                x.add(elem1);
                y.add(elem2+1);
                grid[elem1][elem2+1]=0;
            }
            if((elem2-1)>=0 && grid[elem1][elem2-1]==1)
            {
                
                x.add(elem1);
                y.add(elem2-1);
                grid[elem1][elem2-1]=0;
            }
            count++;
        }
        System.out.println(count);
        return count;
    }
}










