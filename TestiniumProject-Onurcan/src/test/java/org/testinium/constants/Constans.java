package org.testinium.constants;

import org.openqa.selenium.By;


public class Constans {


    public static String PRODUCT_PRICE;

    public static final By BASKET_PRODUCT_PRICE = By.xpath("//*[@id=\"cart-price-container\"]/div[3]/p");

    public static final By INC_PRODUCT = By.cssSelector("option[value='2']");

    public static final By TOTAL_PRODUCT_PRICE = By.cssSelector("li[class='clearfix total-price-sticky-container']>:nth-of-type(1)");

    public static final By DELETE_PRODUCTS = By.cssSelector("a[title='Sil']");

    public static final By EMPTY_BASKET = By.cssSelector(".gg-d-19.gg-w-21.gg-t-19.gg-m-18>:nth-child(1)");

    public static final By COOKIE = By.xpath("//*[@id=\"__next\"]/main/div[2]/section[1]/section[2]/a/span");

    public static final By TX_SEARCH = By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input");

    public static final By BTN_SEARCH = By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[2]/button");

    public static final By BTN_LOAD_MORE_PRODUCT = By.xpath("//*[@id=\"__next\"]/main/div[2]/div/div/div[2]/div/div[3]/div[4]/nav/ul/li[3]/a");

    public static final By SELECTED_PRODUCT_HREF = By.xpath("/html/body/div[1]/main/div[2]/div/div/div[2]/div/div[3]/div[3]/ul/li/article/div[2]/a");

    public static final By BTN_ADD_TO_CARD = By.id("add-to-basket");

    public static final By BTN_GO_TO_CARD2 = By.xpath("//*[@id=\"header_wrapper\"]/div[4]/div[3]/a");

    public static final By TX_PRODUCT_SINGLE_PRICE = By.id("sp-price-highPrice");

    public static final By PRODUCT_TITLE = By.id("sp-title");

    public static final By TX_PRODUCT_DISCOUNT_PRICE = By.id("sp-price-lowPrice");


}
