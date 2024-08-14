Feature: Bir ziyaretçi olarak alisveris yaptigim sitenin ödeme ve iade koşullarının belirtildiği bir sayfanın olmasını istiyorum.

  Background: Ortak adim
    Given Kullanici browseri acar
    When "customerPageUrl" i girer

  Scenario:Terms and Conditions sayfasina erişme testi

    And Anasayfa footer bolumune kadar page down yapar
    Then Terms and Conditions yazisinin görüntülendigini dogrular
    And Terms and Conditions link baglantisina tiklar
    Then Terms and Conditions sayfasının açıldığını doğrular

  Scenario:Terms and Conditions bağlantısına duyarlı bir tasarımla sayfanın altbilgi bölümünden erişilebilir olmalıdır.

    And Kullanıcı “İtalyan Banner”ına tıklar
    And Sayfanın alt kısmına (footer’a) kadar kaydırır
    Then Şartlar ve Koşullar bağlantısının görünürlüğünü doğrular
    When Şartlar ve Koşullar bağlantısına tıklar
    Then Şartlar ve Koşullar sayfasına erişir


