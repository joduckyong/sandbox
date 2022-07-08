package kr.or.lx;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class SandboxApplicationTests {

	@Test
	void contextLoads() {
	}

//	@Autowired
//    private static RestTemplateBuilder restTemplate;
//	 
//    public static void main(String[] args) {
//        // 원격 파일 다운로드 URL
//        String fileUrl = "/services/sandbox/sandboxes/42/analysis-files/download";
//        URI    url     = URI.create(fileUrl);
//
//        // 원격 파일 다운로드
//        RestTemplate           rt     = new RestTemplate();
//        ResponseEntity<byte[]> res    = rt.getForEntity(url, byte[].class);
//        byte[]                 buffer = res.getBody();
//
//        // 로컬 서버에 저장
//        String fileName = UUID.randomUUID().toString();                    // 파일명 (랜덤생성)
//        String ext      = "." + StringUtils.getFilenameExtension(fileUrl); // 확장자 추출
//        Path   target   = Paths.get("C:\\lx", fileName + ext);    // 파일 저장 경로
//
//        try {
//            FileCopyUtils.copy(buffer, target.toFile());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        
////        try {
////            HttpHeaders headers = new HttpHeaders();
////            headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
////            HttpEntity<String> entity = new HttpEntity<>(headers);
////            ResponseEntity<byte[]> response = restTemplate.build().exchange("/services/sandbox/sandboxes/42/analysis-files/download", HttpMethod.GET, entity, byte[].class);
////            Files.write(Paths.get("C:\\lx\\demo1.zip"), response.getBody());
////        }catch (Exception e){
////            e.printStackTrace();
////        }        
//    }
}
