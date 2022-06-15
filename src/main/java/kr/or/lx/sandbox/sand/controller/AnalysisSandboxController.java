package kr.or.lx.sandbox.sand.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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


@RequestMapping("sandbox/sand/analysisSandbox")
@Slf4j
@Controller
public class AnalysisSandboxController {
	
    @Value("${sandbox.api.url}")
    private String sandboxApiUrl;	
    
	@Autowired
	private ApiService<?> apiService;
	
	/**
     * 분석 샌드박스 관리
     * @return
     */
	@GetMapping("/list")
	public String analysisSandbox(ModelMap model) throws Exception{
		log.info("analysisSandbox");
		
		return "sandbox/sand/analysisSandbox/list";
	}
	
	/**
     * 분석 샌드박스 API
     * @return
     */	
	@ResponseBody
	@PostMapping("{apiId}")
	public Object analysisSandboxs(@RequestBody Map<String, Object> param, ModelMap model) throws Exception{
		log.info("analysisSandboxs");
		
		String url = sandboxApiUrl+param.get("url");
		
		ResponseEntity<?> responseEntity = apiService.post(url, param);
		Object object = responseEntity.getBody();
		
		return object;
	}	
	
	/**
	 * 샌드박스 설정
	 * @return
	 */
	@GetMapping("/step1")
	public String analysisSandboxStep1(ModelMap model) throws Exception{
		log.info("analysisSandboxStep1");
		
		return "sandbox/sand/analysisSandbox/step1";
	}
	
	/**
	 * 시나리오 선택
	 * @return
	 */
	@GetMapping("/step2/{sandbox_id}/{anals_use_prpos_cd}/{anals_use_prpos_cd_nm}")
	public String analysisSandboxStepSet(@PathVariable String sandbox_id, @PathVariable String anals_use_prpos_cd, @PathVariable String anals_use_prpos_cd_nm, ModelMap model) throws Exception{
		log.info("analysisSandboxStep2");
		
		model.put("sandbox_id", sandbox_id);		
		model.put("anals_use_prpos_cd", anals_use_prpos_cd);		
		model.put("anals_use_prpos_cd_nm", anals_use_prpos_cd_nm);		
		return "sandbox/sand/analysisSandbox/step2";
	}
	
	/**
	 * 분석 방식 선택
	 * @return
	 */
	@GetMapping("/step3/{sandbox_id}/{anals_use_prpos_cd}/{cd}")
	public String analysisSandboxStep3(@PathVariable String sandbox_id, @PathVariable String anals_use_prpos_cd, @PathVariable String cd, ModelMap model) throws Exception{
		log.info("analysisSandboxStep3");
		
		model.put("sandbox_id", sandbox_id);		
		model.put("anals_use_prpos_cd", anals_use_prpos_cd);		
		model.put("cd", cd);			
		
		return "sandbox/sand/analysisSandbox/step3";
	}
	
	
}
