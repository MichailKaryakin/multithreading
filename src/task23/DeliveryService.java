package task23;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class DeliveryService {
    private final ConcurrentHashMap<String, PromoCode> promoCodesMap = new ConcurrentHashMap<>();
    private final CopyOnWriteArrayList<Order> processedOrders = new CopyOnWriteArrayList<>();

    public void processOrder(Order order, List<String> promoNames) {
        List<PromoCode> candidates = promoNames.stream()
                .map(promoCodesMap::get)
                .filter(Objects::nonNull)
                .filter(pc -> !pc.isUsed() && pc.isValidForOrder(order))
                .sorted(Comparator.comparingDouble(PromoCode::getDiscount).reversed())
                .toList();

        for (PromoCode bestCode : candidates) {
            if (bestCode.tryUse()) {
                order.applyDiscount(bestCode);
                promoCodesMap.remove(bestCode.getCode());
                break;
            }
        }

        processedOrders.add(order);
        System.out.println("Заказ обработан. Итоговая цена: " + order.getTotalPrice());
    }

    public void addPromoCode(PromoCode code) {
        promoCodesMap.put(code.getCode(), code);
    }

    public CopyOnWriteArrayList<Order> getProcessedOrders() {
        return processedOrders;
    }

    public Collection<PromoCode> getAllCodes() {
        return promoCodesMap.values();
    }
}
