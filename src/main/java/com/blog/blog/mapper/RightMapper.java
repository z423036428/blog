package com.blog.blog.mapper;

import com.blog.blog.module.Right;

public interface RightMapper {
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
    Right selectByPrimaryKey(Long id);

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