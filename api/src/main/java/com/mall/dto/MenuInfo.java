package com.mall.dto;

import java.io.Serializable;
import java.util.Date;

public class MenuInfo implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu_info.id
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu_info.name
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu_info.parent_id
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    private String parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu_info.parent_name
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    private String parentName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu_info.level
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    private String level;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu_info.create_time
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu_info.modify_time
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    private Date modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu_info.last_modify_user
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    private String lastModifyUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu_info.staus
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    private String staus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table menu_info
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu_info.id
     *
     * @return the value of menu_info.id
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu_info.id
     *
     * @param id the value for menu_info.id
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu_info.name
     *
     * @return the value of menu_info.name
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu_info.name
     *
     * @param name the value for menu_info.name
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu_info.parent_id
     *
     * @return the value of menu_info.parent_id
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu_info.parent_id
     *
     * @param parentId the value for menu_info.parent_id
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu_info.parent_name
     *
     * @return the value of menu_info.parent_name
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    public String getParentName() {
        return parentName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu_info.parent_name
     *
     * @param parentName the value for menu_info.parent_name
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu_info.level
     *
     * @return the value of menu_info.level
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    public String getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu_info.level
     *
     * @param level the value for menu_info.level
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu_info.create_time
     *
     * @return the value of menu_info.create_time
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu_info.create_time
     *
     * @param createTime the value for menu_info.create_time
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu_info.modify_time
     *
     * @return the value of menu_info.modify_time
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu_info.modify_time
     *
     * @param modifyTime the value for menu_info.modify_time
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu_info.last_modify_user
     *
     * @return the value of menu_info.last_modify_user
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    public String getLastModifyUser() {
        return lastModifyUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu_info.last_modify_user
     *
     * @param lastModifyUser the value for menu_info.last_modify_user
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    public void setLastModifyUser(String lastModifyUser) {
        this.lastModifyUser = lastModifyUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu_info.staus
     *
     * @return the value of menu_info.staus
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    public String getStaus() {
        return staus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu_info.staus
     *
     * @param staus the value for menu_info.staus
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    public void setStaus(String staus) {
        this.staus = staus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu_info
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", parentId=").append(parentId);
        sb.append(", parentName=").append(parentName);
        sb.append(", level=").append(level);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", lastModifyUser=").append(lastModifyUser);
        sb.append(", staus=").append(staus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}