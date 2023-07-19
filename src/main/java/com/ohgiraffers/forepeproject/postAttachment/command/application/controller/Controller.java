package com.ohgiraffers.forepeproject.postAttachment.command.application.controller;


import com.ohgiraffers.forepeproject.postAttachment.command.application.dto.AttachmentDTO;
import com.ohgiraffers.forepeproject.postAttachment.command.application.service.AttachmentService;
import com.ohgiraffers.forepeproject.postAttachment.command.application.service.FileUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    private AttachmentService attachmentService;
    private FileUtils fileUtils;

    public Controller(AttachmentService attachmentService,FileUtils fileUtils){
        this.attachmentService = attachmentService;
        this.fileUtils= fileUtils;
    }

    @RequestMapping("/test/attachment")
    public String saveFile(Model model, @RequestParam("files") List<MultipartFile> multipartFileList){
        Long postNum=2L;
        List<AttachmentDTO> files= fileUtils.uploadFiles(multipartFileList);
        attachmentService.addAttachment(postNum,files);
        return "/test/1";
    }
    @GetMapping("/test/1")
    public String testPostNum(Model model,@RequestParam("postNum") Long postNum){
        model.addAttribute("files",attachmentService.findAllFileByPostId(postNum));
        return "/test/view";
    }

    @RequestMapping("/test/write")
    public String defaultLocation(){
        return "testAttachment";
    }

    @RequestMapping("/test/view")
    public String readLocation(Model model){
        model.addAttribute("files",attachmentService.findAllFileByPostId(2));
//        model.addAttribute("path",fileUtils.getPath());
        return "viewTest";
    }

    @RequestMapping("/test/delete")
    public String readLocation(){
        System.out.println("result 값"+attachmentService.deleteAllByPostId(1));
        return "/test/1";
    }

    @RequestMapping("/test/modify")
    public String modifyLocation(@RequestParam("files") List<MultipartFile> multipartFileList){
        Long postNum = 2L;
        List<AttachmentDTO> delFiles = attachmentService.findAllFileByPostId(2); //게시글 정보 조회
        for(AttachmentDTO file : delFiles){
            fileUtils.deleteFile(file.getAttachRename(),file.getFileType()); //게시글 첨부파일 삭제
        }
        System.out.println("result 값"+attachmentService.deleteAllByPostId(postNum)); //데이터베이스 삭제

        List<AttachmentDTO> files= fileUtils.uploadFiles(multipartFileList); // 파일 업로드
        attachmentService.addAttachment(postNum,files);
        return "/test/1";
    }
}
