@smoke
  Feature: Wishlist | ❤ sure

    Scenario: the ❤ selection
      When click on ❤ HTC
      Then Validate the message was appear

      Scenario:
        When success message gone click on Wishlist
        Then get Qty Value