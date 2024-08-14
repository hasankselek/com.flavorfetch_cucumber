Feature: As a restaurant manager, I would like to have the Delivery page in the Order Type menu
  in order to edit the delivery details

  Scenario: Access test to the admin panel with URL testing

    Given Kullanici browseri acar
    When "adminPageUrl" i girer
    Then Admin anasayfasının açıldığını doğrular
    And Admin panelinin yüklendiğini doğrular