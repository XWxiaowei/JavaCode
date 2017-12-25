package com.jay.generator.mapper;

import com.jay.generator.model.ShDepartment;
import java.util.List;

public interface ShDepartmentMapper {
    /**
     * insert
     * @param record
     * @return int
     */
    int insert(ShDepartment record);

    /**
     * selectByPrimaryKey
     * @param did
     * @return com.jay.generator.model.ShDepartment
     */
    ShDepartment selectByPrimaryKey(Integer did);

    /**
     * selectAll
     * @return java.util.List<com.jay.generator.model.ShDepartment>
     */
    List<ShDepartment> selectAll();

    /**
     * updateByPrimaryKey
     * @param record
     * @return int
     */
    int updateByPrimaryKey(ShDepartment record);
}