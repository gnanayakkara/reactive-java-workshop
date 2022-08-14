package io.javabrains.reactiveworkshop;

import java.io.IOException;

import org.reactivestreams.Subscription;

import reactor.core.Disposable;
import reactor.core.publisher.BaseSubscriber;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberFlux() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        Disposable subscribe = ReactiveSources.intNumbersFlux().subscribe(number -> System.out.println(number),
        										   err -> System.out.println(err.getMessage()),
        										   () -> System.out.println("Completed"));

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux().subscribe(new MyScubscriber());

        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MyScubscriber<T> extends BaseSubscriber<T>{
	
	@Override
	protected void hookOnSubscribe(Subscription subscription) {
		System.out.println("Subscribe happened");
		request(1);
		//super.hookOnSubscribe(subscription);
	}
	
	@Override
	protected void hookOnNext(T value) {
		System.out.println(value.toString() + " received");
		request(1);
		//super.hookOnNext(value);
	}
	
}