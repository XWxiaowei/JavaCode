package com.jay.generator.mapper;

import com.jay.generator.model.ShEmployee;
import java.util.List;

public interface ShEmployeeMapper {
    /**
     * insert
     * @param record
     * @return int
     */
    int insert(ShEmployee record);

    /**
     * selectByPrimaryKey
     * @param eid
     * @return com.jay.generator.model.ShEmployee
     */
    ShEmployee selectByPrimaryKey(Integer eid);

    /**
     * selectAll
     * @return java.util.List<com.jay.generator.model.ShEmployee>
     */
    List<ShEmployee> selectAll();

    /**
     * updateByPrimaryKey
     * @param record
     * @return int
     */
    int updateByPrimaryKey(ShEmployee record);

    /**
     * countList
     * @return int
     */
    int countList();

    /**
     * queryPageList
     * @param current
     * @param pageSize
     * @return java.util.List<com.jay.generator.model.ShEmployee>
     */
    List<ShEmployee> queryPageList(Integer current, Integer pageSize);
}