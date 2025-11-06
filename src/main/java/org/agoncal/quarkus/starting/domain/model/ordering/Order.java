package org.agoncal.quarkus.starting.domain.model.ordering;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

    public class Order {
        private UUID id;
        private UUID userId;
        private List<String> items;
        private BigDecimal totalPrice;
        private String status;

        public Order(UUID userId, List<String> items) {
            this.id = UUID.randomUUID();
            this.userId = userId;
            this.items = items;
//            this.totalPrice = calculateTotal(items);
//            this.status = OrderStatus.PENDING;
        }

//        private BigDecimal calculateTotal(List<String> items) {
//            return items.stream()
//                    .map(OrderItem::getPrice)
//                    .reduce(BigDecimal.ZERO, BigDecimal::add);
//        }
    }


