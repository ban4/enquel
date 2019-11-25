package com.jskj.enquel.test.controller;

import com.jskj.enquel.EnquelApplication;
import com.jskj.enquel.controller.EnquelController;
import com.jskj.enquel.entity.UserDTO;
import com.jskj.enquel.service.impl.EnquelServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EnquelApplication.class)
public class EnquelControllerTest {

    @Spy
    @InjectMocks
    private EnquelController enquelController;

    //@Mock
    //private EnquelService enquelService;

    @Mock
    private EnquelServiceImpl enquelServiceImpl;

    @Test
    public void getUserControllerTest(){
        System.out.println("start test...");
        ResponseEntity<UserDTO> user = enquelController.getUser(1);
        System.out.println(user);
        System.out.println("end test...");

        when(enquelController.getUser(1)).thenReturn(null);
        System.out.println("when ok");

    }

    @Test
    public void getUserServiceTest(){
        System.out.println("test service start");
        //UserDTO user = enquelServiceImpl.getUser(1);
       // System.out.println(user);
        System.out.println("test service end");
    }

    @Test
    public void mockTest(){
        //mock一个Iterator类
        Iterator iterator = mock(Iterator.class);
        //预设当iterator调用next()时第一次返回hello，第n次都返回world
        Mockito.when(iterator.next()).thenReturn("hello").thenReturn("world");
        //使用mock的对象
        String result = iterator.next() + " " + iterator.next() + " " + iterator.next();
        //验证结果
        assertEquals("hello world world",result);

        String ss = null;
        Assert.assertNotNull(ss);
    }

    @Test
    public void compareMockAndSpyTest(){

        System.out.println("Mock start ......");
        List<String> mockList = Mockito.mock(List.class);
        Mockito.when(mockList.get(0)).thenReturn("helloworld");
        String result = mockList.get(0);
        Mockito.verify(mockList).get(0);
        Assert.assertEquals("helloworld", result);
        System.out.println("Mock end......");


        System.out.println("spy start -----");
        // 让我们来模拟一个LinkedList
        List<String> spyList = new LinkedList<>();
        List<String> spy = spy(spyList);

        // spy.get(0)将会调用真实的方法
        // 将会抛出 IndexOutOfBoundsException (list是空的)
        //spy.add("aa");
        when(spy.get(0)).thenReturn("foo");
        assertEquals("foo", spy.get(0));
        System.out.println("spy end -----");
    }

    @Test
    public void SpyTest1(){
        // 让我们来模拟一个LinkedList
        List<String> list = new LinkedList<>();
        List<String> spy = spy(list);
        // 必须使用doReturn来插桩
        doReturn("foo").when(spy).get(0);
        assertEquals("foo", spy.get(0));

    }



}
