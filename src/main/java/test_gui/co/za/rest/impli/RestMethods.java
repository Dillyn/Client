package test_gui.co.za.rest.impli;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import test_gui.co.za.util.BasicAuthInterceptor;

import java.util.ArrayList;
import java.util.List;

public class RestMethods {
    public static RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        final List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add( new BasicAuthInterceptor( "admin", "admin" ) );
        restTemplate.setInterceptors(interceptors);
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return restTemplate;
    }

    public static HttpHeaders getHeaders() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        return requestHeaders;
    }
}
