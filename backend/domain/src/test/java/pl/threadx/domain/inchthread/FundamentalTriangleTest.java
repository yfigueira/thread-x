package pl.threadx.domain.inchthread;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class FundamentalTriangleTest {

    @Test
    void forPitch_WhenPitchIsNull_ShouldThrowIllegalArgumentException() {
        // given, when, then
        assertThatThrownBy(() -> FundamentalTriangle.forPitch(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Pitch cannot be null.");
    }

    @Test
    void forPitch_ShouldReturnNewFundamentalTriangleWith6DecimalPrecision() {
        // given
        var pitch = Pitch.fromThreadsPerInch(new BigDecimal(8));
        var expectedHeight = new BigDecimal("0.108253");

        // when
        var result = FundamentalTriangle.forPitch(pitch);

        // then
        assertThat(result.h(), is(equalTo(expectedHeight)));
    }
}