// import java.io.*;
// import java.util.*;

// class baek__2263 {
// static int[] inorder;
// static int[] postorder;
// static int[] position;
// static StringBuilder sb = new StringBuilder();

// static void solve(int inorder_start, int inorder_end, int postorder_start,
// int postorder_end) {
// if (inorder_start > inorder_end || postorder_start > postorder_end)
// return;
// int root = postorder[postorder_end];
// int l = position[root] - inorder_start;
// int r = inorder_end - position[root];

// sb.append(root + " ");
// solve(inorder_start, position[root] - 1, postorder_start, postorder_start + l
// - 1);
// solve(position[root] + 1, inorder_end, postorder_end - r, postorder_end - 1);
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// int n = Integer.parseInt(br.readLine());

// inorder = new int[n + 1];
// postorder = new int[n + 1];
// position = new int[n + 1];

// String[] temp = br.readLine().split(" ");

// for (int i = 1; i < n + 1; i++) {
// inorder[i] = Integer.parseInt(temp[i - 1]);
// position[inorder[i]] = i;
// }

// temp = br.readLine().split(" ");

// for (int i = 1; i < n + 1; i++) {
// postorder[i] = Integer.parseInt(temp[i - 1]);
// }

// solve(1, n, 1, n);

// System.out.print(sb);
// }
// }

import java.io.*;
import java.util.*;

class baek__2263 {
    static int[] preOrder;
    static int[] postOrder;
    static int[] index;
    static StringBuilder sb = new StringBuilder();

    static void go(int preStart, int preEnd, int postStart, int postEnd) {

        if (preStart > preEnd || postStart > postEnd)
            return;

        int root = postOrder[postEnd];
        int rootIndex = index[root];

        System.out.print(root + " ");
        int sizeL = rootIndex - preStart;
        int sizeR = preEnd - rootIndex;

        go(preStart, rootIndex - 1, postStart, postStart + sizeL - 1);
        go(rootIndex + 1, preEnd, postEnd - sizeR, postEnd - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        preOrder = new int[n];
        postOrder = new int[n];
        index = new int[n + 1];

        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            preOrder[i] = Integer.parseInt(temp[i]);
            index[preOrder[i]] = i;
        }

        temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(temp[i]);
        }

        go(0, n - 1, 0, n - 1);

        System.out.print(sb);
    }
}