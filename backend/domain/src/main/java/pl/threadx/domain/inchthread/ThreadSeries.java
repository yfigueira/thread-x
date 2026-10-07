package pl.threadx.domain.inchthread;

public enum ThreadSeries {

    UNC("UNC", "Coarse-Thread Series"),
    UNF("UNF", "Fine-Thread Series"),
    UNEF("UNEF", "Extra-Fine-Thread Series"),
    _4UN("4 UN", "Constant-Pitch Series with 4 threads per inch"),
    _6UN("6 UN", "Constant-Pitch Series with 6 threads per inch"),
    _8UN("8 UN", "Constant-Pitch Series with 8 threads per inch"),
    _12UN("12 UN", "Constant-Pitch Series with 12 threads per inch"),
    _16UN("16 UN", "Constant-Pitch Series with 16 threads per inch"),
    _20UN("20 UN", "Constant-Pitch Series with 20 threads per inch"),
    _28UN("28 UN", "Constant-Pitch Series with 28 threads per inch"),
    _32UN("32 UN", "Constant-Pitch Series with 32 threads per inch"),
    ;

    private final String designation;
    private final String description;

    ThreadSeries(String designation, String description) {
        this.designation = designation;
        this.description = description;
    }

    public String designation() {
        return this.designation;
    }

    public String description() {
        return this.description;
    }
}
