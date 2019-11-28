package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import com.tensquare.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: LabelService
 * @Description: 标签业务类
 * @Author: wangcunfu
 * @Date: 2019/11/25 22:37
 * @Version: v1.0 文件初始创建
 */
@Service
public class LabelService {
    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * @Description: 查询全部标签
     * @Date: 2019/11/25 22:40
     * @Author: wangcunfu
     * @Return java.util.List<com.tensquare.base.pojo.Label>
     */
    public List<Label> findAll(){
        return labelDao.findAll();
    }

    /**
     * @Description: 根据id查询标签信息
     * @param id
     * @Date: 2019/11/25 22:43
     * @Author: wangcunfu
     * @Return com.tensquare.base.pojo.Label
     * @Throws
     */
    public Label findById(String id){
        return labelDao.findById(id).get();
    }

    /**
     * @Description: 增加标签
     * @param label
     * @Date: 2019/11/25 22:47
     * @Author: wangcunfu
     * @Return void
     * @Throws
     */
    @Transactional(rollbackFor = Exception.class)
    public void add(Label label){
        label.setId(String.valueOf(idWorker.nextId()));
        label.setState("0");
        labelDao.save(label);
    }
    /**
     * @Description: 修改标签/逻辑删除
     * @param label
     * @Date: 2019/11/25 22:45
     * @Author: wangcunfu
     * @Return com.tensquare.base.pojo.Label
     * @Throws
     */
    @Transactional(rollbackFor = Exception.class)
    public Label updateById(Label label){
        return labelDao.save(label);
    }

    /**
     * @Description: 物理删除单条标签
     * @param id
     * @Date: 2019/11/25 22:51
     * @Author: wangcunfu
     * @Return void
     * @Throws
     */
    public void delete(String id){
        labelDao.deleteById(id);
    }
}
