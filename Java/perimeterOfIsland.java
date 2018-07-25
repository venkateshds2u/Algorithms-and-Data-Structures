
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16







class Solution 
{
    int perimeter=0;
    public int islandPerimeter(int[][] grid) 
    {
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    helper(i,j, grid);
                }
            }
        }
        return perimeter;
        
    }
    public void helper(int i, int j, int[][] grid)
    {
        {
            if(i<grid.length&&i-1>=0&&j<grid[0].length&&j>=0&&grid[i-1][j]==0) 
            {   
                perimeter=perimeter+1;
            }
            else if(i-1<0)
            {
                perimeter = perimeter +1;
            }
            if(i<grid.length&&i>=0&&j+1<grid[0].length&&j>=0&&grid[i][j+1]==0) 
            {   
                perimeter=perimeter+1;
            }
            else if(j+1>=grid[0].length)
            {
                perimeter=perimeter+1;
            }
            if(i+1<grid.length&&i>=0&&j<grid[0].length&&j>=0&&grid[i+1][j]==0) 
            {   
                perimeter=perimeter+1;
            }
            else if(i+1>=grid.length)
            {
                perimeter=perimeter+1;
            }
            if(i<grid.length&&i>=0&&j<grid[0].length&&j-1>=0&&grid[i][j-1]==0) 
            {   
                perimeter=perimeter+1;
            }
            else if(j-1<0)
            {
                perimeter=perimeter+1;
            }
            
        }
       
    }
    
}

