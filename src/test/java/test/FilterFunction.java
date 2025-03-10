package test;

import pom.PomClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.ConfigReader;
import utility.GWD;

import java.util.Set;

public class FilterFunction {

    public static void main(String[] args) {
        PomClass element = new PomClass();

        GWD.getDriver().get(ConfigReader.getProperty("URL2"));
        element.wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("URL2")));

        if (!element.acceptAllButton.isEmpty()) {
            element.acceptAllButton.get(0).click();
        }

        element.wait.until(ExpectedConditions.visibilityOf(element.seeQAJobs));
        element.jsClick(element.seeQAJobs);

        element.scrollToElement(element.browseText);
        element.wait.until(ExpectedConditions.visibilityOf(element.totalPage));

        element.wait.until(ExpectedConditions.visibilityOf(element.locationBox));
        element.locationBox.click();

        element.wait.until(ExpectedConditions.visibilityOf(element.location));
        element.location.click();

        element.scrollToElement(element.positionListItem.get(1));

        for (int i = 0; i < element.positionListItem.size(); i++) {
            element.wait.until(ExpectedConditions.visibilityOf(element.departmentText));
            element.verifyContainsText(element.locationText, "Istanbul");
            element.verifyContainsText(element.departmentText, "Quality");

            element.hoverOver(element.positionListItem.get(i));

            element.wait.until(ExpectedConditions.visibilityOf(element.viewRoleButton));
            element.viewRoleButton.click();

            String homePage = GWD.getDriver().getWindowHandle();
            Set<String> windowHandle = GWD.getDriver().getWindowHandles();
            for (String newPage : windowHandle) {
                if (!newPage.equals(homePage)) {
                    GWD.getDriver().switchTo().window(newPage);

                    element.wait.until(ExpectedConditions.visibilityOf(element.applyButton));
                    element.applyButton.click();
                    element.verifyContainsText(element.submitText, "SUBMIT YOUR APPLICATION");

                    GWD.getDriver().close();
                }
            }
            GWD.getDriver().switchTo().window(homePage);
        }
        GWD.tearDown();
    }
}