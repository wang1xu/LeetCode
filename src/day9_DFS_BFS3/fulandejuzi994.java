package day9_DFS_BFS3;

import java.util.LinkedList;
import java.util.Queue;

/*
在给定的网格中，每个单元格可以有以下三个值之一：
值0代表空单元格；
值1代表新鲜橘子；
值2代表腐烂的橘子。
每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回-1。

示例 1：
输入：[[2,1,1],[1,1,0],[0,1,1]]
输出：4

示例 2：
输入：[[2,1,1],[0,1,1],[1,0,1]]
输出：-1
解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。

示例 3：
输入：[[0,2]]
输出：0
解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。

提示：
1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] 仅为0、1或2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotting-oranges
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class fulandejuzi994 {
    public static void main(String[] args) {
        int[][] grid=new int[][]{
                {2,1,1},
                {1,1,0},
                {0,1,1},
        };
        juzhen542.showMatrix(grid);
        Solution1 solution = new Solution1();
        int ans=solution.orangesRotting(grid);
        juzhen542.showMatrix(grid);
        System.out.println(ans);
    }
}

class Solution1 {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int min=0;
        while (!queue.isEmpty()) {
            Queue<int[]> newqueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                int[] point = queue.poll();
                int x = point[0], y = point[1];
                for (int i = 0; i < 4; i++) {
                    int mx = x + dx[i], my = y + dy[i];
                    if(mx>=0&&mx<row&&my>=0&&my<col&&grid[mx][my]==1){
                        grid[mx][my]=2;
                        newqueue.offer(new int[]{mx, my});
                    }
                }
            }
            if (newqueue.isEmpty()) {
                break;
            }
            queue = newqueue;
            min++;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return min;
    }
}
