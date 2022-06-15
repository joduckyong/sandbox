package kr.or.lx.sandbox.env.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.lx.common.ApiService;
import lombok.extern.slf4j.Slf4j;


@RequestMapping("sandbox/env/dockerImage")
@Slf4j
@Controller
public class DockerImageController {
	
	@Value("${sandbox.api.url}")
    private String sandboxApiUrl;	
    
	@Autowired
	private ApiService<?> apiService;
	
	/**
     * 분석 환경 관리 - 도커 이미지 관리
     * @return
     */	
	@GetMapping("/list")
	public String dockerImageList(ModelMap model) throws Exception{
		
		return "sandbox/env/dockerImage/list";
	}
	
	/**
     * 분석 환경 관리 - 도커 이미지 API
     * @return
     */		
	@ResponseBody
	@PostMapping("{apiId}")
	public Object dockerImageMng(@RequestBody Map<String, Object> param, ModelMap model) throws Exception{
		log.info("dockerImageMng");
		
		String url = sandboxApiUrl+param.get("url");
		
		ResponseEntity<?> responseEntity = apiService.post(url, param);
		Object object = responseEntity.getBody();
		
		return object;
	}
	
	
}
