package com.ssm.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description 上传文件
 * @author 欧阳
 * @since 2018年12月15日 下午10:51:26
 * @version V1.0
 */

@Controller
@RequestMapping("/upload")
public class UploadFileController {

	private final static String SUCCESS = "success"; // 返回结果
	
	
	//进入上传文件页面
	@RequestMapping("/upload")
	public String upload() throws Exception {

		return "uploadFile";
	}
	
	//上传文件
	@RequestMapping("/uploadFile")
	public String uploadFile(@RequestParam(value = "uploadFile", required = true) MultipartFile[] files) throws Exception {

		for(MultipartFile file : files) {
			// 原始文件名称
			String fileName = file.getOriginalFilename();
			System.out.println("原文件名： " + fileName);

			// 上传图片
			File uploadPath = new File("G:/upload/" + fileName);

			if (!uploadPath.exists()) {
				uploadPath.mkdirs();
			}
			// 向磁盘写文件
			file.transferTo(uploadPath);
		}

		return SUCCESS;
	}
}
