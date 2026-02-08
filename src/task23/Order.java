package task23;

import java.util.List;

public class Order {
    private final List<Product> products;
    private PromoCode appliedPromoCode;

    public Order(List<Product> products) {
        this.products = products;
    }

    public void applyDiscount(PromoCode promoCode) {
        this.appliedPromoCode = promoCode;
    }

    public double getTotalPrice() {
        int basePrice = products.stream().mapToInt(Product::price).sum();
        if (appliedPromoCode != null) {
            return basePrice * appliedPromoCode.getDiscount();
        }
        return basePrice;
    }

    public int getBasePrice() {
        return products.stream().mapToInt(Product::price).sum();
    }
}
