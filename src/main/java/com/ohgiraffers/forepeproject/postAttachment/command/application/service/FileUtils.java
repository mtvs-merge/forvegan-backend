package com.ohgiraffers.forepeproject.postAttachment.command.application.service;

import com.ohgiraffers.forepeproject.postAttachment.command.application.dto.AttachmentDTO;
import com.ohgiraffers.forepeproject.postAttachment.command.domain.aggregate.entity.AttachmentMybatis;
import org.springframework.stereotype.Component;
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
    private final Path dir = Paths.get("");
    private String uploadPath = "/src/main/resources/static/uploadImg";


    public List<AttachmentDTO> uploadFiles(List<MultipartFile> multipartFileList){
        List<AttachmentDTO> files= new ArrayList<>();
        for(MultipartFile multipartFile : multipartFileList){
            if(multipartFile.isEmpty()){
                continue;
            }
            files.add(uploadFile(multipartFile));
        }
        return files;
    }

    private AttachmentDTO uploadFile(MultipartFile multipartFile) {
        if (multipartFile.isEmpty()){
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
