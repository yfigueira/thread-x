package pl.threadx.domain.inchthread;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class LengthOfEngagementTest {

    @Test
    void forPitch_ShouldReturnNewLengthOfEngagementWith4DecimalPrecision() {
        // given
        var pitch = Pitch.fromThreadsPerInch(ThreadsPerInch._20.numValue());

        // when
        var result = LengthOfEngagement.forPitch(pitch);

        // then
        assertThat(result.length(), is(equalTo(new BigDecimal("0.4500"))));
        assertThat(result.length().scale(), is(equalTo(4)));
    }

    @Test
    void forThreadSize_ShouldReturnNewLengthOfEngagementWith4DecimalPrecision() {
        // given
        var threadSize = ThreadSize._1;

        // when
        var result = LengthOfEngagement.forThreadSize(threadSize);

        // then
        assertThat(result.length(), is(equalTo(new BigDecimal("1.0000"))));
        assertThat(result.length().scale(), is(equalTo(4)));
    }
}