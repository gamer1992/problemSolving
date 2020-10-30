package com.guru.learning.arrays;

public class QueensAttackII {
//https://www.hackerrank.com/challenges/queens-attack-2/problem
// Passes 20/30 I Hacker Rank , Can be optimized !!!
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        boolean[][] visited = new boolean[n + 1][n + 1];

        for (int[] obstacle : obstacles) {
            visited[obstacle[0]][obstacle[1]] = true;
        }
        int count = 0;
        int temp = 0;
        for (Direction d : Direction.values()) {
            temp = Math.max(calculateRight(n, r_q, c_q,  visited, d), 0);
             System.out.println(d.toString() + " " + calculateRight(n, r_q, c_q,  visited, d));
            count += temp;
        }
       //return calculateRight(n, r_q, c_q,  visited, Direction.NORTH);
       return count;
    }

    static int calculateRight(int n, int r_q, int c_q, boolean[][] visited, Direction direction) {

        if (r_q > n || c_q > n || r_q < 1 || c_q < 1) {
            return -1;
        }

        if (visited[r_q][c_q]) {
            return -1;
        }

        if (direction.equals(Direction.NORTH)) {
            return 1 + calculateRight(n, r_q - 1, c_q, visited, Direction.NORTH);
        } else if (direction.equals(Direction.SOUTH)) {
            return 1 + calculateRight(n, r_q + 1, c_q, visited, Direction.SOUTH);
        } else if (direction.equals(Direction.WEST)) {
            return 1 + calculateRight(n, r_q, c_q - 1, visited, Direction.WEST);
        } else if (direction.equals(Direction.EAST)) {
            return 1 + calculateRight(n, r_q, c_q + 1, visited, Direction.EAST);
        } else if (direction.equals(Direction.NORTHEAST)) {
            return 1 + calculateRight(n, r_q - 1, c_q + 1, visited, Direction.NORTHEAST);
        } else if (direction.equals(Direction.NORTHWEST)) {
            return 1 + calculateRight(n, r_q - 1, c_q - 1, visited, Direction.NORTHWEST);
        } else if (direction.equals(Direction.SOUTHEAST)) {
            return 1 + calculateRight(n, r_q +1, c_q + 1, visited, Direction.SOUTHEAST);
        } else
            return 1+ calculateRight(n, r_q + 1, c_q - 1, visited, Direction.SOUTHWEST);

    }


    public static void main(String args[]) {
     /*   5 3
        4 3
        5 5
        4 2
        2 3*/
        int n = 5, k = 3, r = 4, q = 3;
        int[][] obstacles = {{5, 5}, {4, 2}, {2, 3}};
        System.out.println(queensAttack(n, k, r, q, obstacles));

        r = 4;
        q = 4;
        n = 4;
        k = 0;
        int[][] obstacles_2 = {};
        System.out.print(queensAttack(n, k, r, q, obstacles_2));

        r=1;
        q=1;
        n=1;
        k=0;

        System.out.print(queensAttack(n, k, r, q, obstacles_2));

    }
}

enum Direction {
    NORTH,
    SOUTH,
    WEST,
    EAST,
    SOUTHWEST,
    NORTHWEST,
    SOUTHEAST,
    NORTHEAST
}

