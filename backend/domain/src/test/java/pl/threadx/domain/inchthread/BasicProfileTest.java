package pl.threadx.domain.inchthread;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class BasicProfileTest {

    @Test
    void whenNullThreadsPerInch_ShouldThrowNullPointerException() {
        assertThatThrownBy(() -> new BasicProfile(null, ThreadSize._1))
                .isInstanceOf(NullPointerException.class);

        assertThatThrownBy(() -> new BasicProfile(ThreadsPerInch._8, null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void p_ShouldReturnPitchValueWith8DecimalPrecision() {
        // given
        var basicProfile = new BasicProfile(ThreadsPerInch._36, ThreadSize.Nr8);
        var expectedPitch = new BigDecimal("0.02777778");

        // when
        var result = basicProfile.p();

        // then
        assertThat(result, is(equalTo(expectedPitch)));
        assertThat(result.scale(), is(equalTo(8)));
    }

    @Test
    void p1I8_ShouldReturnOneEighthOfPitchValueWith6DecimalPrecision() {
        // given
        var basicProfile = new BasicProfile(ThreadsPerInch._36, ThreadSize.Nr8);
        var expectedPitch = new BigDecimal("0.003472");

        // when
        var result = basicProfile.p1I8();

        // then
        assertThat(result, is(equalTo(expectedPitch)));
        assertThat(result.scale(), is(equalTo(6)));
    }

    @Test
    void p1I4_ShouldReturnOneFourthOfPitchValueWith6DecimalPrecision() {
        // given
        var basicProfile = new BasicProfile(ThreadsPerInch._36, ThreadSize.Nr8);
        var expectedPitch = new BigDecimal("0.006944");

        // when
        var result = basicProfile.p1I4();

        // then
        assertThat(result, is(equalTo(expectedPitch)));
        assertThat(result.scale(), is(equalTo(6)));
    }

    @Test
    void p1I2_ShouldReturnHalfOfPitchValueWith6DecimalPrecision() {
        // given
        var basicProfile = new BasicProfile(ThreadsPerInch._36, ThreadSize.Nr8);
        var expectedPitch = new BigDecimal("0.013889");

        // when
        var result = basicProfile.p1I2();

        // then
        assertThat(result, is(equalTo(expectedPitch)));
        assertThat(result.scale(), is(equalTo(6)));
    }

    @Test
    void h_ShouldReturnHeightOfFundamentTriangleValueWith6DecimalPrecision() {
        // given
        var basicProfile = new BasicProfile(ThreadsPerInch._8, ThreadSize._1);
        var expectedHeight = new BigDecimal("0.108253");

        // when
        var result = basicProfile.h();

        // then
        assertThat(result, is(equalTo(expectedHeight)));
        assertThat(result.scale(), is(equalTo(6)));
    }

    @Test
    void h1I8_ShouldReturnOneEighthOfFundamentalTringleHeightWith6DecimalPrecision() {
        // given
        var basicProfile = new BasicProfile(ThreadsPerInch._8, ThreadSize._1);
        var expectedHeight = new BigDecimal("0.013532");

        // when
        var result = basicProfile.h1I8();

        // then
        assertThat(result, is(equalTo(expectedHeight)));
        assertThat(result.scale(), is(equalTo(6)));
    }

    @Test
    void h1I4_ShouldReturnOneFourthOfFundamentalTringleHeightWith6DecimalPrecision() {
        // given
        var basicProfile = new BasicProfile(ThreadsPerInch._8, ThreadSize._1);
        var expectedHeight = new BigDecimal("0.027063");

        // when
        var result = basicProfile.h1I4();

        // then
        assertThat(result, is(equalTo(expectedHeight)));
        assertThat(result.scale(), is(equalTo(6)));
    }

    @Test
    void h3I8_ShouldReturnThreeEightsOfFundamentalTringleHeightWith6DecimalPrecision() {
        // given
        var basicProfile = new BasicProfile(ThreadsPerInch._8, ThreadSize._1);
        var expectedHeight = new BigDecimal("0.040595");

        // when
        var result = basicProfile.h3I8();

        // then
        assertThat(result, is(equalTo(expectedHeight)));
        assertThat(result.scale(), is(equalTo(6)));
    }

    @Test
    void h1I2_ShouldReturnHalfOfFundamentalTringleHeightWith6DecimalPrecision() {
        // given
        var basicProfile = new BasicProfile(ThreadsPerInch._8, ThreadSize._1);
        var expectedHeight = new BigDecimal("0.054127");

        // when
        var result = basicProfile.h1I2();

        // then
        assertThat(result, is(equalTo(expectedHeight)));
        assertThat(result.scale(), is(equalTo(6)));
    }

    @Test
    void h5I8_ShouldReturnFiveEightsOfFundamentalTringleHeightWith6DecimalPrecision() {
        // given
        var basicProfile = new BasicProfile(ThreadsPerInch._8, ThreadSize._1);
        var expectedHeight = new BigDecimal("0.067658");

        // when
        var result = basicProfile.h5I8();

        // then
        assertThat(result, is(equalTo(expectedHeight)));
        assertThat(result.scale(), is(equalTo(6)));
    }

    @Test
    void d_ShouldReturnBasicMajorDiameterValueWith4DecimalPrecision() {
        // given
    }
}