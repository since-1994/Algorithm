// import java.io.*;
// import java.util.*;

// class Hw {
// int h1;
// int w1;
// int h2;
// int w2;

// Hw(int h1, int w1, int h2, int w2) {
// this.h1 = h1;
// this.w1 = w1;
// this.h2 = h2;
// this.w2 = w2;
// }
// }

// class Sticker {
// int h;
// int w;

// Sticker(int h, int w) {
// this.h = h;
// this.w = w;
// }
// }

// class baek__16937 {

// static Hw getSwap(Sticker st1, Sticker st2, int k) {
// if (k == 0) {
// return new Hw(st1.h, st1.w, st2.h, st2.w);
// } else if (k == 1) {
// return new Hw(st1.w, st1.h, st2.h, st2.w);
// } else if (k == 2) {
// return new Hw(st1.w, st1.h, st2.w, st2.h);
// } else {
// return new Hw(st1.h, st1.w, st2.w, st2.h);
// }
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// String[] temp = br.readLine().split(" ");
// int h = Integer.parseInt(temp[0]);
// int w = Integer.parseInt(temp[1]);

// int n = Integer.parseInt(br.readLine());

// Sticker[] stickers = new Sticker[n];

// for (int i = 0; i < n; i++) {
// temp = br.readLine().split(" ");
// stickers[i] = new Sticker(Integer.parseInt(temp[0]),
// Integer.parseInt(temp[1]));
// }

// int ans = 0;

// for (int i = 0; i < n - 1; i++) {
// for (int j = i + 1; j < n; j++) {
// for (int k = 0; k < 4; k++) {
// Hw hw = getSwap(stickers[i], stickers[j], k);

// int h1 = hw.h1;
// int w1 = hw.w1;
// int h2 = hw.h2;
// int w2 = hw.w2;

// // 세로
// if (h1 + h2 <= h && Math.max(w1, w2) <= w) {
// ans = Math.max(ans, h1 * w1 + h2 * w2);
// }

// // 가로
// if (w1 + w2 <= w && Math.max(h1, h2) <= h) {
// ans = Math.max(ans, h1 * w1 + h2 * w2);
// }
// }

// }
// }

// System.out.print(ans);

// }
// }