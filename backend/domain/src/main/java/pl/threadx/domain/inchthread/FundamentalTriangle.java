package pl.threadx.domain.inchthread;

import java.math.BigDecimal;
import java.math.RoundingMode;

class FundamentalTriangle {

    private final BigDecimal h;

    private FundamentalTriangle(BigDecimal h) {
        this.h = h;
    }

    /**
     * Returns the FundamentalTriangle instance height value.
     * */
    BigDecimal h() {
        return this.h;
    }

    /**
     * Returns a new FundamentalTriangle instance, calculated for the provided {@code Pitch}.
     * The FundamentalTriangle value precision is set to 6 decimal places.
     *
     * @param pitch the pitch this fundamental triangle is calculated for.
     *
     * */
    static FundamentalTriangle forPitch(Pitch pitch) {
        if (pitch == null) {
            throw new IllegalArgumentException("Pitch cannot be null.");
        }

        var height = new BigDecimal("0.866025404")
                .multiply(pitch.value())
                .setScale(6, RoundingMode.HALF_UP);

        return new FundamentalTriangle(height);
    }
}
