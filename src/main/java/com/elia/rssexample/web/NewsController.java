package com.elia.rssexample.web;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elia.rssexample.biz.NewsService;

/**
 * News page controller.
 *
 * @author Sami Elomaa
 */
@Controller
@RequestMapping("/")
public class NewsController {

	private static String PAGE_NEWS = "news";

	private Logger log = Logger.getLogger(NewsController.class.getName());

	private NewsService newsService;
	
/** PUBLIC METHODS ************************************************************/

	@Autowired
	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

//------------------------------------------------------------------------------
	/**
	 * View news page.
	 * 
	 * @param model - model for request parameters
	 * @return name of view
	 */
	@RequestMapping("/news")
	public String actionViewNews(Model model) {
		
		log.trace("Enter actionViewNews().");
		
		model.addAttribute("newsList", newsService.getNewsList());
		
		return PAGE_NEWS;
	}
}
