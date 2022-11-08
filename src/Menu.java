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
            System.out.println("������� 1�� �����");
            one = numbers();
            System.out.println("������� 2�� �����");
            two = numbers();
            System.out.println("������� ��� ��������");
            res = whichMethod();
            System.out.println("��������� " + res);
            sc.next();
        }
    }

    private double numbers() { /* �������� �� ��, ���� �� ����� int ��� double */
        double one1 = 0;
        while (!sc.hasNextDouble() || !sc.hasNextInt()) {
            System.out.println("��� �� �����");
            sc.next();
        }
        if (sc.hasNextInt()) {
            one1 = sc.nextInt();
        } else if (sc.hasNextDouble()) {
            one1 = sc.nextDouble();
        }
        return one1;
    }

    private void symbol() {   /* �������� ����� ������ ������ */
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
                    System.out.println("���������� ������");
            }
        }
    }

    private double whichMethod() { /* ������ �� ������� ���������� ����� ����� ����� ������������ */
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
