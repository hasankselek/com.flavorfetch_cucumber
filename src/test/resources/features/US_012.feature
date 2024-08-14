Feature: Bir kullanıcı olarak menüleri inceleyip satın alabileceğim restoran sayfalarının olmasını isterim.

  Background: Ortak adim
    Given Kullanici browseri acar
    When "customerPageUrl" i girer

  Scenario: Yerel mutfağa sahip restoranlari customer ana sayfasında görüntüleme testi

    When Sign-in butonuna tıkladığında login sayfasına gittiğini görüntüler
    And "correct_username_hasan" ve "correct_password_hasan" ile giriş yapar
    Then Anasayfada yerel mutfakları görüntüler