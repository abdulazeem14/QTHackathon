package path;

import java.util.ArrayList;


class Path {
public static ArrayList<String> pth=new ArrayList<>();

    public static void isPath(
            int matrix[][], int n)
    {
        boolean visited[][]
                = new boolean[n][n];

        boolean flag = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (
                        matrix[i][j] == 1
                                && !visited[i][j])

                    if (isPath(
                            matrix, i, j, visited)) {
                        // if path exists
                        flag = true;
                        break;
                    }
            }
        }
        if (flag)
            System.out.println(" path is available");
        else
            System.out.println("path is not available");
    }

    // Method for checking boundaries
    public static boolean isSafe(
            int i, int j,
            int matrix[][])
    {

        if (
                i >= 0 && i < matrix.length
                        && j >= 0
                        && j < matrix[0].length)
            return true;
        return false;
    }
    public static boolean isPath(
            int matrix[][],
            int i, int j,
            boolean visited[][])
    {
        if (
                isSafe(i, j, matrix)
                        && matrix[i][j] != 0
                        && !visited[i][j]) {
            visited[i][j] = true;

            if (matrix[i][j] == 2)
                return true;

            boolean up = isPath(
                    matrix, i - 1,
                    j, visited);

            if (up) {
                pth.add("up");
                return true;
            }

            boolean left
                    = isPath(
                    matrix, i, j - 1, visited);
            if (left){
                pth.add("left");
                return true;}
            boolean down = isPath(
                    matrix, i + 1, j, visited);
            if (down)
            {
                pth.add("down");
                return true;}
            boolean right
                    = isPath(
                    matrix, i, j + 1,
                    visited);
            if (right){
                pth.add("right");
                return true;}
        }
        return false;
    }
    public static void main(String[] args)
    {

        int matrix[][] = {
                {0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                {0,  0,  3,  3,  3,  3,  3,  3,  3,  0},
                {0,  0,  3,  0,  3,  0,  0,  0,  0,  0},
                {0,  3,  3,  0,  3,  0,  0,  0,  0,  0},
                {0,  3,  0,  0,  3,  3,  3,  3,  3,  0},
                {0,  3,  3,  3,  0,  0,  3,  0,  0,  0},
                {0,  0,  0,  3,  0,  0,  3,  0,  0,  0},
                {1,  3,  0,  3,  0,  0,  3,  0,  0,  0},
                {0,  3,  3,  3,  0,  0,  3,  3,  0,  0},
                {0,  0,  0,  0,  0,  0,  0,  3,  3,  2}};
        isPath(matrix, 10);
        System.out.println(pth.size());
        System.out.println("traverse");
        for(int i=pth.size()-1;i>0;i--){
            System.out.println(pth.get(i));
        }
    }
}


