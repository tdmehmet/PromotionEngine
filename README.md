# Problem Statement 1: Promotion engine

# Promotion Sample:

- Simple promotion engine for a checkout process.
- Cart contains a list of single character SKU ids (A, B, C...) over which the promotion engine will need to run.
- Test Cases :
- Unit Price for SKU IDs :
- A -> 50, B -> 30, C -> 20, D -> 15
- Active Promotions:
- 3As -> 130, 2Bs -> 45, C & D -> 30
- CASE 1 : 1 A, 1 B, 1 C - Test Method : should_return_100_when_A_B_C_Ordered_Once - Expected Value: 100
- CASE 2 : 5 A, 5 B, 1 C - Test Method : should_return_370_when_5A_5B_1C_Ordered - Expected Value: 370
- CASE 3 : 3 A, 5 B, 1 C, 1 D - Test Method : should_return_280_when_3A_5B_1C_1D_Ordered - Expected Value: 280

# com.promotion.engine.controller (Controller Package)

# PromotionEngineController.java (Controller Class):

- This is the initialization class for Promotion Engine. (Not used but will can be implemented as a Web Interface, a classic main method or as a spring MVC component).
- A future enhancement

# com.promotion.engine.service (Service Package)

# IPromotionService (Service Interface):

- Used for polymorphism of the classes ComboPromotionService and NonComboPromotionService.

# ComboPromotionService (Service Class):

- Calculates promotions for combined products (promotions which has more than one distinct SKUs) as in the test case 3.

# NonComboPromotionService (Service Class):

- Calculates promotions for non combined products (Promotions which has only one distinct SKU) as in the test cases 1 and 2.

# IPriceService (Service Interface):

- Used as Interface for Price Service.

# PriceService (Service Class):

- Calculates cart price by applying all promotions (Combined and non combined). Used for test cases 1, 2 and 3

# com.promotion.engine.repository (Repository Package)

# IPromotionRepository (Repository Interface):

- Used as an interface for Promotion Repository which returns all promotions from external systems (For this case it is hard coded).

# PromotionRepository (Repository Class):

- Used for gathering all promotions from external systems that can be a database, an other API etc... (For this case it is hard coded).

# com.promotion.engine.model (Model Package)

# Product (Model Class):

| Field Name | Usage                                                                                                                                | Used |
| ---------- | ------------------------------------------------------------------------------------------------------------------------------------ | ---- |
| sku        | Product' s single character SKU code.                                                                                                | Yes  |
| unitPrice  | Price used to calculate total cart price for the remaining items after promotion calculations.                                       | Yes  |
| discount   | Used if any discount is applied to any product. In the sample test cases it is not used but mentioned as a future optional promotion | No   |

| Method Name        | Usage                                                                                 | Used |
| ------------------ | ------------------------------------------------------------------------------------- | ---- |
| getDiscountedPrice | Returns product' s discounted price for future enhancement.                           | No   |
| equals             | Overridden method to compare just SKU fields for the equality of 2 product instances. | Yes  |

# ProductItem (Model Class):

| Field Name | Usage                                                                                                                 | Used |
| ---------- | --------------------------------------------------------------------------------------------------------------------- | ---- |
| product    | Product itself. Used for both promotion and cart product' s info                                                      | Yes  |
| quantity   | used for Number of Product items in the cart or minimum number Product to be ordered for activation of any promotion. | Yes  |

# Promotion (Model class):

| Field Name        | Usage                                                                                                      | Used |
| ----------------- | ---------------------------------------------------------------------------------------------------------- | ---- |
| List<ProductItem> | List of products of promotion. It is a list because there maybe more than one distinct SKUs in a Promotion | Yes  |
| promotionPrice    | Total promotion price. As a sample 3 As is 130                                                             | Yes  |
| comboPromotion    | Determines if the promotion is for a combination of more than 1 products. Like C & D is 30                 | Yes  |
| priority          | Determines the priority of the promotion to be applied. It is not used but can be used in the future       | No   |

| Method Name        | Usage                                                                                                                       | Used |
| ------------------ | --------------------------------------------------------------------------------------------------------------------------- | ---- |
| getPromotionProfit | Used to calculate total profit of promotion. This may be used as a future enhancement to apply promotions by their profits. | No   |

# Cart (Model class):

| Field Name        | Usage                                                                                                        | Used |
| ----------------- | ------------------------------------------------------------------------------------------------------------ | ---- |
| List<ProductItem> | List of ordered products in the Cart. It is a list because there maybe more than one distinct SKUs in a Cart | Yes  |

| Method Name                  | Usage                                                                                                                                          | Used |
| ---------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------- | ---- |
| getcartPriceWithoutPromotion | Returns total price of cart without applying any promotion. This maybe used as a future enhancement to calculate total profit of Cart.         | No   |
| findItem                     | This method is used to find cart product item by given any other product Item. It is used especially matching cart and promotion product items | Yes  |

# com.promotion.engine.test (package) :

# PromotionEngineTest (class):

- Used for testing the following scenarios :

1. 1 A, 1 B, 1 C -> test name: should_return_100_when_A_B_C_Ordered_Once
2. 5 A, 5 B, 1 C -> test name: should_return_370_when_5A_5B_1C_Ordered
3. 3 A, 5 B, 1 C, 1 D -> should_return_280_when_3A_5B_1C_1D_Ordered

# Process Flow:

1. Request comes to controller (This time requests are created with JUnit 5)
2. A cart instance is created according to test cases mentioned as above scenarios.
3. Price Service class' s calculatePromotedTotalPrice service is called with the cart instance.
4. Promotions are applied in a loop of promotions that are gathered via Promotion Repository.
5. Promotion service is selected according to the boolean variable comboPromotion. If it is a combopromotion then combo promotion class' s calculatePromotionService used if not non combo promotion class' s calculatePromotionService is used.
6. Remaning product prices are calculated.
7. Promoted products price and remaining product prices are summed and returned to test cases.

# Feature enhancement:

- Can be enhanced to calculate discounts for a given product.
- Application of all promotions according to selected priority or max profit.

# Technologies:

1. Java programming language is used to implement statement. Version of Java is Java-11.
2. Maven is used for package management
3. Eclipse latest version 2021-12 (4.22.0) with Build Id: 20211202-1639 is used as Integrated Development Environment.
