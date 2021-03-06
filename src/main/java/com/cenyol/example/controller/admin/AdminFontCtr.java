package com.cenyol.example.controller.admin;

import com.cenyol.example.model.OrderEntity;
import com.cenyol.example.model.ProductEntity;
import com.cenyol.example.model.PromotionEntity;
import com.cenyol.example.repository.OrderRepo;
import com.cenyol.example.repository.ProductRepo;
import com.cenyol.example.repository.PromotionRepo;
import com.cenyol.example.service.OrderService;
import com.cenyol.example.service.ProductService;
import com.cenyol.example.service.PromotionService;
import com.cenyol.example.utils.StringUtil;
import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;

import java.util.*;


@Controller
public class AdminFontCtr {


    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private OrderService orderService;
    @Autowired
    private PromotionService promotionService;

    // 商品列表
    @RequestMapping(value = "/admin/pro", method = RequestMethod.GET)
    public String proList(ModelMap modelMap) {
        // 返回pages目录下的userManage.jsp
        List<ProductEntity> productList = productRepo.findAll();
        modelMap.addAttribute("proList", productList);//用于将controller方法里面的参数(proList)传递给所需的jsp页面，以进行相关显示
        return "admin/product";
    }
    // 商品添加
    @RequestMapping(value = "/admin/pro/add", method = RequestMethod.GET)
    public String proAdd(ModelMap modelMap) {
        return "admin/addproduct";
    }
    // 商品修改
    @RequestMapping(value = "/admin/pro/{id}", method = RequestMethod.GET)
    public String proUpdate(ModelMap modelMap, @PathVariable String id) {
        ProductEntity productEntity = productRepo.findOne(Integer.valueOf(id));
        modelMap.addAttribute("pro", productEntity);
        return "admin/productdetail";
    }
    @RequestMapping(value = "/admin/pro/add", method = RequestMethod.POST)//得到接收的数据
    public ModelAndView proadd(
            String type,
            String price,
            String name,
            String description,
            @RequestParam(value = "image", required = true) MultipartFile image,
            Map<String, String> map,
            HttpServletResponse response,
            HttpServletRequest request) {

        ModelAndView ret = null;

        if (image.getSize() < 2 || image.getSize() < 2) {
            if (image.getSize() < 2) {
                map.put("msg", "添加失败,请选择内容页图片:");
            } else {
                map.put("msg", "添加失败,请选择封面:");
            }
            map.put("url", "");
        } else {
            String imagenewname = new Date().getTime() + new Random().nextInt() + image.getOriginalFilename();
            saveFile(request, imagenewname, image);

            ProductEntity productEntity = new ProductEntity(
                    type,
                    name,
                    Double.parseDouble(price),
                    0,
                    "/upload/" + imagenewname,
                    description
            );
            if (productService.add(productEntity) != null) {
                //数据传输到数据库success
                map.put("msg", "添加成功");
            } else {
                //fail
                map.put("msg", "添加失败");
            }
            map.put("url", "/admin/pro");
        }
        ret = new ModelAndView("admin/jsalert");

        return ret;
    }


    @RequestMapping(value = "/admin/pro/{id}/modify", method = RequestMethod.POST)
    public ModelAndView promodify(
            String type,
            String price,
            String name,
            String description,
            @RequestParam(value = "image", required = false) MultipartFile image,
            Map<String, String> map,
            HttpServletResponse response,
            HttpServletRequest request,
            @PathVariable String id) {

        ModelAndView ret = null;

        String imagenewname = "";
        if (image.getSize() > 2) {
            imagenewname = new Date().getTime() + new Random().nextInt() + image.getOriginalFilename();
            saveFile(request, imagenewname, image);
        }

        ProductEntity productEntity = new ProductEntity(
                type,
                name,
                Double.parseDouble(price),
                0,
                imagenewname.equals("") ? "" : ("/upload/" + imagenewname),
                description
        );
        productEntity.setProductid(Integer.parseInt(id));
        if (productService.update(productEntity) != null) {
            //success
            map.put("msg", "修改成功");
        } else {
            //fail
            map.put("msg", "修改失败");
        }
        map.put("url", "/admin/pro");

        ret = new ModelAndView("admin/jsalert");

        return ret;
    }


    @RequestMapping(value = "/admin/pro/{id}/del", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, String> del(
            @PathVariable String id
    ) {
        HashMap hm = new HashMap();


        if (productService.del(Integer.parseInt(id)) == true) {

            hm.put("state", "00000");

        }else{
            hm.put("state","10000");
        }

        return  hm;

    }


    /**
     * 功能描述   保存图片
     *
     * @param newFileName 上传照片文件名
     * @param filedata    文件数据
     *                    <p>
     *                    修改历史 ：(修改人，修改时间，修改原因/内容)
     * @author ：xiaoyu 创建日期 ：2014年2月12日 下午7:37:45
     */
    private void saveFile(HttpServletRequest request, String newFileName, MultipartFile filedata) {
        // TODO Auto-generated method stub
        // 根据配置文件获取服务器图片存放路径
        String picDir = "";
        picDir = request.getSession()
                .getServletContext().getRealPath("/")
                + "upload" + File.separator;

        String saveFilePath = picDir;

        /* 构建文件目录 */
        File fileDir = new File(saveFilePath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        try {
            FileOutputStream out = new FileOutputStream(saveFilePath + File.separator
                    + newFileName);
            // 写入文件
            out.write(filedata.getBytes());
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    // 订单列表
    @RequestMapping(value = "/admin/order", method = RequestMethod.GET)
    public String orderList(ModelMap modelMap) {
        // 返回pages目录下的userManage.jsp
        List<OrderEntity> orderList = orderRepo.findAll();
        modelMap.addAttribute("orderList", orderList);
        return "admin/order";
    }


    @RequestMapping(value = "/admin/order/{id}/del", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, String> orderDel(
            @PathVariable String id
    ) {
        HashMap hm = new HashMap();


        if (orderService.del(Integer.parseInt(id)) == true) {

            hm.put("state", "00000");

        }else{
            hm.put("state","10000");
        }

        return  hm;

    }

    @RequestMapping(value = "/admin/order/{id}/comfirm", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, String> orderComfirm(
            @PathVariable String id
    ) {
        HashMap hm = new HashMap();
        try{

            orderService.update(Integer.parseInt(id),2);
            hm.put("state", "00000");
        }catch (Exception e){
            hm.put("state","10000");
        }
        return  hm;

    }


    //促销
    @RequestMapping(value = "/cx/add", method = RequestMethod.POST)//得到接收的数据
    @ResponseBody
    public HashMap<String, String> cuxiao(
            String productid,
            String starttime,
            String   endtime,
             String price){

//        Date starttime1 =AdminFontCtr.LocalDateTimeToUdate(starttime);
//        Date endtime1 =AdminFontCtr.LocalDateTimeToUdate(endtime);

        HashMap<String,String> map = new HashMap<String, String>();

        Date date1 = t2(Long.parseLong(starttime));
        Date date2 = t2(Long.parseLong(endtime));

        PromotionEntity promotionEntity = new PromotionEntity(Integer.valueOf(productid),Double.valueOf(price),date1,date2);
        if (promotionService.add(promotionEntity)!=null) {
                map.put("state","00000");

        }else
            map.put("state","10001");
        return map;
}

    /**
     * 时间戳转换为日期对象
     */
    public static Date t2(long times){

        Date date = new Date(times);
        System.out.println(date);
        //输出结果：Tue Dec 10 16:54:26 CST 2013
        return date;
    }

}
