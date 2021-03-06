package com.mall.mapper;

import com.mall.dto.RoleInfo;
import com.mall.dto.RoleInfoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lb
 */
@Mapper
public interface RoleInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    int countByExample(RoleInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    int deleteByExample(RoleInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    int insert(RoleInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    int insertSelective(RoleInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    List<RoleInfo> selectByExample(RoleInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    RoleInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    int updateByExampleSelective(@Param("record") RoleInfo record, @Param("example") RoleInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    int updateByExample(@Param("record") RoleInfo record, @Param("example") RoleInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    int updateByPrimaryKeySelective(RoleInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbggenerated Wed Mar 02 14:56:31 CST 2022
     */
    int updateByPrimaryKey(RoleInfo record);
}