Feature: US_001/As a visitor, I must be able to access the websites in order to use the site

  Scenario: Access test to the homepage with URL testing

    Given Kullanici browseri acar
    When "customerPageUrl" i girer
    Then Anasayfaya eriştiğini doğrular
    And Anasayfadaki tüm elementlerin yüklediğini doğrular