package org.zee.ttt;

public enum Value {
    /**
     * X
     */
    CROSS("X"),

    /**
     * O
     */
    NAUGHT("0"),

    /**
     * No value yet
     */
    EMPTY("-");

    String displayValue;

    Value(String displayValue) {
        this.displayValue = displayValue;
    }

    @Override
    public String toString() {
        return displayValue;
    }
}
