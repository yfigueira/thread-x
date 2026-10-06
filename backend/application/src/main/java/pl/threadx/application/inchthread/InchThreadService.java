package pl.threadx.application.inchthread;

import pl.threadx.domain.inchthread.InchThread;

public interface InchThreadService {

    InchThread calculateParams(final CalculateParamsCommand cmd);
}
