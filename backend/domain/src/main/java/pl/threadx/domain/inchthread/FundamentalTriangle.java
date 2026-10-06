package pl.threadx.domain.inchthread;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FundamentalTriangle {

    private final BigDecimal h;

    private FundamentalTriangle(BigDecimal h) {
        this.h = h;
    }

    /**
     * Returns the FundamentalTriangle instance height value.
     * */
    public BigDecimal h() {
        return this.h;
    }

    /**
     * Returns a new FundamentalTriangle instance, calculated for the provided {@code Pitch}.
     * The FundamentalTriangle value precision is set to 6 decimal places.
     *
     * @param pitch the pitch this fundamental triangle is calculated for.
     *
     * */
    public static FundamentalTriangle forPitch(Pitch pitch) {
        if (pitch == null) {
            throw new IllegalArgumentException("Pitch cannot be null.");
        }

        var height = new BigDecimal("0.866025404")
                .multiply(pitch.p())
                .setScale(6, RoundingMode.HALF_UP);

        return new FundamentalTriangle(height);
    }

    /**
     * Returns 1/8 of the FundamentalTriangle instance height value.
     * */
    public BigDecimal h1_8() {
        return hMultipliedBy("0.125");
    }

    /**
     * Returns 1/4 of the FundamentalTriangle instance height value.
     * */
    public BigDecimal h1_4() {
        return hMultipliedBy("0.25");
    }

    /**
     * Returns 3/8 of the FundamentalTriangle instance height value.
     * */
    public BigDecimal h3_8() {
        return hMultipliedBy("0.375");
    }

    /**
     * Returns 1/2 of the FundamentalTriangle instance height value.
     * */
    public BigDecimal h1_2() {
        return hMultipliedBy("0.5");
    }

    /**
     * Returns 5/8 of the FundamentalTriangle instance height value.
     * */
    public BigDecimal h5_8() {
        return hMultipliedBy("0.625");
    }

    private BigDecimal hMultipliedBy(String multiplier) {
        return new BigDecimal(multiplier)
                .multiply((this.h))
                .setScale(6, RoundingMode.HALF_UP);
    }
}
