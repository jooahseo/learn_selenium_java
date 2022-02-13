import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.network.Network;
import org.openqa.selenium.devtools.v95.network.model.Request;
import org.openqa.selenium.devtools.v95.network.model.Response;

import java.util.Optional;

public class NetworkListening {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/jooahseo/work/chromedriver");

        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        //Selenium can listen the response after enable the network
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        //listen when request is sent out
        devTools.addListener(Network.requestWillBeSent(), request -> {
            Request req = request.getRequest();
            System.out.println(req.getUrl());
            //req.getHeaders()
        });

        //listen when response is received
        devTools.addListener(Network.responseReceived(), response -> {
            Response res = response.getResponse();
            System.out.println(res.getUrl());
            System.out.println(res.getStatus());
            if(res.getStatus().toString().startsWith("4")){
                System.out.println(res.getUrl()+"is failing with status code"+res.getStatus());
            }
        });

        driver.get("https://rahulshettyacademy.com/angularAppdemo");
        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
    }
}
