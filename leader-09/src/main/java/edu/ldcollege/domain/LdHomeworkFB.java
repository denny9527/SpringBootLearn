/**
 * @Title: LdHomeworkFB.java
 * @Package: edu.ldcollege.domain
 * @Description: 
 * @author Zhang Kui
 * @date 2017年10月14日 下午03:47:49
 * @version V1.0.0
 */
package edu.ldcollege.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据库表：T_HOMEWORK_CORRECTION
 * @ClassName: LdHomeworkFB
 * @Description: 
 * @author Zhang Kui
 * @date 2017年10月14日 下午03:47:49
 * @version 1.0.0 
 */
public class LdHomeworkFB implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 记录ID
     * 表字段：T_HOMEWORK_CORRECTION.ID
     */
    private Long id;

    /**
     * 批改学员ID
     * 表字段：T_HOMEWORK_CORRECTION.CORRECT_USER_ID
     */
    private Long correctUserId;

    /**
     */
    private Long userId;

    /**
     * 作业ID
     * 表字段：T_HOMEWORK_CORRECTION.HOMEWORK_ID
     */
    private Long homeworkId;

    /**
     * 作业级别
     * 表字段：T_HOMEWORK_CORRECTION.LEVEL_FLAG
     */
    private String levelFlag;

    /**
     * 评语
     * 表字段：T_HOMEWORK_CORRECTION.MARK
     */
    private String mark;

    /**
     */
    private Date createDate;
    
    private String appraiseFlag;
    
    private String appraiseUserAccount;
    
    private String appraiseUserName;
    
    private String level;
    
    private String appraise;
    
    private String createDateStr;

    /**
     * 获取 记录ID 字段：T_HOMEWORK_CORRECTION.ID
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 记录ID 字段：T_HOMEWORK_CORRECTION.ID
     *
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 批改学员ID 字段：T_HOMEWORK_CORRECTION.CORRECT_USER_ID
     *
     * @return the correctUserId
     */
    public Long getCorrectUserId() {
        return correctUserId;
    }

    /**
     * 设置 批改学员ID 字段：T_HOMEWORK_CORRECTION.CORRECT_USER_ID
     *
     * @param correctUserId the correctUserId to set
     */
    public void setCorrectUserId(Long correctUserId) {
        this.correctUserId = correctUserId;
    }

    /**
     */
    public Long getUserId() {
        return userId;
    }

    /**
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取 作业ID 字段：T_HOMEWORK_CORRECTION.HOMEWORK_ID
     *
     * @return the homeworkId
     */
    public Long getHomeworkId() {
        return homeworkId;
    }

    /**
     * 设置 作业ID 字段：T_HOMEWORK_CORRECTION.HOMEWORK_ID
     *
     * @param homeworkId the homeworkId to set
     */
    public void setHomeworkId(Long homeworkId) {
        this.homeworkId = homeworkId;
    }

    /**
     * 获取 作业级别 字段：T_HOMEWORK_CORRECTION.LEVEL_FLAG
     *
     * @return the levelFlag
     */
    public String getLevelFlag() {
        return levelFlag;
    }

    /**
     * 设置 作业级别 字段：T_HOMEWORK_CORRECTION.LEVEL_FLAG
     *
     * @param levelFlag the levelFlag to set
     */
    public void setLevelFlag(String levelFlag) {
        this.levelFlag = levelFlag == null ? null : levelFlag.trim();
    }

    /**
     * 获取 评语 字段：T_HOMEWORK_CORRECTION.MARK
     *
     * @return the mark
     */
    public String getMark() {
        return mark;
    }

    /**
     * 设置 评语 字段：T_HOMEWORK_CORRECTION.MARK
     *
     * @param mark the mark to set
     */
    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }
    
    /** 
	 * @return createDate 
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/** 
	 * @return appraiseFlag 
	 */
	public String getAppraiseFlag() {
		return appraiseFlag;
	}

	/**
	 * @param appraiseFlag the appraiseFlag to set
	 */
	public void setAppraiseFlag(String appraiseFlag) {
		this.appraiseFlag = appraiseFlag;
	}

	/** 
	 * @return appraiseUserAccount 
	 */
	public String getAppraiseUserAccount() {
		return appraiseUserAccount;
	}

	/**
	 * @param appraiseUserAccount the appraiseUserAccount to set
	 */
	public void setAppraiseUserAccount(String appraiseUserAccount) {
		this.appraiseUserAccount = appraiseUserAccount;
	}

	/** 
	 * @return appraiseUserName 
	 */
	public String getAppraiseUserName() {
		return appraiseUserName;
	}

	/**
	 * @param appraiseUserName the appraiseUserName to set
	 */
	public void setAppraiseUserName(String appraiseUserName) {
		this.appraiseUserName = appraiseUserName;
	}

	/** 
	 * @return level 
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/** 
	 * @return appraise 
	 */
	public String getAppraise() {
		return appraise;
	}

	/**
	 * @param appraise the appraise to set
	 */
	public void setAppraise(String appraise) {
		this.appraise = appraise;
	}
	
	/** 
	 * @return createDateStr 
	 */
	public String getCreateDateStr() {
		return createDateStr;
	}

	/**
	 * @param createDateStr the createDateStr to set
	 */
	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", correctUserId=").append(correctUserId);
        sb.append(", userId=").append(userId);
        sb.append(", homeworkId=").append(homeworkId);
        sb.append(", levelFlag=").append(levelFlag);
        sb.append(", mark=").append(mark);
        sb.append(", createDate=").append(createDate);
        sb.append(", appraiseFlag=").append(appraiseFlag);
        sb.append("]");
        return sb.toString();
    }
}