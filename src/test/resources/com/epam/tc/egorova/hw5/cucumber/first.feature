Feature: Exercise One

  Scenario: Home Page and Different Elements Page Test
    Given I open JDI GitHub site
    And I login as user 'Roman Iovlev'
    Then user 'Roman Iovlev' should be loggined
    And I open through the header menu Service -> Different Elements Page
    When I select checkboxes
    Then 'Water' and 'Wind' elements should be checked
    When I select 'Selen' radiobutton
    Then 'Selen' element should be checked
    When I select 'Yellow' in dropdown
    Then 'Yellow' element should be selected
    And Log rows should be displayed
