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

    private void assertIllegalArgumentExceptionThrown(BigDecimal argument) {
        assertThatThrownBy(() -> Pitch.fromThreadsPerInch(argument))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Threads per inch value should be greater than zero.");
    }

    @ParameterizedTest
    @MethodSource("threadsPerInchArguments")
    void fromThreadsPerInch_ShouldReturnNewPitchWith8DecimalPrecision(BigDecimal threadsPerInch, BigDecimal expectedValue) {
        // given, when
        var result = Pitch.fromThreadsPerInch(threadsPerInch).value();

        // then
        assertThat(result, is(equalTo(expectedValue)));
    }

    private static Stream<Arguments> threadsPerInchArguments() {
        return Stream.of(
            Arguments.of(BigDecimal.valueOf(80), scaled(0.01250000)),
            Arguments.of(BigDecimal.valueOf(44), scaled(0.02272727)),
            Arguments.of(BigDecimal.valueOf(36), scaled(0.02777778)),
            Arguments.of(BigDecimal.valueOf(20), scaled(0.05000000)),
            Arguments.of(BigDecimal.valueOf(12), scaled(0.08333333)),
            Arguments.of(BigDecimal.valueOf(9), scaled(0.11111111)),
            Arguments.of(BigDecimal.valueOf(8), scaled(0.12500000)),
            Arguments.of(BigDecimal.valueOf(4.5), scaled(0.22222222))
        );
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

    private static Stream<Arguments> eighthValueArguments() {
        return Stream.of(
                Arguments.of(BigDecimal.valueOf(36), scaled(0.00347222)),
                Arguments.of(BigDecimal.valueOf(9), scaled(0.01388889)),
                Arguments.of(BigDecimal.valueOf(8), scaled(0.01562500))
        );
    }

    private static BigDecimal scaled(double value) {
        return BigDecimal.valueOf(value).setScale(8, RoundingMode.HALF_UP);
    }
}