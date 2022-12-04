package day2;

public enum Hand {
    ROCK("A",1),
    PAPER("B",2),
    SCISSORS("C",3);
    private String code;
    private int value;

    Hand(String c,  int v) {
        this.code = c;
        this.value = v;
    }

    public String getCode() {
        return code;
    }

    public int getValue() {
        return value;
    }
}
