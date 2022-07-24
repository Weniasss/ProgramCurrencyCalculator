/**
 * The Currency class provides object
 * that use in Calculator class
 * @version JDK 1.8
 * @author Volodymyr Zaikovskyi
 */
public class Currency {

    private String currencyName;
    private double rate;

    /** Class constructor */
    public Currency(String currencyName, double rate) {
        setCurrencyName(currencyName);
        setRate(rate);
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        if (rate <= 0) {
            String warning = "rate is less than or equal to 0: " + rate;
            throw  new IllegalArgumentException(warning);
        }
        this.rate = rate;
    }
}