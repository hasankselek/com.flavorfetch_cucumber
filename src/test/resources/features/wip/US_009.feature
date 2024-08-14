Feature: Bir ziyaretçi olarak alisveris yaptigim sitenin gizlilik politikalarının belirtildiği bir sayfanın olmasını istiyorum.

  Background: Ortak adim
    Given Kullanici browseri acar
    When "customerPageUrl" i girer
    And Anasayfa footer bolumune kadar page down yapar

  Scenario: Privacy Policy sayfasina erişim testi

    Then Anasayfanın footer bölümünde gizlilik politikası navigasyonunu görür
    And Gizlilik politikası sayfasının navigasyon linkine tıklar
    Then Gizlilik politikası sayfasının yüklendiğini görüntüler

  Scenario: Privacy Policy sayfasi ve Privacy Policy yazisi görüntüleme testi

    And Gizlilik politikası sayfasının navigasyon linkine tıklar
    Then Gizlilik politikası sayfasında “Gizlilik Politikası” başlığını görüntüler

  Scenario: Privacy Policy sayfasi için Contact adresi testi

    And Gizlilik politikası sayfasının navigasyon linkine tıklar
    Then Gizlilik politikasi sayfasinda gizlilik politikasi ve bilgi guvenligi hakkinda iletisim adresi oldugunu goruntuler
    And Iletisim adresine tiklanir bir e-posta istemcisini açar ve tıklanan e-posta adresini alıcı olarak otomatik olarak ekler.


