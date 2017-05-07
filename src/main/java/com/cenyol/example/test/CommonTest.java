package com.cenyol.example.test;

import com.cenyol.example.model.ProductEntity;
import com.cenyol.example.repository.ProductRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Created by shentao on 2017/5/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:WEB-INF/mvc-dispatcher-servlet.xml"})
public class CommonTest {

    @Autowired
    ProductRepo productRepo;

    @Test
    public void test(){

        List<ProductEntity> productEntityList = productRepo.findAll();
        for (int i = 0; i <productEntityList.size() ; i++) {
            System.out.println(productEntityList.get(i).getProductname());

        }
    }
}
