@smoke
  Feature: F08_Wishlist.feature | user can add products to wish list and be able to view it

    Scenario: user adds the htc one phone to his wish list
      When user clicks on wish list button on the htc phone product
      Then message that confirms addition of the phone appears

Scenario: user after adding the htc one phone

  When user clicks on wish list button on the htc phone product
  Then message that confirms addition of the phone appears
  When  the success message disapear user clicks on the wishlist button on top of the page
  Then verify the quantity of the product is bigger than 0