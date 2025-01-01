# E-Commerce Simulation Project

## Overview
This project simulates a basic e-commerce application with functionalities for customers and administrators. It provides a comprehensive product catalog, customer wallet management, discount deals, and customer statuses (Normal, Prime, Elite). The program also supports customer registration, cart management, and checkout processes.

___

## Features

### Admin Features
- **Login**: Admins can log in using their credentials.
- **Product Management**: Add products to categories and set discounts.
- **Deal Management**: Create giveaway deals combining multiple products.

### Customer Features
- **Sign Up and Login**: Customers can register and log in with a username and password.
- **Cart Management**: 
  - Browse products and add them to the cart.
  - Add deals directly to the cart.
  - View and empty the cart.
- **Account Management**:
  - View account balance and add money to the wallet.
  - Upgrade customer status to Prime or Elite with associated perks.
- **Checkout**: Customers can place orders and view applicable discounts.
- **Coupons**: View and apply discount coupons for additional savings.

### Product and Deal Browsing
- **Product Catalog**: Explore products in different categories.
- **Deals**: View available product combinations at discounted giveaway prices.

___

## Classes and Their Responsibilities

### `Customer`
Handles customer data, including name, password, cart, wallet balance, and status. Supports operations such as adding items to the cart, emptying the cart, and upgrading the status.

### `Admin`
Manages admin data such as username and password. Provides methods for admin login.

### `Product`
Represents individual products with attributes such as category ID, name, price, discounts, and discount partners. Also supports giveaway deals.

### `Category`
Represents product categories with an ID, name, and associated product list.

### `lists` (Interface)
Maintains shared data structures:
- `customerList`: List of all registered customers.
- `adminList`: List of admin users.
- `categoryList`: List of product categories.
- `productList`: List of products.
- `dealsList`: List of available product deals.

___

## How to Run the Project

1. Clone the repository or copy the code files into your project folder.
2. Compile the Java code using:
   ```bash
   javac -d . *.java
   ```
3. Run the program using:
   ```bash
   java OOPs_assignment.main
   ```
4. Follow the menu options to explore the e-commerce application.

___

## Menu Options

### Main Menu
- **Enter as Admin**
- **Explore the Product Catalog**
- **Show Available Deals**
- **Enter as Customer**
- **Exit the Application**

### Customer Menu
- **Sign Up**
- **Log In**
- **Back**

### Customer Actions
- **Browse Products**
- **Browse Deals**
- **Add a Product to Cart**
- **Add Products in Deal to Cart**
- **View Coupons**
- **Check Account Balance**
- **View Cart**
- **Empty Cart**
- **Checkout Cart**
- **Upgrade Customer Status**
- **Add Amount to Wallet**
- **Back**

___

## Notes
- The project currently uses in-memory data structures for storage.
- Customer statuses (**Normal**, **Prime**, **Elite**) come with different discount rates and perks.
- Randomized coupon system for additional discounts.
- Admins and customers must enter valid credentials to access their respective functionalities.

___

## Future Improvements
- Implement a database for persistent storage.
- Add a graphical user interface (GUI) for better user experience.
- Enhance security with encrypted passwords.
- Add more detailed reports for admins, such as sales analytics.

___

## Author
This project is developed as part of an assignment to demonstrate object-oriented programming concepts in Java.
