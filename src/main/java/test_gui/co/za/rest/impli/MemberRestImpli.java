package test_gui.co.za.rest.impli;

import org.springframework.web.bind.annotation.DeleteMapping;
import test_gui.co.za.domain.members.Member;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import test_gui.co.za.rest.RestAPI;
import test_gui.co.za.util.AppUtil;

public class MemberRestImpli implements RestAPI<Member, Integer> {

    AppUtil util = new AppUtil();
    String BASE_URL = util.getUri() + "api/member";
    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Member get(Integer id) {
        final String url = BASE_URL + "/read/" + id;
        Member address = restTemplate.getForObject(url, Member.class,id.toString());
        return address;
    }

    @Override
    public Member post(Member entity) {
        String url = BASE_URL + "/create";
        HttpEntity<Member> httpEntity = new HttpEntity<Member>(entity,requestHeaders);
        Member address = restTemplate.postForObject(url, httpEntity,Member.class);
        return address;
    }

    @Override
    public Member put(Member entity) {
        String url = BASE_URL + "/update";
        HttpEntity<Member> requestEntity = new HttpEntity<Member>(entity,requestHeaders);
        ResponseEntity<Member> responseEntity = restTemplate.exchange(url,HttpMethod.PUT, requestEntity, Member.class);
        Member address = responseEntity.getBody();
        return address;
    }

    @Override
    @DeleteMapping
    public void delete(Integer id) {
        String url = BASE_URL + "/delete/" + id;
        restTemplate.delete(url);
    }

    @Override
    public List<Member> getAll() {
        String url = BASE_URL + "/read/all";
        List<Member> addresses = new ArrayList<>();
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Member[]> responseEntity = restTemplate.exchange(url,HttpMethod.GET, requestEntity, Member[].class);
        Member[] results = responseEntity.getBody();

        for (Member b : results) {
            addresses.add(b);
        }
        return addresses;
    }

}

