package task22;

import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;

class SensorData {
    private final DoubleAdder sum = new DoubleAdder();
    private final LongAdder count = new LongAdder();

    public void addValue(double value) {
        sum.add(value);
        count.increment();
    }

    public double getAverageAndReset() {
        double s = sum.sumThenReset();
        long c = count.sumThenReset();
        return c == 0 ? 0 : s / c;
    }
}