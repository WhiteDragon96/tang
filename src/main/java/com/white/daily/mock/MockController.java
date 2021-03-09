package com.white.daily.mock;

import com.white.daily.mock.service.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author tcs
 * @date Created in 2021-03-04
 */
@RestController
@RequestMapping("/mock")
public class MockController {

    @Autowired
    private MockService mockService;

    @RequestMapping("/file")
    public String uploadFile(@RequestPart("file")MultipartFile file, Model model) throws IOException {

        String filename = file.getOriginalFilename();//文件名
        String substring = filename.substring(filename.lastIndexOf("."));//后缀名
        String filePath = "E:\\图片\\upload";
        File desk = new File(filePath + filename);
        if (!desk.getParentFile().exists()){
            desk.getParentFile().mkdirs();
        }
        file.transferTo(desk);
        String fileName = "/图片/upload" + filename;
        model.addAttribute("fileName",fileName);
        return filename;
    }

    @RequestMapping("send")
    public String sendEmail(){
        mockService.sendEmail();
        return null;
    }
}
