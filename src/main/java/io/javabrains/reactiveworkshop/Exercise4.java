package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        ReactiveSources.intNumberMono().subscribe(number -> System.out.println(number));

        // Get the value from the Mono into an integer variable
        //1). With Optional
       /* Optional<Integer> number = ReactiveSources.intNumberMono().blockOptional();
       System.out.println("Block : " + number.get());*/
        
        Integer number = ReactiveSources.intNumberMono().block();
        System.out.println("Block : " + number);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
 