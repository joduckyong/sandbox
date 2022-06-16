package kr.or.lx.sandbox.result.controller;

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


@RequestMapping("sandbox/result/objectDetection")
@Slf4j
@Controller
public class ObjectDetectionController {
	
    @Value("${sandbox.api.url}")
    private String sandboxApiUrl;	
    
	@Autowired
	private ApiService<?> apiService;
	
	/**
     * 데이터 분석 결과 - 객체 감지 - 데이터 로딩
     * @return
     */
	@GetMapping("/step1")
	public String objectDetectionStep1(ModelMap model) throws Exception{
		
		return "sandbox/result/objectDetection/step1";
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
	
	/**
     * 데이터 분석 결과 - 객체 감지 - 데이터 전처리
     * @return
     */
	@GetMapping("/step2")
	public String objectDetectionStep2(ModelMap model) throws Exception{
		
		return "sandbox/result/objectDetection/step2";
	}
	
	/**
     * 데이터 분석 결과 - 객체 감지 - 결과 비교
     * @return
     */
	@GetMapping("/step3")
	public String objectDetectionStep3(ModelMap model) throws Exception{
		
		return "sandbox/result/objectDetection/step3";
	}
	
	/**
     * 데이터 분석 결과 - 객체 감지 - 데이터 재학습 결과
     * @return
     */
	@GetMapping("/step4")
	public String objectDetectionStep4(ModelMap model) throws Exception{
		
		return "sandbox/result/objectDetection/step4";
	}
	
	/**
	 * 데이터 분석 결과 - 객체 감지 - 데이터 분석 결과
	 * @return
	 */
	@GetMapping("/step5")
	public String objectDetectionStep5(ModelMap model) throws Exception{
		
		return "sandbox/result/objectDetection/step5";
	}
	
}
