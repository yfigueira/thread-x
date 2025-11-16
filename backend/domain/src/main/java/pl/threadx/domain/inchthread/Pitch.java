package pl.threadx.domain.inchthread;

import java.math.BigDecimal;

class Pitch {

    private final BigDecimal value;

    private Pitch(BigDecimal value) {
        this.value = value;
    }

    static Pitch fromThreadsPerInch(BigDecimal threadsPerInch) {
        if (threadsPerInch.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Threads per inch value should be greater than zero.");
        }
        return null;
    }
}
