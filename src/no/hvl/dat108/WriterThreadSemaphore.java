package no.hvl.dat108;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class WriterThreadSemaphore extends Thread{
	
	private PersonSemaphore person;
	private Semaphore semWrite;
	private Semaphore semRead;
	private int nr;
	private static AtomicInteger writerCount = new AtomicInteger(0);
	
	
	public WriterThreadSemaphore(Semaphore semWrite, Semaphore semRead, PersonSemaphore person, int nr) {
		this.semWrite = semWrite;
		this.semRead = semRead;
		this.person = person;
		this.nr = nr;
	}

	@Override
	public void run() {
		try {
			
			semWrite.acquire();
			writerCount.getAndIncrement();
			if (writerCount.get() == 1) {
				semRead.acquire();
			}
			
			
			System.out.println("WriterThread nr " + nr +  " is writing.");
			person.setNavn();
			

			writerCount.getAndDecrement();
			if (writerCount.get() == 0) {
				semRead.release();
			}

			semWrite.release();
			
		} catch (InterruptedException exc) { 
            System.out.println(exc); 
        } 
		
		
	}

}
