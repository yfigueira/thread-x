package pl.threadx.application.inchthread;

import org.springframework.stereotype.Service;
import pl.threadx.domain.inchthread.InchThread;

@Service
class InchThreadServiceImpl implements InchThreadService {

    @Override
    public InchThread calculateParams(final CalculateParamsCommand cmd) {
        return InchThread.newInchThread(cmd.threadSize(), cmd.threadsPerInch(), cmd.toleranceClass());
    }
}
