package steps;


import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;


public class Hooks extends CommonMethods {
    @Before
    public void start() {
        openBrowser();
    }

    @AfterStep
    public void shot(Scenario scenario){
        byte [] picture;
        picture = takeScreenShot("step/" +scenario.getName());
        scenario.attach(picture,"image/png",scenario.getName());

    }

    @After
    public void end(Scenario scenario) {

        byte[] pic;
        if (scenario.isFailed()) {
            pic = takeScreenShot("failed/" + scenario.getName());
        } else {
            pic = takeScreenShot("passed/" + scenario.getName());
        }
        scenario.attach(pic, "image/png", scenario.getName());

        closeBrowser();
    }
}
