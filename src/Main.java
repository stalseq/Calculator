import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean pr;
        int a;
        int b;



        String[] op = {"+", "-", "/", "*"};
        String[] op1 = {"\\+", "-", "/", "\\*"};

        System.out.println("Введите выражение:");

        String strings2 = scanner.nextLine();

        System.out.println("Результат");

        int x = -1;
        for (int i = 0; i < op.length; i++) {
            if (strings2.contains(op[i])) {
                x = i;
                break;
            }
        }

        if (x == -1) {
            System.out.println("Неверная орефметическая операция");
            return;
        }
        String[] data = strings2.split(op1[x]);

        if (data.length != 2) {
            throw new IOException("Должно быть два операнда");
        }

        int result;


        if (Converter.prov(data[0]) && Converter.prov(data[1])) {
            a = Converter.convertToArabian(data[0]);
            b = Converter.convertToArabian(data[1]);
            pr = true;
        } else if (!Converter.prov(data[0]) && !Converter.prov(data[1])) {
            a = Integer.parseInt(data[0]);
            b = Integer.parseInt(data[1]);
            pr = false;
        } else {
            throw new IOException("Числа должны быть в одном формате");
        }


        if (a > 10 || b > 10) {
            throw new IOException("Числа должны быть от 0 до 10");

        }



        switch (op[x]) {
            case "+": result = a + b;
            break;
            case "-": result = a - b;
            break;
            case "*": result = a * b;
            break;
            default: result = a / b;
            break;
        };

        if (pr){
            int xxx = result;
            if (xxx <= 0) {throw new IOException("Римское число не может быть отрицаткльным");}

            System.out.println(Converter.convertToRes(result));


        } else {
            System.out.println(result);
        }

    }





        }


