package org.ninad.router;

@Component
public class OrderTools {

    @Tool(description = "Get the current status of an order")
    public String getOrderStatus(String orderId) {

        // Call database/service
        return "Order " + orderId + " is SHIPPED";
    }
}
