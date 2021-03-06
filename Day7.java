/**
	Problem: You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

*/

class Solution {
    public int islandPerimeter(int[][] grid) {
        int permeter = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    if(i==0 || grid[i-1][j] == 0) permeter++;
                    if(i==n-1 || grid[i+1][j] == 0) permeter++;
                    if(j==0 || grid[i][j-1] == 0) permeter++;
                    if(j==m-1 || grid[i][j+1] == 0) permeter++;
                }
            }
        }
        return permeter;
    }
}