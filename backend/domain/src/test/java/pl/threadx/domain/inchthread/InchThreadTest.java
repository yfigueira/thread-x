package pl.threadx.domain.inchthread;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class InchThreadTest {

    @Test
    void newInchThread_WhenToleranceClassIsExternal_ShouldReturnExternalInchThread() {
        // given
        var threadSize = ThreadSize._1;
        var threadsPerInch = ThreadsPerInch._8;
        var toleranceClass = ToleranceClass._2A;

        // when
        var result = InchThread.newInchThread(threadSize, threadsPerInch, toleranceClass);

        // then
        assertThat(result, is(instanceOf(ExternalInchThread.class)));
    }

    @Test
    void newInchThread_WhenToleranceClassIsInternal_ShouldReturnInternalInchThread() {
        // given
        var threadSize = ThreadSize._1;
        var threadsPerInch = ThreadsPerInch._8;
        var toleranceClass = ToleranceClass._2B;

        // when
        var result = InchThread.newInchThread(threadSize, threadsPerInch, toleranceClass);

        // then
        assertThat(result, is(instanceOf(InternalInchThread.class)));
    }

    @ParameterizedTest
    @MethodSource("nullNewInchThreadArguments")
    void newInchThread_WhenNullArgumentProvided_ShouldThrowNullPointerException(
            ThreadSize threadSize,
            ThreadsPerInch threadsPerInch,
            ToleranceClass toleranceClass
    ) {
        assertThatThrownBy(() -> InchThread.newInchThread(threadSize, threadsPerInch, toleranceClass))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void lengthOfEngagement_ShouldReturnValueForSeriesWith4DecimalPrecision() {
        // given

        // length of engagement based on diameter
        var uncThread = InchThread.newInchThread(ThreadSize._1, ThreadsPerInch._8, ToleranceClass._2A);

        // length of engagement based on pitch
        var unefThread = InchThread.newInchThread(ThreadSize._1, ThreadsPerInch._20, ToleranceClass._2A);

        var expectedUncResult = new BigDecimal("1.0000");
        var expectedUnefResult = new BigDecimal("0.4500");

        // when
        var uncResult = uncThread.lengthOfEngagement();
        var unefResult = unefThread.lengthOfEngagement();

        // then
        assertThat(uncResult, is(equalTo(expectedUncResult)));
        assertThat(uncResult.scale(), is(equalTo(4)));

        assertThat(unefResult, is(equalTo(expectedUnefResult)));
        assertThat(unefResult.scale(), is(equalTo(4)));
    }

    private static Stream<Arguments> nullNewInchThreadArguments() {
        return Stream.of(
                Arguments.of(ThreadSize._1, ThreadsPerInch._8, null),
                Arguments.of(ThreadSize._1, null, ToleranceClass._2A),
                Arguments.of(null, ThreadsPerInch._8, ToleranceClass._2A)
        );
    }
}