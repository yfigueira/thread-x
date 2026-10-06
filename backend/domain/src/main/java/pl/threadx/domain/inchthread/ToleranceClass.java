package pl.threadx.domain.inchthread;

public enum ToleranceClass {
    _1A("1A"),
    _2A("2A"),
    _3A("3A"),
    _1B("1B"),
    _2B("2B"),
    _3B("3B")
    ;

    private final String designation;

    ToleranceClass(String designation) {
        this.designation = designation;
    }

    public String designation() {
        return this.designation;
    }
}
