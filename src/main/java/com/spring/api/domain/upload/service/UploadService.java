package com.spring.api.domain.upload.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.spring.api.domain.model.Post;
import com.spring.api.domain.upload.dto.AttachFileDTO;

public interface UploadService {

	public List<AttachFileDTO> createPdf(Post post, AttachFileDTO attachDTO);
	
	public String checkExtension(MultipartFile fd);
	
	public List<Post> bringPostList();
	
	public int searchFileNo(Post post);
	
	public String searchFilePath(int fileNo);
}
