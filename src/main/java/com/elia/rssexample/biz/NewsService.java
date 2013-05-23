package com.elia.rssexample.biz;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.elia.rssexample.data.NewsDao;
import com.elia.rssexample.model.NewsItem;

/**
 * Service for getting news items. Caches news items to class member. Fetches from 
 * repository is scheduled for 60 minutes.
 * 
 * @author Sami Elomaa
 */
@Service
public class NewsService {

	private Logger log = Logger.getLogger(NewsService.class.getName());
	
	private NewsDao newsDao;
	
	private List<NewsItem> newsList;
	
/** CONSTRUCTORS **************************************************************/
	
	/**
	 * Initializes service.
	 * 
	 * @param newsDao - news data access object
	 */
	@Autowired
	NewsService(NewsDao newsDao) {
		this.newsDao = newsDao;
	}

/** PUBLIC METHODS ************************************************************/

	/**
	 * Get list of news items.
	 * 
	 * @return list of news items
	 */
	public List<NewsItem> getNewsList() {
		
		log.trace("Enter getNewsList().");

		if(newsList == null) {
			updateNews();
		}
		
		return newsList;
	}
	
/** PROTECTED METHODS *********************************************************/

	/**
	 * Update news items from repository every 60 minutes.
	 */
	@Scheduled(fixedRate=3600000)
	protected void updateNews() {

		log.trace("Enter updateNews().");

		List<NewsItem> list = newsDao.getNewsList();
		
		Collections.sort(list);
		Collections.reverse(list);
		
		newsList = list;
	}
}
