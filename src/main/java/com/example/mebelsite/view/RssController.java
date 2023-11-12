package com.example.mebelsite.view;

import com.example.mebelsite.model.entity.RssUrlEntity;
import com.example.mebelsite.model.repository.NewsItemRepository;
import com.example.mebelsite.model.repository.RssUrlRepository;
import com.example.mebelsite.util.RssUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Slf4j
@Controller
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class RssController {

    private final RssUrlRepository rssUrlRepository;
    private final NewsItemRepository newsRepository;

    @GetMapping("/rss")
    public String getRssHTML(Model model) {

        var items = newsRepository.findAll();
        var news = new ArrayList<>(items);

        var urls = rssUrlRepository.findAll().stream().map(RssUrlEntity::getUrl).toList();
        if (!urls.isEmpty()) {
            urls.forEach(url -> {
                var itemsFromRss = RssUtils.getNewsFromRss(url);
                news.addAll(itemsFromRss);
            });
        }
        model.addAttribute("news", news);

        var urlsLinks = rssUrlRepository.findAll();
        model.addAttribute("urls", urlsLinks);

        return "rss/rss";
    }

    @GetMapping("/rss/new")
    public String getRssNewHTML() {
        return "rss/rssNew";
    }
}