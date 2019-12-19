package com.cloud.yanger.commons.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalUtils {

	/**
	 * 提供精确加法计算的add方法（例：1+2，1是被加数，2是加数）
	 * 
	 * @param value1
	 *            被加数
	 * @param value2
	 *            加数
	 * @return 两个参数的和
	 */
	public static Double add(Double value1, Double value2) {
		BigDecimal b1 = new BigDecimal(value1.toString());
		BigDecimal b2 = new BigDecimal(value2.toString());
		return b1.add(b2).doubleValue();
	}

	/**
	 * 提供精确减法运算的sub方法（例：1-2,1是被减数，2是减数）
	 *
	 * @param value1
	 *            被减数
	 * @param value2
	 *            减数
	 * @return 两个参数的差
	 */
	public static Double sub(Double value1, Double value2) {
		BigDecimal b1 = new BigDecimal(value1.toString());
		BigDecimal b2 = new BigDecimal(value2.toString());
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * 提供精确乘法运算的mul方法（例：1*2,1是被乘数，2是乘数）
	 *
	 * @param value1
	 *            被乘数
	 * @param value2
	 *            乘数
	 * @return 两个参数的积
	 */
	public static Double mul(Double value1, Double value2) {
		BigDecimal b1 = new BigDecimal(value1.toString());
		BigDecimal b2 = new BigDecimal(value2.toString());
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * 提供精确的除法运算方法div（例：1÷2，1是被除数，2是除数）
	 *
	 * @param value1
	 *            被除数
	 * @param value2
	 *            除数
	 * @param scale
	 *            精确范围
	 * @return 两个参数的商
	 */
	public static Double div(Double value1, Double value2, int scale) throws IllegalAccessException {
		// 如果精确范围小于0，抛出异常信息
		if (scale < 0) {
			throw new IllegalAccessException("精确度不能小于0");
		}
		BigDecimal b1 = new BigDecimal(value1.toString());
		BigDecimal b2 = new BigDecimal(value2.toString());
		// 指定枚举类型，可以指定RoundingMode的8种枚举类型之一，对这8种枚举类型如果有疑问，可以参考上面RoundingMode的总结和描述。
		// 这里指定的DOWN，对应RoundingMode的ROUND_DOWN模式，会直接舍去精确度后面的数值。
		return b1.divide(b2, scale, RoundingMode.DOWN).doubleValue();
	}

	/**
	 * BigDecimal多参数相加
	 * 
	 * @param value
	 *            第一个参数
	 * @param valuen
	 *            多个参数
	 * @author wangzx
	 */
	public static Double safeAdd(Double value, Double... valuen) {
		BigDecimal b1 = new BigDecimal(value.toString());
		BigDecimal[] bn = new BigDecimal[valuen.length];
		for (int i = 0; i < valuen.length; i++) {
			bn[i] = new BigDecimal(valuen[i].toString());
		}
		for (BigDecimal b : bn) {
			b1 = b1.add(null == b ? BigDecimal.ZERO : b);
		}
		return b1.doubleValue();
	}

}
