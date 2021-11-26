package com.coffeemachine.services;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.coffeemachine.exceptions.OutletLimitReached;
import com.coffeemachine.models.Beverage;
import com.coffeemachine.models.CoffeeMachine;

/**
 * This class is the service class for the Coffee Machine. It processes the
 * orders in a multi threaded manner.
 * 
 * @author pritampallab
 *
 */
public class CoffeeMachineService {
	private CoffeeMachine coffeeMachine;
	private ThreadPoolExecutor threadPoolExecutor;

	public CoffeeMachineService() {
		coffeeMachine = CoffeeMachine.getCoffeeMachine();
	}

	/**
	 * This method processes the orders
	 * 
	 * @throws InterruptedException
	 */
	public void processOrders() throws InterruptedException {
		if (coffeeMachine.getOutletsCount() == 0) {
			System.out.println("No outlet is there");
			return;
		}
		// Creating a thread pool
		threadPoolExecutor = new ThreadPoolExecutor(0, coffeeMachine.getOutletsCount(), 5000L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<>(coffeeMachine.getBeverages().size()));
		threadPoolExecutor.setRejectedExecutionHandler(new OutletLimitReached());
		for (Beverage beverage : coffeeMachine.getBeverages()) {
			BeverageService beverageService = new BeverageService(beverage);
			threadPoolExecutor.submit(beverageService);
		}
		threadPoolExecutor.shutdown();
	}

	/**
	 * This method takes the orders from the user
	 * 
	 * @param beverages List<Beverage>
	 */
	public void takeOrders(List<Beverage> beverages) {
		coffeeMachine.getBeverages().addAll(beverages);
	}

	/**
	 * This method configures the CoffeeMachine
	 * 
	 * @param getOutletsCount int
	 */
	public void configure(int getOutletsCount) {
		coffeeMachine.setOutletsCount(getOutletsCount);
	}
}
