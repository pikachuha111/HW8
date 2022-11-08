import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    Multiplication multiplication = new Multiplication();
    Division division = new Division();
    Subtraction subtraction = new Subtraction();
    Addition addition = new Addition();
    private double one;
    private double two;
    private String symbolOperation;
    private double res;

    public Menu() {
    }

    public void answer() {
        result();
    }

    private void result() {
        while (!sc.hasNext("exit")) {
            System.out.println("Введите 1ое число");
            one = numbers();
            System.out.println("Введите 2ое число");
            two = numbers();
            System.out.println("Введите мат операцию");
            res = whichMethod();
            System.out.println("Результат " + res);
            sc.next();
        }
    }

    private double numbers() { /* проверка на то, пока не будет int или double */
        double one1 = 0;
        while (!sc.hasNextDouble() || !sc.hasNextInt()) {
            System.out.println("Это не число");
            sc.next();
        }
        if (sc.hasNextInt()) {
            one1 = sc.nextInt();
        } else if (sc.hasNextDouble()) {
            one1 = sc.nextDouble();
        }
        return one1;
    }

    private void symbol() {   /* проверка чтобы ввелся символ */
        char oper;
        boolean ans = false;
        while (!ans) {
            switch (oper = sc.next().charAt(0)) {
                case '+':
                    this.symbolOperation = "Addition";
                   ans = true;
                    break;
                case '-':
                    this.symbolOperation = "Subtraction";
                    ans = true;
                    break;
                case '/':
                    this.symbolOperation = "Division";
                    ans = true;
                    break;
                case '*':
                    this.symbolOperation = "Multiplication";
                    ans = true;
                    break;
                default:
                    System.out.println("Невалидный символ");
            }
        }
    }

    private double whichMethod() { /* исходя из символа сравниваем какой метод будем использовать */
        symbol();
        String method = this.symbolOperation;
        if (method.equals("Multiplication")) {
            return multiplication.action(one, two);
        } else if (method.equals("Division")) {
            return division.action(one, two);
        } else if (method.equals("Addition")) {
            return addition.action(one, two);
        } else return subtraction.action(one, two);
    }

}
