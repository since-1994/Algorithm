// import java.io.*;
// import java.util.*;

// class Pair {
// int height;
// int quantity;

// Pair(int height, int quantity) {
// this.height = height;
// this.quantity = quantity;
// }
// }

// class baek__3015 {

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// int n = Integer.parseInt(br.readLine());

// int[] heights = new int[n];

// for (int i = 0; i < n; i++) {
// heights[i] = Integer.parseInt(br.readLine());
// }

// Stack<Pair> stack = new Stack<>();

// long answer = 0;

// for (int i = 0; i < n; i++) {
// if (stack.empty()) {
// stack.add(new Pair(heights[i], 1));
// } else {
// while (!stack.empty() && stack.peek().height < heights[i]) {
// Pair now = stack.pop();
// answer += now.quantity;
// }
// if (stack.empty()) {
// stack.add(new Pair(heights[i], 1));
// } else if (stack.peek().height == heights[i]) {
// Pair now = stack.pop();
// answer += now.quantity;
// if (!stack.empty()) {
// answer += 1;
// }
// stack.add(new Pair(heights[i], now.quantity + 1));
// } else if (stack.peek().height > heights[i]) {
// stack.add(new Pair(heights[i], 1));
// answer += 1;
// }
// }
// }

// System.out.print(answer);

// }
// }