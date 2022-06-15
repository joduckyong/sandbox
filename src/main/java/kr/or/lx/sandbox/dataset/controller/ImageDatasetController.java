package kr.or.lx.sandbox.dataset.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.or.lx.common.ApiService;
import lombok.extern.slf4j.Slf4j;


@RequestMapping("sandbox/dataset/imageDataset")
@Slf4j
@Controller
public class ImageDatasetController {

    @Value("${sandbox.api.url}")
    private String sandboxApiUrl;	
    
	@Autowired
	private ApiService<?> apiService;
	
	/**
     * 이미지 데이터셋 관리
     * @return
     */
	@GetMapping("/list")
	public String imageDataset(ModelMap model) throws Exception{
		log.info("imageDataset");
		
		return "sandbox/dataset/imageDataset/list";
	}
	
	/**
     * 이미지 데이터셋 API
     * @return
     */	
	@ResponseBody
	@PostMapping("{apiId}")
	public Object imagesDatasets(@RequestBody Map<String, Object> param, ModelMap model) throws Exception{
		log.info("imagesDatasets");
		
		String url = sandboxApiUrl+param.get("url");
		
		ResponseEntity<?> responseEntity = apiService.post(url, param);
		Object object = responseEntity.getBody();
		
		return object;
	}	
	
	/**
	 * 이미지 데이터셋 첨부 API
	 * @return
	 */	
	@ResponseBody
	@PostMapping("/file/{apiId}")
	public Object imagesDatasetsFileUpload(MultipartHttpServletRequest multipartRequest, ModelMap model) throws Exception{
		log.info("imagesDatasetsFileUpload");
		log.info("param : "+ObjectUtils.isEmpty(multipartRequest));
		
		String url = sandboxApiUrl+multipartRequest.getParameter("url");
		String creator_id = multipartRequest.getParameter("creator_id");
		String modifier_id = multipartRequest.getParameter("modifier_id");
		String user_id = multipartRequest.getParameter("user_id");
		String menu_id = multipartRequest.getParameter("menu_id");
		log.info("url : " + url);
		
		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("creator_id", creator_id);
		body.add("modifier_id", modifier_id);
		body.add("user_id", user_id);
		body.add("menu_id", menu_id);
		
		if (ObjectUtils.isEmpty(multipartRequest) == false) {
			Iterator<String> filenameIterator = multipartRequest.getFileNames();
			String name;
			while (filenameIterator.hasNext()) {
				name = filenameIterator.next();
				log.info("File name tag : " + name);
				List<MultipartFile> fileList = multipartRequest.getFiles(name);
				for (MultipartFile multipartFile : fileList) {
					body.add(name, multipartFile.getResource());
				}
			}
		}		
		
		ResponseEntity<?> responseEntity = apiService.post(url, body);
		Object object = responseEntity.getBody();
		
		return object;
	}	
	
	/**
	 * 이미지 데이터셋 등록
	 * @return
	 */
	@GetMapping("/add/{image_dataset_id}")
	public String imageDatasetAdd(@PathVariable String image_dataset_id, ModelMap model) throws Exception{
		log.info("imageDatasetAdd");
		
		model.put("image_dataset_id", image_dataset_id);
		return "sandbox/dataset/imageDataset/add";
	}
	
	
}
