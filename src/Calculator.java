import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение, строки выделяются кавычками \"\" : ");
        String exp = scn.nextLine();
        char action;
        String[] data;

        if (exp.contains(" + ")) {
            data = exp.split(" \\+ ");
            action = '+';
        } else if (exp.contains(" - ")) {
            data = exp.split(" - ");
            action = '-';
        } else if (exp.contains(" * ")) {
            data = exp.split(" \\* ");
            action = '*';
        } else if (exp.contains(" / ")) {
            data = exp.split(" / ");
            action = '/';
        }else{
            throw new Exception("Не найден знак действия");
        }
        if (data[0].contains("\"")) {
        }else {
            throw new Exception("Первым аргументом выражения должна быть строка в кавычках \"\"");
        }
        int dlinnaArgumenta0 = data[0].length();
        int dlinnaArgumenta1 = data[1].length();
        if (dlinnaArgumenta0 > 10 || dlinnaArgumenta1 > 10) throw new Exception("Не больше 10 символов");

        if (action == '*' || action == '/') {
            if (data[1].contains("\"")) throw new Exception("Строку можно делить или умножать только на число");
        }
        if (action == '*' || action == '/') {
            int a = Integer.parseInt(data[1]);
            if (a >= 1 && a <= 10) {
            }else {
                throw new Exception("Используйте числа от 1 до 10");
            }
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }

        if (action == '+') {
            printInQuotes(data[0] + data[1]);
        } else if (action == '*') {
            int multiplier = Integer.parseInt(data[1]);
            String result = "";
            for (int i = 0; i < multiplier; i++) {
                result += data[0];
            }
            printInQuotes(result);
        } else if (action == '-') {
            int index = data[0].indexOf(data[1]);
            if(index == -1){
                printInQuotes(data[0]);
            }else{
                String result = data[0].substring(0, index);
                result+=data[0].substring(index+data[1].length());
                printInQuotes(result);
            }
        }else{
            int newLen = data[0].length()/Integer.parseInt(data[1]);
            String result = data[0].substring(0,newLen);
            printInQuotes(result);
        }


    }
    static void printInQuotes(String text){
        String str = text;
        int a = str.length();
        if (a > 40) {
            System.out.println("\""+(text.substring(0,40)+"...")+"\"");
        }else {
            System.out.println("\""+text+"\"");
        }




    }
}
