package co.edu.escuelaing.parcial2;


import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollatzvController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private boolean flag = true;

    @GetMapping("/collatz")
    public String collatz(@RequestParam(value = "value", defaultValue = "13") Integer value) throws IOException {
        Integer [] array = {value};
        flag = !flag;
        return HttpConnection.conection(array,flag);
    }
}