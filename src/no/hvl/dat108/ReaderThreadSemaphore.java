
package no.hvl.dat108;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class ReaderThreadSemaphore extends Thread {
	private PersonSemaphore person;
	private Semaphore semWrite;
	private Semaphore semRead;
	private int nr;
	private static AtomicInteger readerCount = new AtomicInteger(0);

	public ReaderThreadSemaphore(Semaphore semWrite, Semaphore semRead, PersonSemaphore person, int nr) {
		this.person = person;
		this.semRead = semRead;
		this.semWrite = semWrite;
		this.nr = nr;
	}

	@Override
	public void run() {

		try {
			semRead.acquire();
			readerCount.getAndIncrement();
			if (readerCount.get() == 1) {
				semWrite.acquire();
			}
			semRead.release();
			
			System.out.println("ReaderThread nr: " + nr + " reads: " + person.getNavn());
			
			semRead.acquire();
			readerCount.getAndDecrement();
			if (readerCount.get() == 0) {
				semWrite.release();
			}
			semRead.release();
			
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
}
