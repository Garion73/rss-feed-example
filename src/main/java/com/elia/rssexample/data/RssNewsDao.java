package com.elia.rssexample.data;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Repository;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import com.elia.rssexample.model.NewsItem;

/**
 * RSS Feed implementation of NewsDao.
 * 
 * @author Sami Elomaa
 */
@Repository
public class RssNewsDao implements NewsDao {
	
	private Logger log = Logger.getLogger(RssNewsDao.class.getName());

	private List<String> rssUrlList;

/** PUBLIC METHODS ************************************************************/

	/**
	 * Set rss url's to use when fetching news.
	 * 
	 * @param rssUrlList - rss url list
	 */
	public void setRssUrlList(List<String> rssUrlList) {
		this.rssUrlList = rssUrlList;
	}
	
//------------------------------------------------------------------------------
	/**
	 * @see com.elia.rssexample.data.NewsDao
	 */
	@SuppressWarnings("unchecked")
	public List<NewsItem> getNewsList() {
		
		// TODO: exception handling
		
		log.trace("Enter getNewsList().");

		List<NewsItem> newsList = new ArrayList<NewsItem>();
		
		XmlReader reader = null;
		try {
			for(String rssUrl : rssUrlList) {

				reader = new XmlReader(new URL(rssUrl));
				SyndFeed feed = new SyndFeedInput().build(reader);
				
				for(SyndEntry entry : (List<SyndEntry>)feed.getEntries()) {
	
					NewsItem item = new NewsItem();
					
					item.setTitle(entry.getTitle());
					item.setDescription(entry.getDescription().getValue());
					item.setLink(entry.getLink());
					item.setPublished(entry.getPublishedDate());
					
					newsList.add(item);
				}
			}
		}
		catch(Exception e) {
			log.error("Error reading feed.", e);
		}
		finally {
			try { reader.close();}
			catch(IOException e) {
				log.warn("Unable to close xml reader.", e);
			}
		}
		
		return newsList;
	}
}
