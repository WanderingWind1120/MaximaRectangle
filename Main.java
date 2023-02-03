package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int ans = 0, m = matrix.length, n = matrix[0].length;
        // declare m là độ dài của array mẹ , n là độ dài của array con
        int[] height = new int[n]; // height

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    height[j] = 0;
                    continue; // dính if statement này là đẩy lên vòng loop tiếp theo luôn
                }
                height[j]++; // Loop từng hàng trong matrix xem độ độ cao lớn nhất của phần tử  1 ở từng vị trị cột
                // nếu phần tử 0 xen giữa
                // đặt lại giá trị của phần tử height vị trí thứ j trong boolean về 0
                for (int cur = j - 1, pre = height[j]; cur >= 0; cur--) {
                    if (height[cur] == 0) break; // nếu dính if statement này thì trong
                    // cái hình chữ nhật đăng xét nó có cứa phần tử '0' cho nên nó không còn là rectangle thỏa mãn
                    // nữa
                    // loop lùi hàng các cột đằng trước xem độ cao của các ô 1 là bao nhiêu
                    pre = Math.min(pre, height[cur]); // Tìm chiều cao thực tế của rectangle
                    // bằng cách tìm min độ cao các cột đang được loop
                    ans = Math.max(ans, (j - cur + 1) * pre); // tính phần chung của các cột 1
                    // tính diện tính của hình chữ nhật trong vòng loop hiện tại và tìm max so với kết quả
                    // của vòng loop trước đó
                }
                ans = Math.max(ans, height[j]); // cột cái phần tử 1 liên tiếp cũng là một rectangle cho nên
                // cần so để tìm ra giá trị lớn nhất của ans sau mỗi vòng loop
            }
        }
        return ans;
    }
}