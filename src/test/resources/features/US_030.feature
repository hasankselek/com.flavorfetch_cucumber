@MerchantScheduled
Feature:As a restaurant manager, I want future orders from my restaurant to be listed on the Scheduled page.

  Background:Ortak adim
    Given kullanici merchant hesap bilgileriyle merchant dashboarda giris yapar
    Then Dashboard menusunden Orders'a tiklar
    Then Orders alt menulerinden Scheduled'a tiklar

  Scenario: TC_3001 Test of display scheduled orders and order details in a list format and filter them

    And  Verilen siparislerin listelendigini dogrular
    Then Siparis detaylarinda musteri isminin gorundugunu dogrular
    Then Siparis adetinin gorundugunu dogrular
    When Siparis numarasinin gorundugunu dogrular
    And  Siparis tarih ve saatinin gorundugunu dogrular
    Then Siparisi order number veya customer name girerek ile filtreleme alaninin oldugun dogrular
    Then Order type , payment status ve sort secebilmek icin dropdown menuler oldugunu dogrular
    And  Dasboard'a tiklar
    Then Merchant hesabindan cikis yapar


  Scenario: TC_3002 Test of scheduled orders page header section

    And  Baslik kisminda Orders scheduled as of today ...  yazdigini dogrular
    Then How to manage orders bilgilendirme sayfasi oldugunu dogrular
    Then Accepting Orders butonunun calistigini dogrular
    And  Bildirim butonu gorundugunu  dogrular
    And  Dasboard'a tiklar
    Then Merchant hesabindan cikis yapar


  Scenario: TC_3003  Test of the accept order function

    And Verilen siparise tiklar
    Then "Accept" butonu oldugunu dogrular
    And Accept butonun erisilebilir oldugunu dogrular
    Then Accept butonuna basar ve accepted edildigini dogrular
    And Dasboard'a tiklar
    And Merchant hesabindan cikis yapar

  Scenario: TC_3004 Test of the reject order function

    And Verilen siparise tiklar
    Then "Reject" butonu oldugunu dogrular
    When Reject butonuna basar
    Then Gerekcenin yazilabilecegi box'in oldugunu dogrular
    And Secebilmek icin bir listenin gorundugunu dogrular
    When Seceneklerden birini secer
    And Reject order butonuna basar
    Then Dasboard'a tiklar
    And Merchant hesabindan cikis yapar

  Scenario: TC_3005 Test of order summary to include the names, prices,total quantity and total price of the ordered items

    And Verilen siparise tiklar
    Then Siparis ozetinde urunlerin isimlerinin goruntulendigini dogrular
    And Urunlerin fiyatinin goruntulendigini dogrular
    And Siparis verilen toplam urun adedinin goruntulendigini dogrular
    And Toplam fiyatin goruntulendigini dogrular
    Then Dasboard'a tiklar
    And Merchant hesabindan cikis yapar

  Scenario: TC_3006 Test of being able to print the order slip or download as a pdf format and able to contact option with customer

    And Verilen siparise tiklar
    Then Siparis fisini yazdirmak icin print butonu bulundugunu dogrular
    And Print butonunun erisilebilir oldugunu dogrular
    When More options veya ... ibaresine tiklar
    Then Dropdown menude "Download PDF (A4)" oldugunu dogrular
    And Dropdown menude "Contact customer" oldugunu dogrular
    Then Dasboard'a tiklar
    And Merchant hesabindan cikis yapar