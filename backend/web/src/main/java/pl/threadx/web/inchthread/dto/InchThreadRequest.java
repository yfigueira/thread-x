package pl.threadx.web.inchthread.dto;

import pl.threadx.domain.inchthread.ThreadSize;
import pl.threadx.domain.inchthread.ThreadsPerInch;
import pl.threadx.domain.inchthread.ToleranceClass;

public record InchThreadRequest(
        ThreadSize threadSize,
        ThreadsPerInch threadPerInch,
        ToleranceClass toleranceClass
) {
}
