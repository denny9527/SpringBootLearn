/**
 * @Title: LdHomeworkQuery.java
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
 * @ClassName: LdHomeworkQuery
 * @Description: 
 * @author Zhang Kui
 * @date 2017年10月14日 下午03:47:49
 * @version 1.0.0
 */
public class LdHomeworkQuery extends QueryPage {

    private static final long serialVersionUID = 1L;

    /**
     * 记录ID
     * 表字段：T_USER_HOMEWORK.ID
     */
    private Long id;

    /**
     * 学员ID
     * 表字段：T_USER_HOMEWORK.USER_ID
     */
    private Long userId;

    /**
     * 班级ID
     * 表字段：T_USER_HOMEWORK.CLASS_ID
     */
    private Long classId;

    /**
     * 课程ID
     * 表字段：T_USER_HOMEWORK.LESSON_ID
     */
    private Long lessonId;

    /**
     * 作业文件路径
     * 表字段：T_USER_HOMEWORK.HOMEWORK_FILE_PATH
     */
    private String homeworkFilePath;

    /**
     * 作业文件名称
     * 表字段：T_USER_HOMEWORK.HOMEWORK_FILE_NAME
     */
    private String homeworkFileName;

    /**
     * 批改标志(0:未批改 1:已批改)
     * 表字段：T_USER_HOMEWORK.CORRECT_FLAG
     */
    private String correctFlag;

    /**
     * 点赞数
     * 表字段：T_USER_HOMEWORK.STAR_COUNT
     */
    private Long starCount;

    /**
     * 差评数
     * 表字段：T_USER_HOMEWORK.NEGATIVE_COUNT
     */
    private Long negativeCount;

    /**
     * 优秀作业
     * 表字段：T_USER_HOMEWORK.BEST_FLAG
     */
    private String bestFlag;

    /**
     * 上传时间
     * 表字段：T_USER_HOMEWORK.CREATE_DATE
     */
    private Date createDate;

    /**
     * 排序
     */
    private String orderBy;
    
    private Long excludeUserId;

    public LdHomeworkQuery() {
        super();
    }

    /**
     * 获取 记录ID 字段：T_USER_HOMEWORK.ID
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 记录ID 字段：T_USER_HOMEWORK.ID
     *
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 学员ID 字段：T_USER_HOMEWORK.USER_ID
     *
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置 学员ID 字段：T_USER_HOMEWORK.USER_ID
     *
     * @param userId the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取 班级ID 字段：T_USER_HOMEWORK.CLASS_ID
     *
     * @return the classId
     */
    public Long getClassId() {
        return classId;
    }

    /**
     * 设置 班级ID 字段：T_USER_HOMEWORK.CLASS_ID
     *
     * @param classId the classId to set
     */
    public void setClassId(Long classId) {
        this.classId = classId;
    }

    /**
     * 获取 课程ID 字段：T_USER_HOMEWORK.LESSON_ID
     *
     * @return the lessonId
     */
    public Long getLessonId() {
        return lessonId;
    }

    /**
     * 设置 课程ID 字段：T_USER_HOMEWORK.LESSON_ID
     *
     * @param lessonId the lessionId to set
     */
    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    /**
     * 获取 作业文件路径 字段：T_USER_HOMEWORK.HOMEWORK_FILE_PATH
     *
     * @return the homeworkFilePath
     */
    public String getHomeworkFilePath() {
        return homeworkFilePath;
    }

    /**
     * 设置 作业文件路径 字段：T_USER_HOMEWORK.HOMEWORK_FILE_PATH
     *
     * @param homeworkFilePath the homeworkFilePath to set
     */
    public void setHomeworkFilePath(String homeworkFilePath) {
        this.homeworkFilePath = homeworkFilePath == null ? null : homeworkFilePath.trim();
    }

    /**
     * 获取 作业文件名称 字段：T_USER_HOMEWORK.HOMEWORK_FILE_NAME
     *
     * @return the homeworkFileName
     */
    public String getHomeworkFileName() {
        return homeworkFileName;
    }

    /**
     * 设置 作业文件名称 字段：T_USER_HOMEWORK.HOMEWORK_FILE_NAME
     *
     * @param homeworkFileName the homeworkFileName to set
     */
    public void setHomeworkFileName(String homeworkFileName) {
        this.homeworkFileName = homeworkFileName == null ? null : homeworkFileName.trim();
    }

    /**
     * 获取 批改标志(0:未批改 1:已批改) 字段：T_USER_HOMEWORK.CORRECT_FLAG
     *
     * @return the correctFlag
     */
    public String getCorrectFlag() {
        return correctFlag;
    }

    /**
     * 设置 批改标志(0:未批改 1:已批改) 字段：T_USER_HOMEWORK.CORRECT_FLAG
     *
     * @param correctFlag the correctFlag to set
     */
    public void setCorrectFlag(String correctFlag) {
        this.correctFlag = correctFlag == null ? null : correctFlag.trim();
    }

    /**
     * 获取 点赞数 字段：T_USER_HOMEWORK.STAR_COUNT
     *
     * @return the starCount
     */
    public Long getStarCount() {
        return starCount;
    }

    /**
     * 设置 点赞数 字段：T_USER_HOMEWORK.STAR_COUNT
     *
     * @param starCount the starCount to set
     */
    public void setStarCount(Long starCount) {
        this.starCount = starCount;
    }

    /**
     * 获取 差评数 字段：T_USER_HOMEWORK.NEGATIVE_COUNT
     *
     * @return the negativeCount
     */
    public Long getNegativeCount() {
        return negativeCount;
    }

    /**
     * 设置 差评数 字段：T_USER_HOMEWORK.NEGATIVE_COUNT
     *
     * @param negativeCount the negativeCount to set
     */
    public void setNegativeCount(Long negativeCount) {
        this.negativeCount = negativeCount;
    }

    /**
     * 获取 优秀作业 字段：T_USER_HOMEWORK.BEST_FLAG
     *
     * @return the bestFlag
     */
    public String getBestFlag() {
        return bestFlag;
    }

    /**
     * 设置 优秀作业 字段：T_USER_HOMEWORK.BEST_FLAG
     *
     * @param bestFlag the bestFlag to set
     */
    public void setBestFlag(String bestFlag) {
        this.bestFlag = bestFlag == null ? null : bestFlag.trim();
    }

    /**
     * 获取 上传时间 字段：T_USER_HOMEWORK.CREATE_DATE
     *
     * @return the createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置 上传时间 字段：T_USER_HOMEWORK.CREATE_DATE
     *
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
	 * @return excludeUserId 
	 */
	public Long getExcludeUserId() {
		return excludeUserId;
	}

	/**
	 * @param excludeUserId the excludeUserId to set
	 */
	public void setExcludeUserId(Long excludeUserId) {
		this.excludeUserId = excludeUserId;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", classId=").append(classId);
        sb.append(", lessonId=").append(lessonId);
        sb.append(", homeworkFilePath=").append(homeworkFilePath);
        sb.append(", homeworkFileName=").append(homeworkFileName);
        sb.append(", correctFlag=").append(correctFlag);
        sb.append(", starCount=").append(starCount);
        sb.append(", negativeCount=").append(negativeCount);
        sb.append(", bestFlag=").append(bestFlag);
        sb.append(", createDate=").append(createDate);
        sb.append(", orderBy=").append(orderBy);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}