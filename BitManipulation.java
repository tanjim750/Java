import java.util.Scanner;

class BitManipulation {
    // get value of the position
    public static int getBit(int number, int position) {
        int bitMask = 1<<position;
        int result = bitMask & number;
        
        if(result == 0){
            return 0;
        }
        return 1;
    }

    // set value 1 at the position
    public static int setBit(int number, int position) {
        int bitMask = 1<<position;
        int result = bitMask | number;
        
        return result;
    }

    // set value 1 at the position
    public static int clearBit(int number, int position) {
        int bitMask = 1<<position;
        int NOTBitMask = ~bitMask;
        int result = NOTBitMask | number;
        
        return result;
    }

    // set value 1 at the position
    public static int updateBit(int number, int position, int update) {
        if(update == 0){
            int result = setBit(number, position);
            return result;
        }else {
            int result = clearBit(number, position);
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("\n\t\t1. Get bit at position\n\t\t2. Set bit at position\n\t\t3. Clear bit at position\n\t\t4. Update bit at position\n\t\t0. EXIT\n\n\t\tSelect your operation: ");
            int operation = scanner.nextInt();
            System.out.println();

            if(operation == 0) {
                break;
            }else if(operation > 4) {
                System.out.println("\t\tInvalid option. Try again!!");
            }else{   
                System.out.print("\t\tEnter your number: ");
                int number = scanner.nextInt();
                System.out.print("\n\t\tEnter the position: ");
                int position = scanner.nextInt();

                if(operation == 1){
                    int result = getBit(number, position);
                    System.out.println("\t\tThe bit is " + result);
                }else if(operation == 2){
                    int result = setBit(number, position);
                    System.out.println("\t\tNew number is " + result);
                }else if(operation == 3){
                    int result = clearBit(number, position);
                    System.out.println("\t\tNew number is " + result);
                }else if(operation == 4){
                    System.out.print("\t\tEnter the update value(1 or 0): ");
                    int update = scanner.nextInt();
                    if(update == 0 || update == 1){
                        int result = updateBit(number, position, update);
                        System.out.println("\t\tNew number is " + result);
                    }else {
                        System.out.println("\t\tGiven invalid value ");
                    }
                }
            }

            System.out.print("\t\tDo you want to continue(Y/N): ");
            String input = scanner.next();
            if(input.compareToIgnoreCase("n") == 0){
                break;
            }
        }

        
        scanner.close();
        
    }
}
