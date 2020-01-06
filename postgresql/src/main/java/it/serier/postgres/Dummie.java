package it.serier.postgres;

public class Dummie {

    boolean evenOdd(int a, int b) {

        boolean isEven = false;
        //<Solution>
        isEven = (b & a) < 1;
        //</Solution>
        String outcome = isEven ?"Even":"Odd";
        System.out.println("a " + a + " b " + b + "="+(a+b)+" ==> a&b " + (a & b) +" " +outcome);
        return isEven;
    }

    public static void main(String[] args) {
        Dummie reader = new Dummie();

        for (int x = 1; x < 10; x++) {
            for (int y = 1; y < 10; y++) {
                reader.evenOdd(x, y);
            }
        }
    }

    //<Tests>
    public boolean testX_equals_Y_always_False() {
        boolean allFalse = true;
        for (int x = 1; x < 10; x++) {
            allFalse &= !this.evenOdd(x, x);
        }
        return allFalse;
    }

    public boolean testStart_always_True() {
        boolean allTrue = true;
        for (int x = 1; x < 10; x++) {
            allTrue &= this.evenOdd(1, x) == (x % 2 == 0);
        }
        return allTrue;
    }
    //</Tests>

}
