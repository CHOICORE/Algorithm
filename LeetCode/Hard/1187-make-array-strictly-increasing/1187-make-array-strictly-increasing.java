class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        int L1 = arr1.length, L2 = arr2.length;
        int[][] stack = new int[L1 + 1][2];
        stack[0][0] = -1000;
        stack[0][1] = 0;
        int top = 0;

        int[][] tmp = new int[L1 + 1][2];
        int t2 = -1;

        Arrays.sort(arr2);

        for (int k : arr1) {

            int i2 = 0, j = 0;
            while (i2 < L2 && j <= top) {
                int cur = arr2[i2];

                if (cur <= stack[j][0]) {
                    ++i2;
                    continue;
                }

                while (j + 1 <= top && cur > stack[j + 1][0]) ++j;
                ++t2;
                tmp[t2][0] = cur;
                tmp[t2][1] = stack[j][1] + 1;

                ++i2;
                ++j;
            }

            while (top >= 0 && stack[top][0] >= k) --top;
            if (top >= 0) {
                int x = stack[top][1];

                int u = 0;
                top = -1;

                while (u <= t2 && tmp[u][0] < k) {
                    ++top;
                    stack[top][0] = tmp[u][0];
                    stack[top][1] = tmp[u][1];
                    ++u;
                }

                ++top;
                stack[top][0] = k;
                stack[top][1] = x;

                while (u <= t2 && tmp[u][1] >= x) ++u;

                while (u <= t2) {
                    ++top;
                    stack[top][0] = tmp[u][0];
                    stack[top][1] = tmp[u][1];
                    ++u;
                }
            } else {
                // top==-1
                for (int u = 0; u <= t2; u++) {
                    ++top;
                    stack[top][0] = tmp[u][0];
                    stack[top][1] = tmp[u][1];
                }

            }

            t2 = -1;

            if (top < 0) break;
        }

        return top >= 0 ? stack[top][1] : -1;
    }
}
