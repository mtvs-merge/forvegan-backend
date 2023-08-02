package com.ohgiraffers.forepeproject.post.command.application.controller;

import com.ohgiraffers.forepeproject.post.command.application.dto.PostCreateDTO;
import com.ohgiraffers.forepeproject.post.command.application.service.PostCreateService;

import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.PostEntity;
import com.ohgiraffers.forepeproject.postAttachment.command.application.service.FileUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
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
@SessionAttributes("fileInfoList")
@RequestMapping("/post")
public class PostCreateController {
    private final PostCreateService postCreateService;

    public PostCreateController(PostCreateService postCreateService) {
        this.postCreateService = postCreateService;
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute("createDTO") PostCreateDTO createDTO, @RequestParam("file")List<MultipartFile> files, RedirectAttributes redirectAttributes, HttpSession session,Model model) {

        PostEntity postEntity = new PostEntity();
        FileUtils fileUtils =new FileUtils();
//        int categoryNum = (int) model.getAttribute("categoryNum");
        int categoryNum = createDTO.getPostCategoryNum();
        fileUtils.log("카테고리 넘버"+categoryNum);
        createDTO.setPostCategoryNum(categoryNum);
        BeanUtils.copyProperties(createDTO, postEntity);

        postCreateService.createPost(postEntity);


        Path path = Paths.get("");
        String uploadPath = "/src/main/resources/static/loadImg";
        List<String> paths = new ArrayList<>();
        for (MultipartFile file: files){
            if(file.getContentType()=="null"){
                return "redirect:/post/" +1;
            }
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
                String saveName = UUID.randomUUID().toString().replaceAll("-","")+"."+StringUtils.getFilenameExtension(file.getOriginalFilename());
                String uploadTempPath = tempDir.getAbsolutePath() + File.separator + saveName;
                file.transferTo(new File(uploadTempPath));
                paths.add(uploadTempPath);
            } catch (IOException e) {
                throw new RuntimeException("파일 업로드 실패", e);
            }
        }
        redirectAttributes.addFlashAttribute("postNum", postEntity.getPostNum());
        session.setAttribute("fileInfoList", files);
        redirectAttributes.addFlashAttribute("tempPath",paths);

        return "redirect:/attachment/save";
    }

    @GetMapping("/write")
    public String write(Model model){
        PostCreateDTO createDTO = new PostCreateDTO();
//        model.addAttribute("categoryNum",num);
        model.addAttribute("createDTO",createDTO);
        return "/write";
    }



    public static class Post {
        public void setPostDetail(String postDetail) {
        }

        public void setPostName(String postName) {
        }

        public String getPostDetail() {
            return null;
        }

        public String getPostName() {
            return null;
        }
    }
}