package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.GWD;
import utility.ReusableMethods;

import java.util.List;

public class PomClass extends ReusableMethods {

    public PomClass() {
        PageFactory.initElements(GWD.driver, this);
    }

    @FindBy(linkText = "Company")
    public WebElement companyButton;

    @FindBy(linkText = "Careers")
    public WebElement careersButton;

    @FindBy(xpath = "//div[@class='container']/div/a")
    public WebElement teamsButton;

    @FindBy(xpath = "//h3[contains(@class, 'text-center ')]")
    public List<WebElement> teams;

    @FindBy(xpath = "//*[text()='Accept All']")
    public List<WebElement> acceptAllButton;

    @FindBy(xpath = "//a[text()='See all QA jobs']")
    public WebElement seeQAJobs;

    @FindBy(xpath = "(//span[@class='selection'])[1]")
    public WebElement locationBox;

    @FindBy(xpath = "//h3[contains(text(), 'Browse')]")
    public WebElement browseText;

    @FindBy(css = "[class='totalResult']")
    public WebElement totalPage;

    @FindBy(xpath="//li[contains(@id,'Istanbul, Turkiye')]")
    public WebElement location;

    @FindBy(xpath = "//div[contains(@class,'position-list-item-')]")
    public List <WebElement> positionListItem;

    @FindBy(xpath = "//div[text()='Istanbul, Turkiye']")
    public WebElement locationText;

    @FindBy(xpath = "//span[contains(@class,'position-department text-large')]")
    public WebElement departmentText;

    @FindBy(xpath = "//*[text()='View Role']")
    public WebElement viewRoleButton;

    @FindBy(css = "[class='postings-btn template-btn-submit shamrock']")
    public WebElement applyButton;

    @FindBy(xpath = "//h4[text()='Submit your application']")
    public WebElement submitText;

    @FindBy(xpath = "//*[text()='New York']")
    public WebElement locationNewYork;

    @FindBy(xpath = "//*[text()='Sao Paulo']")
    public WebElement locationSaoPaulo;

    @FindBy(xpath = "//*[contains(text(), 'Our Locations')]")
    public WebElement ourLocationsText;

    @FindBy(css = "div[class='elementor elementor-22610'] a:nth-child(2)")
    public WebElement rightIcon;

    @FindBy(xpath = "//h2[normalize-space()='Life at Insider']")
    public WebElement lifeInsider;

    @FindBy(xpath = "//div[@class='elementor-main-swiper swiper-container swiper-container-initialized swiper-container-horizontal']")
    public WebElement blockImg;
}