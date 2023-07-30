package com.ohgiraffers.forepeproject.postAttachment.command.application.service;

import com.ohgiraffers.forepeproject.postAttachment.command.application.dto.AttachmentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FileUtils {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Path dir = Paths.get("");
    private String uploadPath = "/src/main/resources/static/uploadImg";

    private void log(String name){
        logger.trace("trace log={}",name);
        logger.debug("debug log={}",name);
        logger.info("info log={}",name);
        logger.warn("warn log={}",name);
        logger.error("error log={}",name);
    }
    public List<AttachmentDTO> uploadFiles(List<MultipartFile> multipartFileList){
        List<AttachmentDTO> files= new ArrayList<>();
        log("테스트1");
        for(MultipartFile multipartFile : multipartFileList){
            if(multipartFile.isEmpty()){
                continue;
            }
            files.add(uploadFile(multipartFile));
        }
        log("테스트3");
        return files;
    }

    private AttachmentDTO uploadFile(MultipartFile multipartFile) {
        if (multipartFile.isEmpty()){
            log("테스트2");
            return null;
        }
        if(dir.isAbsolute()){
            uploadPath = dir.toString() + uploadPath;
        }else {
            uploadPath = dir.toAbsolutePath().toString()+uploadPath;
        }
        String saveName = saveFileName(multipartFile.getOriginalFilename());
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")).toString();
        System.out.println(getUploadPath() + " path1,upload1" + uploadPath);
        String uploadPath = getUploadPath() + File.separator + saveName;
        System.out.println(getUploadPath() + " path2,upload2 =" + uploadPath);
        File uploadFile = new File(uploadPath);

        try {
            multipartFile.transferTo(uploadFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return AttachmentDTO.builder()
                .attachName(multipartFile.getOriginalFilename())
                .attachRename(saveName)
                .fileType(StringUtils.getFilenameExtension(multipartFile.getOriginalFilename()))
                .size(multipartFile.getSize())
                .build();
    }
    public boolean deleteFile(String fileName,String fileType){
        File file =new File(getPath()+ File.separator+fileName+fileType);
        if(file.exists()){
            return file.delete();
        }

        return false;
    }

    private String saveFileName(String originalFilename) {
        log("테스트4");
        String uuid= UUID.randomUUID().toString().replaceAll("-","");
        String extension = StringUtils.getFilenameExtension(originalFilename);
        return uuid+"."+extension;
    }

    private String getUploadPath(String today) {
        return maeDirectories(uploadPath+File.separator+today);
    }

    public String getUploadPath() {
        return maeDirectories(uploadPath);
    }

    private String maeDirectories(String path) {
        File dir=new File(path);
        if(dir.exists() == false){
            dir.mkdir();
        }
        return dir.getPath();
    }

    public String getPath(){
        if(dir.isAbsolute()){
            uploadPath = dir.toString() + uploadPath;
        }else {
            uploadPath = dir.toAbsolutePath().toString()+uploadPath;
        }

        String path = getUploadPath();

        return path;
    }

}
