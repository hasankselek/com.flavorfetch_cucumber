package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.AdminPage;
import pages.CustomerPage;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerStepDefinitions {

    static CustomerPage customerPage;
    static AdminPage adminPage;
    static MerchantPage merchantPage;
    static Actions actions ;

    @Given("Kullanici browseri acar")
    public void kullanici_browseri_acar() {
        customerPage = new CustomerPage();
        Driver.getDriver().get("about:blank");

    }

    @Given("{string} i girer")
    public void i_girer(String configdenIstenenUrl) {
        customerPage = new CustomerPage();
        adminPage = new AdminPage();
        merchantPage = new MerchantPage();
        Driver.getDriver().navigate().to(ConfigReader.getProperty(configdenIstenenUrl));

    }

    @Given("Anasayfa header bolumundeki Sign in butonuna tiklar")
    public void anasayfa_header_bolumundeki_sign_in_butonuna_tiklar() {
        customerPage = new CustomerPage();

        customerPage.signInButton.click();

    }

    @Then("Password girebilmek icin bir box oldugunu dogrular")
    public void password_girebilmek_icin_bir_box_oldugunu_dogrular() {
        customerPage = new CustomerPage();
        assertTrue(customerPage.passwordBox.isDisplayed());
    }

    @Then("Password girilecek alanin zorunlu oldugunu dogrular")
    public void password_girilecek_alanin_zorunlu_oldugunu_dogrular() {
        customerPage = new CustomerPage();
        assertTrue(customerPage.passwordBox.getAccessibleName().contains("*"));
    }


    @Then("Remember me' secenegi icin bir checkbox oldugunu dogrular")
    public void remember_me_secenegi_icin_bir_checkbox_oldugunu_dogrular() {
        customerPage = new CustomerPage();
        assertTrue(customerPage.rememberMeCheckBox.isDisplayed());
    }

    @Then("Forgot password?' secenegi icin bir link baglantisi oldugunu dogrular")
    public void forgot_password_secenegi_icin_bir_link_baglantisi_oldugunu_dogrular() {
        customerPage = new CustomerPage();
        assertTrue(customerPage.forgotPasswordLink.isDisplayed());
    }

    @Then("Sayfayi kapatir")
    public void sayfayi_kapatir() {
        Driver.quitDriver();
    }

    @Then("Yeni kayitlar icin bir Sign Up link baglantisi oldugunu dogrular")
    public void yeniKayitlarIcinBirSignUpLinkBaglantisiOldugunuDogrular() {
        customerPage = new CustomerPage();
        assertTrue(customerPage.signUpButton.isDisplayed());
    }

    @Then("Email-telefon numarasi girebilmek icin bir box oldugunu dogrular")
    public void emailTelefonNumarasiGirebilmekIcinBirBoxOldugunuDogrular() {
        customerPage = new CustomerPage();
        assertTrue(customerPage.emailBox.isDisplayed());
    }

    @Then("Password'u gizleyip acmak icin goz ikonu oldugunu dogrular")
    public void passwordUGizleyipAcmakIcinGozIkonuOldugunuDogrular() {
        customerPage = new CustomerPage();
        assertTrue(customerPage.passworrdHideShowEye.isDisplayed());
    }

    @And("{int} saniye bekler")
    public void saniyeBekler(int beklenilecekSure) {

        try {
            Thread.sleep(beklenilecekSure * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    @Then("Sign in butonuna tiklar ve basarili giris yapabildigini dogrular")
    public void signInButonunaTiklarVeBasariliGirisYapabildiginiDogrular() {
        customerPage = new CustomerPage();

        customerPage.loginSigninButton.click();
        assertTrue(customerPage.notificicationsButton.isDisplayed());

    }

    @And("Hesaptan cikis yapar")
    public void hesaptanCikisYapar() {
        customerPage = new CustomerPage();
        customerPage.profileDropdownMenu.click();
        customerPage.logoutButton.click();
    }


    @Then("Email-telefon numarasi alanina {string} girer")
    public void emailTelefonNumarasiAlaninaGirer(String configdenIstenenUsernamePhone) {
        customerPage = new CustomerPage();

        customerPage.emailBox.sendKeys(ConfigReader.getProperty(configdenIstenenUsernamePhone));

    }

    @Then("Password alanina  {string} girer")
    public void passwordAlaninaGirer(String configdenIstenenPassword) {
        customerPage = new CustomerPage();

        customerPage.passwordBox.sendKeys(ConfigReader.getProperty(configdenIstenenPassword));

    }


    @When("Sign in butonuna tiklar ve basarili giris yapamadigini dogrular.")
    public void signInButonunaTiklarVeBasariliGirisYapamadiginiDogrular() {
        customerPage = new CustomerPage();
        customerPage.loginSigninButton.click();
        assertTrue(customerPage.loginAlert.isDisplayed());

    }

    @Then("Anasayfa footer bolumune kadar page down yapar")
    public void anasayfa_footer_bolumune_kadar_page_down_yapar() {
        customerPage = new CustomerPage();

        customerPage.cookieAccept.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(customerPage.appStoreLogo).perform();


    }

    @Then("Contact us' link baglantisina tiklar")
    public void contact_us_link_baglantisina_tiklar() {
        customerPage = new CustomerPage();

        Assertions.assertTrue(customerPage.contactUsLink.isDisplayed());
        Assertions.assertTrue(customerPage.contactUsLink.isEnabled());
        customerPage.contactUsLink.click();

    }

    @Then("Acilan sayfada sitenin telefon numarasinin gorundugunu dogrular")
    public void acilan_sayfada_sitenin_telefon_numarasinin_gorundugunu_dogrular() {
        customerPage = new CustomerPage();
        assertTrue(customerPage.contactSiteNumber.isDisplayed());

    }

    @Then("Telefon numarasinin erisilebilir oldugunu dogrular")
    public void telefon_numarasinin_erisilebilir_oldugunu_dogrular() {
        customerPage = new CustomerPage();
        assertTrue(customerPage.contactSiteNumber.isEnabled());

    }

    @Then("Sitenin emailinin gorundugunu dogrular")
    public void sitenin_emailinin_gorundugunu_dogrular() {
        customerPage = new CustomerPage();
        assertTrue(customerPage.contactSiteMail.isDisplayed());

    }

    @Then("Emailin erisilebilir oldugunu dogrular")
    public void emailin_erisilebilir_oldugunu_dogrular() {
        customerPage = new CustomerPage();
        assertTrue(customerPage.contactSiteMail.isEnabled());

    }


    @Then("Acilan sayfada isim yazabilmek icin bir box oldugunu dogrular")
    public void acilanSayfadaIsimYazabilmekIcinBirBoxOldugunuDogrular() {
        customerPage = new CustomerPage();
        assertTrue(customerPage.contactNameBox.isDisplayed());

    }

    @Then("Isim yazma alaninin zorunlu alan oldugunu dogrular")
    public void ısimYazmaAlanininZorunluAlanOldugunuDogrular() {
        customerPage = new CustomerPage();
        assertTrue(customerPage.contactNameBox.getAccessibleName().contains("*"));
    }

    @Then("Sayfada email yazabilmek icin bir box oldugunu dogrular")
    public void sayfadaEmailYazabilmekIcinBirBoxOldugunuDogrular() {
        customerPage = new CustomerPage();
        assertTrue(customerPage.contactMailBox.isDisplayed());

    }

    @Then("Email yazma alaninin zorunlu alan oldugunu dogrular")
    public void emailYazmaAlanininZorunluAlanOldugunuDogrular() {
        customerPage = new CustomerPage();
        assertTrue(customerPage.contactMailBox.getAccessibleName().contains("*"));
    }

    @Then("Mesaj yazabilmek icin bir box oldugunu dogrular")
    public void mesajYazabilmekIcinBirBoxOldugunuDogrular() {
        customerPage = new CustomerPage();
        assertTrue(customerPage.contactMessageBox.isDisplayed());
    }

    @Then("Mesaj alaninin zorunlu oldugunu dogrular")
    public void mesajAlanininZorunluOldugunuDogrular() {
        customerPage = new CustomerPage();
        assertTrue(customerPage.contactMessageBox.getAccessibleName().contains("*"));

    }

    @And("Contact ile alakali bir resim gorundugunu dogrular")
    public void contactIleAlakaliBirResimGorundugunuDogrular() {
        customerPage = new CustomerPage();
        assertTrue(customerPage.contactImage.isDisplayed());
    }

    @Then("Acilan sayfada isim alanini dogru ve eksiksiz bilgilerle doldurur")
    public void acilanSayfadaIsimAlaniniDogruVeEksiksizBilgilerleDoldurur() {
        customerPage = new CustomerPage();
        customerPage.contactNameBox.sendKeys(ConfigReader.getProperty("contactName_hasan"));
    }

    @Then("Mesaj alanini doldurur")
    public void mesajAlaniniDoldurur() {

        customerPage = new CustomerPage();
        customerPage.contactMessageBox.sendKeys(ConfigReader.getProperty("contactMessage"));

    }

    @Then("Formu submit eder")
    public void formuSubmitEder() {
        customerPage = new CustomerPage();
        customerPage.submitFormButton.click();
    }

    @And("Basarili bir sekilde submit edebildigini dogrular")
    public void basariliBirSekildeSubmitEdebildiginiDogrular() {
        customerPage = new CustomerPage();
        assertTrue(customerPage.requestSentText.isDisplayed());


    }

    @Then("Email alanini dogru ve eksiksiz bilgilerle doldurur")
    public void emailAlaniniDogruVeEksiksizBilgilerleDoldurur() {
        customerPage = new CustomerPage();
        customerPage.contactMailBox.sendKeys(ConfigReader.getProperty("correct_username_hasan"));
    }

    @Then("Email alanini {string} doldurur")
    public void emailAlaniniDoldurur(String configdenAlinanEmail) {

        customerPage = new CustomerPage();
        customerPage.contactMailBox.sendKeys(ConfigReader.getProperty(configdenAlinanEmail));


    }

    @And("Basarili bir sekilde submit edemedigini dogrular")
    public void basariliBirSekildeSubmitEdemediginiDogrular() {
        customerPage = new CustomerPage();


        boolean invalidMesajGozuktuMu = true;
        try {
            assertTrue(customerPage.invalidEmailText.isDisplayed());
        } catch (Exception e) {
            invalidMesajGozuktuMu = false;
        }

        assertTrue(invalidMesajGozuktuMu);

    }


    @Then("Anasayfaya eriştiğini doğrular")
    public void anasayfayaEriştiğiniDoğrular() {

        String expectedUrl = ConfigReader.getProperty("customerPageUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(expectedUrl,actualUrl);

    }

    @And("Anasayfadaki tüm elementlerin yüklediğini doğrular")
    public void anasayfadakiTümElementlerinYüklediğiniDoğrular() {

        customerPage = new CustomerPage();
        Assertions.assertTrue(customerPage.flavorFetchLogo.isDisplayed());
    }

    @Then("Footer'daki logonun görüntülendiğini kontrol eder")
    public void footer_daki_logonun_görüntülendiğini_kontrol_eder() {
        Assertions.assertTrue(customerPage.footerLogo.isDisplayed());
    }

    @And("Homepage Footer'daki logoya tıklar")
    public void homepageFooterDakiLogoyaTıklar() {

        customerPage.footerLogo.click();
    }

    @Then("Anasayfanın yenilendiğini doğrular")
    public void anasayfanınYenilendiğiniDoğrular() {
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://qa.flavorfetch.com/";
        Assertions.assertEquals(actualUrl,expectedUrl);
    }

    @Then("Facebook ikonuna tıklar ve doğru sayfaya yönlendirdiğini doğrular")
    public void facebook_ikonuna_tıklar_ve_doğru_sayfaya_yönlendirdiğini_doğrular() {
        customerPage.footerFacebookLogo.click();
        ReusableMethods.bekle(1);
        ReusableMethods.windowaGec("https://www.facebook.com/",Driver.getDriver());
        String expectedFacebookIconUrl = ConfigReader.getProperty("facebookURL");
        String actualFacebookIconUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(expectedFacebookIconUrl,actualFacebookIconUrl,"Facebook icon url yanlış");
        ReusableMethods.windowaGec("https://qa.flavorfetch.com/",Driver.getDriver());

    }

    @Then("Instagram ikonuna tıklar ve doğru sayfaya yönlendirdiğini doğrular")
    public void instagram_ikonuna_tıklar_ve_doğru_sayfaya_yönlendirdiğini_doğrular() {
        customerPage.footerInstagramLogo.click();
        ReusableMethods.windowaGec("https://qa.flavorfetch.com/www.instagram.com",Driver.getDriver());
        String expectedInstagramIconUrl = ConfigReader.getProperty("instagramURL");
        String actualInstagramIconUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(actualInstagramIconUrl,expectedInstagramIconUrl,"Instagram url'si eslesmiyor");
        ReusableMethods.bekle(2);
        ReusableMethods.windowaGec("https://qa.flavorfetch.com/",Driver.getDriver());

    }

    @Then("LinkedIn ikonuna tıklar ve doğru sayfaya yönlendirdiğini doğrular")
    public void linked_ın_ikonuna_tıklar_ve_doğru_sayfaya_yönlendirdiğini_doğrular() {
        customerPage.footerLinkedInLogo.click();
        ReusableMethods.windowaGec("https://qa.flavorfetch.com/www.linkedin.com",Driver.getDriver());
        String expectedLinkedInIconUrl = ConfigReader.getProperty("linkedInURL");
        String actualLinkedInIconUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(actualLinkedInIconUrl, expectedLinkedInIconUrl,"LinkedIn url'si eslesmiyor");
        ReusableMethods.bekle(2);
        ReusableMethods.windowaGec("https://qa.flavorfetch.com/",Driver.getDriver());
    }

    @Then("X ikonuna tıklar ve doğru sayfaya yönlendirdiğini doğrular")
    public void x_ikonuna_tıklar_ve_doğru_sayfaya_yönlendirdiğini_doğrular() {
        customerPage.footerXLogo.click();
        ReusableMethods.windowaGec("https://x.com/",Driver.getDriver());
        String expectedXIconUrl = ConfigReader.getProperty("xURL");
        String actualXIconUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(actualXIconUrl, expectedXIconUrl,"X url'si eslesmiyor");
        ReusableMethods.bekle(2);
        ReusableMethods.windowaGec("https://qa.flavorfetch.com/",Driver.getDriver());
    }

    @Then("Youtube ikonuna tıklar ve doğru sayfaya yönlendirdiğini doğrular")
    public void youtube_ikonuna_tıklar_ve_doğru_sayfaya_yönlendirdiğini_doğrular() {
        customerPage.footerYoutubeLogo.click();
        ReusableMethods.windowaGec("https://www.facebook.com/",Driver.getDriver());
        String expectedYoutubeIconUrl = ConfigReader.getProperty("youtubeURL");
        String actualYoutubeIconUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(actualYoutubeIconUrl, expectedYoutubeIconUrl,"Youtube url'si eslesmiyor");
        ReusableMethods.bekle(2);
        ReusableMethods.windowaGec("https://qa.flavorfetch.com/",Driver.getDriver());
    }

    @Then("App Store ikonuna tıklar ve doğru sayfaya yönlendirdiğini doğrular")
    public void app_store_ikonuna_tıklar_ve_doğru_sayfaya_yönlendirdiğini_doğrular() {
        Assertions.assertTrue(customerPage.appStoreLogo.isDisplayed());
        Assertions.assertTrue(customerPage.appStoreLogo.isEnabled());
        customerPage.appStoreLogo.click();
        String expectedUrl = "https://www.apple.com/app-store/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(expectedUrl,actualUrl);
        Driver.getDriver().navigate().back();
    }

    @Then("Google Play ikonuna tıklar ve doğru sayfaya yönlendirdiğini doğrular")
    public void google_play_ikonuna_tıklar_ve_doğru_sayfaya_yönlendirdiğini_doğrular() {
        Assertions.assertTrue(customerPage.googlePlayLogo.isDisplayed());
        Assertions.assertTrue(customerPage.googlePlayLogo.isEnabled());
        customerPage.googlePlayLogo.click();
        String expectedTitleIcerik = "Google Play";
        String actualTitle = Driver.getDriver().getTitle();
        Assertions.assertTrue(actualTitle.contains(expectedTitleIcerik));
    }

    @Then("Contact Us sayfasının açıldığını doğrular")
    public void contact_us_sayfasının_açıldığını_doğrular() {
        String expectedUrl = "https://qa.flavorfetch.com/contactus";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(expectedUrl,actualUrl);
        Driver.getDriver().navigate().back();
        ReusableMethods.bekle(1);
    }

    @Then("Terms and Conditions link baglantisina tiklar")
    public void terms_and_conditions_link_baglantisina_tiklar() {
        Assertions.assertTrue(customerPage.termsandconditionsLink.isDisplayed());
        Assertions.assertTrue(customerPage.termsandconditionsLink.isEnabled());
        customerPage.termsandconditionsLink.click();
    }
    @Then("Terms and Conditions sayfasının açıldığını doğrular")
    public void terms_and_conditions_sayfasının_açıldığını_doğrular() {
        String expectedUrl = "https://qa.flavorfetch.com/terms-and-conditions";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(expectedUrl,actualUrl);
        Driver.getDriver().navigate().back();
        ReusableMethods.bekle(1);
    }
    @Then("Privacy Policy link baglantisina tiklar")
    public void privacy_policy_link_baglantisina_tiklar() {
        Assertions.assertTrue(customerPage.privacypolicyLink.isDisplayed());
        Assertions.assertTrue(customerPage.privacypolicyLink.isEnabled());
        customerPage.privacypolicyLink.click();
    }
    @Then("Privacy Policy sayfasının açıldığını doğrular")
    public void privacy_policy_sayfasının_açıldığını_doğrular() {
        String expectedUrl = "https://qa.flavorfetch.com/privacy-policy";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(expectedUrl,actualUrl);
        Driver.getDriver().navigate().back();
    }

    @And("Become a Partner linkine tıklar")
    public void becomeAPartnerLinkineTıklar() {
        customerPage.becomeaPartnerLink.click();
        String expectedUrl = "https://qa.flavorfetch.com/merchant/signup";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(expectedUrl,actualUrl);
    }

    @Then("Business başlığını ve Become a Partner linkinin görüntülendiğini doğrular")
    public void businessBaşlığınıVeBecomeAPartnerLinkininGörüntülendiğiniDoğrular() {
        Assertions.assertTrue(customerPage.businessTitle.isDisplayed());
        Assertions.assertTrue(customerPage.becomeaPartnerLink.isDisplayed());
        Assertions.assertTrue(customerPage.becomeaPartnerLink.isEnabled());

    }

    @Then("'FlavorFetchCorp.2023' yazısının görüntülendiğini doğrular")
    public void flavor_fetch_corp_yazısının_görüntülendiğini_doğrular() {
        Assertions.assertTrue(customerPage.flavorFetchCorp2023Text.isDisplayed());
    }

    @Then("flavorfetch.com linkine tıklar")
    public void flavorfetch_com_linkine_tıklar() {
        Assertions.assertTrue(customerPage.flavorFatchLink.isDisplayed());
        Assertions.assertTrue(customerPage.flavorFatchLink.isEnabled());
        customerPage.flavorFatchLink.click();
        String expectedUrl = "https://qa.flavorfetch.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(actualUrl,expectedUrl);
    }

    @Then("Blog başlığının görüntülendiğini doğrular")
    public void blog_başlığının_görüntülendiğini_doğrular() {
        Assertions.assertTrue(customerPage.blogTitleText.isDisplayed());
    }

    @Then("Her bir blog linkine tıklar ve doğru sayfanın açıldığını doğrular")
    public void her_bir_blog_linkine_tıklar_ve_doğru_sayfanın_açıldığını_doğrular() {

        // 1. blog link
        Assertions.assertTrue(customerPage.firstBlogLink.isDisplayed());
        Assertions.assertTrue(customerPage.firstBlogLink.isEnabled());
        customerPage.firstBlogLink.click();
        String expectedUrl = "https://qa.flavorfetch.com/the-social-side-of-online-food-ordering-connecting-communities-through-cuisine";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(expectedUrl,actualUrl);
        Driver.getDriver().navigate().back();
        ReusableMethods.bekle(1);

        // 2. blog link
        Assertions.assertTrue(customerPage.secondBlogLink.isDisplayed());
        Assertions.assertTrue(customerPage.secondBlogLink.isEnabled());
        customerPage.secondBlogLink.click();
        expectedUrl = "https://qa.flavorfetch.com/exploring-the-delights-of-home-cooking-a-guide-to-meal-kit-delivery-services";
        actualUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(expectedUrl,actualUrl);
        Driver.getDriver().navigate().back();
        ReusableMethods.bekle(1);

        // 3. blog link
        Assertions.assertTrue(customerPage.thirdBlogLink.isDisplayed());
        Assertions.assertTrue(customerPage.thirdBlogLink.isEnabled());
        customerPage.thirdBlogLink.click();
        expectedUrl = "https://qa.flavorfetch.com/embrace-the-convenience-ordering-food-online";
        actualUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(expectedUrl,actualUrl);
        Driver.getDriver().navigate().back();
        ReusableMethods.bekle(1);

        // 4. blog link
        Assertions.assertTrue(customerPage.fourthBlogLink.isDisplayed());
        Assertions.assertTrue(customerPage.fourthBlogLink.isEnabled());
        customerPage.fourthBlogLink.click();
        expectedUrl = "https://qa.flavorfetch.com/nourishing-the-body-and-mind-the-healing-power-of-food";
        actualUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(expectedUrl,actualUrl);
        Driver.getDriver().navigate().back();
    }

    @When("Team2 restaurantina gider")
    public void team2_restaurantina_gider() {
        ReusableMethods.customerHasanAccesToTeam2Restaurent();

    }

    @Then("Restaurant ismini ve resmini kontrol eder")
    public void restaurant_ismini_ve_resmini_kontrol_eder() {
        String expectedRestaurantName = "Team2";
        Assertions.assertTrue(customerPage.restaurantName.isDisplayed());
        Assertions.assertEquals(customerPage.restaurantName.getText(), expectedRestaurantName);
        Assertions.assertTrue(customerPage.restaurantPicture.isDisplayed());

    }

    @Then("Restaurant fiyat tipini kontrol eder")
    public void restaurant_fiyat_tipini_kontrol_eder() {
        String expectedRestaurantType = "$ - low cost restaurant";
        Assertions.assertTrue(customerPage.restraurantPriceType.isDisplayed());
        Assertions.assertEquals(customerPage.restraurantPriceType.getText(), expectedRestaurantType);

    }

    @Then("Restaurant tipini kontrol eder")
    public void restaurant_tipini_kontrol_eder() {
        Assertions.assertEquals(customerPage.restraurantType.getText(), customerPage.sandwichAndWraps.getText());
    }

    @Then("Restaurant skorunu kontrol eder")
    public void restaurant_skorunu_kontrol_eder() {
        Assertions.assertTrue(customerPage.restaurantScore.isDisplayed());
        Assertions.assertTrue(0.0 <= Double.parseDouble(customerPage.restaurantScore.getText()) &&
                5.0 >= Double.parseDouble(customerPage.restaurantScore.getText()));

    }

    @When("Toplam yorum sayisina tiklar")
    public void toplam_yorum_sayisina_tiklar() {

        customerPage.restaurantReviews.click();
    }

    @Then("Yorumlara yönlendirilip yönlendirilmedigini kontrol eder")
    public void yorumlara_yönlendirilip_yönlendirilmedigini_kontrol_eder() {

        Assertions.assertTrue(customerPage.sectionReviews.isDisplayed());
        JSUtilities.scrollToTop(Driver.getDriver());
        ReusableMethods.bekle(1);
    }

    @Then("{string} seçeneginin görünüp görünmedigini kontrol eder")
    public void seçeneginin_görünüp_görünmedigini_kontrol_eder(String expectedSaveStoreText) {
        expectedSaveStoreText = "Save store";
        Assertions.assertEquals(customerPage.saveStoreText.getText(), expectedSaveStoreText);
        Assertions.assertTrue(customerPage.favSaveStoreButton.isEnabled());
        ReusableMethods.bekle(3);
        customerPage.favSaveStoreButton.click();
        ReusableMethods.bekle(2);
    }

    @Then("Favori simgesine tiklar")
    public void favori_simgesine_tiklar() {
        customerPage.favSavedButton.click();
    }

    @Then("{string} seçeneginin göründügünü kontrol eder")
    public void seçeneginin_göründügünü_kontrol_eder(String expectedSavedText) {

        expectedSavedText = "Saved";
        Assertions.assertTrue(customerPage.saveStoreText.getText().contains(expectedSavedText));
        ReusableMethods.bekle(3);
    }


    @Then("Siparis alim tiplerini kontrol eder ve tiklar")
    public void siparisAlimTipleriniKontrolEderVeTiklar() {
        List<String> orderTypeText = new ArrayList<>();
        for (int i = 0; i < customerPage.customerOrderType.size(); i++) {
            customerPage.customerOrderType.get(i).click();
            ReusableMethods.bekle(1);
            orderTypeText.add(customerPage.customerOrderType.get(i).getText());
            Assertions.assertTrue(customerPage.customerOrderType.get(i).isDisplayed());
            Assertions.assertTrue(customerPage.customerOrderType.get(i).isEnabled());
            Assertions.assertEquals(customerPage.customerOrderType.get(i).getText(),orderTypeText.get(i));
        }
    }

    @Then("Cart ikonu varsa görüntülendigini dogrular")
    public void cart_ikonu_varsa_görüntülendigini_dogrular() {
        Assertions.assertTrue(customerPage.cartIcon.isDisplayed());
        ReusableMethods.bekle(2);
    }

    @Then("{string} yazisinin görüntülendigini dogrular")
    public void yazisinin_görüntülendigini_dogrular(String expectedEmptyCartText) {
        expectedEmptyCartText = "You don't have any orders here!";
        String actualEmptyCartText = Driver.getDriver().findElement(By.xpath("//*[@class='m-0 mt-3']")).getText();
        Assertions.assertTrue(actualEmptyCartText.contains(expectedEmptyCartText));
        ReusableMethods.bekle(2);
    }

    @And("Cart'in bos olup olmadigini kontrol eder")
    public void cartInBosOlupOlmadiginiKontrolEder() {
        Assertions.assertTrue(customerPage.cartTitle.isDisplayed());
        ReusableMethods.bekle(2);
    }

    @Then("Urun fotograflarinin görüntülendigini dogrular")
    public void urun_fotograflarinin_görüntülendigini_dogrular() {

        for (int i = 1; i < customerPage.merchantProductPictures.size(); i++) {
            Assertions.assertTrue(customerPage.merchantProductPictures.get(i).isDisplayed());
        }
    }

    @Given("Urun fiyati, aciklamasi ve adinin görüntülendigini dogrular")
    public void urun_fiyati_aciklamasi_ve_adinin_görüntülendigini_dogrular() {
        for (int i = 0; i < customerPage.productsInformation.size(); i++) {
            Assertions.assertTrue(customerPage.productsInformation.get(i).isDisplayed());
            Assertions.assertTrue(customerPage.productsInformation.get(i).getText().contains("$"));
        }
    }

    @Given("Menu ve altmenulerin görüntülendigini dogrular")
    public void menuVeAltmenulerinGörüntülendiginiDogrular() {

        Assertions.assertTrue(customerPage.menuText.isDisplayed());
    }

    @Given("Menu ismine basildiginda dogru menuye yönlendirdigini dogrular")
    public void menuIsmineBasildigindaDogruMenuyeYönlendirdiginiDogrular() {

        for (int i = 0; i < customerPage.subMenus.size(); i++) {
            Assertions.assertTrue(customerPage.customerOrderType.get(i).isDisplayed());
            Assertions.assertTrue(customerPage.customerOrderType.get(i).isEnabled());
        }

        String expectedKebabMenuText = customerPage.subMenus.get(0).getText();
        ReusableMethods.bekle(1);
        customerPage.subMenus.get(0).click();
        Assertions.assertEquals(customerPage.kebabText.getText(),expectedKebabMenuText);

        customerPage.subMenus.get(1).click();
        String expectedDondurmaMenuText = customerPage.subMenus.get(1).getText();
        Assertions.assertEquals(customerPage.dondurmaText.getText(),expectedDondurmaMenuText);
    }

    @Given("Add to Cart butonunun görüntülendigini dogrular ve tiklar")
    public void add_to_cart_butonunun_görüntülendigini_dogrular_ve_tiklar() {
        for (int i = 0; i < customerPage.addToCartButton.size(); i++) {
            Assertions.assertTrue(customerPage.addToCartButton.get(i).isDisplayed());
        }
    }

    @Given("Sepete ürün ekler ve bilgilerinin görüntülendigini dogrular")
    public void sepete_ürün_ekler_ve_bilgilerinin_görüntülendigini_dogrular() {
        customerPage.addToCartButton.get(0).click();
        String firstProductNameCart = Driver.getDriver().findElement(By.xpath("(//*[@class='mb-1'])")).getText();
        Assertions.assertTrue(customerPage.productsInformation.get(0).getText().contains(firstProductNameCart));
    }

    @Given("+ butonuna basarak sepete urun ekler")
    public void butonuna_basarak_sepete_ürün_ekler() {
        customerPage.plusButton.click();
        ReusableMethods.bekle(2);
    }

    @Given("Urun sayisinin ve toplam fiyatin arttigini dogrular")
    public void urun_sayisinin_ve_toplam_fiyatin_arttigini_dogrular() {

        String expectedProductQuantity = "2";
        String expectedProductPrice = "30.00$";
        String actualProductQuantity = Driver.getDriver().findElement(By.xpath("//div[@class='col-6 p-0 d-flex justify-content-start flex-column']//div[@class='qty']")).getText();
        String actualProductPrice = Driver.getDriver().findElement(By.xpath("//div[@class='inner-wrapper-sticky']//div[1]//div[1]//div[3]//p[1]")).getText();
        Assertions.assertEquals(actualProductQuantity, expectedProductQuantity);
        Assertions.assertEquals(actualProductPrice,expectedProductPrice);
    }

    @Given("- butonuna basarak sepetteki urun sayisini azaltir")
    public void butonuna_basarak_sepetteki_urun_sayisini_azaltir() {
        customerPage.minusButton.click();
        ReusableMethods.bekle(2);

    }

    @Given("Urun sayisinin ve toplam fiyatin azaldigini dogrular")
    public void urun_sayisinin_ve_toplam_fiyatin_azaldigini_dogrular() {
        String expectedProductQuantity = "1";
        String actualProductQuantity = Driver.getDriver().findElement(By.xpath("//div[@class='col-6 p-0 d-flex justify-content-start flex-column']//div[@class='qty']")).getText();
        String expectedProductPrice = "15.00$";
        String actualProductPrice = Driver.getDriver().findElement(By.xpath("//div[@class='inner-wrapper-sticky']//div[1]//div[1]//div[3]//p[1]")).getText();
        Assertions.assertEquals(actualProductQuantity, expectedProductQuantity);
        Assertions.assertEquals(actualProductPrice,expectedProductPrice);
    }

    @Given("Clear butonuna basar")
    public void clear_butonuna_basar() {
        customerPage.clearButton.click();
        ReusableMethods.bekle(2);
    }

    @Given("Sepetin bos oldugunu dogrular")
    public void sepetin_bos_oldugunu_dogrular() {
        Assertions.assertTrue(customerPage.cartIcon.isDisplayed());
        String expectedEmptyCartText = "You don't have any orders here!";
        String actualEmptyCartText = Driver.getDriver().findElement(By.xpath("//*[@class='m-0 mt-3']")).getText();
        Assertions.assertTrue(actualEmptyCartText.contains(expectedEmptyCartText));
    }

    @Given("Ürünün görselinin, adinin ve fiyatinin görüntülendigini dogrular")
    public void ürünün_görselinin_adinin_ve_fiyatinin_görüntülendigini_dogrular() {
        customerPage.addToCartButton.get(1).click();
        ReusableMethods.bekle(2);
        WebElement customizePageProductImage = Driver.getDriver().findElement(By.xpath("(//*[@class='el-image'])[8]"));
        Assertions.assertTrue(customizePageProductImage.isDisplayed());

        String expectedCustomizePageProductName = "pide";
        String actualCustomizePageProductName = Driver.getDriver().findElement(By.xpath("//*[@id='item-details']/div/h4")).getText();
        Assertions.assertEquals(actualCustomizePageProductName,expectedCustomizePageProductName);

        String expectedCustomizePageProductPrice = "25.00$";
        String actualCustomizePageProductPrice = Driver.getDriver().findElement(By.xpath("//*[@id='item-details']/div/div[2]/label")).getText();
        Assertions.assertEquals(actualCustomizePageProductPrice,expectedCustomizePageProductPrice);

    }

    @Given("{string} basliginin görüntülendigini dogrular ve kutucugu doldurur")
    public void basliginin_görüntülendigini_dogrular_ve_kutucugu_doldurur(String specialInstruction) {
        actions = new Actions(Driver.getDriver());
        specialInstruction = customerPage.specialInstructionsText.getText();
        Assertions.assertTrue(customerPage.specialInstructionsText.isDisplayed());
        Faker faker = new Faker();
        Assertions.assertTrue(customerPage.specialInstructionsTextArea.isDisplayed());
        actions.click(customerPage.specialInstructionsTextArea).sendKeys(faker.lorem().sentence()).perform();

    }

    @Given("{string} basliginin görüntülendigini dogrular ve seceneklerden birini secer")
    public void basliginin_görüntülendigini_dogrular_ve_seceneklerden_birini_secer(String ifSoldOutTitle) {

        ifSoldOutTitle = customerPage.ifSoldOutTitle.getText();
        Assertions.assertTrue(customerPage.ifSoldOutTitle.isDisplayed());
        JSUtilities.clickWithJS(Driver.getDriver(),customerPage.ifSoldOutSelect);
        ReusableMethods.bekle(2);

        Random rand = new Random();
        Select select = new Select(customerPage.ifSoldOutSelect);
        List<WebElement> options = select.getOptions();
        int randomIndex = rand.nextInt(options.size());
        select.selectByIndex(randomIndex);
        ReusableMethods.bekle(3);

    }

    @Given("Urun sayisini artirip azaltir")
    public void urun_sayisini_artirip_azaltir() {
        customerPage.customizePagePlusButton.click();
        ReusableMethods.bekle(2);
        String expectedProductQuantity = "2";
        String actualProductQuantity = customerPage.customizePageQuantity.getText();
        Assertions.assertEquals(actualProductQuantity,expectedProductQuantity);


        customerPage.customizePageMinusButton.click();
        ReusableMethods.bekle(2);
        expectedProductQuantity = "1";
        actualProductQuantity = customerPage.customizePageQuantity.getText();
        Assertions.assertEquals(actualProductQuantity,expectedProductQuantity);
    }

    @Given("{string} butonunun görüntülendigini ve kullanilabilirligini dogrular")
    public void butonunun_görüntülendigini_ve_kullanilabilirligini_dogrular(String customizeAddToCartButton) {
        customizeAddToCartButton = customerPage.customizePageAddToCartButton.getText();
        Assertions.assertTrue(customerPage.customizePageAddToCartButton.isEnabled());
        Assertions.assertTrue(customerPage.customizePageAddToCartButton.isDisplayed());
        Assertions.assertTrue(customerPage.customizePageAddToCartButton.getText().contains("Add to cart - "));

    }

    @Given("{string} yazisinin ve toplam fiyatin görüntülendigini dogrular")
    public void yazisinin_ve_toplam_fiyatin_görüntülendigini_dogrular(String expectedCheckoutText) {
        Assertions.assertTrue(customerPage.checkoutButton.isDisplayed());
        expectedCheckoutText = "Checkout";
        String actualCheckoutText = customerPage.checkoutButton.getText();
        Assertions.assertTrue(customerPage.checkoutButton.getText().contains(expectedCheckoutText));

        List<WebElement> priceListWebElement = Driver.getDriver().findElements(By.xpath("//p[@class='mb-0']"));
        List<String> priceListString = ReusableMethods.stringListesineDonustur(priceListWebElement);

        List<Integer> priceList = new ArrayList<>();
        for (int i = 0; i < priceListString.size(); i++) {
            priceList.add(Integer.parseInt(priceListString.get(i).replace("$", "").replace(".", "")));
        }
        int sum = 0;
        for (Integer number : priceList) {
            sum += number;
        }
        int actualPrice = Integer.parseInt(Driver.getDriver().findElement(By.xpath("//*[@id='vue-cart']/div/div[2]/a/div[2]")).
                getText().replace("$", "").replace(".", ""));
        Assertions.assertEquals(actualPrice, sum);
    }

    @Given("Checkout butonuna tiklar")
    public void checkout_butonuna_tiklar() {
        customerPage.checkoutButton.click();
        ReusableMethods.bekle(2);
    }

    @Given("Dogru sayfaya yönlendirdigini kontrol eder ve önceki sayfaya geri döner")
    public void dogru_sayfaya_yönlendirdigini_kontrol_eder_ve_önceki_sayfaya_geri_döner() {
        String expectedUrl = "https://qa.flavorfetch.com/account/checkout";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        assertEquals(actualUrl, expectedUrl);
        Driver.getDriver().navigate().back();
    }

    @Given("Galeri ve Hakkında bölümlerinin görüntülendigini dogrular")
    public void galeri_ve_hakkında_bölümlerinin_görüntülendigini_dogrular() {

        Assertions.assertTrue(customerPage.aboutRestaurant.isDisplayed());
        Assertions.assertTrue(customerPage.galleryText.isDisplayed());

    }

    @Given("Adress metninin ve Get Direction linkinin görüntülendigini dogrular")
    public void adress_metninin_ve_get_direction_linkinin_görüntülendigini_dogrular() {

        Assertions.assertTrue(customerPage.restaurantAddress.isDisplayed());
        Assertions.assertTrue(customerPage.restaurantGetDirectionLink.isEnabled());
        Assertions.assertTrue(customerPage.restaurantGetDirectionLink.isDisplayed());

    }

    @Given("Opening Hours kısmının görüntülendigini dogrular")
    public void opening_hours_kısmının_görüntülendigini_dogrular() {
        Assertions.assertTrue(customerPage.restaurantOpeningHours.isDisplayed());
        Assertions.assertTrue(customerPage.restaurantOpeningHours.getText().contains("Opening hours:"));
    }

    @Given("Google Maps linkinin görüntülendigini dogrular")
    public void google_maps_linkinin_görüntülendigini_dogrular() {
        Assertions.assertTrue(customerPage.restaurantGoogleMaps.isEnabled());
        Assertions.assertTrue(customerPage.restaurantGoogleMaps.isDisplayed());
    }

    @Then("Header bölümünde logo olduğunu doğrular")
    public void header_bölümünde_logo_olduğunu_doğrular() {
        ReusableMethods.bekle(1);
        assertTrue(customerPage.anaSayfaHeaderLogo.isDisplayed());

    }

    @And("Logoya tıkladığında anasayfayı refresh ettiğini doğrular")
    public void logoya_tıkladığında_anasayfayı_refresh_ettiğini_doğrular() {
        customerPage.anaSayfaHeaderLogo.click();
        ReusableMethods.bekle(2);
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://qa.flavorfetch.com/";
        assertEquals(actualUrl,expectedUrl);
    }

    @Then("Header bölümünde sağ tarafta Cart bölümü ve cart ikonu olduğunu doğrular")
    public void header_bölümünde_sağ_tarafta_cart_bölümü_ve_cart_ikonu_olduğunu_doğrular() {
        ReusableMethods.bekle(1);
        assertTrue(customerPage.cartHeaderButton.isDisplayed());
    }

    @And("Cart bölümüne tıkladığında eklenen ürünleri görüntüler ve doğrular")
    public void cart_bölümüne_tıkladığında_eklenen_ürünleri_görüntüler_ve_doğrular() {
        ReusableMethods.bekle(1);
        customerPage.cartHeaderButton.click();
    }

    @When("Cart sekmesine tıkladığında ürünlerin toplam fiyatını ve her ürünün fiyatını görüntüler")
    public void cart_sekmesine_tıkladığında_ürünlerin_toplam_fiyatını_ve_her_ürünün_fiyatını_görüntüler() {
        ReusableMethods.bekle(1);
        assertTrue(customerPage.cartHeaderSayfa.isDisplayed());
    }

    @Then("Sign-in butonunun varlığını görüntüler")
    public void sign_in_butonunun_varlığını_görüntüler() {
        ReusableMethods.bekle(1);
        assertTrue(customerPage.signInButton.isDisplayed());
    }

    @When("Sign-in butonuna tıkladığında login sayfasına gittiğini görüntüler")
    public void sign_in_butonuna_tıkladığında_login_sayfasına_gittiğini_görüntüler() {
        customerPage.signInButton.click();
        ReusableMethods.bekle(1);
        String expectedUrl = "https://qa.flavorfetch.com/account/login";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        assertEquals(expectedUrl,actualUrl);

    }

    @And("{string} ve {string} ile giriş yapar")
    public void ve_ile_giriş_yapar(String hasanEmail, String hasanSifre) {
        customerPage.signInButton.click();
        customerPage.emailBox.sendKeys(ConfigReader.getProperty(hasanEmail));
        customerPage.passwordBox.sendKeys(ConfigReader.getProperty(hasanSifre));
        customerPage.loginSigninButton.click();
    }
    @Then("Anasayfada yerel mutfakları görüntüler")
    public void anasayfada_yerel_mutfakları_görüntüler() {
        assertTrue(customerPage.localCuisine.isDisplayed());
    }



}

