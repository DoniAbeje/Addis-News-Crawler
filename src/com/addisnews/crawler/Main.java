package com.addisnews.crawler;

import com.addisnews.crawler.domain.News;
import com.addisnews.crawler.network.APIConnector;
import com.addisnews.crawler.network.Crawler;
import com.addisnews.crawler.network.RetrofitConnector;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        News news = new News(

                0,
                "title",
                "content",
                "1",
                "July 10",
                "Reporter",
                "google.com",
                ""
        );

        RetrofitConnector connector = APIConnector.getConnector();
        try {
         Response<Void> response =  connector.insertNews(news).execute();
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void crawlReporter(WebDriver driver) {

        Crawler crawler = new Crawler.Builder(driver)
                .addTitleSelector(By.cssSelector("h3.post-title"))
                .addContentSelector(By.cssSelector("div.post-body"))
                .addDateSelector(By.cssSelector("span.post-created"))
                .addImageSelector(By.tagName("img"))
                .addNewsContainerSelector(By.cssSelector(".post-block.display-term.margin-bottom-30"))
                //.addSourceUrlSelector()
                .setNewsCategoryID("1")
                .setSourceWebsiteName("Reporter")
                .setUrl("https://www.ethiopianreporter.com/index.php/poletika")
                .build();

        List<News> newsList = crawler.crawl();

        for (News news :
                newsList) {
            System.out.println(news);
        }

    }

    public WebDriver setup() {
        String key = "webdriver.chrome.driver";
        String value = "G:\\Documents\\Study\\3rd Year\\Second Semester\\Software Engineering II\\Lab\\Chrome driver\\chromedriver.exe";
        System.setProperty(key, value);
        return new ChromeDriver();
    }

}
