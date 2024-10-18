/*
package com.white.daily.mock;

import com.wf.captcha.SpecCaptcha;
import com.white.daily.annotation.ApiLog;
import com.white.daily.mock.service.MockService;
import com.white.daily.mock.service.UserService;
import com.white.daily.pojo.QueryRefundResultRequest;
import com.white.daily.mock.entity.User;
import com.white.daily.pojo.excel.StudentExcel;
import com.white.daily.util.ExcelUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.xmlbeans.impl.validator.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

*/
/**
 * @author tcs
 * @date Created in 2021-03-04
 *//*

@RestController
@RequestMapping("/mock")
@Slf4j
@AllArgsConstructor
public class MockController {

    @Autowired
    private MockService mockService;
    @Autowired
    private UserService userService;

    @ApiLog("test")
    @RequestMapping("/test")
    public String test(HttpServletRequest request) {
        String clientIp = request.getHeader("x-forwarded-for");
        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("Proxy-Client-IP");
        }
        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("WL-Proxy-Client-IP");
        }
        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getRemoteAddr();
        }
        System.out.println(LocalDateTime.now().toString() + ": " + clientIp);

        return "FUCK!";
    }

    @RequestMapping("/file")
    public String uploadFile(@RequestPart("file") MultipartFile file, Model model) throws IOException {

        String filename = file.getOriginalFilename();//文件名
        String substring = filename.substring(filename.lastIndexOf("."));//后缀名
        String filePath = "E:\\图片\\upload";
        File desk = new File(filePath + filename);
        if (!desk.getParentFile().exists()) {
            desk.getParentFile().mkdirs();
        }
        file.transferTo(desk);
        String fileName = "/图片/upload" + filename;
        model.addAttribute("fileName", fileName);
        return filename;
    }

    @RequestMapping("send")
    public String sendEmail() {
        mockService.sendEmail();
        return null;
    }

    */
/**
     * 文件下载（失败了会返回一个有部分数据的Excel）
     * <p>
     * 1. 创建excel对应的实体对象
     * <p>
     * 2. 设置返回的 参数
     * <p>
     * 3. 直接写，这里注意，finish的时候会自动关闭OutputStream,当然你外面再关闭流问题不大
     *//*

    @GetMapping("/download")
    public void download(HttpServletResponse response) throws IOException {
        List<StudentExcel> excelList = new ArrayList<>();
        StudentExcel studentExcel = new StudentExcel("迪丽热巴", "female", 19);
        StudentExcel studentExcel2 = new StudentExcel("古力娜扎", "female", 22);
        StudentExcel studentExcel3 = new StudentExcel("德玛西亚", "male", 25);
        excelList.add(studentExcel);
        excelList.add(studentExcel2);
        excelList.add(studentExcel3);
        ExcelUtils.export(response, "testFileName", "sheetName", excelList, StudentExcel.class);
    }

    @PostMapping("/submit")
    public String submit(@RequestBody @Valid QueryRefundResultRequest beanValidationVO) {
        try {
            ValidatorUtil.validateWithBizError(beanValidationVO);
        } catch (Exception e) {
            log.info(e.toString());
        }
        return beanValidationVO.toString();
    }

    @GetMapping("/user")
    public List<User> getUser() {
        return userService.getUserList();
    }


    */
/**
     * 获取验证码
     *
     * @return
     *//*

    @GetMapping("/captcha")
    public String getCaptcha() {
        */
/*SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        String verCode = specCaptcha.text().toLowerCase();
        String key = StringUtil.randomUUID();
        // 存入redis并设置过期时间为30分钟
        bladeRedis.setEx(CacheNames.CAPTCHA_KEY + key, verCode, Duration.ofMinutes(30));
        // 将key和base64返回给前端
        return Kv.create().set("key", key).set("image", specCaptcha.toBase64());*//*

        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        return specCaptcha.toBase64();
    }
}
*/
