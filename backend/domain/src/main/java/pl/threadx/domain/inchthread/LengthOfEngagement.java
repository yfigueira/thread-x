package pl.threadx.domain.inchthread;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LengthOfEngagement {

    private final BigDecimal length;

    private LengthOfEngagement(BigDecimal length) {
        this.length = length;
    }

    /**
     * This should be used to calculate the default length of engagement for thread series
     * UNC, UNF, 4 UN, 6 UN and 8 UN.
     * */
    public static LengthOfEngagement forThreadSize(ThreadSize size) {
        var len = new BigDecimal(size.diameter()).setScale(4, RoundingMode.HALF_UP);
        return new LengthOfEngagement(len);
    }

    /**
     * This should be used to calculate the default length engagement for thread series
     * UNEF, 12 UN, 16 UN, 20 UN, 28 UN and 32 UN.
     * */
    public static LengthOfEngagement forPitch(Pitch pitch) {
        var len = pitch.p().multiply(new BigDecimal("9")).setScale(4, RoundingMode.HALF_UP);
        return new LengthOfEngagement(len);
    }

    public BigDecimal length() {
        return this.length;
    }
}
