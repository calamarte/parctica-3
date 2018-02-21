package practica3.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@PropertySource("classpath:application.properties")
@RestController
public class MicroservicesController {

    @Value("${peer.port}")
    private String peerPort;
    @Value("${block.port}")
    private String blockPort;
    @Value("${peer.view.ip}")
    private String defaultIpForViewPeers;

    private RestTemplate restTemplate = new RestTemplate();


    @RequestMapping(value = "/peers", method = RequestMethod.POST)
    public String showPeers(){
        HttpEntity<String> requestEntity = new HttpEntity<String>("");

        ResponseEntity<String> responseEntity = restTemplate.exchange("http://"+defaultIpForViewPeers+":"+peerPort+"/peers",
                HttpMethod.POST, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @RequestMapping(value = "/blocks", method = RequestMethod.POST)
    public String showBlocksByPeer(@RequestBody String peerIp){

        try {
            System.out.println(peerIp);
            JSONObject dataJSON = new JSONObject(peerIp);

            HttpEntity<String> requestEntity = new HttpEntity<String>("");

            ResponseEntity<String> responseEntity = restTemplate.exchange("http://"+ dataJSON.get("peerIp") +":"+blockPort+"/blocks",
                    HttpMethod.POST, requestEntity, String.class);
            return responseEntity.getBody();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @RequestMapping(value = "/addBlock" , method = RequestMethod.POST)
    public String addBlock(@RequestBody String blockData){

        try {

            JSONObject dataJSON = new JSONObject(blockData);
            String peerIp = dataJSON.remove("peerIp").toString();

            HttpEntity<String> requestEntity = new HttpEntity<String>(dataJSON.toString());
            ResponseEntity<String> responseEntity = restTemplate.exchange(
                    "http://"+ peerIp +":"+blockPort,
                    HttpMethod.POST, requestEntity, String.class);

            return responseEntity.getBody();

        } catch (JSONException e) {
            return "error";
        }
    }


}
