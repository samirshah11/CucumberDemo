Feature: AddToCart Functionality

  @Smoke
  Scenario: User should be allow to add items in the cart.
    Given User is on shopping landing page
    When User add few products in cart
    |Tomato|2KG|
    |Cauliflower|3KG|
    Then On cart page product should be appear with defined quantity and amount