public enum Nominals {
    N50(50),
    N100(100),
    N500(500),
    N1000(1000),
    N5000(5000);


    private final int number;
    Nominals(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
