@Login
Feature: As a user, I want to be able to login with my email and password information that I registered on the site.

  Scenario: TC_0501 Test of "Email","Password","Forgot password?", "Remember me"  and "Sign Up" fields

    Given Kullanici browseri acar
    And  "customerPageUrl" i girer
    And  Anasayfa header bolumundeki Sign in butonuna tiklar
    And 2 saniye bekler
    Then Email-telefon numarasi girebilmek icin bir box oldugunu dogrular
    Then Password girebilmek icin bir box oldugunu dogrular
    Then Password girilecek alanin zorunlu oldugunu dogrular
    Then Password'u gizleyip acmak icin goz ikonu oldugunu dogrular
    Then Remember me' secenegi icin bir checkbox oldugunu dogrular
    Then Forgot password?' secenegi icin bir link baglantisi oldugunu dogrular
    Then Yeni kayitlar icin bir Sign Up link baglantisi oldugunu dogrular


  Scenario: TC_0502 Test of successful logging in with the correct email and correct password

    Given Kullanici browseri acar
    And  "customerPageUrl" i girer
    And  Anasayfa header bolumundeki Sign in butonuna tiklar
    Then Email-telefon numarasi alanina "correct_username_hasan" girer
    Then Password alanina  "correct_password_hasan" girer
    Then Sign in butonuna tiklar ve basarili giris yapabildigini dogrular
    And Hesaptan cikis yapar


  Scenario: TC_0503 Test of successful logging in with the correct phone number and correct password

    Given Kullanici browseri acar
    And  "customerPageUrl" i girer
    And  Anasayfa header bolumundeki Sign in butonuna tiklar
    Then Email-telefon numarasi alanina "correct_phonenumber_hasan" girer
    Then Password alanina  "correct_password_hasan" girer
    Then Sign in butonuna tiklar ve basarili giris yapabildigini dogrular
    And Hesaptan cikis yapar

  Scenario: TC_0504 Test of unsuccessful logging in with the incorrect email and correct password

    Given Kullanici browseri acar
    And  "customerPageUrl" i girer
    And  Anasayfa header bolumundeki Sign in butonuna tiklar
    Then Email-telefon numarasi alanina "incorrect_username_hasan" girer
    Then Password alanina  "correct_password_hasan" girer
    And 2 saniye bekler
    When Sign in butonuna tiklar ve basarili giris yapamadigini dogrular.


  Scenario: TC_0505 Test of unsuccessful logging in with the correct email and incorrect password

    Given Kullanici browseri acar
    And  "customerPageUrl" i girer
    And  Anasayfa header bolumundeki Sign in butonuna tiklar
    Then Email-telefon numarasi alanina "correct_username_hasan" girer
    Then Password alanina  "incorrect_password_hasan" girer
    When Sign in butonuna tiklar ve basarili giris yapamadigini dogrular.