package pl.threadx.application.inchthread;

import lombok.Builder;
import pl.threadx.domain.inchthread.ThreadSize;
import pl.threadx.domain.inchthread.ThreadsPerInch;
import pl.threadx.domain.inchthread.ToleranceClass;

@Builder
public record CalculateParamsCommand(
        ThreadSize threadSize,
        ThreadsPerInch threadsPerInch,
        ToleranceClass toleranceClass
) {
}
