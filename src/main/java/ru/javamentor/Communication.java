package ru.javamentor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.javamentor.rest.entity.User;

import java.util.List;

@Component
public class Communication {

//    @Autowired
//    private RestTemplate restTemplate;
//
//    private final String URL = "http://94.198.50.185:7081/api/users";
//    public String getAllUsers() {
//        ResponseEntity<String> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null,
//                String.class);
//
//        return responseEntity.getBody();
//    }
//
//    public User getUser(int id) {
//        return null;
//    }
//    public void saveUser(User user) {
//        Long id = user.getId();
//        if(id == 0) {
//            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, user, String.class);
//            System.out.println(responseEntity.getBody());
//        } else {
//            restTemplate.exchange(URL, HttpMethod.POST, null,User.class);
//            restTemplate.put(URL, user);
//            System.out.println();
//        }
//
//
//    }
//
//    public void deleteUser(int id) {
//        restTemplate.delete(URL + "/" + id);
//    }
}
