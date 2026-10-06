package pl.threadx.web.inchthread.dto;

import pl.threadx.domain.inchthread.FundamentalTriangle;

public record FundamentalTriangleDto(
        String h,
        String h1_8,
        String h1_4,
        String h3_8,
        String h1_2,
        String h5_8
) {

    public static FundamentalTriangleDto fromFundamentalTriangle(FundamentalTriangle ft) {
        return new FundamentalTriangleDto(
                ft.h().toString(),
                ft.h1_8().toString(),
                ft.h1_4().toString(),
                ft.h3_8().toString(),
                ft.h1_2().toString(),
                ft.h5_8().toString()
        );
    }
}
