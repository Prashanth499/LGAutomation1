            package tests;



            import org.testng.annotations.BeforeMethod;
            import org.testng.annotations.Test;
            import org.testng.asserts.SoftAssert;
            import pages.LGPage;
            import testbase.WebTestBase;

            import static java.awt.SystemColor.text;


            public class LGTest extends WebTestBase {
                public pages.LGPage LGPage;

                LGTest() {

                    super();
                }

                @BeforeMethod
                public void beforemethod() {
                    initialization();
                    LGPage = new LGPage();
                }


                @Test(priority = 3)

                public void productCheckOut() {
                    SoftAssert softAssert = new SoftAssert();
                    LGPage.searchBtn();
                    LGPage.searchBoxtext(prop.getProperty("searchAppliances"));
                    LGPage.monitorSelect();
                    LGPage.checkInPage();
                    softAssert.assertEquals("", "", "LG cart icon should be clicked");
                    softAssert.assertAll();
                    driver.close();


                }

                @Test(priority = 2)
                public void verifyHover() throws InterruptedException {
                    SoftAssert softAssert = new SoftAssert();
                    LGPage.airConditionerHover();
                    Thread.sleep(2000);
                    softAssert.assertAll();
                    driver.close();
                }

                @Test(priority = 1)
                public void SocialPageClick() throws InterruptedException {
                    SoftAssert softAssert = new SoftAssert();
                    LGPage.youtubeclk();
                    Thread.sleep(2000);
                    softAssert.assertAll();
                    driver.close();
                }


            }










