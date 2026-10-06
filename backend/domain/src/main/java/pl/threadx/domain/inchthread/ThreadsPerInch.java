package pl.threadx.domain.inchthread;

import java.math.BigDecimal;

public enum ThreadsPerInch {
    _4("4"),
    _4_1I2("4.5"),
    _5("5"),
    _6("6"),
    _7("7"),
    _8("8"),
    _9("9"),
    _10("10"),
    _11("11"),
    _12("12"),
    _13("13"),
    _14("14"),
    _16("16"),
    _18("18"),
    _20("20"),
    _24("24"),
    _28("28"),
    _32("32"),
    _36("36"),
    _40("40"),
    _44("44"),
    _48("48"),
    _56("56"),
    _64("64"),
    _72("72"),
    _80("80")
    ;

    private final String value;

    ThreadsPerInch(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public BigDecimal numValue() {
        return new BigDecimal(this.value);
    }
}
