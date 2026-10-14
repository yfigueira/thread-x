package pl.threadx.domain.inchthread;

final class ExternalInchThread extends InchThread {

    ExternalInchThread(ThreadSize threadSize, ThreadsPerInch threadsPerInch, ToleranceClass toleranceClass) {
        super(threadSize, threadsPerInch, toleranceClass);
    }
}
