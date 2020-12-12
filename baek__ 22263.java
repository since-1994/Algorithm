import java.io.*;
import java.util.*;

class baek__2263 {
    static int[] inorder;
    static int[] postorder;
    static int[] position;
    static StringBuilder sb = new StringBuilder();

    static void solve(int inorder_start, int inorder_end, int postorder_start, int postorder_end) {
        if (inorder_start > inorder_end || postorder_start > postorder_end)
            return;
        int root = postorder[postorder_end];
        int l = position[root] - inorder_start;
        int r = inorder_end - position[root];

        sb.append(root + " ");
        solve(inorder_start, position[root] - 1, postorder_start, postorder_start + l - 1);
        solve(position[root] + 1, inorder_end, postorder_end - r, postorder_end - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        inorder = new int[n + 1];
        postorder = new int[n + 1];
        position = new int[n + 1];

        String[] temp = br.readLine().split(" ");

        for (int i = 1; i < n + 1; i++) {
            inorder[i] = Integer.parseInt(temp[i - 1]);
            position[inorder[i]] = i;
        }

        temp = br.readLine().split(" ");

        for (int i = 1; i < n + 1; i++) {
            postorder[i] = Integer.parseInt(temp[i - 1]);
        }

        solve(1, n, 1, n);

        System.out.print(sb);
    }
}