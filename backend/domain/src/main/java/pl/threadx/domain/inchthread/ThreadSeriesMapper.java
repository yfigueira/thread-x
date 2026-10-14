package pl.threadx.domain.inchthread;

import lombok.NonNull;

import java.util.Map;

public class ThreadSeriesMapper {

    private static final Map<String, ThreadSeries> MAPPINGS = Map.<String, ThreadSeries>ofEntries(
        Map.entry("Nr 0-80", ThreadSeries.UNF),

        Map.entry("Nr 1-64", ThreadSeries.UNC),
        Map.entry("Nr 1-72", ThreadSeries.UNF),

        Map.entry("Nr 2-56", ThreadSeries.UNC),
        Map.entry("Nr 2-64", ThreadSeries.UNF),

        Map.entry("Nr 3-48", ThreadSeries.UNC),
        Map.entry("Nr 3-56", ThreadSeries.UNF),

        Map.entry("Nr 4-40", ThreadSeries.UNC),
        Map.entry("Nr 4-48", ThreadSeries.UNF),

        Map.entry("Nr 5-40", ThreadSeries.UNC),
        Map.entry("Nr 5-44", ThreadSeries.UNF),

        Map.entry("Nr 6-32", ThreadSeries.UNC),
        Map.entry("Nr 6-40", ThreadSeries.UNF),

        Map.entry("Nr 8-32", ThreadSeries.UNC),
        Map.entry("Nr 8-36", ThreadSeries.UNF),

        Map.entry("Nr 10-24", ThreadSeries.UNC),
        Map.entry("Nr 10-32", ThreadSeries.UNF),

        Map.entry("Nr 12-24", ThreadSeries.UNC),
        Map.entry("Nr 12-28", ThreadSeries.UNF),
        Map.entry("Nr 12-32", ThreadSeries.UNEF),

        Map.entry("1/4-20", ThreadSeries.UNC),
        Map.entry("1/4-28", ThreadSeries.UNF),
        Map.entry("1/4-32", ThreadSeries.UNEF),

        Map.entry("5/16-18", ThreadSeries.UNC),
        Map.entry("5/16-24", ThreadSeries.UNF),
        Map.entry("5/16-32", ThreadSeries.UNEF),
        Map.entry("5/16-20", ThreadSeries._20UN),
        Map.entry("5/16-28", ThreadSeries._28UN),

        Map.entry("3/8-16", ThreadSeries.UNC),
        Map.entry("3/8-24", ThreadSeries.UNF),
        Map.entry("3/8-32", ThreadSeries.UNEF),
        Map.entry("3/8-20", ThreadSeries._20UN),
        Map.entry("3/8-28", ThreadSeries._28UN),

        Map.entry("7/16-14", ThreadSeries.UNC),
        Map.entry("7/16-20", ThreadSeries.UNF),
        Map.entry("7/16-28", ThreadSeries.UNEF),
        Map.entry("7/16-16", ThreadSeries._16UN),
        Map.entry("7/16-32", ThreadSeries._32UN),

        Map.entry("1/2-13", ThreadSeries.UNC),
        Map.entry("1/2-20", ThreadSeries.UNF),
        Map.entry("1/2-28", ThreadSeries.UNEF),
        Map.entry("1/2-16", ThreadSeries._16UN),
        Map.entry("1/2-32", ThreadSeries._32UN),

        Map.entry("9/16-12", ThreadSeries.UNC),
        Map.entry("9/16-18", ThreadSeries.UNF),
        Map.entry("9/16-24", ThreadSeries.UNEF),
        Map.entry("9/16-16", ThreadSeries._16UN),
        Map.entry("9/16-20", ThreadSeries._20UN),
        Map.entry("9/16-28", ThreadSeries._28UN),
        Map.entry("9/16-32", ThreadSeries._32UN),

        Map.entry("5/8-11", ThreadSeries.UNC),
        Map.entry("5/8-18", ThreadSeries.UNF),
        Map.entry("5/8-24", ThreadSeries.UNEF),
        Map.entry("5/8-12", ThreadSeries._12UN),
        Map.entry("5/8-16", ThreadSeries._16UN),
        Map.entry("5/8-20", ThreadSeries._20UN),
        Map.entry("5/8-28", ThreadSeries._28UN),
        Map.entry("5/8-32", ThreadSeries._32UN),

        Map.entry("11/16-24", ThreadSeries.UNEF),
        Map.entry("11/16-12", ThreadSeries._12UN),
        Map.entry("11/16-16", ThreadSeries._16UN),
        Map.entry("11/16-20", ThreadSeries._20UN),
        Map.entry("11/16-28", ThreadSeries._28UN),
        Map.entry("11/16-32", ThreadSeries._32UN),

        Map.entry("3/4-10", ThreadSeries.UNC),
        Map.entry("3/4-16", ThreadSeries.UNF),
        Map.entry("3/4-20", ThreadSeries.UNEF),
        Map.entry("3/4-12", ThreadSeries._12UN),
        Map.entry("3/4-28", ThreadSeries._28UN),
        Map.entry("3/4-32", ThreadSeries._32UN),

        Map.entry("13/16-20", ThreadSeries.UNEF),
        Map.entry("13/16-12", ThreadSeries._12UN),
        Map.entry("13/16-16", ThreadSeries._16UN),
        Map.entry("13/16-28", ThreadSeries._28UN),
        Map.entry("13/16-32", ThreadSeries._32UN),

        Map.entry("7/8-9", ThreadSeries.UNC),
        Map.entry("7/8-14", ThreadSeries.UNF),
        Map.entry("7/8-20", ThreadSeries.UNEF),
        Map.entry("7/8-12", ThreadSeries._12UN),
        Map.entry("7/8-16", ThreadSeries._16UN),
        Map.entry("7/8-28", ThreadSeries._28UN),
        Map.entry("7/8-32", ThreadSeries._32UN),

        Map.entry("15/16-20", ThreadSeries.UNEF),
        Map.entry("15/16-12", ThreadSeries._12UN),
        Map.entry("15/16-16", ThreadSeries._16UN),
        Map.entry("15/16-28", ThreadSeries._28UN),
        Map.entry("15/16-32", ThreadSeries._32UN),

        Map.entry("1-8", ThreadSeries.UNC),
        Map.entry("1-12", ThreadSeries.UNF),
        Map.entry("1-20", ThreadSeries.UNEF),
        Map.entry("1-16", ThreadSeries._16UN),
        Map.entry("1-28", ThreadSeries._28UN),
        Map.entry("1-32", ThreadSeries._32UN),

        Map.entry("1 1/16-18", ThreadSeries.UNEF),
        Map.entry("1 1/16-8", ThreadSeries._8UN),
        Map.entry("1 1/16-12", ThreadSeries._12UN),
        Map.entry("1 1/16-16", ThreadSeries._16UN),
        Map.entry("1 1/16-20", ThreadSeries._20UN),
        Map.entry("1 1/16-28", ThreadSeries._28UN),

        Map.entry("1 1/8-7", ThreadSeries.UNC),
        Map.entry("1 1/8-12", ThreadSeries.UNF),
        Map.entry("1 1/8-18", ThreadSeries.UNEF),
        Map.entry("1 1/8-8", ThreadSeries._8UN),
        Map.entry("1 1/8-16", ThreadSeries._16UN),
        Map.entry("1 1/8-20", ThreadSeries._20UN),
        Map.entry("1 1/8-28", ThreadSeries._28UN),

        Map.entry("1 3/16-18", ThreadSeries.UNEF),
        Map.entry("1 3/16-8", ThreadSeries._8UN),
        Map.entry("1 3/16-12", ThreadSeries._12UN),
        Map.entry("1 3/16-16", ThreadSeries._16UN),
        Map.entry("1 3/16-20", ThreadSeries._20UN),
        Map.entry("1 3/16-28", ThreadSeries._28UN),

        Map.entry("1 1/4-7", ThreadSeries.UNC),
        Map.entry("1 1/4-12", ThreadSeries.UNF),
        Map.entry("1 1/4-18", ThreadSeries.UNEF),
        Map.entry("1 1/4-8", ThreadSeries._8UN),
        Map.entry("1 1/4-16", ThreadSeries._16UN),
        Map.entry("1 1/4-20", ThreadSeries._20UN),
        Map.entry("1 1/4-28", ThreadSeries._28UN),

        Map.entry("1 5/16-18", ThreadSeries.UNEF),
        Map.entry("1 5/16-8", ThreadSeries._8UN),
        Map.entry("1 5/16-12", ThreadSeries._12UN),
        Map.entry("1 5/16-16", ThreadSeries._16UN),
        Map.entry("1 5/16-20", ThreadSeries._20UN),
        Map.entry("1 5/16-28", ThreadSeries._28UN),

        Map.entry("1 3/8-6", ThreadSeries.UNC),
        Map.entry("1 3/8-12", ThreadSeries.UNF),
        Map.entry("1 3/8-18", ThreadSeries.UNEF),
        Map.entry("1 3/8-8", ThreadSeries._8UN),
        Map.entry("1 3/8-16", ThreadSeries._16UN),
        Map.entry("1 3/8-20", ThreadSeries._20UN),
        Map.entry("1 3/8-28", ThreadSeries._28UN),

        Map.entry("1 7/16-18", ThreadSeries.UNEF),
        Map.entry("1 7/16-6", ThreadSeries._6UN),
        Map.entry("1 7/16-8", ThreadSeries._8UN),
        Map.entry("1 7/16-12", ThreadSeries._12UN),
        Map.entry("1 7/16-16", ThreadSeries._16UN),
        Map.entry("1 7/16-20", ThreadSeries._20UN),
        Map.entry("1 7/16-28", ThreadSeries._28UN),

        Map.entry("1 1/2-6", ThreadSeries.UNC),
        Map.entry("1 1/2-12", ThreadSeries.UNF),
        Map.entry("1 1/2-18", ThreadSeries.UNEF),
        Map.entry("1 1/2-8", ThreadSeries._8UN),
        Map.entry("1 1/2-16", ThreadSeries._16UN),
        Map.entry("1 1/2-20", ThreadSeries._20UN),
        Map.entry("1 1/2-28", ThreadSeries._28UN),

        Map.entry("1 9/16-18", ThreadSeries.UNEF),
        Map.entry("1 9/16-6", ThreadSeries._6UN),
        Map.entry("1 9/16-8", ThreadSeries._8UN),
        Map.entry("1 9/16-12", ThreadSeries._12UN),
        Map.entry("1 9/16-16", ThreadSeries._16UN),
        Map.entry("1 9/16-20", ThreadSeries._20UN),

        Map.entry("1 5/8-18", ThreadSeries.UNEF),
        Map.entry("1 5/8-6", ThreadSeries._6UN),
        Map.entry("1 5/8-8", ThreadSeries._8UN),
        Map.entry("1 5/8-12", ThreadSeries._12UN),
        Map.entry("1 5/8-16", ThreadSeries._16UN),
        Map.entry("1 5/8-20", ThreadSeries._20UN),

        Map.entry("1 11/16-18", ThreadSeries.UNEF),
        Map.entry("1 11/16-6", ThreadSeries._6UN),
        Map.entry("1 11/16-8", ThreadSeries._8UN),
        Map.entry("1 11/16-12", ThreadSeries._12UN),
        Map.entry("1 11/16-16", ThreadSeries._16UN),
        Map.entry("1 11/16-20", ThreadSeries._20UN),

        Map.entry("1 3/4-5", ThreadSeries.UNC),
        Map.entry("1 3/4-6", ThreadSeries._6UN),
        Map.entry("1 3/4-8", ThreadSeries._8UN),
        Map.entry("1 3/4-12", ThreadSeries._12UN),
        Map.entry("1 3/4-16", ThreadSeries._16UN),
        Map.entry("1 3/4-20", ThreadSeries._20UN),

        Map.entry("1 13/16-6", ThreadSeries._6UN),
        Map.entry("1 13/16-8", ThreadSeries._8UN),
        Map.entry("1 13/16-12", ThreadSeries._12UN),
        Map.entry("1 13/16-16", ThreadSeries._16UN),
        Map.entry("1 13/16-20", ThreadSeries._20UN),

        Map.entry("1 7/8-6", ThreadSeries._6UN),
        Map.entry("1 7/8-8", ThreadSeries._8UN),
        Map.entry("1 7/8-12", ThreadSeries._12UN),
        Map.entry("1 7/8-16", ThreadSeries._16UN),
        Map.entry("1 7/8-20", ThreadSeries._20UN),

        Map.entry("1 15/16-6", ThreadSeries._6UN),
        Map.entry("1 15/16-8", ThreadSeries._8UN),
        Map.entry("1 15/16-12", ThreadSeries._12UN),
        Map.entry("1 15/16-16", ThreadSeries._16UN),
        Map.entry("1 15/16-20", ThreadSeries._20UN),

        Map.entry("2-4 1/2", ThreadSeries.UNC),
        Map.entry("2-6", ThreadSeries._6UN),
        Map.entry("2-8", ThreadSeries._8UN),
        Map.entry("2-12", ThreadSeries._12UN),
        Map.entry("2-16", ThreadSeries._16UN),
        Map.entry("2-20", ThreadSeries._20UN),

        Map.entry("2 1/8-6", ThreadSeries._6UN),
        Map.entry("2 1/8-8", ThreadSeries._8UN),
        Map.entry("2 1/8-12", ThreadSeries._12UN),
        Map.entry("2 1/8-16", ThreadSeries._16UN),
        Map.entry("2 1/8-20", ThreadSeries._20UN),

        Map.entry("2 1/4-4 1/2", ThreadSeries.UNC),
        Map.entry("2 1/4-6", ThreadSeries._6UN),
        Map.entry("2 1/4-8", ThreadSeries._8UN),
        Map.entry("2 1/4-12", ThreadSeries._12UN),
        Map.entry("2 1/4-16", ThreadSeries._16UN),
        Map.entry("2 1/4-20", ThreadSeries._20UN),

        Map.entry("2 3/8-6", ThreadSeries._6UN),
        Map.entry("2 3/8-8", ThreadSeries._8UN),
        Map.entry("2 3/8-12", ThreadSeries._12UN),
        Map.entry("2 3/8-16", ThreadSeries._16UN),
        Map.entry("2 3/8-20", ThreadSeries._20UN),

        Map.entry("2 1/2-4", ThreadSeries.UNC),
        Map.entry("2 1/2-6", ThreadSeries._6UN),
        Map.entry("2 1/2-8", ThreadSeries._8UN),
        Map.entry("2 1/2-12", ThreadSeries._12UN),
        Map.entry("2 1/2-16", ThreadSeries._16UN),
        Map.entry("2 1/2-20", ThreadSeries._20UN),

        Map.entry("2 5/8-4", ThreadSeries._4UN),
        Map.entry("2 5/8-6", ThreadSeries._6UN),
        Map.entry("2 5/8-8", ThreadSeries._8UN),
        Map.entry("2 5/8-12", ThreadSeries._12UN),
        Map.entry("2 5/8-16", ThreadSeries._16UN),
        Map.entry("2 5/8-20", ThreadSeries._20UN),

        Map.entry("2 3/4-4", ThreadSeries.UNC),
        Map.entry("2 3/4-6", ThreadSeries._6UN),
        Map.entry("2 3/4-8", ThreadSeries._8UN),
        Map.entry("2 3/4-12", ThreadSeries._12UN),
        Map.entry("2 3/4-16", ThreadSeries._16UN),
        Map.entry("2 3/4-20", ThreadSeries._20UN),

        Map.entry("2 7/8-4", ThreadSeries._4UN),
        Map.entry("2 7/8-6", ThreadSeries._6UN),
        Map.entry("2 7/8-8", ThreadSeries._8UN),
        Map.entry("2 7/8-12", ThreadSeries._12UN),
        Map.entry("2 7/8-16", ThreadSeries._16UN),
        Map.entry("2 7/8-20", ThreadSeries._20UN),

        Map.entry("3-4", ThreadSeries.UNC),
        Map.entry("3-6", ThreadSeries._6UN),
        Map.entry("3-8", ThreadSeries._8UN),
        Map.entry("3-12", ThreadSeries._12UN),
        Map.entry("3-16", ThreadSeries._16UN),
        Map.entry("3-20", ThreadSeries._20UN),

        Map.entry("3 1/8-4", ThreadSeries._4UN),
        Map.entry("3 1/8-6", ThreadSeries._6UN),
        Map.entry("3 1/8-8", ThreadSeries._8UN),
        Map.entry("3 1/8-12", ThreadSeries._12UN),
        Map.entry("3 1/8-16", ThreadSeries._16UN),

        Map.entry("3 1/4-4", ThreadSeries.UNC),
        Map.entry("3 1/4-6", ThreadSeries._6UN),
        Map.entry("3 1/4-8", ThreadSeries._8UN),
        Map.entry("3 1/4-12", ThreadSeries._12UN),
        Map.entry("3 1/4-16", ThreadSeries._16UN),

        Map.entry("3 3/8-4", ThreadSeries._4UN),
        Map.entry("3 3/8-6", ThreadSeries._6UN),
        Map.entry("3 3/8-8", ThreadSeries._8UN),
        Map.entry("3 3/8-12", ThreadSeries._12UN),
        Map.entry("3 3/8-16", ThreadSeries._16UN),

        Map.entry("3 1/2-4", ThreadSeries.UNC),
        Map.entry("3 1/2-6", ThreadSeries._6UN),
        Map.entry("3 1/2-8", ThreadSeries._8UN),
        Map.entry("3 1/2-12", ThreadSeries._12UN),
        Map.entry("3 1/2-16", ThreadSeries._16UN),

        Map.entry("3 5/8-4", ThreadSeries._4UN),
        Map.entry("3 5/8-6", ThreadSeries._6UN),
        Map.entry("3 5/8-8", ThreadSeries._8UN),
        Map.entry("3 5/8-12", ThreadSeries._12UN),
        Map.entry("3 5/8-16", ThreadSeries._16UN),

        Map.entry("3 3/4-4", ThreadSeries.UNC),
        Map.entry("3 3/4-6", ThreadSeries._6UN),
        Map.entry("3 3/4-8", ThreadSeries._8UN),
        Map.entry("3 3/4-12", ThreadSeries._12UN),
        Map.entry("3 3/4-16", ThreadSeries._16UN),

        Map.entry("3 7/8-4", ThreadSeries._4UN),
        Map.entry("3 7/8-6", ThreadSeries._6UN),
        Map.entry("3 7/8-8", ThreadSeries._8UN),
        Map.entry("3 7/8-12", ThreadSeries._12UN),
        Map.entry("3 7/8-16", ThreadSeries._16UN),

        Map.entry("4-4", ThreadSeries.UNC),
        Map.entry("4-6", ThreadSeries._6UN),
        Map.entry("4-8", ThreadSeries._8UN),
        Map.entry("4-12", ThreadSeries._12UN),
        Map.entry("4-16", ThreadSeries._16UN),

        Map.entry("4 1/8-4", ThreadSeries._4UN),
        Map.entry("4 1/8-6", ThreadSeries._6UN),
        Map.entry("4 1/8-8", ThreadSeries._8UN),
        Map.entry("4 1/8-12", ThreadSeries._12UN),
        Map.entry("4 1/8-16", ThreadSeries._16UN),

        Map.entry("4 1/4-4", ThreadSeries._4UN),
        Map.entry("4 1/4-6", ThreadSeries._6UN),
        Map.entry("4 1/4-8", ThreadSeries._8UN),
        Map.entry("4 1/4-12", ThreadSeries._12UN),
        Map.entry("4 1/4-16", ThreadSeries._16UN),

        Map.entry("4 3/8-4", ThreadSeries._4UN),
        Map.entry("4 3/8-6", ThreadSeries._6UN),
        Map.entry("4 3/8-8", ThreadSeries._8UN),
        Map.entry("4 3/8-12", ThreadSeries._12UN),
        Map.entry("4 3/8-16", ThreadSeries._16UN),

        Map.entry("4 1/2-4", ThreadSeries._4UN),
        Map.entry("4 1/2-6", ThreadSeries._6UN),
        Map.entry("4 1/2-8", ThreadSeries._8UN),
        Map.entry("4 1/2-12", ThreadSeries._12UN),
        Map.entry("4 1/2-16", ThreadSeries._16UN),

        Map.entry("4 5/8-4", ThreadSeries._4UN),
        Map.entry("4 5/8-6", ThreadSeries._6UN),
        Map.entry("4 5/8-8", ThreadSeries._8UN),
        Map.entry("4 5/8-12", ThreadSeries._12UN),
        Map.entry("4 5/8-16", ThreadSeries._16UN),

        Map.entry("4 3/4-4", ThreadSeries._4UN),
        Map.entry("4 3/4-6", ThreadSeries._6UN),
        Map.entry("4 3/4-8", ThreadSeries._8UN),
        Map.entry("4 3/4-12", ThreadSeries._12UN),
        Map.entry("4 3/4-16", ThreadSeries._16UN),

        Map.entry("4 7/8-4", ThreadSeries._4UN),
        Map.entry("4 7/8-6", ThreadSeries._6UN),
        Map.entry("4 7/8-8", ThreadSeries._8UN),
        Map.entry("4 7/8-12", ThreadSeries._12UN),
        Map.entry("4 7/8-16", ThreadSeries._16UN),

        Map.entry("5-4", ThreadSeries._4UN),
        Map.entry("5-6", ThreadSeries._6UN),
        Map.entry("5-8", ThreadSeries._8UN),
        Map.entry("5-12", ThreadSeries._12UN),
        Map.entry("5-16", ThreadSeries._16UN),

        Map.entry("5 1/8-4", ThreadSeries._4UN),
        Map.entry("5 1/8-6", ThreadSeries._6UN),
        Map.entry("5 1/8-8", ThreadSeries._8UN),
        Map.entry("5 1/8-12", ThreadSeries._12UN),
        Map.entry("5 1/8-16", ThreadSeries._16UN),

        Map.entry("5 1/4-4", ThreadSeries._4UN),
        Map.entry("5 1/4-6", ThreadSeries._6UN),
        Map.entry("5 1/4-8", ThreadSeries._8UN),
        Map.entry("5 1/4-12", ThreadSeries._12UN),
        Map.entry("5 1/4-16", ThreadSeries._16UN),

        Map.entry("5 3/8-4", ThreadSeries._4UN),
        Map.entry("5 3/8-6", ThreadSeries._6UN),
        Map.entry("5 3/8-8", ThreadSeries._8UN),
        Map.entry("5 3/8-12", ThreadSeries._12UN),
        Map.entry("5 3/8-16", ThreadSeries._16UN),

        Map.entry("5 1/2-4", ThreadSeries._4UN),
        Map.entry("5 1/2-6", ThreadSeries._6UN),
        Map.entry("5 1/2-8", ThreadSeries._8UN),
        Map.entry("5 1/2-12", ThreadSeries._12UN),
        Map.entry("5 1/2-16", ThreadSeries._16UN),

        Map.entry("5 5/8-4", ThreadSeries._4UN),
        Map.entry("5 5/8-6", ThreadSeries._6UN),
        Map.entry("5 5/8-8", ThreadSeries._8UN),
        Map.entry("5 5/8-12", ThreadSeries._12UN),
        Map.entry("5 5/8-16", ThreadSeries._16UN),

        Map.entry("5 3/4-4", ThreadSeries._4UN),
        Map.entry("5 3/4-6", ThreadSeries._6UN),
        Map.entry("5 3/4-8", ThreadSeries._8UN),
        Map.entry("5 3/4-12", ThreadSeries._12UN),
        Map.entry("5 3/4-16", ThreadSeries._16UN),

        Map.entry("5 7/8-4", ThreadSeries._4UN),
        Map.entry("5 7/8-6", ThreadSeries._6UN),
        Map.entry("5 7/8-8", ThreadSeries._8UN),
        Map.entry("5 7/8-12", ThreadSeries._12UN),
        Map.entry("5 7/8-16", ThreadSeries._16UN),

        Map.entry("6-4", ThreadSeries._4UN),
        Map.entry("6-6", ThreadSeries._6UN),
        Map.entry("6-8", ThreadSeries._8UN),
        Map.entry("6-12", ThreadSeries._12UN),
        Map.entry("6-16", ThreadSeries._16UN)
    );

    private ThreadSeriesMapper() { }

    public static ThreadSeries map(
            @NonNull ThreadSize threadSize,
            @NonNull ThreadsPerInch threadsPerInch)
    {
        var key = "%s-%s".formatted(threadSize.designation(), threadsPerInch.value());
        if (!MAPPINGS.containsKey(key)) {
            throw new ThreadMappingNotSupportedException(
                    "The combination of thread size %s with %s threads per inch is not supported"
                            .formatted(threadSize.designation(), threadsPerInch.value()));
        }
        return MAPPINGS.get(key);
    }
}
