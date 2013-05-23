package com.elia.rssexample.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Transfer object for news item.
 * 
 * @author Sami Elomaa
 */
public class NewsItem implements Serializable, Comparable<NewsItem> {

	private static final long serialVersionUID = 1L;

	private String title;
	private String description;
	private String link;
	private Date   published;
	
/** PUBLIC METHODS ************************************************************/

	/**
	 * Get title.
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set title.
	 * 
	 * @param title - title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

//------------------------------------------------------------------------------
	/**
	 * Get description.
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set description.
	 * 
	 * @param description - description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

//------------------------------------------------------------------------------
	/**
	 * Get link to complete article.
	 * 
	 * @return link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * Set link to complete article.
	 * 
	 * @param link - link
	 */
	public void setLink(String link) {
		this.link = link;
	}

//------------------------------------------------------------------------------
	/**
	 * Get publish date.
	 * 
	 * @return publish date
	 */
	public Date getPublished() {
		return published;
	}

	/**
	 * Set publish date.
	 * 
	 * @param published - publish date
	 */
	public void setPublished(Date published) {
		this.published = published;
	}

//------------------------------------------------------------------------------
	/**
	 * Compares published date of this object with the published date of specified object for order.
	 * 
	 * @param o - object to compare
	 * @return -1, 0 or 1 as this object is less than, equal to or greater than the specified object
	 */
	public int compareTo(NewsItem o) {
		
		return this.published.compareTo(o.published);
	}
}
