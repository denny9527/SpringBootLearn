/**
 * @Title: LdHomework.java
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
 * 数据库表：T_USER_HOMEWORK
 * @ClassName: LdHomework
 * @Description: 
 * @author Zhang Kui
 * @date 2017年10月14日 下午03:47:49
 * @version 1.0.0 
 */
public class LdHomework implements Serializable {

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
    
    private String className;

    /**
     * 课程ID
     * 表字段：T_USER_HOMEWORK.LESSON_ID
     */
    private Long lessonId;
    
    private String lessonName;

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
    
    private String correctFlagStr;

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
    
    private String bestFlagStr;

    /**
     * 上传时间
     * 表字段：T_USER_HOMEWORK.CREATE_DATE
     */
    private Date createDate;
    
    private String createDateStr;
    
    private String userAccount;
    
    private String userName;
    
    private String appraiseFlag;

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
     * @return the lessionId
     */
    public Long getLessonId() {
        return lessonId;
    }

    /**
     * 设置 课程ID 字段：T_USER_HOMEWORK.LESSON_ID
     *
     * @param lessiond the lessionId to set
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
	 * @return className 
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/** 
	 * @return lessionName 
	 */
	public String getLessonName() {
		return lessonName;
	}

	/**
	 * @param lessonName the lessonName to set
	 */
	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	/** 
	 * @return correctFlagStr 
	 */
	public String getCorrectFlagStr() {
		return correctFlagStr;
	}

	/**
	 * @param correctFlagStr the correctFlagStr to set
	 */
	public void setCorrectFlagStr(String correctFlagStr) {
		this.correctFlagStr = correctFlagStr;
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

	/** 
	 * @return bestFlagStr 
	 */
	public String getBestFlagStr() {
		return bestFlagStr;
	}

	/**
	 * @param bestFlagStr the bestFlagStr to set
	 */
	public void setBestFlagStr(String bestFlagStr) {
		this.bestFlagStr = bestFlagStr;
	}

	/** 
	 * @return userAccount 
	 */
	public String getUserAccount() {
		return userAccount;
	}

	/**
	 * @param userAccount the userAccount to set
	 */
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	/** 
	 * @return userName 
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
        sb.append("]");
        return sb.toString();
    }
}