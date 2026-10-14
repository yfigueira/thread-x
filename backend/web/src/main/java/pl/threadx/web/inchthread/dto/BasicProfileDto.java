package pl.threadx.web.inchthread.dto;

import pl.threadx.domain.inchthread.BasicProfile;

public record BasicProfileDto(
        String p,
        String p1I8,
        String p1I4,
        String p1I2,
        String h,
        String h1I8,
        String h1I4,
        String h3I8,
        String h1I2,
        String h5I8
) {

    public static BasicProfileDto fromBasicProfile(BasicProfile basicProfile) {
        return new BasicProfileDto(
                basicProfile.p().toString(),
                basicProfile.p1I8().toString(),
                basicProfile.p1I4().toString(),
                basicProfile.p1I2().toString(),
                basicProfile.h().toString(),
                basicProfile.h1I8().toString(),
                basicProfile.h1I4().toString(),
                basicProfile.h3I8().toString(),
                basicProfile.h1I2().toString(),
                basicProfile.h5I8().toString()
        );
    }
}
