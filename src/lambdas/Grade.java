package lambdas;

public enum Grade {
    A('a',1),
    B('b',2),
    F('c',3);

    private char letter;
    private int number;


    Grade( char b, int a){
        this.letter=b;
        this.number=a;
    }

    public char getLetter() {
        return letter;
    }

    public int getNumber() {
        return number;
    }
}