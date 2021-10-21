package com.ae.visuavid.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/manage/videos")
public class VideoController {

    @PostMapping(value = "/videoUpload", consumes = { "multipart/form-data" })
    public ResponseEntity<String> userFileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        try {
            //			              String senderEmailId=request.getParameter("senderEmailId");
            //			              String agentMail=request.getParameter("agentMail");
            //			              String sessionId=request.getParameter("sessionId");
            //			              String role=request.getParameter("role");
            //			              String orgUniqueNumber=request.getParameter("orgUniqueNumber");
            //			              String filename=file.getOriginalFilename();
            //
            //			      		  message.setFileName(filename);
            //			              message.setData(file.getBytes());
            //			              message.setFileName(filename);
            //			      		  message.setFileType(file.getContentType());
            //			              DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            //			  			  //LocalDateTime now = LocalDateTime.now();
            //			              Date date = new Date();
            //			  			  message.setMessagesentdate(date);
            //			  			  webChatService.saveMessage(message);
        } catch (Exception e) {
            System.out.println(e);
        }
        return ResponseEntity
            .ok()
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
            .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With")
            .body("We have sent the reset password link.Please check your email");
    }
}
