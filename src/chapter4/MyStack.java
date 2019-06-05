package chapter4;

import java.util.Stack;

public class MyStack {

    String[] operators;
    int[] numbers = new int[100];
    int size = 0;

    public int calculate(String s) {
        operators = s.split(" ");
        return parse(operators);
    }

    String[] splitLine(String line) {
        return line.split(" ");
    }

    public void push(int i) {
        numbers[size] = i;
        size++;
    }

    public int pop() {
        int result = numbers[size - 1];
        size--;
        return result;
    }

    public int parse(String[] operators) {
        int result = 0;

        for (String operator : operators) {
            try {
                int number = Integer.parseInt(operator);
                push(number);
            } catch (Exception e) {
                int number2 = pop();
                int number1 = pop();

                switch (operator) {
                    case "+":
                        result = number1 + number2;
                        break;
                    case "-":
                        result = number1 - number2;
                        break;
                    case "*":
                        result = number1 * number2;
                        break;
                    default:
                        new RuntimeException("不正な演算子");
                }

                push(result);
            }
        }
        return result;
    }

    public int calculateByDefaultStack(String line) {
        operators = splitLine(line);

        Stack<Integer> stack = new Stack<>();
        for (String operator : operators) {
            int a;
            int b;
            switch (operator) {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a + b);
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a * b);
                    break;
                default:
                    stack.push(Integer.parseInt(operator));
                    break;
            }

        }
        return stack.pop();
    }
}
