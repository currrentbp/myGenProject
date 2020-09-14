package com.currentbp.Interesting.likou.offer.complete;

import com.currentbp.util.all.ListUtil;
import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author baopan
 * @createTime 2020/8/31 21:44
 */
public class T012Exist {
/*
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，
每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，
那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
[['a','b','c','e'],
['s','f','c','s'],
['a','d','e','e']]
但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
示例 1：
输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'ABCCED'
输出：true
示例 2：
输入：board = [['a','b'],['c','d']], word = 'abcd'
输出：false

解题思路：
1、制作一个所有字符的字典表Map<>:字符2位置s
2、
 */


    @Test
    public void t1() {
        StringUtil.printObject(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
    }

    private List<int[]> directions = new ArrayList<>();

    {
        directions.add(new int[]{0, 1});
        directions.add(new int[]{0, -1});
        directions.add(new int[]{1, 0});
        directions.add(new int[]{-1, 0});
    }

    //这个策略耗时太久，原因：1、拷贝时间太长，2、路径的编写太耗时
    public boolean exist(char[][] board, String word) {
        if (null == word || 0 == word.length()) {
            return true;
        }
        Map<Character, List<int[]>> dics = init(board);
        int index = 0;
        List<List<int[]>> paths = new ArrayList<>();

        //第一层
        List<int[]> firstLevel = dics.get(word.charAt(index));
        if (null == firstLevel || 0 == firstLevel.size()) {
            return false;
        }
        for (int[] ints : firstLevel) {
            List<int[]> temp = new ArrayList<>();
            temp.add(ints);
            paths.add(temp);
        }
        index++;

        //第二个字符以后
        while (index < word.length()) {
            long time1 = System.currentTimeMillis();
            char currentChar = word.charAt(index);
            List<List<int[]>> temp = new ArrayList<>();

            for (int i = 0; i < paths.size(); i++) {
                List<int[]> currentPath = paths.get(i);//当前路径
                List<int[]> nextPoints = getNextPoints(currentChar, currentPath, board);//可能的下一个点

                for (int j = 0; j < nextPoints.size(); j++) {
                    int[] nextPoint = nextPoints.get(j);//下一个可能的点
                    boolean isOk = checkPath(currentPath, nextPoint);//对比当前路径和下一个点的是否正确
                    if (isOk) {
                        List<int[]> newPath = getCopy(currentPath);
                        newPath.add(nextPoint);
                        temp.add(newPath);
                    }
                }
            }

            if (null == temp || 0 == temp.size()) {
                return false;
            }
            index++;
            paths = temp;
            long time2 = System.currentTimeMillis();
            System.out.println("最外层耗时：" + (time2 - time1));
        }
//        StringUtil.printObject(paths);
        return paths.size() > 0;
    }

    /**
     * 获取下个点的位置
     */
    private List<int[]> getNextPoints(char currentChar, List<int[]> currentPath, char[][] board) {
        int[] lastPoint = currentPath.get(currentPath.size() - 1);
        int y = lastPoint[1];
        int x = lastPoint[0];
        int maxY = board.length;
        int maxX = board[0].length;
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < directions.size(); i++) {
            int[] direction = directions.get(i);
            int nextY = y + direction[1];
            int nextX = x + direction[0];
            if (nextX >= 0 && nextX < maxX && nextY >= 0 && nextY < maxY) {//在数组范围内
                if (currentChar == board[nextY][nextX]) {
                    result.add(new int[]{nextX, nextY});
                }
            }
        }
        return result;
    }

    private List<int[]> getCopy(List<int[]> currentPath) {
        long startTime = System.currentTimeMillis();
        List<int[]> result = new ArrayList<>();
        if (null == currentPath || 0 == currentPath.size()) {
            return result;
        }
        result.addAll(currentPath);
        long endTime = System.currentTimeMillis();
        long useTime = endTime - startTime;
        if (useTime > 10) {
            System.out.println("拷贝时间：" + useTime + " length:" + currentPath.size());
        }
        return result;
    }

    /**
     * 检查：1、当前点是否已经存在，
     * 2、检查当前点是否是最后一个点的近邻
     */
    private boolean checkPath(List<int[]> path, int[] point) {
        if (null == path || 0 == path.size()) {
            return true;
        }
        //判断是否已经经过了这个点
        for (int i = 0; i < path.size(); i++) {
            int[] now = path.get(i);
            if (now[0] == point[0] && now[1] == point[1]) {
                return false;
            }
        }
        int[] lastPoint = path.get(path.size() - 1);
        //判断是否是近邻
        if (lastPoint[0] == point[0] && (lastPoint[1] + 1 == point[1] || lastPoint[1] - 1 == point[1])) {//x相同
            return true;
        }
        if (lastPoint[1] == point[1] && (lastPoint[0] + 1 == point[0] || lastPoint[0] - 1 == point[0])) {//y相同
            return true;
        }
        return false;
    }

    private Map<Character, List<int[]>> init(char[][] board) {
        Map<Character, List<int[]>> result = new HashMap<>();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                char c = board[y][x];
                if (result.containsKey(c)) {
                    List<int[]> ints = result.get(c);
                    ints.add(new int[]{x, y});
                } else {
                    List<int[]> temp = new ArrayList<>();
                    temp.add(new int[]{x, y});
                    result.put(c, temp);
                }
            }
        }
        return result;
    }

    @Test
    public void t2() {
//        StringUtil.printObject(exist2(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
//        StringUtil.printObject(exist2(new char[][]{{'A'}}, "A"));
        StringUtil.printObject(exist2(new char[][]{{'A', 'B'}}, "BA"));
    }

    /*
    解决思路2：使用递归的方式解决问题
    增加一个标记二维数组
     */
    public boolean exist2(char[][] board, String word) {
        if (null == word || 0 == word.length()) {
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int[][] flagBoard = new int[board.length][board[0].length];
                if (dfs(board, flagBoard, j, i, word, 0)) {
                    printArray(flagBoard);
                    return true;
                }
            }
        }

        return false;
    }


    private boolean dfs(char[][] board, int[][] flagBoard, int x, int y, String word, int index) {
        if (index >= word.length()) {
            return true;
        }
        if (x < 0 || y < 0 || x >= board[0].length || y >= board.length) {//该点不存在，表示不是路径的位置
            return false;
        }
        if (flagBoard[y][x] != 0) {
            return false;
        }

        char currentChar = board[y][x];
        char targetChar = word.charAt(index);
        if (currentChar == targetChar) {//当前位置是需要的字符，则继续向下递归遍历，否则表示不是需要的字符
            flagBoard[y][x] = index + 1;
            //上
            if (dfs(board, flagBoard, x, y + 1, word, index + 1)) {
                return true;
            }
            //左
            if (dfs(board, flagBoard, x - 1, y, word, index + 1)) {
                return true;
            }
            //下
            if (dfs(board, flagBoard, x, y - 1, word, index + 1)) {
                return true;
            }
            //右
            if (dfs(board, flagBoard, x + 1, y, word, index + 1)) {
                return true;
            }
        }
        flagBoard[y][x] = 0;
        return false;
    }

    private void printArray(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(""+board[i][j]+" ");
            }
            System.out.println();
        }
    }

}
