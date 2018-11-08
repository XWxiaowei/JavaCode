package com.aisino.projects.task.mapper;

import com.aisino.projects.task.model.TelefenGoods;
import java.util.List;

public interface TelefenGoodsMapper {
    /**
     * deleteByPrimaryKey
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(String id);

    /**
     * insert
     * @param record
     * @return int
     */
    int insert(TelefenGoods record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return com.aisino.projects.task.model.TelefenGoods
     */
    TelefenGoods selectByPrimaryKey(String id);

    /**
     * selectAll
     * @return java.util.List<com.aisino.projects.task.model.TelefenGoods>
     */
    List<TelefenGoods> selectAll();

    /**
     * updateByPrimaryKey
     * @param record
     * @return int
     */
    int updateByPrimaryKey(TelefenGoods record);

    /**
     * countList
     * @return int
     */
    int countList();

    /**
     * queryPageList
     * @param current
     * @param pageSize
     * @return java.util.List<com.aisino.projects.task.model.TelefenGoods>
     */
    List<TelefenGoods> queryPageList(Integer current, Integer pageSize);
}