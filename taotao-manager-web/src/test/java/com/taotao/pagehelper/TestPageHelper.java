package com.taotao.pagehelper;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.tools.classfile.Annotation.element_value;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;

/**
 * 测试分页插件
 * <p>Title: TestPageHelper</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年10月19日上午9:46:41
 * @version 1.0
 */
public class TestPageHelper {

	@Test
	public void testPageHelper() throws Exception {
		//创建一个spring容器的实例
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		//从容器中获得Mapper的代理对象
		TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);
		//调用mapp的方法查询商品列表
		TbItemExample example = new TbItemExample();
		//分页处理
		PageHelper.startPage(1, 10);
		List<TbItem> list = itemMapper.selectByExample(example);
		//取分页结果
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		int pages = pageInfo.getPages();
		System.out.println("查询结果总页数：" + pages);
		System.out.println("当前页：" + pageInfo.getPageNum());
		System.out.println("每页记录数：" + pageInfo.getPageSize());
		for (TbItem tbItem : list) {
			System.out.println(tbItem.getTitle());
		}
	}
}
