public enum Value {
    ONETHOUSAND(1000),
    FIVEHUNDRED(500),
    ONEHUNDRED(100);

    private final int value;

    Value(int value) {
        this.value=value;
    }
    public int getValue(){
        return this.value;
    }
}
