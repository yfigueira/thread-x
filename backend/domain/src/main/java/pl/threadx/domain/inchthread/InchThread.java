package pl.threadx.domain.inchthread;

import lombok.NonNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public sealed abstract class InchThread permits ExternalInchThread, InternalInchThread {

    private final ThreadSize threadSize;
    private final ThreadsPerInch threadsPerInch;
    private final ToleranceClass toleranceClass;
    private final ThreadSeries threadSeries;
    private final BasicProfile basicProfile;

    InchThread(ThreadSize threadSize, ThreadsPerInch threadsPerInch, ToleranceClass toleranceClass) {
        Objects.requireNonNull(threadSize);
        Objects.requireNonNull(threadsPerInch);
        Objects.requireNonNull(toleranceClass);

        this.threadSize = threadSize;
        this.threadsPerInch = threadsPerInch;
        this.toleranceClass = toleranceClass;
        this.threadSeries = ThreadSeriesMapper.map(threadSize, threadsPerInch);
        this.basicProfile = new BasicProfile(this.threadsPerInch, this.threadSize);
    }

    /**
     * Returns a new {@code InchThread}.
     * For external thread tolerance classes (1A, 2A or 3A), a new {@code ExternalInchThread} is returned.
     * For internal thread tolerance classes (1B, 2B or 3B), a new {@code InternalInchThread} is returned.
     *
     * @param threadSize this thread's size
     * @param threadsPerInch this thread's number of threads per inch
     * @param toleranceClass this thread's tolerance class
     *
     * @return new {@code InchThread} representation
     * */
    public static InchThread newInchThread(
            @NonNull ThreadSize threadSize,
            @NonNull ThreadsPerInch threadsPerInch,
            @NonNull ToleranceClass toleranceClass)
    {
        return switch (toleranceClass) {
            case _1A, _2A, _3A -> new ExternalInchThread(threadSize, threadsPerInch, toleranceClass);
            case _1B, _2B, _3B -> new InternalInchThread(threadSize, threadsPerInch, toleranceClass);
        };
    }

    /**
     * @return This thread's basic profile.
     * */
    public BasicProfile basicProfile() {
        return this.basicProfile;
    }

    ThreadSize threadSize() {
        return this.threadSize;
    }

    ThreadsPerInch threadsPerInch() {
        return this.threadsPerInch;
    }

    ToleranceClass toleranceClass() {
        return this.toleranceClass;
    }

    ThreadSeries threadSeries() {
        return this.threadSeries;
    }

    BigDecimal lengthOfEngagement() {
        return switch (threadSeries) {
            case UNC, UNF, _4UN, _6UN, _8UN ->
                new BigDecimal(threadSize.diameter()).setScale(4, RoundingMode.HALF_UP);

            case UNEF, _12UN, _16UN, _20UN, _28UN, _32UN ->
                    basicProfile.p().multiply(new BigDecimal("9")).setScale(4, RoundingMode.HALF_UP);
        };
    }
}
