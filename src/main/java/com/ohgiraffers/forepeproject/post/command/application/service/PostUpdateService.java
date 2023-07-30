package com.ohgiraffers.forepeproject.post.command.application.service;

import com.ohgiraffers.forepeproject.post.command.application.dto.PostDeleteDTO;
import com.ohgiraffers.forepeproject.post.command.application.dto.PostUpdateDTO;
import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.PostEntity;
import com.ohgiraffers.forepeproject.post.command.domain.repository.PostRepository;
import com.ohgiraffers.forepeproject.report.command.application.dto.ReportDTO;
import com.ohgiraffers.forepeproject.report.command.domain.aggregate.entity.ReportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostUpdateService {

    private final PostRepository postRepository;

    @Autowired
    public PostUpdateService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public void UpdatePost(PostUpdateDTO postUpdateDTO) {

        PostEntity pe = postRepository.findByPostString(postUpdateDTO.getPostName());

        pe.setPostState("N");

    }
    @Transactional
    public List<ReportDTO> viewPost() {

        List<ReportEntity> reportlist = postRepository.findAll();

        return reportlist.stream().map(reportNum -> modelMapper.map(reportNum, ReportDTO.class)).collect(Collectors.toList());
    }

    public boolean isOwner(PostUpdateDTO postUpdateDTO) {
        PostEntity pe = postRepository.findByPostString(postUpdateDTO.getPostName());
        if(pe.getPostMemberNum() == PostUpdateDTO.getPost()) {
            return true;
        } else {
            return false;
        }

    }
}