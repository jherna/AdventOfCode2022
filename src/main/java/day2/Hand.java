package day2;

public enum Hand {
    ROCK("A","X",1),
    PAPER("B","Y",2),
    SCISSORS("C","Z",3);
    private String code;
    private String code2;
    private int value;

    Hand(String c,  String code2, int v) {
        this.code = c;
        this.value = v;
        this.code2 = code2;
    }

    Hand(String c) {
        this.code = c;
    }

    public String getCode() {
        return code;
    }

    public int getValue() {
        return value;
    }

    public String getCode2() {
        return code2;
    }


}
