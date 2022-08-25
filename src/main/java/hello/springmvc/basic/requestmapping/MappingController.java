package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/hello-basic")
    public String helloBasic(){
        log.info("helloBasic");
        return "ok";
    }

    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1(){
        log.info("mappingGetV1");
        return "ok";
    }

    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2(){
        log.info("mapping-get-v2");
        return "ok";
    }
    /**
     * PathVariable 사용
     * /mapping/userA
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data){
        log.info("mapping Path userId={}", data);
        return "ok";
    }

    @GetMapping("/mapping/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable String orderId){
        log.info("mapping Path userId={}, orderId={}", userId, orderId);
        return "ok";
    }

    /**
     *  특정 파라미터 조건 매핑
     *  (잘 사용 안함)
     */
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam(){
        log.info("mappingParam");
        return "ok";
    }

    /**
     *  특정 헤더 매핑
     */
    @GetMapping(value = "/mapping-header", params = "mode=debug")
    public String mappingHeader(){
        log.info("mappingHeader");
        return "ok";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     *
     */
    @PostMapping(value="/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsume(){
        log.info("mappingConsume");
        return "ok";
    }

    /**
     * Accept 헤더 기반 Media Type
     */
    @PostMapping(value="/mapping-produce", consumes = MediaType.TEXT_HTML_VALUE)
    public String mappingProduces(){
        log.info("mappingProduce");
        return "ok";
    }
}
