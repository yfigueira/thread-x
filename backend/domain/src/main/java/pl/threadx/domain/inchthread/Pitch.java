package pl.threadx.domain.inchthread;

import java.math.BigDecimal;
import java.math.RoundingMode;

class Pitch {

    private final BigDecimal p;

    private Pitch(BigDecimal p) {
        this.p = p;
    }

    /**
     * Returns the Pitch instance value.
     * */
    BigDecimal p() {
        return this.p;
    }

    /**
     * Returns a new Pitch instance, calculated as the reciprocal of the selected number of threads per inch.
     * The Pitch value precision is set to 8 decimal places.
     *
     * @param threadsPerInch the selected number of threads per inch.
     *
     * */
    static Pitch fromThreadsPerInch(BigDecimal threadsPerInch) {
        if (threadsPerInch.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Threads per inch value should be greater than zero.");
        }

        var value = BigDecimal.ONE
                .setScale(8, RoundingMode.HALF_UP)
                .divide(threadsPerInch, RoundingMode.HALF_UP);

        return new Pitch(value);
    }

    /**
     * Returns 1/8 of the Pitch instance value.
     * */
    BigDecimal p1_8() {
        return this.p().divide(BigDecimal.valueOf(8), RoundingMode.HALF_UP);
    }

    /**
     * Returns 1/4 of the Pitch instance value.
     * */
    BigDecimal p1_4() {
        return this.p().divide(BigDecimal.valueOf(4), RoundingMode.HALF_UP);
    }

    /**
     * Returns 1/2 of the Pitch instance value.
     * */
    BigDecimal p1_2() {
        return this.p().divide(BigDecimal.valueOf(2), RoundingMode.HALF_UP);
    }
}
