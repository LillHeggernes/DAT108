package no.hvl.dat108;

import java.util.concurrent.Semaphore;

public class Oppg1Semaphore {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub

		Semaphore semWrite = new Semaphore(1);
		Semaphore semRead = new Semaphore(5);
		PersonSemaphore p = new PersonSemaphore();

		Thread bruker1 = new WriterThreadSemaphore(semWrite, semRead, p, 1);
		Thread bruker2 = new ReaderThreadSemaphore(semWrite, semRead, p, 2);
		Thread bruker3 = new WriterThreadSemaphore(semWrite, semRead, p, 3);
		Thread bruker4 = new ReaderThreadSemaphore(semWrite, semRead, p, 4);
		Thread bruker5 = new WriterThreadSemaphore(semWrite, semRead, p, 5);
		Thread bruker6 = new ReaderThreadSemaphore(semWrite, semRead, p, 6);
		Thread bruker7 = new WriterThreadSemaphore(semWrite, semRead, p, 7);
		Thread bruker8 = new ReaderThreadSemaphore(semWrite, semRead, p, 8);
		Thread bruker9 = new WriterThreadSemaphore(semWrite, semRead, p, 9);
		Thread bruker10 = new ReaderThreadSemaphore(semWrite, semRead, p, 10);

		bruker1.start();
		bruker2.start();
		bruker3.start();
		bruker4.start();
		bruker5.start();
		bruker6.start();
		bruker7.start();
		bruker8.start();
		bruker9.start();
		bruker10.start();
	}

}
