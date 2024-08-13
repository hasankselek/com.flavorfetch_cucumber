@Contact
Feature: As a visitor, I would like to have a contact page on the site so that I can communicate with the site administrators that I shop with

  Scenario: TC_0701 Test of display on site's own Email and phone number information and redirect to related links

    Given Kullanici browseri acar
    And  "customerPageUrl" i girer
    Then Anasayfa footer bolumune kadar page down yapar
    Then Contact us' link baglantisina tiklar
    And Acilan sayfada sitenin telefon numarasinin gorundugunu dogrular
    Then Telefon numarasinin erisilebilir oldugunu dogrular
    Then Sitenin emailinin gorundugunu dogrular
    Then Emailin erisilebilir oldugunu dogrular

  Scenario: TC_0702 Test of customer name, customer email, customer message fields and  image section.

    Given Kullanici browseri acar
    And  "customerPageUrl" i girer
    Then Anasayfa footer bolumune kadar page down yapar
    Then Contact us' link baglantisina tiklar
    Then Acilan sayfada isim yazabilmek icin bir box oldugunu dogrular
    Then Isim yazma alaninin zorunlu alan oldugunu dogrular
    Then Sayfada email yazabilmek icin bir box oldugunu dogrular
    Then Email yazma alaninin zorunlu alan oldugunu dogrular
    Then Mesaj yazabilmek icin bir box oldugunu dogrular
    Then Mesaj alaninin zorunlu oldugunu dogrular
    And Contact ile alakali bir resim gorundugunu dogrular


  Scenario: TC_0703 Test of successful submit with correct name and correct formatted email

    Given Kullanici browseri acar
    And  "customerPageUrl" i girer
    Then Anasayfa footer bolumune kadar page down yapar
    Then Contact us' link baglantisina tiklar
    Then Acilan sayfada isim alanini dogru ve eksiksiz bilgilerle doldurur
    Then Email alanini "correct_username_gulpembe" doldurur
    Then Mesaj alanini doldurur
    Then Formu submit eder
    And Basarili bir sekilde submit edebildigini dogrular


  Scenario: TC_0704 Test of unsuccessful submit with correct name and incorrect formatted email

    Given Kullanici browseri acar
    And  "customerPageUrl" i girer
    Then Anasayfa footer bolumune kadar page down yapar
    Then Contact us' link baglantisina tiklar
    Then Acilan sayfada isim alanini dogru ve eksiksiz bilgilerle doldurur
    Then Email alanini "incorrect_username_hasan" doldurur
    Then Mesaj alanini doldurur
    Then Formu submit eder
    And Basarili bir sekilde submit edemedigini dogrular


  Scenario: TC_0705 Test of unsuccessful submit with empty message

    Given Kullanici browseri acar
    And  "customerPageUrl" i girer
    Then Anasayfa footer bolumune kadar page down yapar
    Then Contact us' link baglantisina tiklar
    Then Acilan sayfada isim alanini dogru ve eksiksiz bilgilerle doldurur
    Then Email alanini "correct_username_hasan" doldurur
    Then Formu submit eder
    And Basarili bir sekilde submit edemedigini dogrular