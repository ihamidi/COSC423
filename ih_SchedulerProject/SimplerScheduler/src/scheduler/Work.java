package scheduler;
/**
 * Created by Izhak Hamidi, E015333340
 **/
public class Work implements JobWorkable{

	public Work() {
		// TODO Auto-generated constructor stub
	}
/*
 * (non-Javadoc)
 * prints a statement that current thread is doing work to the console
 * @see scheduler.JobWorkable#doWork()
 */
	@Override
	public void doWork() {
		
		System.out.println(Thread.currentThread().getName()+" Worker is doing Work");
	}

}
