package com.example.reader.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.reader.entity.TestTable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

//在测试前自动进行spring IOC初始化工作
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
//IOC容器初始化完成 可以注入对象
public class TestMapperTest {
    @Resource
    private TestMapper testMapper;

    @Test
    public void insertSample() {
        testMapper.insertSample();
    }

    @Test
    public void testInsert(){
        TestTable test = new TestTable();
        test.setContent("XXXXX");
        int count = testMapper.insert(test);
        System.out.println("本地新增"+count);
    }

    @Test
    public void testUpdate(){
        TestTable test = new TestTable();
        test.setId(1);
        test.setContent("DDDD");
        testMapper.updateById(test);
    }
    @Test
    public void testDelete(){
        testMapper.deleteById(20);
    }

    @Test
    public void testSelectById(){
        TestTable test = testMapper.selectById(2);
        System.out.println(test.getContent());
    }

    @Test
    public void testSelectList(){
        QueryWrapper<TestTable> wrapper = new QueryWrapper<>();
        wrapper.lt("id",5);
        wrapper.eq("content","测试内容");
        List<TestTable> list = testMapper.selectList(wrapper);
        System.out.println(list.size());
    }

    @Test
    public void testPagination(){
        IPage page = new Page(1,2);
        QueryWrapper<TestTable> wrapper = new QueryWrapper<>();
        wrapper.lt("id",5);
        wrapper.eq("content","测试内容");
        page = testMapper.selectPage(page, wrapper);
        System.out.println("总页数" + page.getPages());
        System.out.println("当前页数据" + page.getRecords());
    }
}