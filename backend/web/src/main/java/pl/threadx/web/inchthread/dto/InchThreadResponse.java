package pl.threadx.web.inchthread.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.threadx.domain.inchthread.InchThread;

public record InchThreadResponse(
        @JsonProperty("pitch")
        PitchDto pitchDto,
        @JsonProperty("fundamentalTriangle")
        FundamentalTriangleDto fundamentalTriangleDto
) {

    public static InchThreadResponse fromInchThread(InchThread inchThread) {
        return new InchThreadResponse(
                PitchDto.fromPitch(inchThread.pitch()),
                FundamentalTriangleDto.fromFundamentalTriangle(inchThread.fundamentalTriangle())
        );
    }
}
