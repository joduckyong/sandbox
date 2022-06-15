package kr.or.lx.sandbox.common.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.lx.common.ApiService;
import lombok.extern.slf4j.Slf4j;


@RequestMapping("sandbox/common")
@Slf4j
@Controller
public class SandCommonController {
	
    @Value("${sandbox.api.url}")
    private String sandboxApiUrl;	

	@Autowired
	private ApiService<?> apiService;
	
	//공통코드
	@ResponseBody
	@PostMapping("{apiId}")
	public Object commonCode(@RequestBody Map<String, Object> param, ModelMap model) throws Exception{
		log.info("commonCode");
		
		String url = sandboxApiUrl+param.get("url");
		
		ResponseEntity<?> responseEntity = apiService.get(url);
		Object object = responseEntity.getBody();
		
		return object;
	}		
	
}
