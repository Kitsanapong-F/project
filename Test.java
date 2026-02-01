import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        boolean runing = true;
        ArrayList<Double> num = new ArrayList<>();
        ArrayList<Character> startop = new ArrayList<>();

        while (runing) {
            boolean Error = false;
            System.out.printf("\nใส่ตัวเลข: ");
            num.add(myScanner.nextDouble());
            myScanner.nextLine();
            while (true) {

                System.out.printf("ใส่เครื่องหมาย: ");
                String op = myScanner.nextLine();
                if (op.equals("=")) {
                    break;
                }
                startop.add(op.charAt(0));

                System.out.printf("ใส่ตัวเลข: ");
                num.add(myScanner.nextDouble());
                myScanner.nextLine();
            }
            for (int i = 0; i < startop.size(); i++) {
                if (startop.get(i) == '%' || startop.get(i) == '/' || startop.get(i) == '*') {
                    double num1 = num.get(i);
                    double num2 = num.get(i + 1);
                    double sum = 0;
                    switch (startop.get(i)) {
                        case '%':
                            if (num2 == 0) {
                                System.out.println("Error: หาร 0 ไม่ได้");
                                Error = true;
                            } else {
                                sum = num1 % num2;
                            }
                            break;
                        case '/':
                            if (num2 == 0) {
                                System.out.println("Error: หารเอาเศษ 0 ไม่ได้");
                                Error = true;
                            } else {
                                sum = num1 / num2;
                            }
                        case '*':
                            sum = num1 * num2;
                            break;
                    }
                    if (!Error) {
                        num.set(i, sum);
                        num.remove(i + 1);
                        startop.remove(i);
                        i--;
                    }
                }
            }

            if (!Error) {
                double fsum = num.get(0);
                for (int i = 0; i < startop.size(); i++) {
                    double addnum = num.get(i + 1);
                    switch (startop.get(i)) {
                        case '+':
                            fsum += addnum;
                            break;
                        case '-':
                            fsum -= addnum;
                            break;
                    }
                }
                System.out.println("ผลลัพธ์เท่ากับ: " + fsum);
            }
            while (true) {
                System.out.println("Exit (Y/N)");
                char mark = myScanner.next().charAt(0);
                if (mark != 'N' && mark != 'n') {
                    if (mark == 'Y' || mark == 'y') {
                        runing = false;
                        System.out.println("End..");
                        break;
                    } else {
                        System.out.println("olny Y or N?");
                    }
                } else {
                    break;
                }
            }

            num.clear();
            startop.clear();
            Error = false;
        }
        myScanner.close();
    }
}