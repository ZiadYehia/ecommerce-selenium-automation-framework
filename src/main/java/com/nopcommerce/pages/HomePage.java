package com.nopcommerce.pages;

import com.nopcommerce.utils.bots.ActionsBot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class HomePage {
    //variables
    private WebDriver driver;
    private ActionsBot actionsBot;
    //locators
    By welcomeMsg = By.cssSelector("[class=\"topic-block-title\"]");
    By loginLink = By.cssSelector("[class=\"ico-login\"]");
    By logoutLink = By.cssSelector("[class=\"ico-logout\"]");
    By registerLink = By.cssSelector("[class=\"ico-register\"]");
    By dynamicMenuLink = By.cssSelector("ul[class=\"top-menu notmobile\"] a");
    By searchInput = By.cssSelector("[id=\"small-searchterms\"]");
    By searchButton = By.cssSelector("[type=\"submit\"]");
    By shoppingCartLink = By.cssSelector("[class=\"ico-cart\"]");
    By shoppingCartQty = By.cssSelector("[class=\"cart-qty\"]");
    By myAccountLink = By.cssSelector("[class=\"ico-account\"]");
    By voteUpRadio = By.cssSelector("[id=\"pollanswers-1\"]");
    By voteButton = By.cssSelector("[id=\"vote-poll-1\"]");
    By voteResultText = By.cssSelector("[class=\"poll-total-votes\"]");
    By facebookLink = By.cssSelector("[class=\"facebook\"]");
    By twitterLink = By.cssSelector("[class=\"twitter\"]");
    By rssLink = By.cssSelector("[class=\"rss\"]");
    By youtubeLink = By.cssSelector("[class=\"youtube\"]");
    By instagramLink = By.cssSelector("[class=\"instagram\"]");
    By featuredProducts = By.cssSelector("div[class=\"product-item\"]");
    By footerInfoLinks = By.cssSelector("div[class=\"footer-block information\"] li");
    By footerCustomerServiceLinks = By.cssSelector("div[class=\"footer-block customer-service\"] li");
    By footerMyAccountLinks = By.cssSelector("div[class=\"footer-block my-account\"] li");
    By footerNewsletterInput = By.cssSelector("[id=\"newsletter-email\"]");
    By footerNewsletterButton = By.cssSelector("[id=\"newsletter-subscribe-button\"]");
    By footerNewsletterMsg = By.cssSelector("[id=\"newsletter-result-block\"]"); //"Thank you for signing up! A verification email has been sent. We appreciate your interest." if successful and "Enter valid email" if not
    By currencyDropdown = By.cssSelector("[id=\"customerCurrency\"]");
    By storeLogo = By.cssSelector("[class=\"header-logo\"] img");
    //constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.actionsBot = new ActionsBot(driver);

    }

    //actions


    //validations


}
