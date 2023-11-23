@smoke
Feature:F04_search | The Search Test

  Scenario:

  Scenario Outline :
    When user could search using product name "<expected>"
    Then validate for success search "<expected>"
    Examples:
      | expected |
      | book     |
      | laptop   |
      | nike     |

Scenario:
  Scenario Outline :
    When user could search using product serialNumber "<sku>"
    Then validate for success search with sku "<sku>"
    Examples:
      | sku       |
      | SCI_FAITH |
      | APPLE_CAM |
      | SF_PRO_11 |