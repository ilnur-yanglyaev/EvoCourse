package com.example.task.service;

import com.example.task.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService{
    @Autowired
    private RestTemplate restTemplate;

    public User getUserData(String username, String token){
        String url = "http://user-service/user/" + username;
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<User> response = restTemplate.exchange(url, HttpMethod.GET, entity, User.class);

        return response.getBody();
    }


}