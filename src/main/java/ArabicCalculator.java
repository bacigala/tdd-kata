
public class ArabicCalculator {

    public static Integer evaluate(int operand1, int operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0)
                    return null;
//                if (operand1 % operand2 != 0)
//                    return null;
                return operand1 / operand2;
            default:
                return null;
        }
    }

}
