package kr.or.lx.sandbox.result.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;


@RequestMapping("sandbox/result/analysisResult")
@Slf4j
@Controller
public class AnalysisResultController {
	
	/**
     * 데이터 분석 결과 조회
     * @return
     */
	@GetMapping("/list/{sandbox_id}")
	public String analysisResult(@PathVariable String sandbox_id, ModelMap model) throws Exception{
		log.info("analysisResult");
		
		model.put("sandbox_id", sandbox_id);		
		return "sandbox/result/analysisResult/list";
	}
	
	
	
}
