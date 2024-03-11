package ru.javamentor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.*;

import org.springframework.web.client.RestTemplate;

import ru.javamentor.rest.configuration.MyConfig;
import ru.javamentor.rest.entity.User;





public class App 
{
    static RestTemplate restTemplate = new RestTemplate();
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://94.198.50.185:7081/api/users", String.class);
//        forEntity.getHeaders().get("Set-Cookie").stream().forEach(System.out::println);
//        String cookie = forEntity.getHeaders().getFirst("Set-Cookie").split(";")[0];
        String cookie = forEntity.getHeaders().getFirst("Set-Cookie");
        System.out.println(cookie);
//
//
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Cookie", cookie);
        User user = new User();
        user.setId(3L);
        user.setName("James");
        user.setLastName("Brown");
        user.setAge((byte) 25);
        HttpEntity <User> requestEntity = new HttpEntity<>(user,headers);

//        requestEntity = new HttpEntity<>(user, headers);

//        System.out.println(restTemplate.exchange("http://94.198.50.185:7081/api/users", HttpMethod.GET, requestEntity, String.class).getBody());
//        System.out.println(getUsers(requestEntity));
        System.out.println(saveUser(requestEntity));
        System.out.println(updateUser(user, requestEntity));
        System.out.println(deleteUser(3L, requestEntity));


    }
    public static String getUsers(HttpEntity <User> requestEntity) {
        return restTemplate.exchange("http://94.198.50.185:7081/api/users", HttpMethod.GET, requestEntity, String.class).getBody();
    }


    public static String saveUser(HttpEntity <User> requestEntity) {

        return restTemplate.exchange("http://94.198.50.185:7081/api/users", HttpMethod.POST, requestEntity, String.class).getBody();
    }

    public static String updateUser(User user, HttpEntity <User> requestEntity) {
        user.setName("Thomas");
        user.setLastName("Shelby");

        return restTemplate.exchange("http://94.198.50.185:7081/api/users", HttpMethod.PUT, requestEntity, String.class).getBody();
    }
    public static String deleteUser(Long id, HttpEntity <User> requestEntity) {


        return restTemplate.exchange("http://94.198.50.185:7081/api/users"+ "/" + id, HttpMethod.DELETE, requestEntity, String.class).getBody();
    }


}
