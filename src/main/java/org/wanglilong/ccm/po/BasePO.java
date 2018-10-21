package org.wanglilong.ccm.po;

import java.util.Date;

import org.springframework.security.core.context.SecurityContextHolder;
import org.wanglilong.ccm.security.SessionUser;

public class BasePO {
	
	private Integer isDeleted;
	private Date createTime;
	private Date updateTime;
	private Date deleteTime;
	private String creator;

	public BasePO(){
		try{
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			if (principal instanceof SessionUser) {
				SessionUser user = (SessionUser) principal;
				this.setCreator(user.getId());
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}
	
}
