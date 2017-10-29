#Author: madhan.kumar@flytxt.com

@madhan_test_suite_on_OfferCreation
Feature: Test suite on Offer creation
  I want to check all test cases related to offer page

 @tag1349
  Scenario: Create offer:Track: Verify creating offers with SMS channel NX-1349
    Given login
    When navigate to precision marketing
    Then navigate to offer management
    Then Navigate_to_Offers
    Then Create_offers_with_SMS_channel
    #Then logout
 @tag1351
  Scenario: Create offer:Track: Verify creating offers with Voice Push channel NX-1351
    Given login
    When navigate to precision marketing
    Then navigate to offer management
    Then Navigate_to_Offers
    Then Create_offers_with_VOICEpush_channel
    #Then logout
 @tag1353
  Scenario: Create offer:Track: Verify creating offers with Wap Push channel NX-1353
    Given login
    When navigate to precision marketing
    Then navigate to offer management
    Then Navigate_to_Offers
    Then Create_offers_with_WAPpush_channel
    #Then logout
 @tag1349	
  Scenario: Create offer:Track: Verify creating Balance-Deduction offers NX-1346
    Given login
    When navigate to precision marketing
    Then navigate to offer management
    Then Navigate_to_Offers
    Then Create_offers_of_BalanceDeduction_type
    #Then logout
 @tag6175
  Scenario: Create offer:Track: Verify creating Combo-Offer offers NX-6175
    Given login
    When navigate to precision marketing
    Then navigate to offer management
    Then Navigate_to_Offers
    Then Create_offers_of_ComboOffer_type
    #Then logout
 @tag6177
  Scenario: Create offer:Track: Verify creating Informational offers NX-6177
    Given login
    When navigate to precision marketing
    Then navigate to offer management
    Then Navigate_to_Offers
    Then Create_offers_of_informational_type
    #Then logout
 @tag1348	
  Scenario: Create offer:Track: Verify creating Recharge offers NX-1348
    Given login
    When navigate to precision marketing
    Then navigate to offer management
    Then Navigate_to_Offers
    Then Create_offers_of_Recharge_type
    #Then logout
 @tag1345
  Scenario: Create offer:Track: Verify creating Seeding offers NX-1345
    Given login
    When navigate to precision marketing
    Then navigate to offer management
    Then Navigate_to_Offers
    Then Create_offers_of_Seeding_type
    #Then logout
 @tag6176
  Scenario: Create offer:Track: Verify creating STV offers NX-6176
    Given login
    When navigate to precision marketing
    Then navigate to offer management
    Then Navigate_to_Offers
    Then Create_offers_of_STV_type
    #Then logout
 @tag1347
  Scenario: Create offer:Track: Verify creating Usage Based offers NX-1347
    Given login
    When navigate to precision marketing
    Then navigate to offer management
    Then Navigate_to_Offers
    Then Create_offers_of_UsageBased_type
    #Then logout