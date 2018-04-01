
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.CookieManager;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine;
import com.gargoylesoftware.htmlunit.util.Cookie;

public class PacktFreeBookClaimer {
	public static void main(String[] args) throws Exception {
		WebClient webClient = new WebClient(BrowserVersion.FIREFOX_52);
		JavaScriptEngine javaScriptEngine = new JavaScriptEngine(webClient);
		webClient.setJavaScriptEngine(javaScriptEngine);
		CookieManager cookieManager = new CookieManager();
		webClient.setCookieManager(cookieManager);
		cookieManager.getCookies();
		WebRequest webRequest = new WebRequest(new URL("https://www.packtpub.com/"));
		webRequest.setHttpMethod(HttpMethod.POST);
		webRequest.setRequestBody("{\n"
				+ "  \"email\": \"vizsoro@gmail.com\",\n"
				+ "  \"password\": \"Almafa123\"\n"
				+ "}");
		HtmlPage page = webClient.getPage(webRequest);
		Set<Cookie> cookies = cookieManager.getCookies();
		WebRequest webRequest2 = new WebRequest(new URL("https://www.packtpub.com//packt/offers/free-learning?login=1"));
		webRequest2.setHttpMethod(HttpMethod.GET);
		Map<String, String> additionalHeader = new HashMap<>();
		cookies.forEach(c->additionalHeader.putIfAbsent(c.getName(), c.getValue()));
		webRequest2.setAdditionalHeaders(additionalHeader);
		page = webClient.getPage(webRequest);
		DomElement elementById = page.getElementById("free-learning-claim");
		
		elementById.click();
		webClient.close();
	}
	
	
	
}
