package abhidesign.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import abhidesign.TestComponents.BaseTest;
import abhidesign.pageobject.CartPage;
import abhidesign.pageobject.CheckoutPage;
import abhidesign.pageobject.ConfirmationPage;
import abhidesign.pageobject.LandingPage;
import abhidesign.pageobject.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest{

	@Test
	public void SubmitOrder() throws IOException{
		
		String productname="ZARA COAT 3";
		landingpage.goTo();
		ProductCatalogue productcatalouge = landingpage.LoginApplication("abhishekhashi@gmail.com", "Hashirama@1");
		List<WebElement> products=productcatalouge.getProductList();
		productcatalouge.addProductToCart(productname);
		CartPage cartpage = productcatalouge.goToCart();
		Boolean match =cartpage.verifyProductDisplay(productname);
		Assert.assertTrue(match);
		CheckoutPage checkoutpage =cartpage.goTocheckOutPage();
		checkoutpage.selectCountry("india");
		ConfirmationPage confirmationpage = checkoutpage.submitOrder();
		String conMsg=confirmationpage.verifyConfirmationMsg();
		Assert.assertTrue(conMsg.equalsIgnoreCase("Thankyou for the order."));
		
		

	}

}
