package com.addisnews.crawler.network;

import com.addisnews.crawler.domain.News;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Crawler {

    private List<News> newsList = new ArrayList<>();
    private By titleSelector;
    private By contentSelector;
    private By imageSelector;
    private By dateSelector;
    private By sourceUrlSelector;
    private By newsContainerSelector;
    private String sourceWebsiteName;
    private String newsCategoryID;
    private String url;
    private WebDriver driver;

    public List<News> crawl() {
        setup();
        List<WebElement> newsContainerElements = getNewsContainerElements();
        for (WebElement newsContainerElement :
                newsContainerElements) {

            String title = extractTitle(newsContainerElement);
            String content = extractContent(newsContainerElement);
            String publishedDate = extractPublishedDate(newsContainerElement);
            String imageSrc = extractImageSrc(newsContainerElement);
            //TODO Uncomment
//            String sourceUrl = extractSourceUrl(newsContainerElement);
            String sourceUrl = "";

            News news = new News(0, title, content, newsCategoryID, publishedDate, sourceWebsiteName, sourceUrl, imageSrc);
            newsList.add(news);
        }
        close();
        return newsList;
    }

    private List<WebElement> getNewsContainerElements() {
        return driver.findElements(newsContainerSelector);
    }

    private String extractTitle(WebElement newsContainer) {
        return newsContainer.findElement(titleSelector).getText();
    }

    private String extractContent(WebElement newsContainer) {
        return newsContainer.findElement(contentSelector).getText();
    }

    private String extractPublishedDate(WebElement newsContainer) {
        return newsContainer.findElement(dateSelector).getText();
    }

    private String extractImageSrc(WebElement newsContainer) {
        try {
            return newsContainer.findElement(imageSelector).getAttribute("src");
        }
        catch (NoSuchElementException e){}

        return "";
    }

    private String extractSourceUrl(WebElement newsContainer) {
        return newsContainer.findElement(sourceUrlSelector).getAttribute("href");
    }

    private void setup() {
        driver.get(url);
    }
    private void close(){
        driver.close();
    }

    public static class Builder {
        private final Crawler crawler;

        public Builder(WebDriver driver) {

            this.crawler = new Crawler();
            crawler.driver = driver;

        }

        public Builder addTitleSelector(By by) {
            crawler.titleSelector = by;
            return this;
        }

        public Builder addContentSelector(By by) {
            crawler.contentSelector = by;
            return this;
        }

        public Builder addImageSelector(By by) {
            crawler.imageSelector = by;
            return this;
        }

        public Builder addDateSelector(By by) {
            crawler.dateSelector = by;
            return this;
        }

        public Builder addSourceUrlSelector(By by) {
            crawler.sourceUrlSelector = by;
            return this;
        }

        public Builder addNewsContainerSelector(By by) {
            crawler.newsContainerSelector = by;
            return this;
        }

        public Builder setSourceWebsiteName(String sourceWebsiteName) {
            crawler.sourceWebsiteName = sourceWebsiteName;
            return this;
        }

        public Builder setNewsCategoryID(String newsCategoryID) {
            crawler.newsCategoryID = newsCategoryID;
            return this;
        }

        public Builder setUrl(String url) {
            crawler.url = url;
            return this;
        }

        public Crawler build(){
            return crawler;
        }
    }
}
