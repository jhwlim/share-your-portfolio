package com.spring.api.domain.upload.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.j256.simplemagic.ContentInfo;
import com.j256.simplemagic.ContentInfoUtil;
import com.spring.api.domain.model.Post;
import com.spring.api.domain.upload.dto.AttachFileDTO;
import com.spring.api.domain.upload.mapper.ManagePostMapper;
import com.spring.api.domain.upload.service.UploadService;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class UploadServiceImpl implements UploadService{
	
	@Autowired
	ManagePostMapper mapper;
	
	@Value("${image.path.root}")
	private String root;
	
	@Override
	public List<AttachFileDTO> createPdf(Post post, AttachFileDTO attachDTO) {
		MultipartFile file = post.getFile();
		
		List<AttachFileDTO> dto = new ArrayList<>();
		
		UUID fileUuid = UUID.randomUUID();
		
		attachDTO.setUuid(fileUuid.toString());
		
		String gf = getFolder(post, attachDTO, fileUuid);
		
		String uploadFolderPath = root + File.separator + gf;
						
		try {
			PDDocument pdfDoc = PDDocument.load(file.getInputStream());
			PDFRenderer pdfRenderer = new PDFRenderer(pdfDoc);
			
			String testCategory = post.getCategory();
			
			attachDTO.setFileCategory(testCategory);
			
			attachDTO.setUploaderId(post.getWriterId());
			
			attachDTO.setOriginalFileName(file.getOriginalFilename());
			
			attachDTO.setSavedFileName(fileUuid.toString() + file.getOriginalFilename());
			
			attachDTO.setUploadPath(gf);

			attachDTO.setFileSize(file.getSize());
						
			Files.createDirectories(Paths.get(uploadFolderPath));
			
			int numOfPage = pdfDoc.getNumberOfPages();
					
			post.setNumOfPage(numOfPage);
			
			for(int i=0; i < pdfDoc.getPages().getCount(); i++) {
															
				String imgFileName = uploadFolderPath + File.separator + i + ".png";
				
				BufferedImage bim = pdfRenderer.renderImageWithDPI(i, 300, ImageType.RGB);
				
				ImageIOUtil.writeImage(bim, imgFileName, 300);
				
				dto.add(attachDTO);
									
			}
			
			pdfDoc.close();
			
		} catch (InvalidPasswordException e) {

			e.printStackTrace();
			
		} catch (IOException e) {

			e.printStackTrace();
		}
			
		mapper.uploadFiles(attachDTO);
		
		int fileNo = attachDTO.getFileNo();
		
		post.setFileNo(fileNo);
		
		mapper.savePosts(post);
		
		return dto;
	}

	public String getFolder(Post post, AttachFileDTO attachDTO, UUID fileUuid) {
		
		int uploader = post.getWriterId();
		
		MultipartFile file = post.getFile();
		
		String testCategory = post.getCategory();
		
		UUID uuid = fileUuid;
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		Date today = new Date();
				
		String fileName = uuid + "-" + FilenameUtils.getBaseName(file.getOriginalFilename());
		
		String str = sdf.format(today) + "/" + testCategory + "/" + uploader + "/" + fileName;
				
		return str.replace("/", File.separator);
	}

	@Override
	public String checkExtension(MultipartFile fd) {
		
		ContentInfoUtil util = new ContentInfoUtil();
		
		String fileType = fd.getOriginalFilename();
		
		String result = null;
		
		try {
			
			ContentInfo info;
			
			info = util.findMatch(fileType);
			
			if(info == null) {
				log.info(fileType + " Unknown content-type");
			}
			
			log.info(fileType + " ContentType : " + info.getName());
			log.info(fileType + " MimeType : " + info.getMimeType());
			
			String[] extensions = info.getFileExtensions();
			if (extensions != null && extensions.length > 0) {
				for(int j = 0; j < extensions.length; j++) {
					log.info(fileType + " File Extension " + j + " : "
							+ extensions[j]);
				}
			}
			
			result = info.getName();
					
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<Post> bringPostList() {
		
		return mapper.bringPostList();
	}

	@Override
	public int searchFileNo(Post post) {
		
		return mapper.searchFileNo(post);
	}

	@Override
	public String searchFilePath(int fileNo) {
		
		return mapper.searchFilePath(fileNo);
	}

}
