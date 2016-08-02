package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchResultsPage extends BasePage {

	@FindBy(id = "advs")
	private WebElement searchForm;

	@FindBy(id = "advs-keywords")
	private WebElement keywordsField;

	@FindBy(css = ".submit-advs")
	private WebElement searchButton;

	@FindBy(css = ".suggested-search.bd>a")
	private WebElement showAllResultsLink;

	@FindBy(css = "div.description")
	private List<WebElement> titleTextWebElementList;

	private List<String> getTitlesList() {
		List<String> titleTextList = new ArrayList<String>();
		Iterator<WebElement> i = titleTextWebElementList.iterator();
		while (i.hasNext()) {
			WebElement titleTextWebElement = i.next();
			String titleText = titleTextWebElement.getText();
			titleTextList.add(titleText);
		}
		return titleTextList;
	}


	public boolean isSearchTermContained(String searchTerm) {
		List<String> titleTextList = getTitlesList();
		boolean isSearchTermContained = false;
		for (int i = 0; i < titleTextList.size(); i++) {
			if (titleTextList.get(i).contains(searchTerm)) {
				isSearchTermContained = true;
			}
		}
		return isSearchTermContained;
	}

	public SearchResultsPage() {
		PageFactory.initElements(driver, this);
		implicitWaitForElement(searchForm);
	}

	public void performSearch (String searchTerm) {
		keywordsField.sendKeys(searchTerm);
		keywordsField.sendKeys(Keys.RETURN);
		implicitWaitForElement(showAllResultsLink);
	}



}
