import java.lang.Math;

public class Roman {
    public int base;
    public int exponent;
    public String romanForm;
    public Roman(String romanForm, int base, int exponent)
    {
        this.romanForm = romanForm;
        this.base = base;
        this.exponent = exponent;
    }

    public int GetIntegerForm()
    {
        return base * (int)Math.pow(10, exponent);
    }
}
