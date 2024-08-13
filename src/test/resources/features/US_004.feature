Feature: As a visitor, I want the functions in the footer of the Home page to be visible and active

  Scenario: Website logo presence and functionality testing

    Given Kullanici browseri acar
    When "customerPageUrl" i girer
    And Anasayfa footer bolumune kadar page down yapar
    Then Footer'daki logonun görüntülendiğini kontrol eder
    And Homepage Footer'daki logoya tıklar
    Then Anasayfanın yenilendiğini doğrular

  Scenario: Social media logos presence and functionality testing

    Given Kullanici browseri acar
    When "customerPageUrl" i girer
    And Anasayfa footer bolumune kadar page down yapar
    Then Facebook ikonuna tıklar ve doğru sayfaya yönlendirdiğini doğrular
    Then Instagram ikonuna tıklar ve doğru sayfaya yönlendirdiğini doğrular
    Then LinkedIn ikonuna tıklar ve doğru sayfaya yönlendirdiğini doğrular
    Then X ikonuna tıklar ve doğru sayfaya yönlendirdiğini doğrular
    Then Youtube ikonuna tıklar ve doğru sayfaya yönlendirdiğini doğrular


  Scenario: App Store-Google Play icons presence and functionality testing

    Given Kullanici browseri acar
    When "customerPageUrl" i girer
    And Anasayfa footer bolumune kadar page down yapar
    Then App Store ikonuna tıklar ve doğru sayfaya yönlendirdiğini doğrular
    Then Google Play ikonuna tıklar ve doğru sayfaya yönlendirdiğini doğrular


  Scenario: 'Contact Us','Terms and Conditions' and 'Privacy Policy' links functionality testing

    Given Kullanici browseri acar
    When "customerPageUrl" i girer
    And Anasayfa footer bolumune kadar page down yapar
    And Contact us' link baglantisina tiklar
    Then Contact Us sayfasının açıldığını doğrular
    When Terms and Conditions link baglantisina tiklar
    Then Terms and Conditions sayfasının açıldığını doğrular
    When Privacy Policy link baglantisina tiklar
    Then Privacy Policy sayfasının açıldığını doğrular


  Scenario: 'Become a Partner' link functionality testing

    Given Kullanici browseri acar
    When "customerPageUrl" i girer
    Then Anasayfa footer bolumune kadar page down yapar
    Then Business başlığını ve Become a Partner linkinin görüntülendiğini doğrular
    And Become a Partner linkine tıklar


  Scenario: 'FlavorFetch.com' link redirection and 'Flavor Fetch Corp. 2023' text visibility testing

    Given Kullanici browseri acar
    When "customerPageUrl" i girer
    Then Anasayfa footer bolumune kadar page down yapar
    Then 'FlavorFetchCorp.2023' yazısının görüntülendiğini doğrular
    Then flavorfetch.com linkine tıklar
    And Anasayfanın yenilendiğini doğrular

  Scenario: Access to blog posts under 'Blog' title test

    Given Kullanici browseri acar
    When "customerPageUrl" i girer
    Then Anasayfa footer bolumune kadar page down yapar
    Then Blog başlığının görüntülendiğini doğrular
    And Her bir blog linkine tıklar ve doğru sayfanın açıldığını doğrular