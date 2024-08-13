Feature: Bir ziyaretçi olarak Homepage sayfasinin header bolumundeki fonksiyonlarin görünür ve aktif olmasini istiyorum

  Background: Ortak adim
    Given Kullanici browseri acar
    When "customerPageUrl" i girer

  Scenario: Anasayfadaki logoya basilinca sayfanin yenilenmesi testi

    Then Header bölümünde logo olduğunu doğrular
    And Logoya tıkladığında anasayfayı refresh ettiğini doğrular

  Scenario: Alısveris sepeti,Sign in butonu görüntülenmesi ve işlevsellik testi

    Then Header bölümünde sağ tarafta Cart bölümü ve cart ikonu olduğunu doğrular
    And Cart bölümüne tıkladığında eklenen ürünleri görüntüler ve doğrular
    When Cart sekmesine tıkladığında ürünlerin toplam fiyatını ve her ürünün fiyatını görüntüler

  Scenario: Sign in butonunun dogru sayfaya yonlendirme testi

    Then Sign-in butonunun varlığını görüntüler
    When Sign-in butonuna tıkladığında login sayfasına gittiğini görüntüler




