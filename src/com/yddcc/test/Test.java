package com.yddcc.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yddcc.service.BaseService;
import com.yddcc.beans.ClassRoom;
import com.yddcc.beans.Teacher;
import com.yddcc.utils.BeanDefined;
import com.yddcc.utils.BeanFactory;


public class Test {
	public static void main(String[] args) throws Exception {
		 //1.声明注册bean
		  BeanDefined beanObj = new BeanDefined();
		  beanObj.setBeanId("teacher");
		  beanObj.setClassPath("com.yddcc.beans.Teacher");
		  beanObj.setScope("prototype");
		  
		  List<BeanDefined> beanList = new ArrayList();
		  beanList.add(beanObj);//spring核心配置
		  
		  
		  BeanDefined beanObj2 = new BeanDefined();
		  beanObj2.setBeanId("classRoom");
		  beanObj2.setClassPath("com.yddcc.beans.ClassRoom");
		  beanObj2.setScope("prototype");
		  
		  Map<String, String> propertyMap =  beanObj2.getPropertyMap();
		  propertyMap.put("classRoomName", "一年一班");
		  propertyMap.put("stuArray", "小白,小黑,小红");
		  propertyMap.put("school", "小学1,小学2");
		  
		  beanList.add(beanObj2);//spring核心配置
		  
		  BeanDefined beanObj3 = new BeanDefined();
		  beanObj3.setBeanId("isomeService");
		  beanObj3.setClassPath("com.yddcc.service.impl.ISomeService");
		 
		  BeanDefined beanObj4 = new BeanDefined();		
		  beanObj4.setClassPath("com.yddcc.utils.MyBeanPostProcessor");
		  
		  beanList.add(beanObj3);//spring核心配置
		  beanList.add(beanObj4);//spring核心配置
		  
		  //2.声明一个Spring提供BeanFacotory
		  BeanFactory factory = new BeanFactory(beanList);
		  
		  //3.开发人员向BeanFactory索要实例对象.
		  Teacher t= (Teacher) factory.getBean("teacher");
		  System.out.println(t);
		  
		  Teacher t2= (Teacher) factory.getBean("teacher");
		  System.out.println(t2);
		  
		  System.out.println("---------------------");
		  
		  ClassRoom cr = (ClassRoom) factory.getBean("classRoom");
		  System.out.println(cr);
		  System.out.println(cr.getClassRoomName());
		  System.out.println(cr.getSchool());
		  for(int i = 0;i < cr.getStuArray().length;i++){
			  System.out.println(cr.getStuArray()[i]);
		  }
		  
		  
		  System.out.println("---------------------");
		 
		  
		  BaseService t3= (BaseService) factory.getBean("isomeService");
		  System.out.println("t=1111:"+t3);
		  System.out.println("222:"+t3.doSome());//HELLO MIKE
		  System.out.println("222:"+t3.doAny());//HELLO yddcc
		 
	}
}
