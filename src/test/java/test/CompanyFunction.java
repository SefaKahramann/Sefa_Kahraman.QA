package test;

import pom.PomClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utility.ConfigReader;
import utility.GWD;

import java.util.*;

public class CompanyFunction {

    public static void main(String[] args) {
        PomClass element = new PomClass();

        GWD.getDriver().get(ConfigReader.getProperty("URL1"));
        element.wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("URL1")));

        element.wait.until(ExpectedConditions.elementToBeClickable(element.companyButton));
        element.companyButton.click();

        element.wait.until(ExpectedConditions.elementToBeClickable(element.careersButton));
        element.careersButton.click();

        element.scrollToElement(element.locationNewYork);
        Assert.assertTrue(element.ourLocationsText.getText().contains("Our Locations"));
        Assert.assertTrue(element.locationNewYork.isDisplayed());
        Assert.assertTrue(element.locationNewYork.getText().equals("New York"));

        Assert.assertTrue(element.locationSaoPaulo.isDisplayed());
        Assert.assertTrue(element.locationSaoPaulo.getText().equals("Sao Paulo"));

        element.jsClick(element.rightIcon);

        element.wait.until(ExpectedConditions.visibilityOfAllElements(element.teamsButton));
        element.scrollToElement(element.teamsButton);
        element.wait.until(ExpectedConditions.elementToBeClickable(element.teamsButton));
        element.jsClick(element.teamsButton);

        List<String> teamsNames = new ArrayList<>();
        Collections.addAll(teamsNames, "Customer Success", "Sales", "Product & Engineering",
                "Finance & Business Support", "Marketing", "CEO’s Executive Office",
                "Purchasing & Operations", "People and Culture", "Business Intelligence", "Security Engineering",
                "Partnership", "Quality Assurance", "Mobile Business Unit", "Partner Support Development", "Product Design");

        for (int i = 0; i < element.teams.size(); i++) {
            element.scrollToElement(element.teams.get(i));
            element.wait.until(ExpectedConditions.visibilityOf(element.teams.get(i)));
            Assert.assertTrue(element.teams.get(i).getText().equals(teamsNames.get(i)));
        }

        element.scrollToElement(element.lifeInsider);
        Assert.assertTrue(element.lifeInsider.isDisplayed());
        Assert.assertTrue(element.lifeInsider.getText().contains("Life at Insider"));

        element.scrollToElement(element.blockImg);
        element.wait.until(ExpectedConditions.visibilityOf(element.blockImg));
        Assert.assertTrue(element.blockImg.isDisplayed());

        GWD.tearDown();
    }
}