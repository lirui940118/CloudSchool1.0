package com.CloudSchool.controller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.CloudSchool.domain.UEditor;
import com.alibaba.fastjson.JSONObject;
@Controller
public class UeditorController {
	@Value("${imgUrl}")
	String imgUrl;
	
	
	@RequestMapping(value = "/ueditor")
	@ResponseBody
	public String ueditor(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ueditor---配置");
	    String s = "{\n" + 
	    		"    \n" + 
	    		"    \"imageActionName\": \"uploadimage\", \n" + 
	    		"    \"imageFieldName\": \"upfile\", \n" + 
	    		"    \"imageMaxSize\": 2048000, \n" + 
	    		"    \"imageAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"], \n" + 
	    		"    \"imageCompressEnable\": true, \n" + 
	    		"    \"imageCompressBorder\": 1600, \n" + 
	    		"    \"imageInsertAlign\": \"none\", \n" + 
	    		"    \"imageUrlPrefix\": \"\", \n" + 
	    		"    \"imagePathFormat\": \"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\", \n" + 
	    		"\n" + 
	    		"    \n" + 
	    		"    \"scrawlActionName\": \"uploadscrawl\", \n" + 
	    		"    \"scrawlFieldName\": \"upfile\", \n" + 
	    		"    \"scrawlPathFormat\": \"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\", \n" + 
	    		"    \"scrawlMaxSize\": 2048000, \n" + 
	    		"    \"scrawlUrlPrefix\": \"\", \n" + 
	    		"    \"scrawlInsertAlign\": \"none\",\n" + 
	    		"\n" + 
	    		"    \n" + 
	    		"    \"snapscreenActionName\": \"uploadimage\", \n" + 
	    		"    \"snapscreenPathFormat\": \"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\", \n" + 
	    		"    \"snapscreenUrlPrefix\": \"\", \n" + 
	    		"    \"snapscreenInsertAlign\": \"none\", \n" + 
	    		"\n" + 
	    		"    \n" + 
	    		"    \"catcherLocalDomain\": [\"127.0.0.1\", \"localhost\", \"img.baidu.com\"],\n" + 
	    		"    \"catcherActionName\": \"catchimage\", \n" + 
	    		"    \"catcherFieldName\": \"source\", \n" + 
	    		"    \"catcherPathFormat\": \"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\", \n" + 
	    		"    \"catcherUrlPrefix\": \"\", \n" + 
	    		"    \"catcherMaxSize\": 2048000, \n" + 
	    		"    \"catcherAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"], \n" + 
	    		"\n" + 
	    		"    \n" + 
	    		"    \"videoActionName\": \"uploadvideo\", \n" + 
	    		"    \"videoFieldName\": \"upfile\", \n" + 
	    		"    \"videoPathFormat\": \"/ueditor/jsp/upload/video/{yyyy}{mm}{dd}/{time}{rand:6}\", \n" + 
	    		"    \"videoUrlPrefix\": \"\", \n" + 
	    		"    \"videoMaxSize\": 102400000, \n" + 
	    		"    \"videoAllowFiles\": [\n" + 
	    		"        \".flv\", \".swf\", \".mkv\", \".avi\", \".rm\", \".rmvb\", \".mpeg\", \".mpg\",\n" + 
	    		"        \".ogg\", \".ogv\", \".mov\", \".wmv\", \".mp4\", \".webm\", \".mp3\", \".wav\", \".mid\"], \n" + 
	    		"\n" + 
	    		"    \n" + 
	    		"    \"fileActionName\": \"uploadfile\", \n" + 
	    		"    \"fileFieldName\": \"upfile\", \n" + 
	    		"    \"filePathFormat\": \"/ueditor/jsp/upload/file/{yyyy}{mm}{dd}/{time}{rand:6}\", \n" + 
	    		"    \"fileUrlPrefix\": \"\", \n" + 
	    		"    \"fileMaxSize\": 51200000, \n" + 
	    		"    \"fileAllowFiles\": [\n" + 
	    		"        \".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\",\n" + 
	    		"        \".flv\", \".swf\", \".mkv\", \".avi\", \".rm\", \".rmvb\", \".mpeg\", \".mpg\",\n" + 
	    		"        \".ogg\", \".ogv\", \".mov\", \".wmv\", \".mp4\", \".webm\", \".mp3\", \".wav\", \".mid\",\n" + 
	    		"        \".rar\", \".zip\", \".tar\", \".gz\", \".7z\", \".bz2\", \".cab\", \".iso\",\n" + 
	    		"        \".doc\", \".docx\", \".xls\", \".xlsx\", \".ppt\", \".pptx\", \".pdf\", \".txt\", \".md\", \".xml\"\n" + 
	    		"    ], \n" + 
	    		"\n" + 
	    		"    \n" + 
	    		"    \"imageManagerActionName\": \"listimage\", \n" + 
	    		"    \"imageManagerListPath\": \"/ueditor/jsp/upload/image/\", \n" + 
	    		"    \"imageManagerListSize\": 20, \n" + 
	    		"    \"imageManagerUrlPrefix\": \"\", \n" + 
	    		"    \"imageManagerInsertAlign\": \"none\", \n" + 
	    		"    \"imageManagerAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"], \n" + 
	    		"\n" + 
	    		"    \n" + 
	    		"    \"fileManagerActionName\": \"listfile\", \n" + 
	    		"    \"fileManagerListPath\": \"/ueditor/jsp/upload/file/\", \n" + 
	    		"    \"fileManagerUrlPrefix\": \"\", \n" + 
	    		"    \"fileManagerListSize\": 20, \n" + 
	    		"    \"fileManagerAllowFiles\": [\n" + 
	    		"        \".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\",\n" + 
	    		"        \".flv\", \".swf\", \".mkv\", \".avi\", \".rm\", \".rmvb\", \".mpeg\", \".mpg\",\n" + 
	    		"        \".ogg\", \".ogv\", \".mov\", \".wmv\", \".mp4\", \".webm\", \".mp3\", \".wav\", \".mid\",\n" + 
	    		"        \".rar\", \".zip\", \".tar\", \".gz\", \".7z\", \".bz2\", \".cab\", \".iso\",\n" + 
	    		"        \".doc\", \".docx\", \".xls\", \".xlsx\", \".ppt\", \".pptx\", \".pdf\", \".txt\", \".md\", \".xml\"\n" + 
	    		"    ] \n" + 
	    		"\n" + 
	    		"}";
	   
	    return s;
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("imageActionName", "uploadimage"); // 执行上传图片的action名称
//        jsonObject.put("imageAllowFiles", new String[] { ".png", ".jpg", ".jpeg", ".gif", ".bmp" }); // 允许上传的图片类型
//        jsonObject.put("imageFieldName", "upfile"); // 提交的图片表单名称
//        jsonObject.put("imageMaxSize", "2048000"); // 上传大小限制，单位B
//        jsonObject.put("imageCompressEnable", true); // 是否压缩图片,默认是true
//        jsonObject.put("imageCompressBorder", 1600); // 图片压缩最长边限制
//        jsonObject.put("imageInsertAlign", "none"); // 插入的图片浮动方式
//        jsonObject.put("imageUrlPrefix", "http://127.0.0.1:8080/static/image/"); // 图片访问路径前缀
//        jsonObject.put("imagePathFormat", "/{yyyy}{mm}{dd}/{time}{rand:6}"); // 上传保存路径,可以自定义保存路径和文件名格式
//        return s;

	}
	
	@RequestMapping(value = "/imgUpdate")
	@ResponseBody
	public UEditor imgUpdate(MultipartFile upfile) {
		System.out.println("ueditor---imgupdate图片上传");
	    if (upfile.isEmpty()) {
	        return null;
	    }
	    // 获取文件名
	    String fileName = upfile.getOriginalFilename();
	    // 获取文件的后缀名
	    String suffixName = fileName.substring(fileName.lastIndexOf("."));
	    // 这里我使用随机字符串来重新命名图片
//	    fileName = Calendar.getInstance().getTimeInMillis() + Randoms.getRandomStringLower(4) + suffixName;
	    fileName = Calendar.getInstance().getTimeInMillis() + (int)(Math.random()*9000)+1000 + suffixName;
	    // 这里的路径为Nginx的代理路径，这里是/data/images/xxx.png
//	    File dest = new File(ConstantL.IMAGE_UPDATE_PATH + fileName);
	    File dest = new File(imgUrl + fileName);
	    // 检测是否存在目录
	    if (!dest.getParentFile().exists()) {
	        dest.getParentFile().mkdirs();
	        System.out.println("检测是否存在目录");
	    }
	    try {
	    	upfile.transferTo(dest);
	        //url的值为图片的实际访问地址 这里我用了Nginx代理，访问的路径是http://localhost/xxx.png
	        String config = "{\"state\": \"SUCCESS\"," +
//	                "\"url\": \"" + ConstantL.BASE_URL + fileName + "\"," +
	                "\"url\": \"/baidueditor/" + fileName + "\"," +
	                "\"title\": \"" + fileName + "\"," +
	                "\"original\": \"" + fileName + "\"}";
	        
	        UEditor u = new UEditor();
	        u.setUrl("/baidueditor/" + fileName);
	        u.setState("SUCCESS");
	        u.setTitle("hello");
	        u.setOriginal("hello");
	        return u;
	    } catch (IllegalStateException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
}
