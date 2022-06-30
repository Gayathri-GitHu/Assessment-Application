@tag
Feature: Shopping application 
  I want to register to the application and shop in it

  @signin
  Scenario Outline: Successful SignIn with Valid data
    Given User launches the application 
    When User navigates to the registration page "<Email>"
    And User enters the required information in Your Personal Information section "<FirstName>","<LastName>","<Password>","<Day>","<Month>","<year>"
    And User enters the required information in Your Address section "<Company>","<Address1>","<Address2>","<City>","<State>","<PostalCode>","<AdditionalInfo>","<Phone>","<Pref>"
    And User Registers the account
    Then User validates the Account name in the landing page "<FirstName>","<LastName>"
    And User Logout from the application
    Examples:
    |Email|FirstName|LastName|Password|Day|Month|year|Company|Address1|Address2|City|State|AdditionalInfo|PostalCode|Phone|Pref|
    |ukg@gmail.com|Viaz|Niaz|Password|5|April|2015|Comp|Home Apartment|HomeRoad|HomeCity|California|HomeLocation|000000|10000900000|Home|
  
  @cart
  Scenario Outline: Successful addition of a product to the cart
    Given User launches the application  
    And User Login to the application "<email>","<password>"
    Then User validates the Account name in the landing page "<FirstName>","<LastName>"
    And User search a product "<productname>"
    And User adds the product to the cart "<productname>"
		Then User proceed to the payments "<productname>"
		Then User validates the detail 
    Examples: 
      | productname  |email| password|FirstName|LastName|
      | Faded Short Sleeve T-shirts |    ukg@gmail.com|Password|Viaz|Niaz|
    