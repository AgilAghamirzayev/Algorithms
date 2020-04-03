package bfs;

public class AppB {

    public static void main(String[] args) {
        WebCrawler crawler = new WebCrawler();
        String rootUrl = "http://www.bbc.com";
        crawler.discoverWeb(rootUrl);
    }
}

