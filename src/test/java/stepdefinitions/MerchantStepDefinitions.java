package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MerchantPage;
import utilities.Driver;
import utilities.ReusableMethods;
import static org.junit.jupiter.api.Assertions.*;


public class MerchantStepDefinitions {

    static MerchantPage merchantPage;

    @Given("kullanici merchant hesap bilgileriyle merchant dashboarda giris yapar")
    public void kullaniciMerchantHesapBilgileriyleMerchantDashboardaGirisYapar() {
        merchantPage=new MerchantPage();
        ReusableMethods.accessToMerchant();
    }

    @Then("Dashboard menusunden Orders'a tiklar")
    public void dashboardMenusundenOrdersATiklar() {
        merchantPage=new MerchantPage();
        merchantPage.ordersLink.click();

    }

    @Then("Orders alt menulerinden Scheduled'a tiklar")
    public void ordersAltMenulerindenScheduledATiklar() {
        merchantPage=new MerchantPage();
        merchantPage.scheduledLink.click();

    }

    @And("Verilen siparislerin listelendigini dogrular")
    public void verilenSiparislerinListelendiginiDogrular() {
        assertTrue(merchantPage.scheduledOrdersList.size() > 0);
        merchantPage=new MerchantPage();
    }


    @Then("Siparis detaylarinda musteri isminin gorundugunu dogrular")
    public void siparisDetaylarindaMusteriIsmininGorundugunuDogrular() {
        merchantPage=new MerchantPage();
        assertTrue(merchantPage.customerNameInOrderDetails.isDisplayed());

    }

    @Then("Siparis adetinin gorundugunu dogrular")
    public void siparisAdetininGorundugunuDogrular() {
        merchantPage=new MerchantPage();
        assertTrue(merchantPage.itemQuantitiyInOrderDetails.isDisplayed());

    }

    @When("Siparis numarasinin gorundugunu dogrular")
    public void siparisNumarasininGorundugunuDogrular() {
        merchantPage=new MerchantPage();
        assertTrue((merchantPage.orderNumberInOrderDetails.isDisplayed()));

    }

    @And("Siparis tarih ve saatinin gorundugunu dogrular")
    public void siparisTarihVeSaatininGorundugunuDogrular() {
        merchantPage=new MerchantPage();
        assertTrue(merchantPage.orderDatenTimeInOrderDetails.isDisplayed());

    }

    @Then("Siparisi order number veya customer name girerek ile filtreleme alaninin oldugun dogrular")
    public void siparisiOrderNumberVeyaCustomerNameGirerekIleFiltrelemeAlanininOldugunDogrular() {
        merchantPage=new MerchantPage();
        assertTrue(merchantPage.filterBox.isDisplayed());
    }



    @And("Dasboard'a tiklar")
    public void dasboardATiklar() {
        merchantPage=new MerchantPage();
        merchantPage.dashboardLink.click();

    }

    @Then("Merchant hesabindan cikis yapar")
    public void merchantHesabindanCikisYapar() {
        merchantPage=new MerchantPage();
        merchantPage.merchantNameDropdown.click();
        merchantPage.logoutMerchantDashboard.click();
    }

    @Then("Order type , payment status ve sort secebilmek icin dropdown menuler oldugunu dogrular")
    public void orderTypePaymentStatusVeSortSecebilmekIcinDropdownMenulerOldugunuDogrular() {
        merchantPage=new MerchantPage();
        assertTrue(merchantPage.orderTypeDropdownMenu.isDisplayed());
        assertTrue(merchantPage.paymentStatusDropdownMenu.isDisplayed());
        assertTrue(merchantPage.sortDropdownMenu.isDisplayed());

    }

    @And("Baslik kisminda Orders scheduled as of today ...  yazdigini dogrular")
    public void baslikKismindaOrdersScheduledAsOfTodayYazdiginiDogrular() {
        assertTrue(merchantPage.scheduledOrdersLeftHeader.getText().contains("Orders scheduled as of today"));
    }

    @Then("How to manage orders bilgilendirme sayfasi oldugunu dogrular")
    public void howToManageOrdersBilgilendirmeSayfasiOldugunuDogrular() {
        merchantPage.howToManageOrdersLink.click();
        String expectedUrl = "https://qa.flavorfetch.com/backoffice/orders/scheduled/howtomanageorders/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        assertEquals(actualUrl, expectedUrl);

    }

