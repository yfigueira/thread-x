package pl.threadx.domain.inchthread;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


class PitchTest {

    @Test
    void fromThreadsPerInch_WhenThreadsPerInchIsZeroOrLess_ShouldThrowIllegalArgumentException() {
        // given
        var negative = BigDecimal.valueOf(-1.00);
        var zero = BigDecimal.ZERO;

        // when, then
        assertIllegalArgumentExceptionThrown(negative);
        assertIllegalArgumentExceptionThrown(zero);
    }

    @ParameterizedTest
    @MethodSource("fromThreadsPerInchArguments")
    void fromThreadsPerInch_ShouldReturnNewPitchWith8DecimalPrecision(BigDecimal threadsPerInch, BigDecimal expectedValue) {
        // given, when
        var result = Pitch.fromThreadsPerInch(threadsPerInch).value();

        // then
        assertThat(result, is(equalTo(expectedValue)));
    }

    @ParameterizedTest
    @MethodSource("eighthValueArguments")
    void eighthValue_ShouldReturnOneEighthOfPitchValue(BigDecimal tpi, BigDecimal expectedResult) {
        // given
        var pitch = Pitch.fromThreadsPerInch(tpi);

        // when
        var result = pitch.eighthValue();

        // then
        assertThat(result, is(equalTo(expectedResult)));
    }

    @ParameterizedTest
    @MethodSource("quarterValueArguments")
    void quarterValue_ShouldReturnOneQuarterOfPitchValue(BigDecimal tpi, BigDecimal expectedResult) {
        // given
        var pitch = Pitch.fromThreadsPerInch(tpi);

        // when
        var result = pitch.quarterValue();

        // then
        assertThat(result, is(equalTo(expectedResult)));
    }

    private void assertIllegalArgumentExceptionThrown(BigDecimal argument) {
        assertThatThrownBy(() -> Pitch.fromThreadsPerInch(argument))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Threads per inch value should be greater than zero.");
    }

    private static Stream<Arguments> fromThreadsPerInchArguments() {
        return Stream.of(
                arguments(36, 0.02777778),
                arguments(9, 0.11111111),
                arguments(8, 0.12500000)
        );
    }

    private static Stream<Arguments> eighthValueArguments() {
        return Stream.of(
                arguments(36, 0.00347222),
                arguments(9, 0.01388889),
                arguments(8, 0.01562500)
        );
    }

    private static Stream<Arguments> quarterValueArguments() {
        return Stream.of(
                arguments(36, 0.00694445),
                arguments(9, 0.02777778),
                arguments(8, 0.03125000)
        );
    }

    private static Arguments arguments(double input, double expectedResult) {
        return Arguments.of(BigDecimal.valueOf(input), scaled(expectedResult));
    }

    private static BigDecimal scaled(double value) {
        return BigDecimal.valueOf(value).setScale(8, RoundingMode.HALF_UP);
    }
}