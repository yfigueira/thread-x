package pl.threadx.application.inchthread;

import org.springframework.stereotype.Service;
import pl.threadx.domain.inchthread.*;

@Service
class InchThreadServiceImpl implements InchThreadService {

    @Override
    public InchThread calculateParams(final CalculateParamsCommand cmd) {
        var pitch = Pitch.fromThreadsPerInch(cmd.threadsPerInch().numValue());
        var fundamentalTriangle = FundamentalTriangle.forPitch(pitch);

        var series = new ThreadSeriesMapper().mapSeriesFor(cmd.threadSize(), cmd.threadsPerInch());

        var lengthOfEngagement = getLengthOfEngagement(series, cmd.threadSize(), pitch);

        return InchThread.newInchThread(cmd.threadSize(), cmd.threadsPerInch(), cmd.toleranceClass());
    }

    private LengthOfEngagement getLengthOfEngagement(ThreadSeries series, ThreadSize size, Pitch pitch) {
        return switch (series) {
            case UNC, UNF, _4UN, _6UN, _8UN -> LengthOfEngagement.forThreadSize(size);
            case UNEF, _12UN, _16UN, _20UN, _28UN, _32UN -> LengthOfEngagement.forPitch(pitch);
        };
    }
}
