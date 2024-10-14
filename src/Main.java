public class Main {
    public static void main(String[] args) {

        // BITWISE OPERATORS = special operators used in bit level programming ( knowing binary is important for this topic)

        // & = AND
        // | = OR
        // ^ = XOR
        // << LEFT SHIFT
        // >> RIGHT SHIFT

        int x = 6;  // 6 = 00000110
        int y = 12; //12 = 00001100
        int z = 0;  //0  = 00000000
        z = x & y;
        System.out.println("AND: "+ z);
        z = x | y;
        System.out.println("OR: "+z);
        z = x ^ y;
        System.out.println("XOR: "+z);
        z = x << 2;
        System.out.println("LEFT SHIFT: "+z);
        z = x >> 1;
        System.out.println("RIGHT SHIFT: "+z);


        int q = 20;
        int n = 3;

        System.out.println(q + " is binary "+Integer.toBinaryString(q));


        q = binary(q, n);
        System.out.println(q+" is binary "+ Integer.toBinaryString(q));







        int d = 120;
        if (EvenOrOdd(d)) {
            System.out.println(d+" is even");
        }
        else {
            System.out.println(d + " is odd");
        }





    }

    public static boolean EvenOrOdd(int x) {
        return (x & 1) == 0;
    }

    public static int binary(int n, int k) {
        return n & ~(1 <<(k -1));
    }

    public static void prepareMidterm() {
        System.out.println("We wish you take 100 points");
    }




}