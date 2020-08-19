package com.isoft.demo.controller;

import com.isoft.demo.bean.ResponseData;
import com.isoft.demo.entity.User;
import com.isoft.demo.service.UserService;
import com.isoft.demo.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@CrossOrigin  //允许跨域请求
@RestController  //序列化为Json
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    String path = "userphoto/";
    @GetMapping("ccc")
    public String ccc(){
        System.out.println("ccccccccccccccccccccc");
        return "啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊";
    }
    /*修改密码*/
    @PutMapping("pwd")
    public ResponseData updatePassword(@RequestBody Map<String , Object> map){
        int r= -1 ;
        try {
            r = userService.updatePass((Integer) map.get("id")  , (String) map.get("oldpass") , (String) map.get("newpass"));
        }catch (Exception e){
            e.printStackTrace();
            r = 2;
        }
        String msg = "";
        switch (r){
            case 0 : msg = "修改成功";
            break;
            case 1 : msg = "原密码错误";
            break;
            case 2 : msg = "修改失败";
            break;
        }
        return new ResponseData(r , msg , r== 0? true : false);
    }
    /*修改头像*/
    @PostMapping("photo")
    public ResponseData uploadPhoto(Integer id , @RequestParam("userphoto") MultipartFile file , HttpServletRequest request) {
        if (null == file){
            return new ResponseData(-1 , "上传文件为空" , null);
        }
        //处理文件名
        String oriFilename = file.getOriginalFilename();
        String extName = oriFilename.substring(oriFilename.lastIndexOf("."));
        //文件新名字
        String newFileName = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date()) + "_" + id +extName ;
        //文件路径
        boolean isOk = FileUtil.saveUpFile(request , path ,newFileName ,file);
        //保存成功后，处理文件的绝对url
        String photoUrl = null ;
        if (isOk){
            photoUrl = FileUtil.url(request , path , newFileName);
            //更改数据库
            User u = new User();
            u.setUserId(id);
            u.setUserPhotoUrl(newFileName);
            isOk = userService.updatePhoto(u);
        }
        ResponseData responseData = new ResponseData();
        responseData.setErrCode(isOk ? 0 : -1);
        responseData.setMsg(isOk ? "上传成功" : "上传失败");
        responseData.setData(photoUrl);
        return responseData;
    }

}
