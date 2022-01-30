package org.testinium.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testinium.base.BaseTest;
import org.testinium.page.SearchAndAddCartItemProcess;

public class TestMain extends BaseTest {
    SearchAndAddCartItemProcess searchAndAddCartItemProcess;

    @Before
    public void before() {
        searchAndAddCartItemProcess = new SearchAndAddCartItemProcess(getWebDriver());
    }

    @Test
    public void test() {
        searchAndAddCartItemProcess
                .closeCookie()
                .sendSearchWord()
                .moveToSearchButton()
                .clickSearchButton()
                .scrollDownPage()
                .clickSecondPage()
                .clickProduct()
                .addToCard()
                .clickGoToCardButton()
                .comparePrice()
                .incProduct()
                .totalProductPrice()
                .deleteProducts()
                .isEmptyBasket();
    }

    @After
    public void after() {

    }
}
