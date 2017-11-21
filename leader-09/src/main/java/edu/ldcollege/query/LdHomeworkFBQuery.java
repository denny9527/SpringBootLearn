/**
 * @Title: LdHomeworkFBQuery.java
 * @Package: edu.ldcollege.query
 * @Description: 
 * @author Zhang Kui
 * @date 2017年10月14日 下午03:47:49
 * @version V1.0.0
 */
package edu.ldcollege.query;

import com.denny.common.page.QueryPage;
import java.util.Date;

/**
 * @ClassName: LdHomeworkFBQuery
 * @Description: 
 * @author Zhang Kui
 * @date 2017年10月14日 下午03:47:49
 * @version 1.0.0
 */
public class LdHomeworkFBQuery extends QueryPage {

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
    private Date cerareDate;

    /**
     * 排序
     */
    private String orderBy;
    
    private String appraiseFlag;

    public LdHomeworkFBQuery() {
        super();
    }

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
     */
    public Date getCerareDate() {
        return cerareDate;
    }

    /**
     */
    public void setCerareDate(Date cerareDate) {
        this.cerareDate = cerareDate;
    }

    /**
     * @param orderBy the orderBy to set
     */
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy == null ? null : orderBy.trim();
    }

    /**
     * @return the orderBy
     */
    public String getOrderBy() {
        return orderBy;
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

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", id=").append(id);
        sb.append(", correctUserId=").append(correctUserId);
        sb.append(", userId=").append(userId);
        sb.append(", homeworkId=").append(homeworkId);
        sb.append(", levelFlag=").append(levelFlag);
        sb.append(", mark=").append(mark);
        sb.append(", cerareDate=").append(cerareDate);
        sb.append(", orderBy=").append(orderBy);
        sb.append(", appraiseFlag=").append(appraiseFlag);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}