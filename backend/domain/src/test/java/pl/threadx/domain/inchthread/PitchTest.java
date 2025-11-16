package pl.threadx.domain.inchthread;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


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
}