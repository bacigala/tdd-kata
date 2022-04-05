
public class Main {

    public static void main(String[] args) {
        int argsCount = args == null ? 0 : args.length;
        if (argsCount != 1)
            throw new IllegalArgumentException("Expected exactly one argument, got " + argsCount + ".");

        System.out.println(RomanCalculator.evaluate(args[0]));
    }

}
