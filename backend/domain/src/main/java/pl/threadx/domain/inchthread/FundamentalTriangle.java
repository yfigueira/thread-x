package pl.threadx.domain.inchthread;

class FundamentalTriangle {

    private FundamentalTriangle() {

    }

    static FundamentalTriangle forPitch(Pitch pitch) {
        if (pitch == null) {
            throw new IllegalArgumentException("Pitch cannot be null.");
        }

        return null;
    }
}
