package com.ohgiraffers.forepeproject.post.command.application.controller;

import com.ohgiraffers.forepeproject.post.command.application.dto.PostDTO;
import com.ohgiraffers.forepeproject.post.command.application.service.PostModifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/update")
public class PostModifyController {

    private final PostModifyService postModifyService;

    @Autowired
    PostModifyController(PostModifyService postModifyService) {
        this.postModifyService = postModifyService;
    }

    @PostMapping("/all")
    public String updatePost(@ModelAttribute PostDTO postDTO, @RequestParam("file")List<MultipartFile> files, RedirectAttributes redirectAttributes, HttpSession session) {
        Long postNum=2L;

        Path path = Paths.get("");
        String uploadPath = "/src/main/resources/static/loadImg";
        List<String> paths = new ArrayList<>();
        for (MultipartFile file: files){
            if(path.isAbsolute()){
                uploadPath = path.toString() + uploadPath;
            }else {
                uploadPath = path.toAbsolutePath().toString()+uploadPath;
            }
            try {
                File tempDir = new File(uploadPath + File.separator + "temp"); // 임시 디렉토리 생성
                if (!tempDir.exists()) {
                    tempDir.mkdir();
                }
                String saveName = UUID.randomUUID().toString().replaceAll("-","")+"."+ StringUtils.getFilenameExtension(file.getOriginalFilename());
                String uploadTempPath = tempDir.getAbsolutePath() + File.separator + saveName;
                file.transferTo(new File(uploadTempPath));
                paths.add(uploadTempPath);
            } catch (IOException e) {
                throw new RuntimeException("파일 업로드 실패", e);
            }
        }
        redirectAttributes.addAttribute("postNum", postNum);
        session.setAttribute("fileInfoList", files);
        redirectAttributes.addFlashAttribute("tempPath",paths);

        if(postModifyService.verifyOwner(postDTO)) {
            postModifyService.updatePost(postDTO);
        } else {
            redirectAttributes.addFlashAttribute("message", "게시판 작성자가 아닙니다");
        }

        return "redirect:/attachment/modify";

    }
}