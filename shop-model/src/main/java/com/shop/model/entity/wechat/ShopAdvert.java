package com.shop.model.entity.wechat;

import java.io.Serializable;
import java.util.Date;


/**
 * 广告
 * 
 * @author Yuan Wei
 * @email ywdeveloper@aliyun.com
 * @date 2018-06-14 11:23:10
 */
public class ShopAdvert implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//广告位置
	private Integer positionId;
	//跳转形式 1_内部页面 2_其他小程序 3_APP
	private Integer mediaType;
	//广告标题
	private String title;
	//广告跳转链接
	private String link;
	//广告展示图片
	private String imageUrl;
	//广告内容
	private String content;
	//
	private Date createTime;
	//是否展示 1_是 2_否
	private Integer isShow;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：广告位置
	 */
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}
	/**
	 * 获取：广告位置
	 */
	public Integer getPositionId() {
		return positionId;
	}
	/**
	 * 设置：跳转形式 1_内部页面 2_其他小程序 3_APP
	 */
	public void setMediaType(Integer mediaType) {
		this.mediaType = mediaType;
	}
	/**
	 * 获取：跳转形式 1_内部页面 2_其他小程序 3_APP
	 */
	public Integer getMediaType() {
		return mediaType;
	}
	/**
	 * 设置：广告标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：广告标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：广告跳转链接
	 */
	public void setLink(String link) {
		this.link = link;
	}
	/**
	 * 获取：广告跳转链接
	 */
	public String getLink() {
		return link;
	}
	/**
	 * 设置：广告展示图片
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	/**
	 * 获取：广告展示图片
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	/**
	 * 设置：广告内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：广告内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：是否展示 1_是 2_否
	 */
	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}
	/**
	 * 获取：是否展示 1_是 2_否
	 */
	public Integer getIsShow() {
		return isShow;
	}
}
