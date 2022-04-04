import java.lang.Math;

public class Roman {
    public int base;
    public int exponent;
    public String symbol;
    public Roman(String symbol)
    {
        this.symbol = symbol;
    }
    public Roman(String symbol, int base, int exponent)
    {
        this.symbol = symbol;
        this.base = base;
        this.exponent = exponent;
    }
    public int GetIntegerForm()
    {
        return base * (int)Math.pow(10, exponent);
    }
}