    @Then("Accepting Orders butonunun calistigini dogrular")
    public void acceptingOrdersButonununCalistiginiDogrular() {
        assertTrue(merchantPage.acceptingOrdersButton.isEnabled());
    }

    @And("Bildirim butonu gorundugunu  dogrular")
    public void bildirimButonuGorundugunuDogrular() {
        assertTrue(merchantPage.notificationsButton.isDisplayed());
    }


    @Given("Verilen siparise tiklar")
    public void verilen_siparise_tiklar() {
        merchantPage.scheduledOrdersList.get(1).click();

    }

    @Given("Accept butonun erisilebilir oldugunu dogrular")
    public void accept_butonun_erisilebilir_oldugunu_dogrular() {

        assertTrue(merchantPage.acceptedButton.isEnabled());

    }
    @Given("Accept butonuna basar ve accepted edildigini dogrular")
    public void accept_butonuna_basar_ve_accepted_edildigini_dogrular() {
        merchantPage.acceptedButton.click();
        ReusableMethods.bekle(2);
        assertEquals(merchantPage.orderStatus.getText(), "accepted");

    }


    @Given("{string} butonu oldugunu dogrular")
    public void butonuOldugunuDogrular(String butonIsmi) {

        if (butonIsmi.equalsIgnoreCase("Accept")) {
            String expectedButtonText = butonIsmi;
            String actualButtonText = merchantPage.acceptedButton.getText();
            assertEquals(actualButtonText, expectedButtonText);
        } else {
            String expectedButtonText = butonIsmi;
            String actualButtonText = merchantPage.rejectButton.getText();
            assertEquals(actualButtonText, expectedButtonText);
        }

    }

    @And("Reject butonuna basar")
    public void rejectButonunaBasar() {

        merchantPage.rejectButton.click();
    }

    @And("Gerekcenin yazilabilecegi box'in oldugunu dogrular")
    public void gerekceninYazilabilecegiBoxInOldugunuDogrular() {
        assertTrue(merchantPage.rejectReasonTextBox.isEnabled());
    }

    @And("Secebilmek icin bir listenin gorundugunu dogrular")
    public void secebilmekIcinBirListeninGorundugunuDogrular() {
        assertTrue(merchantPage.rejectReasonPickArea.isDisplayed());
    }

    @And("Seceneklerden birini secer")
    public void seceneklerdenBiriniSecer() {
        merchantPage.rejectReason.click();

    }

    @And("Reject order butonuna basar")
    public void rejectOrderButonunaBasar() {
        merchantPage.rejectOrderButton.click();
    }

    @And("Siparis ozetinde urunlerin isimlerinin goruntulendigini dogrular")
    public void siparisOzetindeUrunlerinIsimlerininGoruntulendiginiDogrular() {
        ReusableMethods.bekle(2);
        assertTrue(merchantPage.productNameOrderSummary.isDisplayed());
    }

    @And("Urunlerin fiyatinin goruntulendigini dogrular")
    public void urunlerinFiyatininGoruntulendiginiDogrular() {
        assertTrue(merchantPage.productPriceOrderSummary.isDisplayed());
    }

    @And("Siparis verilen toplam urun adedinin goruntulendigini dogrular")
    public void siparisVerilenToplamUrunAdedininGoruntulendiginiDogrular() {
        assertTrue(merchantPage.subTotalQuantityOrderSummary.isDisplayed());
    }

    @And("Toplam fiyatin goruntulendigini dogrular")
    public void toplamFiyatinGoruntulendiginiDogrular() {
        assertTrue(merchantPage.subTotalPriceOrderSummary.isDisplayed());
    }

    @And("Siparis fisini yazdirmak icin print butonu bulundugunu dogrular")
    public void siparisFisiniYazdirmakIcinPrintButonuBulundugunuDogrular() {
        assertTrue(merchantPage.printButton.isDisplayed());

    }

    @And("Print butonunun erisilebilir oldugunu dogrular")
    public void printButonununErisilebilirOldugunuDogrular() {
        assertTrue(merchantPage.printButton.isEnabled());
    }

    @And("More options veya ... ibaresine tiklar")
    public void moreOptionsVeyaIbaresineTiklar() {
        merchantPage.moreOptionsDropdownButton.click();

    }

    @And("Dropdown menude {string} oldugunu dogrular")
    public void dropdownMenudeOldugunuDogrular(String istenenLink) {
        assertTrue(merchantPage.moreOptionsDropdownMenu.getText().contains(istenenLink));

    }
}

