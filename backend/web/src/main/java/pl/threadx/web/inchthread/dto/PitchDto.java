package pl.threadx.web.inchthread.dto;

import pl.threadx.domain.inchthread.Pitch;

public record PitchDto(
        String p,
        String p1_8,
        String p1_4,
        String p1_2
) {

    public static PitchDto fromPitch(Pitch pitch) {
        return new PitchDto(
                pitch.p().toString(),
                pitch.p1_8().toString(),
                pitch.p1_4().toString(),
                pitch.p1_2().toString()
        );
    }
}
