package pl.threadx.domain.inchthread;

import lombok.NonNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * This class represents the basic profile of an inch screw thread, as described in the ISO 68-2 standard.
 * Names and symbols used in this class conform to the ISO 68-2 standard.
 * */
public class BasicProfile {

    private final ThreadsPerInch threadsPerInch;

    BasicProfile(@NonNull ThreadsPerInch threadsPerInch) {
        this.threadsPerInch = threadsPerInch;
    }

    /**
     * @return This basic profile's Pitch (P) value, calculated as the reciprocal of this profile's number of threads per inch.
     * The pitch value precision is set to 8 decimal places.
     * */
    public BigDecimal p() {
        return BigDecimal.ONE
                .setScale(8, RoundingMode.HALF_UP)
                .divide(this.threadsPerInch.numValue(), RoundingMode.HALF_UP);
    }

    /**
     * @return 1/8 of this basic profile's pitch value (P/8), rounded to 6 decimal places.
     * */
    public BigDecimal p1I8() {
        return p().divide(new BigDecimal("8"), RoundingMode.HALF_UP)
                .setScale(6, RoundingMode.HALF_UP);
    }

    /**
     * @return 1/4 of this basic profile's pitch value (P/4), rounded to 6 decimal places.
     * */
    public BigDecimal p1I4() {
        return p().divide(new BigDecimal("4"), RoundingMode.HALF_UP)
                .setScale(6, RoundingMode.HALF_UP);
    }

    /**
     * @return 1/2 of this basic profile's pitch value (P/2), rounded to 6 decimal places.
     * */
    public BigDecimal p1I2() {
        return p().divide(new BigDecimal("2"), RoundingMode.HALF_UP)
                .setScale(6, RoundingMode.HALF_UP);
    }

    /**
     * @return The height (H) value of this basic profile's fundamental triangle.
     * The height value precision is set to 6 decimal places.
     * */
    public BigDecimal h() {
        return new BigDecimal("0.866025404")
                .multiply(this.p())
                .setScale(6, RoundingMode.HALF_UP);
    }

    /**
     * @return 1/8 of the height value (H/8) of this basic profile's fundamental triangle.
     * */
    public BigDecimal h1I8() {
        return new BigDecimal("0.125")
                .multiply((this.h()))
                .setScale(6, RoundingMode.HALF_UP);
    }

    /**
     * @return 1/4 of the height value (H/4) of this basic profile's fundamental triangle.
     * */
    public BigDecimal h1I4() {
        return new BigDecimal("0.25")
                .multiply((this.h()))
                .setScale(6, RoundingMode.HALF_UP);
    }

    /**
     * @return 3/8 of the height value (3/8H) of this basic profile's fundamental triangle.
     * */
    public BigDecimal h3I8() {
        return new BigDecimal("0.375")
                .multiply((this.h()))
                .setScale(6, RoundingMode.HALF_UP);
    }

    /**
     * @return 1/2 of the height value (H/2) of this basic profile's fundamental triangle.
     * */
    public BigDecimal h1I2() {
        return new BigDecimal("0.5")
                .multiply((this.h()))
                .setScale(6, RoundingMode.HALF_UP);
    }

    /**
     * @return 5/8 of the height value (5/8H) of this basic profile's fundamental triangle.
     * */
    public BigDecimal h5I8() {
        return new BigDecimal("0.625")
                .multiply((this.h()))
                .setScale(6, RoundingMode.HALF_UP);
    }
}
