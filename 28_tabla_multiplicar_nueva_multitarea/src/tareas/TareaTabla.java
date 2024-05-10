package tareas;

public class TareaTabla implements Runnable {
	private int n;
	public TareaTabla(int n){
		this.n=n;
	}
	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println(n+"X"+i+"="+n*i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
