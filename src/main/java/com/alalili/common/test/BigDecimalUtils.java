package com.alalili.common.test;

import java.math.BigDecimal;

public class BigDecimalUtils {
    public static void main(String[] args) {
        BigDecimal num1 = new BigDecimal("92.00");
        BigDecimal num2 = new BigDecimal("72.011");

        BigDecimal result = num1.subtract(num2);

        // 设置小数点后两位并四舍五入
        result = result.setScale(2, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();

        System.out.println("差值四舍五入后为: " + result);
    }
}
