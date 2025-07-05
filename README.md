# E-Commerce Checkout System 

This project is a simple Java console-based e-commerce checkout system, built as part of the Fawry Rise Journey Full Stack Internship Challenge.

It demonstrates clean object-oriented design and core domain modeling using Java.

---

## 🧩 Features

- Define products with `name`, `price`, and `quantity`
- Supports:
  - **Expirable products** (e.g., Cheese, Biscuits)
  - **Shippable products** (e.g., Cheese, TV)
- Customers can:
  - Add items to cart with specific quantities
  - Checkout with subtotal, shipping fees, and total amount printed

---

## 💡 OOP Principles Used

- ✅ **Encapsulation** – Data and behavior grouped within domain classes (`Product`, `Customer`, `CheckoutService`)
- ✅ **Abstraction** – Interfaces like `Shippable` and `Expirable` model optional product capabilities
- ✅ **Polymorphism** – Handled using `instanceof` to check behavior (e.g., if product is shippable or expirable)
- ✅ **Separation of Concerns** – `Customer` manages cart; `CheckoutService` handles all business logic

---

## 📦 Example Console Output
** Shipment notice **
2x Cheese 400g
1x Biscuits 700g
Total package weight 1.1kg

** Checkout receipt **
2x Cheese 200$
1x Biscuits 150$
Subtotal 350$
Shipping 30$
Amount 380$


## 🚀 How to Run

1. Open in IntelliJ IDEA
2. Run `Main.java`
3. Console will print checkout and shipping summary

---

## 🔧 Project Structure

- `Product` (abstract base class)
  - `Cheese`, `Biscuits`, `TV`, `MobileCard` (concrete types)
- `CartItem`: product + quantity
- `Customer`: holds cart and balance
- `CheckoutService`: handles checkout rules and printing
- `ShippingService`: prints shipping items

---

## 📄 Notes

- Shipping is calculated at **30 EGP per kg**
- Expired or out-of-stock items are blocked at checkout
- Balance is checked before completing the order

---
