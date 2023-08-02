package com.ohgiraffers.forepeproject.postAttachment.command.application.service;

import com.ohgiraffers.forepeproject.postAttachment.command.application.dto.AttachmentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
    private String uploadPath = "/src/main/resources/static/loadImg";

    public void log(String name){
        logger.trace("trace log={}",name);
        logger.debug("debug log={}",name);
        logger.info("info log={}",name);
        logger.warn("warn log={}",name);
        logger.error("error log={}",name);
    }
    public List<AttachmentDTO> uploadFiles(List<MultipartFile> multipartFileList, List<String> savePath){
        List<AttachmentDTO> files= new ArrayList<>();
//        for(MultipartFile multipartFile: multipartFileList){
//            log("testtest1");
//            if(multipartFile.getOriginalFilename() ==null){
//                log("testtest2");
//                continue;
//            }
//            for ()
//            files.add(uploadFile(multipartFile));
//        }
        for(int i=0; i<multipartFileList.size();i++){
            if(multipartFileList.get(i).getOriginalFilename() ==null){
                continue;
            }
            files.add(uploadFile(multipartFileList.get(i),savePath.get(i)));
        }
        log("테스트3");
        return files;
    }

    private AttachmentDTO uploadFile(MultipartFile multipartFile, String savepath) {
        if(multipartFile.getOriginalFilename() ==null){
            log("testtestnull");
            return null;
        }
        if(dir.isAbsolute()){
            log("테스트4");
            uploadPath = dir.toString() + uploadPath;
        }else {
            log("테스트5");
            uploadPath = dir.toAbsolutePath().toString()+uploadPath;
        }
        log("테스트5");
//        String saveName = saveFileName(multipartFile.getOriginalFilename());
//        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")).toString();

        /*System.out.println(getUploadPath() + " path1,upload1" + uploadPath);
        String uploadPath = getUploadPath() + File.separator + saveName;
        System.out.println(getUploadPath() + " path2,upload2 =" + uploadPath);
//        File uploadFile = new File(uploadPath);
        Path path = Paths.get(uploadPath).toAbsolutePath();
        log(path.toAbsolutePath().toString());
        log(path.toFile().getPath().toString());
        log("테스트6");
        try {
//            multipartFile.transferTo(uploadFile);
            multipartFile.transferTo(path.toFile());
//            multipartFile.transferTo(Path.of(multipartFile.getOriginalFilename()));
            log("테스트7");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log("로그 확인 오리지널 네임"+multipartFile.getOriginalFilename());

         */
        String saveName = saveFileName(multipartFile.getOriginalFilename());
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")).toString();


        // 저장된 파일을 옮길 경로 생성
        try {
            File finalDir = new File(uploadPath + File.separator + today); // 옮길 디렉토리 생성
            if (!finalDir.exists()) {
                finalDir.mkdir();
            }
            log("path 찍어보기 : "+savepath);
            String uploadFinalPath = finalDir.getAbsolutePath() + File.separator + saveName;

            File tempFile = new File(savepath);
            if (tempFile.exists()) {
                tempFile.renameTo(new File(uploadFinalPath)); // 파일 이동
            } else {
                throw new RuntimeException("임시 디렉토리에 파일이 존재하지 않습니다.");
            }
        } catch (Exception e) {
            throw new RuntimeException("파일 이동 실패", e);
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
