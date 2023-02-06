@smoke
  Feature: user can click the follow us links and redirected to the required social network
    Scenario:user opens facebook link
      When  user clicks on the "facebook" logo in the end of the page
      Then "https://www.facebook.com/nopCommerce"  is opened in new tab

    Scenario:user opens twitter link
      When  user clicks on the "twitter" logo in the end of the page
      Then "https://twitter.com/nopCommerce"  is opened in new tab

    Scenario:user opens rss link
      When  user clicks on the "rss" logo in the end of the page
      Then "https://demo.nopcommerce.com/new-online-store-is-open"  is opened in new tab

    Scenario:user opens  youtube link
      When  user clicks on the "youtube" logo in the end of the page
      Then "https://www.youtube.com/user/nopCommerce"  is opened in new tab
