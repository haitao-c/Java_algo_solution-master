package io.haitaoc.xiaozhao;



import java.util.Scanner;
public class JingDong19_1 {
    int[] a;
    boolean[][] connected;
    boolean[] visited;

    public void run() {
        Scanner scan = new Scanner(System.in);
        int T = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < T; i++) {
            String[] in = scan.nextLine().split(" ");
            int N = Integer.parseInt(in[0]);
            int M = Integer.parseInt(in[1]);
            a = new int[N + 1];
            visited = new boolean[N + 1];
            for (int j = 0; j < a.length; j++) {
                a[j] = j;
            }
            for (int j = 0; j < visited.length; j++) {
                visited[j] = false;
            }
            connected = new boolean[N + 1][N + 1];
            for (int j = 0; j < M; j++) {
                String[] c = scan.nextLine().split(" ");
                int x = Integer.parseInt(c[0]);
                int y = Integer.parseInt(c[1]);
                connected[x][y] = true;
                connected[y][x] = true;
            }

            System.out.println(isYes());

            for (int j = 0; j < a.length; j++) {
                a[j] = j;
            }

            for (int j = 0; j < connected.length; j++) {
                for (int k = 0; k < connected[0].length; k++) {
                    connected[j][k] = false;
                }
            }
        }
    }

    private String isYes() {
        for (int j = 1; j < connected.length; j++) {
            for (int k = 0; k < connected[0].length; k++) {
                if (!connected[j][k] && !visited[k]) {
                    visited[k] = true;
                    a[k] = j;
                }
            }
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a.length; j++) {
                if (a[i] != a[j] && !connected[i][j])
                    return "No";
            }
        }
        return "Yes";
    }

    public static void main(String[] args) {
        new JingDong19_1().run();
    }
}
