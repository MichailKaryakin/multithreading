package task23;

import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

public class PromoCode {
    private final String code;
    private final double discount;
    private final Date expirationDate;
    private final int minimumOrderValue;
    private final AtomicBoolean isUsed = new AtomicBoolean(false);

    public PromoCode(double discount, String code, Date expirationDate, int minimumOrderValue) {
        this.discount = discount;
        this.code = code;
        this.expirationDate = expirationDate;
        this.minimumOrderValue = minimumOrderValue;
    }

    public boolean isValidForOrder(Order order) {
        Date now = new Date();
        return order.getBasePrice() >= minimumOrderValue && now.before(expirationDate);
    }

    public boolean tryUse() {
        return isUsed.compareAndSet(false, true);
    }

    public boolean isUsed() {
        return isUsed.get();
    }

    public String getCode() {
        return code;
    }

    public double getDiscount() {
        return discount;
    }
}
