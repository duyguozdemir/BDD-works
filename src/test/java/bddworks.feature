Feature: Zara Login-SearchBox Tests
  Background:
    Given Navigate to the website

  @positive
  Scenario Outline:
    When Click the SignPage button
    And Login with username "<userEmail>" and Password "<password>"
    And Click the signIn button
    Then Check and verify login result "Sepet"
    Examples:
      | userEmail                           |  password     |
      | testuserbootcamp@gmail.com          |Cs_123bcamp_123|

  @negative
  Scenario Outline:
    When Click the SignPage button
    And Login with username "<userEmail>" and Password "<password>"
    And Click the signIn button
    Then Check and verify failed login result "Geçerli bir e-posta adresi girin."
    Examples:
      | userEmail                           |  password     |
      | testuserbootcamp@gmail.com          |failedpasss    |


  @positive
  Scenario Outline:
    When Click the searchBox button
    And Click and sendKeys as "<productName>" on searcher
    Then Check and verify search result "SONUÇLAR"
    Examples:
      | productName  |
      | Canta        |

  @negative
  Scenario Outline:
    When Click the searchBox button
    And Click and sendKeys as "<productName>" on searcher
    Then Check and verify no product search result "ARAMADA SONUÇ BULUNAMADI"
    Examples:
      | productName  |
      | DASDASD123   |