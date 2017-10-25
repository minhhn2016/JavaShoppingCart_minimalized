package MinimalizedShoppingCart;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Item> itemList = new ArrayList<Item>();

    public ShoppingCart() {
    }

    public void add(Product product, int quantity) {

        itemList.add(new Item(product, quantity));
    }

    public void remove(Product product) {
        ArrayList<Item> toRemove = new ArrayList<Item>();
        for (Item item : itemList
             ) {
            if (item.getProduct().getProductId() == product.getProductId()) {
                toRemove.add(item);
            }
        }
        itemList.removeAll(toRemove);
    }

    public double getTotalPrice() {
        double finalCartPrice = 0;
        for (Item item : itemList
             ) {
            finalCartPrice += item.getSubtotal();
        }
        return finalCartPrice;
    }

    @Override
    public String
    toString() {
        String orderSummary = "\n=== Shopping Cart ===\n";
        if (itemList.isEmpty()) {
            orderSummary = "There is no items in the shopping cart.";
        }
        else {
            for (Item item : itemList
                    ) {
            orderSummary += item.getProduct().getProductId() + ": " + item.getProduct().getProductName()
                            + ", quantity: " + item.getQuantity() + ", unit price: " + item.getProduct().getProductPrice()
                            + ", subtotal: " + item.getSubtotal() + "\n";
            };
            orderSummary += "\n" + "TOTAL PRICE: " + getTotalPrice() + " euros";
        }

        return orderSummary;
    }


}
