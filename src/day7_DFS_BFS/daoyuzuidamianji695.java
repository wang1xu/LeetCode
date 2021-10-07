package day7_DFS_BFS;

import java.util.Arrays;

/*
给你一个大小为 m x n 的二进制矩阵 grid 。
岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设grid 的四个边缘都被 0（代表水）包围着。
岛屿的面积是岛上值为 1 的单元格的数目。
计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/max-area-of-island
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class daoyuzuidamianji695 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int count=0;

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int ans = maxAreaOfIsland(grid);
        System.out.println(ans);

    }

    public static int maxAreaOfIsland(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int ans=0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] ==1) {
//                    ans=count;
                    DFS(grid,i,j,row,col);
                    ans = Math.max(ans,count);
                    count=0;
                }
            }
        }
        return ans;
    }

    public static void DFS(int[][] grid, int x, int y, int row,int col) {
        //先对自身放个操作，再看其他方格，
        count++;
        grid[x][y]=0;
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i], my = y + dy[i];
            if (mx >= 0 && mx < row && my >= 0 && my < col && grid[mx][my] == 1) {
                grid[mx][my]=0;
                DFS(grid, mx, my, row, col);
            }
        }
    }

    public static void showTwoDArray(int[][] TwoD) {
    for (int i = 0; i < TwoD.length; i++) {
        System.out.println(Arrays.toString(TwoD[i]));
    }
    System.out.println();
    }
}
