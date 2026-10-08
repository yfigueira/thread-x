package pl.threadx.application.inchthread;

import org.springframework.stereotype.Service;
import pl.threadx.domain.inchthread.FundamentalTriangle;
import pl.threadx.domain.inchthread.InchThread;
import pl.threadx.domain.inchthread.Pitch;
import pl.threadx.domain.inchthread.ThreadSeriesMapper;

@Service
class InchThreadServiceImpl implements InchThreadService {

    @Override
    public InchThread calculateParams(final CalculateParamsCommand cmd) {
        var pitch = Pitch.fromThreadsPerInch(cmd.threadsPerInch().numValue());
        var fundamentalTriangle = FundamentalTriangle.forPitch(pitch);

        var series = new ThreadSeriesMapper().mapSeriesFor(cmd.threadSize(), cmd.threadsPerInch());

        return new InchThread(pitch, fundamentalTriangle);
    }
}
