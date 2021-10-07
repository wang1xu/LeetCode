package day7_DFS_BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
给你一个坐标(sr, sc)表示图像渲染开始的像素值（行 ，列）和一个新的颜色值newColor，让你重新上色这幅图像。
为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
最后返回经过上色渲染后的图像。

示例 1:
输入:
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
输出: [[2,2,2],[2,2,0],[2,0,1]]
解析: 
在图像的正中间，(坐标(sr,sc)=(1,1)),
在路径上所有符合条件的像素点的颜色都被更改成2。
注意，右下角的像素没有更改为2，
因为它不是在上下左右四个方向上与初始点相连的像素点。

注意:
image 和image[0]的长度在范围[1, 50] 内。
给出的初始点将满足0 <= sr < image.length 和0 <= sc < image[0].length。
image[i][j] 和newColor表示的颜色值在范围[0, 65535]内。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/flood-fill
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class tuxiangxuanran733 {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        showTwoDArray(image);
        int[][] new_image = floodFill(image, sr, sc, newColor);
//        System.out.println(Arrays.deepToString(image));

        showTwoDArray(new_image);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor != newColor) {
//            dfs(image,sr,sc,currColor,newColor);
            BFS(image,sr,sc,currColor,newColor);

        }
        return image;
    }

//    BFS广度优先搜索，采用栈的方式，由一点向边缘发散
    public static void dfs(int[][] image, int x, int y, int color, int newColor) {
        if (image[x][y] == color) {
            image[x][y] = newColor;
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < image.length && my >= 0 && my < image[0].length) {
                    dfs(image, mx, my, color, newColor);

                }
            }
        }
    }

//DFS深度优先搜索，采用递归方式，一条线，从外向内靠拢
    public static void BFS(int[][] image, int x, int y, int currColor, int newColor) {
        if (currColor == newColor) {
            return;
        }
        int row= image.length,col= image[0].length;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{x, y});
        image[x][y]=newColor;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x1 = cell[0], y1 = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x1 + dx[i], my = y1 + dy[i];
                if (mx >= 0 && mx < row && my >= 0 && my < col && image[mx][my] == currColor) {
                    queue.offer(new int[]{mx, my});
                    image[mx][my]=newColor;
                }
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
