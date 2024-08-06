// forecasting/FinancialForecast.java
package forecasting;

public class FinancialForecast {

    public double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // Base case: If no more periods left, return the present value
        if (periods == 0) {
            return presentValue;
        }
        // Recursive case: Calculate the future value for the next period
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        FinancialForecast forecast = new FinancialForecast();
        double presentValue = 1000.0; // Present value
        double growthRate = 0.05; // 5% growth rate
        int periods = 10; // Number of periods (years)

        double futureValue = forecast.calculateFutureValue(presentValue, growthRate, periods);
        System.out.println("Future Value: " + futureValue);
    }
}
