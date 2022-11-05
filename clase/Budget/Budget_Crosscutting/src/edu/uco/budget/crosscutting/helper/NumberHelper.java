package edu.uco.budget.crosscutting.helper;

import static edu.uco.budget.crosscutting.helper.ObjectHelper.getDefaultIfNull;

public final class NumberHelper {

	public static final byte ZERO = 0;

	private NumberHelper() {
		super();
	}

	public static final <T extends Number> T getDefaultNumber(T value, T defaultValue) {
		return getDefaultIfNull(value, defaultValue);
	}

	public static final <T extends Number> Number getDefaultNumber(T value) {
		return getDefaultNumber(value, ZERO);
	}

	public static final <T extends Number> boolean isGreaterThan(T numberOne, T numberTwo) {
		return getDefaultNumber(numberOne).doubleValue() > getDefaultNumber(numberTwo).doubleValue();
	}

	public static final <T extends Number> boolean isLessThan(T numberOne, T numberTwo) {
		return getDefaultNumber(numberOne).doubleValue() < getDefaultNumber(numberTwo).doubleValue();
	}

	public static final <T extends Number> boolean isEqualsThan(T numberOne, T numberTwo) {
		return getDefaultNumber(numberOne).doubleValue() == getDefaultNumber(numberTwo).doubleValue();
	}

	public static final <T extends Number> boolean isGreaterOrEqualsThan(T numberOne, T numberTwo) {
		return getDefaultNumber(numberOne).doubleValue() >= getDefaultNumber(numberTwo).doubleValue();
	}

	public static final <T extends Number> boolean isLessOrEqualsThan(T numberOne, T numberTwo) {
		return getDefaultNumber(numberOne).doubleValue() <= getDefaultNumber(numberTwo).doubleValue();
	}

	public static final <T extends Number> boolean isDifferentThan(T numberOne, T numberTwo) {
		return !isEqualsThan(numberOne, numberTwo);
	}

	public static final <T extends Number> byte getByte(T number) {
		return getDefaultNumber(number).byteValue();
	}

	public static final <T extends Number> short getShort(T number) {
		return getDefaultNumber(number).shortValue();
	}

	public static final <T extends Number> int getInt(T number) {
		return getDefaultNumber(number).intValue();
	}

	public static final <T extends Number> long getLong(T number) {
		return getDefaultNumber(number).longValue();
	}

	public static final <T extends Number> float getFloat(T number) {
		return getDefaultNumber(number).floatValue();
	}

	public static final <T extends Number> double getDouble(T number) {
		return getDefaultNumber(number).doubleValue();
	}
}