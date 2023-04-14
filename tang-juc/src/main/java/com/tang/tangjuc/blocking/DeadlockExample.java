package com.tang.tangjuc.blocking;


public class DeadlockExample {
	public static void main(String[] args) {
		final Object lock1 = new Object();
		final Object lock2 = new Object();

		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				synchronized (lock1) {
					System.out.println("Thread 1 acquired lock1");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (lock2) {
						System.out.println("Thread 1 acquired lock2");
					}
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				synchronized (lock2) {
					System.out.println("Thread 2 acquired lock2");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (lock1) {
						System.out.println("Thread 2 acquired lock1");
					}
				}
			}
		});

		thread1.start();
		thread2.start();
	}
}
