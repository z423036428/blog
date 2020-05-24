package com.blog.blog.mapper;

import com.blog.blog.module.Right;
import com.blog.blog.module.RightExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RightMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table right
     *
     * @mbggenerated
     */
    int countByExample(RightExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table right
     *
     * @mbggenerated
     */
    int deleteByExample(RightExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table right
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table right
     *
     * @mbggenerated
     */
    int insert(Right record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table right
     *
     * @mbggenerated
     */
    int insertSelective(Right record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table right
     *
     * @mbggenerated
     */
    List<Right> selectByExample(RightExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table right
     *
     * @mbggenerated
     */
    Right selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table right
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Right record, @Param("example") RightExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table right
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Right record, @Param("example") RightExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table right
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Right record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table right
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Right record);
}