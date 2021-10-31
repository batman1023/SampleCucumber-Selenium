package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;


public class Base {
    public static WebDriver driver;

    public static WebDriver getDriver() throws IOException, InterruptedException {
        boolean flag = false;

        Runtime runtime = Runtime.getRuntime();
        runtime.exec("cmd /c start dockerup.bat");
        Thread.sleep(5000);


        String file = "output.txt";
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, 5);
        long stopnow = cal.getTimeInMillis();

        while (System.currentTimeMillis() < stopnow) {
            if (flag) {
                break;
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String currenLine = reader.readLine();

            while (currenLine != null && !flag) {
                if (currenLine.contains("The node is registered to the hub and ready to use")) {
                    System.out.println("Read log file and found a match - setting flag to true");
                    Thread.sleep(5000);
                    flag = true;
                    break;
                }
                currenLine = reader.readLine();
            }
            reader.close();
        }
        Assert.assertTrue(flag);
        Thread.sleep(5000);




    ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");

        URL url = new URL("http://localhost:4444/wd/hub");


        driver = new RemoteWebDriver(url, options);
        return driver;
        //RemoteWebDriver driver=new RemoteWebDriver(new URL("http"))
    }

}

