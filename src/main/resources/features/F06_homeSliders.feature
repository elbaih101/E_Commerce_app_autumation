@smoke
  Feature: F06_homeSliders.feature| user should be able to interact with sliders
    Scenario:user can interact with the slider with the samsung phone
      When user clicks on the "0000089_banner_02.webp" "samsung" slider
      Then user is directed to the phone page "/samsung-s22"
    Scenario:user can interact with the slider with the iphone phone
      When user clicks on the "0000088_banner_01.webp" "iphone" slider
      Then user is directed to the phone page "/iphone-14"
