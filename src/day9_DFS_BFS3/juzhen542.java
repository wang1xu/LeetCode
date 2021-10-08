package day9_DFS_BFS3;

import sun.reflect.generics.tree.VoidDescriptor;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
给定一个由 0 和 1 组成的矩阵 mat，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
两个相邻元素间的距离为 1 。
示例 1：
输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
输出：[[0,0,0],[0,1,0],[0,0,0]]
示例 2：
输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
输出：[[0,0,0],[0,1,0],[1,2,1]]

提示：
m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
mat 中至少有一个 0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/01-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class juzhen542 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[][] matrix=new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        int[][] matrix=new int[][]{{0,0,0},{0,1,0},{1,1,1}};
        showMatrix(matrix);
        int[][] new_mat = solution.updateMatrix(matrix);
        showMatrix(matrix);

    }

    public static void showMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println();
    }

}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] new_mat = new int[mat.length][mat[0].length];
        int row = mat.length, col = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j]=-1;
                }
            }
        }
        //queue队列，先找完0附近的，改值加入队列，
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < row && my >= 0 && my < col && mat[mx][my] == -1) {
                    mat[mx][my]=mat[x][y]+1;
                    queue.offer(new int[]{mx, my});
                }
            }
        }


        return mat;
    }



    public int[][] copyArrays(int[][] mat) {
        int[][] new_mat = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                new_mat[i][j] = mat[i][j];
            }
        }
        return new_mat;
    }
}