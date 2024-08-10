class DataType {
    public static void main(String args[]){
        byte data;
        data = 65; // can have values from -128 or (-2**7) to 127 or ((2**7)-1) | 1 byte | 8 bit
        System.out.println(data);

        // short data type
        short srt = 8826; // can have values from -32768 or (-2**15) to 32767 or ((2**15)-1) | 2 byte | 16 bit
        System.out.println(srt);

        // int data type
        int integer = 7346; // decimal number // can have values from (-2**31) to ((2**31)-1) | 4 byte | 32 bit
        int binNum = 0b10010; // binary number
        int octalNum = 041; // octal number
        int hexNumber = 0x2F; // hexadecimal number // 0x represents hexadecimal
        System.out.println(integer + " " + octalNum + " " + binNum + " " + binNum + " " + hexNumber);

        // float data type
        float flt = 73.43F; // can have values from (-2**31) to ((2**31)-1) | 4 byte | 32 bit
        System.out.println(flt);

        // double data type
        double dbl = 7346.34D; // can have values from (-2**63) to ((2**63)-1) | 8 byte | 64 bit
        double myDoubleScientific = 3.445e2; // 3.445*10^2
        System.out.println(dbl + " "+myDoubleScientific);

        // long data type
        long ln = 73462762262552L; // can have values from (-2**63) to ((2**63)-1) | 8 byte | 64 bit
        System.out.println(ln);

        // char data type  \b (backspace), \t (tab), \n (new line), etc
        char character = 'd'; // can have values from (-2**15) to ((2**15)-1) | 2 byte | 16 bit
        char UnicodeChar = '\u0100';
        System.out.println(character);
        System.out.println(UnicodeChar);

        // boolean data type (by default it is false)
        boolean condition = true; // // can have values true or false | 1 byte | 8 bit
        System.out.println(condition);

        /* primitive data types ends */

        /* not primitive data types starts */
        // string data types
        String str = "Tanjim Abubokor";
        System.out.println(str);
    }
}
