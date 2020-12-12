# algorithm

알고리즘 공부를 합시다.

## 분할 정복

<details>
    <summary>1074</summary>
    <div markdown = "1">
      1074는 쉬운 문제이지만 까다로운 부분이 시간과 메모리 관리이다. 분할 정복을 사용하여서 하지 않아도 되는 것은 쳐내는게 매우 중요하다.
      
      ```java
        static void solve(int x, int y, int n) {
        if (n == 1) {
            return;
        }

        int m = n / 2;

        if (r >= x && r < x + m && c >= y && c < y + m) {
            solve(x, y, m);
            return;
        } else {
            answer += (m * m);
        }
        y += (n / 2);
        if (r >= x && r < x + m && c >= y && c < y + m) {
            solve(x, y, m);
            return;
        } else {
            answer += (m * m);
        }
        y -= (n / 2);
        x += (n / 2);
        if (r >= x && r < x + m && c >= y && c < y + m) {
            solve(x, y, m);
            return;
        } else {
            answer += (m * m);
        }
        y += (n / 2);
        if (r >= x && r < x + m && c >= y && c < y + m) {
            solve(x, y, m);
            return;
        } else {
            answer += (m * m);
        }
    }
    ```

    </div>

</details>
