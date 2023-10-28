            package pages;

            import org.openqa.selenium.By;
            import org.openqa.selenium.Keys;
            import org.openqa.selenium.WebElement;
            import org.openqa.selenium.support.FindBy;
            import testbase.WebTestBase;
            import org.openqa.selenium.support.PageFactory;
            import utils.TestUtils;



            public class LGPage extends WebTestBase {

                @FindBy(xpath = "//a[@href='#navigation_search']")
                WebElement searchButton;


                @FindBy(xpath = "//input[@id='useInputKeyword']")
                WebElement searchBox;

                @FindBy(xpath = "//a[@data-id='gnbNV01014961']")
                WebElement acHover;


                @FindBy(xpath = "//a[@data-link-name='split-ac']")
                WebElement splitAC;


                @FindBy(xpath = "//img[@alt='Youtube']")
                WebElement youtubeBtn;

                @FindBy(xpath = "//img[@data-src='/in/images/monitors/md07584355/49GR85DC-B-350.jpg']")
                WebElement ultraGear;

                @FindBy(xpath = "//a[@class='btn btn-primary btn-lg add-to-cart']")
                WebElement addToCart;

                @FindBy(xpath = "//*[text()='Buy Split AC Online']")
                WebElement titleText;


                public void searchBtn() {
                    searchButton.click();
                }

                public void searchBoxtext(String searchAppliances) {
                    this.searchBox.sendKeys(searchAppliances);
                    searchBox.sendKeys(Keys.ENTER);
                }

                public void monitorSelect(){
                    TestUtils.scrollDownByElement(ultraGear);
                    ultraGear.click();
                }

                public void checkInPage(){
                    TestUtils.waitUntilPageLoad(addToCart);
                    addToCart.click();
                }

                public void airConditionerHover(){
                    TestUtils.mouseHoverOnElement(acHover);
                    splitAC.click();
                   String title = titleText.getText();
                    System.out.println(title );

                }

                public void youtubeclk(){
                    youtubeBtn.click();

                }




                public LGPage() {
                    PageFactory.initElements(driver, this);
                }
            }
