package pl.threadx.application.inchthread;

import org.springframework.stereotype.Service;
import pl.threadx.domain.inchthread.FundamentalTriangle;
import pl.threadx.domain.inchthread.InchThread;
import pl.threadx.domain.inchthread.Pitch;

@Service
class InchThreadServiceImpl implements InchThreadService {

    @Override
    public InchThread calculateParams(final CalculateParamsCommand cmd) {
        var pitch = Pitch.fromThreadsPerInch(cmd.threadsPerInch().numValue());
        var fundamentalTriangle = FundamentalTriangle.forPitch(pitch);

        return new InchThread(pitch, fundamentalTriangle);
    }
}
