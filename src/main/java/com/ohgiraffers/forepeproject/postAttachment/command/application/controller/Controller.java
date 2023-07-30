package com.ohgiraffers.forepeproject.postAttachment.command.application.controller;


import com.ohgiraffers.forepeproject.post.command.application.dto.PostCreateDTO;
import com.ohgiraffers.forepeproject.postAttachment.command.application.dto.AttachmentDTO;
import com.ohgiraffers.forepeproject.postAttachment.command.application.service.AttachmentService;
import com.ohgiraffers.forepeproject.postAttachment.command.application.service.FileUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    private AttachmentService attachmentService;
    private FileUtils fileUtils;

    public Controller(AttachmentService attachmentService,FileUtils fileUtils){
        this.attachmentService = attachmentService;
        this.fileUtils= fileUtils;
    }



    @GetMapping("/attachment/save")
    public String saveFile(Model model, HttpSession session){
        Long postNum=1L;
        List<MultipartFile> multipartFileList = (List<MultipartFile>) session.getAttribute("fileInfoList");
        List<String> savePath = (List<String>) model.getAttribute("tempPath");

        List<AttachmentDTO> files= fileUtils.uploadFiles(multipartFileList,savePath);
        fileUtils.log("파일 사이즈"+files.size());
        attachmentService.addAttachment(postNum,files);

        return "redirect:/post/" +1;
    }



    @RequestMapping("/attachment/delete")
    public String readLocation(Model model){
        int postNum = (int) model.getAttribute("postNum");
        attachmentService.deleteAllByPostId(postNum);
        return "redirect:/post/vegan";
    }

    @RequestMapping("/attachment/modify")
    public String modifyLocation(Model model, HttpSession session){
        Long postNum=2L;
        List<MultipartFile> multipartFileList = (List<MultipartFile>) session.getAttribute("fileInfoList");
        List<String> savePath = (List<String>) model.getAttribute("tempPath");

        List<AttachmentDTO> files= fileUtils.uploadFiles(multipartFileList,savePath);
        attachmentService.modifyAllByPostId(postNum,files);

        return "redirect:/post/" +postNum;
    }
}
