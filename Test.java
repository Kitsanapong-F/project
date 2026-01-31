import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        boolean runing = true;

        while (runing) {
            System.out.printf("ใส่ตัวเลข: ");
            double num1 = myScanner.nextDouble();
            myScanner.nextLine();
            while (true) {
                
                System.out.printf("ใส่เครื่องหมาย: ");
                String op = myScanner.nextLine();
                char startop = op.charAt(0);

                if (startop == '=') {
                    System.out.println("ผลลัพธ์เท่ากับ: "+num1);
                    break;
                }

                System.out.printf("ใส่ตัวเลข: ");
                double num2 = myScanner.nextDouble();
                myScanner.nextLine();

                switch (startop) {
                    case '+':
                        num1 += num2;
                        break;
                    case '-':
                        num1 -= num2;
                        break;
                    case '*':
                        num1 += num2;
                        break;
                    case '%':
                        num1 += num2;
                        break;
                    case '/':
                        if (num2 != 0) {
                            num1 /= num2;
                        }else{
                            System.out.println("Error: หารศูยน์ไม่ได้");
                        }
                        break;
                    default:
                        System.out.println("Error: เครื่องหมายไม่ถูกต้อง");
                        break;
                }
                System.out.println("= "+num1);
            }
            System.out.println("Exit (Y/N)");
            char mark = myScanner.next().charAt(0);
            if (mark != 'N' && mark != 'n') {
                runing = false;
                System.out.println("End..");
            }
        }
        myScanner.close();
    }
}