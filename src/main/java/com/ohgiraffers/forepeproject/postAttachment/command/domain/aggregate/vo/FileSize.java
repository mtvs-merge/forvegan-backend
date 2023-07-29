package com.ohgiraffers.forepeproject.postAttachment.command.domain.aggregate.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class FileSize {
    @Column(name = "FILESIZE",nullable = false,length = 40)
    private long size;

    public FileSize(long size) {
        this.size = size;
    }

    public FileSize() {
    }

    public long getSize() {
        return size;
    }
}
