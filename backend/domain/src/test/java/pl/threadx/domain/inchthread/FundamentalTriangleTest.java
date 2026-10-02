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

    @Test
    void h1_8_ShouldReturnOneEighthOfTheFundamentalTringleHeight() {
        // given
        var pitch = Pitch.fromThreadsPerInch(new BigDecimal(8));
        var fundamentalTriangle = FundamentalTriangle.forPitch(pitch);

        // when
        var result = fundamentalTriangle.h1_8();

        // then
        assertThat(result, is(equalTo(new BigDecimal("0.013532"))));
    }

    @Test
    void h1_4_ShouldReturnOneFourthOfTheFundamentalTringleHeight() {
        // given
        var pitch = Pitch.fromThreadsPerInch(new BigDecimal(8));
        var fundamentalTriangle = FundamentalTriangle.forPitch(pitch);

        // when
        var result = fundamentalTriangle.h1_4();

        // then
        assertThat(result, is(equalTo(new BigDecimal("0.027063"))));
    }

    @Test
    void h3_8_ShouldReturnThreeEighthsOfTheFundamentalTringleHeight() {
        // given
        var pitch = Pitch.fromThreadsPerInch(new BigDecimal(8));
        var fundamentalTriangle = FundamentalTriangle.forPitch(pitch);

        // when
        var result = fundamentalTriangle.h3_8();

        // then
        assertThat(result, is(equalTo(new BigDecimal("0.040595"))));
    }

    @Test
    void h1_2_ShouldReturnHalfOfTheFundamentalTringleHeight() {
        // given
        var pitch = Pitch.fromThreadsPerInch(new BigDecimal(8));
        var fundamentalTriangle = FundamentalTriangle.forPitch(pitch);

        // when
        var result = fundamentalTriangle.h1_2();

        // then
        assertThat(result, is(equalTo(new BigDecimal("0.054127"))));
    }

    @Test
    void h5_8_ShouldReturnFiveEighthsOfTheFundamentalTringleHeight() {
        // given
        var pitch = Pitch.fromThreadsPerInch(new BigDecimal(8));
        var fundamentalTriangle = FundamentalTriangle.forPitch(pitch);

        // when
        var result = fundamentalTriangle.h3_8();

        // then
        assertThat(result, is(equalTo(new BigDecimal("0.040595"))));
    }
}