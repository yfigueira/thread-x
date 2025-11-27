package pl.threadx.domain.inchthread;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FundamentalTriangleTest {

    @Test
    void forPitch_WhenPitchIsNull_ShouldThrowIllegalArgumentException() {
        // given, when, then
        assertThatThrownBy(() -> FundamentalTriangle.forPitch(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Pitch cannot be null.");
    }
}