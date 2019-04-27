import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Result result1 = getSca();
        int numb1 = result1.getFirst();
        int count1 = result1.getSecond();

        Result result2 = getSca();
        int numb2 = result2.getFirst();
        int count2 = result2.getSecond();

        char operation = getOperation();

        int count = count1 + count2;
        if (count != 3) {
            int result = calc(numb1, numb2, operation);
            if (count >= 4){
                String resultat = getRoman(result);
                System.out.println("Результат операции: " + resultat);}
            else System.out.println("Результат операции: " + result);
        }
        else System.out.println("Вы допустили ошибку при вводе числа.");
    }
    public static Result getSca() {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        System.out.println("Введите число:");
        int num = 11;
        String rom;
        if (sc.hasNextInt()) {{
                num = sc.nextInt();
            count = 1;
            }
            if (num >= 11) {
                System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
                sc.next();
                getSca();
            }
        } else if (sc.hasNextLine()) {
            rom = sc.nextLine();
            count = 2;
            if (rom.equals("X"))    { num = 10; }
            if (rom.equals("IX"))   { num = 9; }
            if (rom.equals("VIII")) { num = 8;}
            if (rom.equals("VII"))  { num = 7; }
            if (rom.equals("VI"))   { num = 6;}
            if (rom.equals("V"))    { num = 5;}
            if (rom.equals("IV"))   { num = 4;}
            if (rom.equals("III"))  { num = 3;}
            if (rom.equals("II"))   { num = 2;}
            if (rom.equals("I"))    { num = 1;}
            if (num >= 11) {
                System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
                sc.next();
                getSca();
            }
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            sc.next();
             getSca();
        }

        return new Result(num, count);
    }

        public static int calc(int num1, int num2, char operation){
            int result;
            switch (operation){
                case '+':
                    result = num1+num2;
                    break;
                case '-':
                    result = num1-num2;
                    break;
                case '*':
                    result = num1*num2;
                    break;
                case '/':
                    result = num1/num2;
                    break;
                default:
                    System.out.println("Операция не распознана. Повторите ввод.");
                    result = calc(num1, num2, operation);
            }
            return result;
        }
    public static char getOperation(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите операцию:");
        char operation;
        if(sc.hasNext()){
            operation = sc.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            sc.next();
            operation = getOperation();
        }
        return operation;
    }

        public static String getRoman(int number) {

            String riman[] = {"C","XC","L","XL","X","IX","V","IV","I"};
            int arab[] = {100, 90, 50, 40, 10, 9, 5, 4, 1};
            StringBuilder result = new StringBuilder();
            int i = 0;
            while (number > 0 || arab.length == (i - 1)) {
                while ((number - arab[i]) >= 0) {
                    number -= arab[i];
                    result.append(riman[i]);
                }
                i++;
            }
            return result.toString();
        }
}




