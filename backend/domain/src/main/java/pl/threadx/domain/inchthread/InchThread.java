package pl.threadx.domain.inchthread;

import lombok.Getter;
import lombok.NonNull;

import java.util.Objects;

@Getter
public sealed abstract class InchThread permits ExternalInchThread, InternalInchThread {

    private final ThreadSize threadSize;
    private final ThreadsPerInch threadsPerInch;
    private final ToleranceClass toleranceClass;
    private final ThreadSeries threadSeries;

    InchThread(ThreadSize threadSize, ThreadsPerInch threadsPerInch, ToleranceClass toleranceClass) {
        Objects.requireNonNull(threadSize);
        Objects.requireNonNull(threadsPerInch);
        Objects.requireNonNull(toleranceClass);

        this.threadSize = threadSize;
        this.threadsPerInch = threadsPerInch;
        this.toleranceClass = toleranceClass;
        this.threadSeries = mapThreadSeries();
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

    private ThreadSeries mapThreadSeries() {
        var mapper = new ThreadSeriesMapper();
        return mapper.mapSeriesFor(this.threadSize, this.threadsPerInch);
    }
}
