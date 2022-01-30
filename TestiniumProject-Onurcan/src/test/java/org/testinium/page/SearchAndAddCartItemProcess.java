package org.testinium.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testinium.base.BasePage;
import org.testinium.base.BaseTest;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import org.apache.log4j.Logger;

import static org.testinium.constants.Constans.*;

import static org.testng.AssertJUnit.*;

public class SearchAndAddCartItemProcess extends BasePage {

    public SearchAndAddCartItemProcess(WebDriver driver) {
        super(driver);

    }

    public Logger logger = BaseTest.getInstance();


    public SearchAndAddCartItemProcess closeCookie() {
        logger.info("Close Cookie");
        click(COOKIE);
        return this;
    }

    public SearchAndAddCartItemProcess sendSearchWord() {
        logger.info("The value to be searched has been sent\n");
        sendKeys(TX_SEARCH, "bilgisayar");
        return this;
    }

    public SearchAndAddCartItemProcess moveToSearchButton() {
        logger.info("On the search button");
        hoverElement(BTN_SEARCH);
        return this;
    }

    public SearchAndAddCartItemProcess clickSearchButton() {
        logger.info("Click the search button");
        click(BTN_SEARCH);
        return this;
    }

    public SearchAndAddCartItemProcess scrollDownPage() {
        logger.info("Scroll down page");
        scrollDown();
        return this;
    }

    public SearchAndAddCartItemProcess clickSecondPage() {
        logger.info("Click the See More Product button");
        click(BTN_LOAD_MORE_PRODUCT);
        assertTrue(BaseTest.getWebDriver().getCurrentUrl().contains("2"));
        if (BaseTest.getWebDriver().getCurrentUrl().contains("2")) {
            logger.info("Page 2 Success");
        } else {
            logger.info("Page 2 Failed");
        }
        return this;
    }


    public SearchAndAddCartItemProcess clickProduct() {
        logger.info("Click the product");
        ArrayList<WebElement> webElementList = findElements(SELECTED_PRODUCT_HREF);
        Collections.shuffle(webElementList);
        clickElement(webElementList.get(0));

        return this;
    }


    public SearchAndAddCartItemProcess addToCard() {
        logger.info("Product Add to Card.");
        String singles = findElement(TX_PRODUCT_SINGLE_PRICE).getAttribute("innerText");
        String discounts = findElement(TX_PRODUCT_DISCOUNT_PRICE).getAttribute("innerText");
        String title = findElement(PRODUCT_TITLE).getAttribute("innerText");
        if (singles.length() > 0 || discounts.length() > 0) {
            String number = singles.replace(" TL", "").trim().replace(',', '.');
            String number2 = discounts.replace(" TL", "").trim().replace(',', '.');
            PRODUCT_PRICE = number2;
            FileWriter fwriter = null;
            try {
                fwriter = new FileWriter("C:\\Users\\OnurcanIrmak\\IdeaProjects\\TestiniumProject-Onurcan\\src\\test\\java\\org\\testinium\\info.txt", true);
                fwriter.write(title);
                fwriter.write("\n");
                fwriter.write(number);
                fwriter.write("\n");
                fwriter.write(number2);
                fwriter.write("\n");
                fwriter.write("------------------------------------------------------");
                fwriter.write("\n");
                fwriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        click(BTN_ADD_TO_CARD);
        return this;
    }


    public SearchAndAddCartItemProcess clickGoToCardButton() {
        try {
            Thread.sleep(5000);
            logger.info("Click the go to card button");
            click(BTN_GO_TO_CARD2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return this;
    }

    public SearchAndAddCartItemProcess comparePrice() {
        logger.info("Compare price");
        String basketProductPrice = findElement(BASKET_PRODUCT_PRICE).getAttribute("innerText").replace(" TL", "").trim().replace(',', '.');

        if (PRODUCT_PRICE.equals(basketProductPrice)) {
            logger.info("Compare price EQUAL");
        } else {
            logger.info("Compare price NOT EQUAL");
        }

        assertEquals(PRODUCT_PRICE, basketProductPrice);

        return this;
    }

    public SearchAndAddCartItemProcess incProduct() {
        logger.info("Increase product price");
        click(INC_PRODUCT);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public SearchAndAddCartItemProcess totalProductPrice() {
        logger.info("Total product price");

        String totalProductPrice = findElement(TOTAL_PRODUCT_PRICE).getText();

        assertTrue(totalProductPrice.contains("2 Adet"));

        if (totalProductPrice.contains("2 Adet")) {
            logger.info("Product 2 Adet");
        } else {
            logger.info("Product NOT 2 Adet");
        }

        return this;
    }

    public SearchAndAddCartItemProcess deleteProducts() {
        logger.info("Delete products");
        click(DELETE_PRODUCTS);
        return this;
    }

    public SearchAndAddCartItemProcess isEmptyBasket() {
        try {
            Thread.sleep(5000);
            WebElement emptyBasket = findElement(EMPTY_BASKET);
            logger.info("Is Empty Basket");
            if (emptyBasket.getText().equals("Sepetinizde ürün bulunmamaktadır.")) {
                logger.info("Is Empty Basket TRUE");
            } else {
                logger.info("Is Empty Basket FALSE");
            }

            assertEquals(emptyBasket.getText(), "Sepetinizde ürün bulunmamaktadır.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return this;
    }
}


