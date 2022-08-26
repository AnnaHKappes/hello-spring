package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
@ResponseBody
//@RequestMapping("hello")
public class HelloController {

//    @GetMapping
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

//    @GetMapping("hello")
//    public String hello(){
//        return "Hello, Spring!";
//    }

    //Lives /hello/goodbye
//    @GetMapping("goodbye")
//    public String goodbye(){
//        return "Goodbye, Spring!";
//    }

    //Lives /hello/hello
    //Handles request of the form /hello?name=LaunchCode
    @GetMapping("hello")
    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value="hello")
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language){
        String properGreeting = HelloController.createMessage(name, language);
        return "<h3 style='color:blue'>" + properGreeting + "</h3>";
    }

    //Handles request of the form /hello/LaunchCode
//    @GetMapping("{name}")
//    public String helloWithPathParam(@PathVariable String name){
//        return "Hello, " + name + "!";
//    }

    @GetMapping("form")
    public String helloForm(){
        /*
        <select name="cars" id="cars">
             <option value="volvo">Volvo</option>
             <option value="saab">Saab</option>
             <option value="opel">Opel</option>
             <option value="audi">Audi</option>
        </select>
         */
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                "  <option value='English'>English</option>" +
                "  <option value='Spanish'>Spanish</option>" +
                "  <option value='French'>French</option>" +
                "  <option value='Italian'>Italian</option>" +
                "  <option value='German'>German</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    public static String createMessage(String n, String l) {
        switch (l){
            case "Spanish":
                return "Hola, " + n;
            case "French":
                return "Bonjour, " + n;
            case "Italian":
                return "Ciao, " + n;
            case "German":
                return "Hallo, " + n;
            case "English":
            default:
                return "Hello, " + n;
        }
    }
}