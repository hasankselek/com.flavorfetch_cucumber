Feature: As a user, I would like to have restaurant pages where I can examine the menus and buy


  Scenario: TC_1101 Restaurant information display and functionality testing

    Given Kullanici browseri acar
    When "customerPageUrl" i girer
    And Team2 restaurantina gider
    Then Restaurant ismini ve resmini kontrol eder
    And Restaurant fiyat tipini kontrol eder
    And Restaurant tipini kontrol eder
    And Restaurant skorunu kontrol eder
    When Toplam yorum sayisina tiklar
    Then Yorumlara yönlendirilip yönlendirilmedigini kontrol eder
    And "Save Store" seçeneginin görünüp görünmedigini kontrol eder
    And Favori simgesine tiklar
    And "Saved" seçeneginin göründügünü kontrol eder


  Scenario: TC_1102 Delivery, Dine, Pickup texts viewing and functionality testing

    * Kullanici browseri acar
    * "customerPageUrl" i girer
    * Team2 restaurantina gider
    * Siparis alim tiplerini kontrol eder ve tiklar


  Scenario: TC_1103 Blank Cart Testing

    * Kullanici browseri acar
    * "customerPageUrl" i girer
    * Team2 restaurantina gider
    * Cart'in bos olup olmadigini kontrol eder
    * Cart ikonu varsa görüntülendigini dogrular
    * "You dont' have any orders here!" yazisinin görüntülendigini dogrular


  Scenario: TC_1104 Product Information Testing

    * Kullanici browseri acar
    * "customerPageUrl" i girer
    * Team2 restaurantina gider
    * Urun fotograflarinin görüntülendigini dogrular
    * Urun fiyati, aciklamasi ve adinin görüntülendigini dogrular

  Scenario: TC_1105 Menu title and submenu display and functionality testing

    * Kullanici browseri acar
    * "customerPageUrl" i girer
    * Team2 restaurantina gider
    * Menu ve altmenulerin görüntülendigini dogrular
    * Menu ismine basildiginda dogru menuye yönlendirdigini dogrular


  Scenario: TC_1106 Adding products to the cart, removing them and cart clearing testing

    * Kullanici browseri acar
    * "customerPageUrl" i girer
    * Team2 restaurantina gider
    * Add to Cart butonunun görüntülendigini dogrular ve tiklar
    * Sepete ürün ekler ve bilgilerinin görüntülendigini dogrular
    * + butonuna basarak sepete urun ekler
    * Urun sayisinin ve toplam fiyatin arttigini dogrular
    * - butonuna basarak sepetteki urun sayisini azaltir
    * Urun sayisinin ve toplam fiyatin azaldigini dogrular
    * Clear butonuna basar
    * Sepetin bos oldugunu dogrular


  Scenario: TC_1107 Product Customize Testing

    * Kullanici browseri acar
    * "customerPageUrl" i girer
    * Team2 restaurantina gider
    * Ürünün görselinin, adinin ve fiyatinin görüntülendigini dogrular
    * "Special Instruction" basliginin görüntülendigini dogrular ve kutucugu doldurur
    * "If Sold Out" basliginin görüntülendigini dogrular ve seceneklerden birini secer
    * Urun sayisini artirip azaltir
    * "Add to Cart" butonunun görüntülendigini ve kullanilabilirligini dogrular


  Scenario: TC_1108 Restaurant information viewing testing

    * Kullanici browseri acar
    * "customerPageUrl" i girer
    * Team2 restaurantina gider
    * Galeri ve Hakkında bölümlerinin görüntülendigini dogrular
    * Adress metninin ve Get Direction linkinin görüntülendigini dogrular
    * Opening Hours kısmının görüntülendigini dogrular
    * Google Maps linkinin görüntülendigini dogrular


  Scenario: TC_1109 Checkout Box Testing

    * Kullanici browseri acar
    * "customerPageUrl" i girer
    * Team2 restaurantina gider
    * Sepete ürün ekler ve bilgilerinin görüntülendigini dogrular
    * "Checkout" yazisinin ve toplam fiyatin görüntülendigini dogrular
    * Checkout butonuna tiklar
    * Dogru sayfaya yönlendirdigini kontrol eder ve önceki sayfaya geri döner