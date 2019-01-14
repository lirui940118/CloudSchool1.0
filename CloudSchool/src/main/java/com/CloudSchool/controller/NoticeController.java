package com.CloudSchool.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CloudSchool.domain.CqjUser;
import com.CloudSchool.domain.Notice;
import com.CloudSchool.service.NoticeService;
import com.CloudSchool.service.imgcompressService;
import com.alibaba.fastjson.JSONObject;

@Controller
public class NoticeController {
	@Autowired
	NoticeService ns;
	@RequestMapping(value="/addnotice" ,method=RequestMethod.GET)
	public String toAddNotice() {
		System.out.println("跳转页面-添加通知");
		return "tzx/addnotice";
	}
	@ResponseBody
	@RequestMapping(value="/addnotice" ,method=RequestMethod.POST)
	public int addNotice(HttpSession session,Notice n) {
		CqjUser u=(CqjUser)session.getAttribute("user");
		System.out.println("新增-添加通知"+u.getUserid());
		n.setSender(u.getUserid());
		return ns.insert(n);
	}
	@RequestMapping("/notice")
	public String toNotice() {
		System.out.println("跳转页面-通知列表");
		return "tzx/notice";
	}
	@ResponseBody
	@RequestMapping("/noticeList")
	public List<Notice> NoticeList(String time,String str) {
		System.out.println("查询-通知列表");
		return ns.query(time,str);
	}
	@RequestMapping("/noticeDetail")
	public String toNoticeDetail(HttpSession session,int nid) {
		System.out.println("跳转页面-通知详情");
		session.setAttribute("noticeid", nid);
		return "tzx/noticeDetail";
	}
	@ResponseBody
	@RequestMapping("/noticeInfo")
	public Notice noticeInfo(HttpSession session) {
		System.out.println("查询-通知详情");
		int nid=(int) session.getAttribute("noticeid");
		return ns.selectByPrimaryKey(nid);
	}
	/**
	 * 查询个人id、名字信息
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/querpersonerInfo" )
	public CqjUser uinfo(HttpSession session) {//名字存在standby1中
		CqjUser u=(CqjUser)session.getAttribute("user");
		CqjUser u1=ns.querpersonerInfo(u.getUserid());
		System.out.println("查询个人信息："+u.getUserid());
		return u1;
	}
	
	
    @RequestMapping(value = "config")
    @ResponseBody
    public JSONObject config(String action, @RequestParam(required = false) String callback, @RequestParam(required = false) String encode,
            HttpServletRequest request) throws Exception {
    	System.out.println("请求后台配置----------");
    	String url=request.getContextPath();
    	System.out.println(url);
        JSONObject jsonObject = new JSONObject();
        jsonObject = getConfig();
        // action参数为getConfig中的jsonObject.put("imageActionName", "uploadimage");
        if (action.equals("uploadimage")) {
            // 此处返回上传后的图片路径，json格式为{["url":"http://xinrui.com/image/1.png","state":"SUCCESS"]}
//            jsonObject = com.CloudSchool.service.imgcompressService.ueEditorUpload(request);
            String jsonObject1 ="\"url\":\"http://127.0.0.1:8080/static/image/1.png\",\"state\":\"SUCCESS\"；";
        }
        return jsonObject;
    }

    public JSONObject getConfig() {
    	System.out.println("请求后台配置1------图片上传");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("imageActionName", "uploadimage"); // 执行上传图片的action名称
        jsonObject.put("imageAllowFiles", new String[] { ".png", ".jpg", ".jpeg", ".gif", ".bmp" }); // 允许上传的图片类型
        jsonObject.put("imageFieldName", "upfile"); // 提交的图片表单名称
        jsonObject.put("imageMaxSize", "2048000"); // 上传大小限制，单位B
        jsonObject.put("imageCompressEnable", true); // 是否压缩图片,默认是true
        jsonObject.put("imageCompressBorder", 1600); // 图片压缩最长边限制
        jsonObject.put("imageInsertAlign", "none"); // 插入的图片浮动方式
        jsonObject.put("imageUrlPrefix", "http://127.0.0.1:8080/static/image/"); // 图片访问路径前缀
        jsonObject.put("imagePathFormat", "/{yyyy}{mm}{dd}/{time}{rand:6}"); // 上传保存路径,可以自定义保存路径和文件名格式
        return jsonObject;
    }
}
