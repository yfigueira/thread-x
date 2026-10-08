package pl.threadx.domain.inchthread;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class ThreadSeriesMapperTest {

    @ParameterizedTest
    @MethodSource("threadSeriesMappingArguments")
    void shouldReturnMappedThreadSeries(
            ThreadSize threadSize,
            ThreadsPerInch threadsPerInch,
            ThreadSeries expectedResult)
    {
        // given
        var mapper = new ThreadSeriesMapper();

        // when
        var result = mapper.mapSeriesFor(threadSize, threadsPerInch);

        // then
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    void whenThreadSizeAndThreadsPerInchComboNotSupported_ShouldThrowThreadMappingNotSupportedException() {
        // given
        var threadSize = ThreadSize.Nr0;
        var threadsPerInch = ThreadsPerInch._10;
        var mapper = new ThreadSeriesMapper();

        // when, then
        assertThatThrownBy(() -> mapper.mapSeriesFor(threadSize, threadsPerInch))
                .isInstanceOf(ThreadMappingNotSupportedException.class)
                .hasMessage("The combination of thread size Nr 0 with 10 threads per inch is not supported");
    }

    private static Stream<Arguments> threadSeriesMappingArguments() {
        return Stream.of(
            Arguments.of(ThreadSize._1, ThreadsPerInch._8, ThreadSeries.UNC),
            Arguments.of(ThreadSize.Nr0, ThreadsPerInch._80, ThreadSeries.UNF),
            Arguments.of(ThreadSize._5I8, ThreadsPerInch._24, ThreadSeries.UNEF),
            Arguments.of(ThreadSize._6, ThreadsPerInch._4, ThreadSeries._4UN),
            Arguments.of(ThreadSize._4_5I8, ThreadsPerInch._6, ThreadSeries._6UN),
            Arguments.of(ThreadSize._3_1I2, ThreadsPerInch._8, ThreadSeries._8UN),
            Arguments.of(ThreadSize._3, ThreadsPerInch._12, ThreadSeries._12UN),
            Arguments.of(ThreadSize._2_1I2, ThreadsPerInch._16, ThreadSeries._16UN),
            Arguments.of(ThreadSize._2_1I8, ThreadsPerInch._20, ThreadSeries._20UN),
            Arguments.of(ThreadSize._1_1I2, ThreadsPerInch._28, ThreadSeries._28UN),
            Arguments.of(ThreadSize._13I16, ThreadsPerInch._32, ThreadSeries._32UN)
        );
    }
}