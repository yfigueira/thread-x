package pl.threadx.web.inchthread.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.threadx.domain.inchthread.InchThread;

public record InchThreadResponse(
        @JsonProperty("basicProfile")
        BasicProfileDto basicProfileDto
) {

    public static InchThreadResponse fromInchThread(InchThread inchThread) {
        return new InchThreadResponse(
                BasicProfileDto.fromBasicProfile(inchThread.getBasicProfile())
        );
    }
}
