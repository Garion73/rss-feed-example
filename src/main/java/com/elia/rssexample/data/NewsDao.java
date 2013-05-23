package com.elia.rssexample.data;

import java.util.List;

import com.elia.rssexample.model.NewsItem;

/**
 * Retrieve news information from data storage.
 * 
 * @author Sami Elomaa
 */
public interface NewsDao {

	/**
	 * Retrieve list of news items.
	 * 
	 * @return list of news items
	 */
	public List<NewsItem> getNewsList();
}
