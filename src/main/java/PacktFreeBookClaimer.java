
import com.gargoylesoftware.htmlunit.ImmediateRefreshHandler;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.WebWindow;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class PacktFreeBookClaimer {
	public static void main(String[] args) throws Exception {
		WebClient webClient = new WebClient();
		webClient.setRefreshHandler(new
				ImmediateRefreshHandler());
		HtmlPage page = webClient.getPage("https://www.packtpub.com/packt/offers/free-learning");
		WebWindow enclosingWindow = page.getEnclosingWindow();
		HtmlForm loginForm = (HtmlForm)page.getElementById("packt-user-login-form");
		HtmlInput email = loginForm.getInputByName("email");
		HtmlInput password = loginForm.getInputByName("password");
		HtmlInput loginSubmit = loginForm.getInputByName("op");
		email.type(args[0]);
		password.type(args[1]);
		page = loginSubmit.click();
		DomElement elementById = page.getElementById("free-learning-claim");
		elementById.click();
//		DomElement elementById = afterLogin.getElementById("free-learning-claim");
//		afterLogin.refresh();
		//		HtmlInput searchBox = page.getElementByName("q");
//		searchBox.setValueAttribute("htmlunit");
//
//		HtmlSubmitInput googleSearchSubmitButton =
//				page.getElementByName("btnG"); // sometimes it's "btnK"
//		page=googleSearchSubmitButton.click();
//
//		HtmlDivision resultStatsDiv =
//				page.getFirstByXPath("//div[@id='resultStats']");
//
//		System.out.println(resultStatsDiv.asText()); // About 309,000 results
		webClient.close();
	}
	
	
	
}
