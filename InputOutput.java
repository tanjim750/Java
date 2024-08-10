import java.util.Scanner;


class InputOutput {
    public static void main(String[] args){
        // Display output
        boolean data;
        data = true;
        System.out.println(data);

        // take user input
        Scanner input = new Scanner(System.in);
        boolean condition = true;
        while (condition){
            System.out.print("\nEnter a integer value: ");
            String text = input.nextLine();
            if (text.compareTo("exit") == 0){
                System.out.print("\nProgram exiting");
                break;
            }else{
                System.out.print("\nThe integer value is: "+text);
            }
        }

        input.close();
    }
}