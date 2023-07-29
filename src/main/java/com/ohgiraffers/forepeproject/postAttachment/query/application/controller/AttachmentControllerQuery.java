package com.ohgiraffers.forepeproject.postAttachment.query.application.controller;



import com.ohgiraffers.forepeproject.postAttachment.query.application.service.AttachmentServiceQuery;
import com.ohgiraffers.forepeproject.postAttachment.query.application.service.FileUtilsQuery;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@org.springframework.stereotype.Controller
public class AttachmentControllerQuery {
    private AttachmentServiceQuery attachmentService;
    private FileUtilsQuery fileUtils;

    public AttachmentControllerQuery(AttachmentServiceQuery attachmentService, FileUtilsQuery fileUtils){
        this.attachmentService = attachmentService;
        this.fileUtils= fileUtils;
    }

    @GetMapping("/test/1")
    public String testPostNum(Model model,@RequestParam("postNum") Long postNum){
        model.addAttribute("files",attachmentService.findAllFileByPostId(postNum));
        return "/test/view";
    }

    @RequestMapping("/test/view")
    public String readLocation(Model model){
        model.addAttribute("files",attachmentService.findAllFileByPostId(2));
        model.addAttribute("path",fileUtils.getPath());
        return "viewTest";
    }

}
