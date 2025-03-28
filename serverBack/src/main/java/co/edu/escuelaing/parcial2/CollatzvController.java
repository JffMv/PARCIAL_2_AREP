package co.edu.escuelaing.parcial2;


import java.util.concurrent.atomic.AtomicLong;

import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollatzvController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/collatzsequence")
    public String collatz(@RequestParam(value = "value", defaultValue = "13") Integer value) {
        return GreetingController.Collatz(value);
    }

    private static String Collatz (Integer value){
        String output = value.toString() ;
        Integer aux = value;
        while (aux != 1){
            if (aux%2 ==0){
                aux = aux/2;
            }else {
                aux = (3* aux)+1;
            }
            output += "->" + aux.toString();
        }
        String answer = "{"
                + "\"operation\": \"collatzsequence\",\n"
                + "\"input\": "+ "\""+value.toString()+"\","+"\n"
                + "\"output\": "+"\""+ output+"\""+"\n"+
                "}";

        return answer;
    }
}