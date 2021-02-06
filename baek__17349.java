// import java.io.*;
// import java.util.*;

// class Pair {
// boolean is1;
// int x;

// Pair(boolean is1, int x) {
// this.is1 = is1;
// this.x = x;
// }
// }

// class Answer {
// boolean possible;
// int answer;

// Answer(boolean possible, int answer) {
// this.possible = possible;
// this.answer = answer;
// }

// }

// class baek__17349 {
// static Pair[] comments;
// static HashSet<Integer> answerSet = new HashSet<>();

// static void check(int target) {
// HashSet<Integer> possible = new HashSet<>();
// HashSet<Integer> impossible = new HashSet<>();

// for (int i = 0; i < 9; i++) {
// Pair comment = comments[i];
// if (i == target) {
// if (!comment.is1) {
// if (impossible.contains(comment.x))
// return;
// possible.add(comment.x);
// } else {
// if (possible.contains(comment.x))
// return;
// impossible.add(comment.x);
// }
// } else {
// if (comment.is1) {
// if (impossible.contains(comment.x))
// return;
// possible.add(comment.x);
// } else {
// if (possible.contains(comment.x))
// return;
// impossible.add(comment.x);
// }
// }
// }

// if (possible.size() == 1) {
// Iterator iterator = possible.iterator();
// answerSet.add((int) iterator.next());
// return;
// }
// if (possible.size() == 0 && impossible.size() <= 8) {
// for (int i = 1; i <= 9; i++) {
// if (!impossible.contains(i))
// answerSet.add(i);
// }
// }
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// comments = new Pair[9];
// String[] temp;
// for (int i = 0; i < 9; i++) {
// temp = br.readLine().split(" ");
// boolean is1 = Integer.parseInt(temp[0]) == 1 ? true : false;
// int x = Integer.parseInt(temp[1]);
// comments[i] = new Pair(is1, x);
// }

// for (int i = 0; i < 9; i++) {
// check(i);
// }

// if (answerSet.size() == 1) {
// Iterator iterator = answerSet.iterator();
// System.out.print(iterator.next());
// return;
// }
// System.out.print(-1);

// }
// }
