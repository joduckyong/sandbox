package kr.or.lx.sandbox.result.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.lx.common.ApiService;
import lombok.extern.slf4j.Slf4j;


@RequestMapping("sandbox/result/objectDetection")
@Slf4j
@Controller
public class ObjectDetectionController {
	
    @Value("${sandbox.api.url}")
    private String sandboxApiUrl;	
    
    @Value("${resource.path}")
    private String resourcePath;	
    
    @Value("${upload.path}")
    private String uploadPath;	
    
	@Autowired
	private ApiService<?> apiService;
	
	/**
     * 데이터 분석 결과 - 객체 감지 - 데이터 로딩
     * @return
     */
	@GetMapping("/{step}/{sandbox_id}/{result_id}")
	public String objectDetectionStep(@PathVariable String step, @PathVariable String sandbox_id, @PathVariable String result_id, ModelMap model) throws Exception{
		log.info("objectDetectionStep");
		
		model.put("resourcePath", resourcePath.replace("file:///", ""));		
		model.put("uploadPath", uploadPath.replace("**", ""));	
		model.put("sandbox_id", sandbox_id);	
		model.put("result_id", result_id);	
		return "sandbox/result/objectDetection/"+step;
	}
	
	/**
     * 데이터 분석 결과 API
     * @return
     */	
	@ResponseBody
	@PostMapping("{apiId}")
	public Object objectDetection(@RequestBody Map<String, Object> param, ModelMap model) throws Exception{
		log.info("objectDetection");
		
		String url = sandboxApiUrl+param.get("url");
		
		ResponseEntity<?> responseEntity = apiService.post(url, param);
		Object object = responseEntity.getBody();
		
		return object;
	}	
	
	
}
