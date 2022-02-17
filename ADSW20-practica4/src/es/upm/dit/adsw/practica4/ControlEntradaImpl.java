package es.upm.dit.adsw.practica4;
public class ControlEntradaImpl implements ControlEntrada {
	
	private boolean ocupado = false;
	private Thread dentro = null;
	
	@Override
	public synchronized long entrarEnTramo() throws RuntimeException {
	
		if(Thread.currentThread()!=dentro){
		long start = System.currentTimeMillis();
		while(ocupado) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long end = System.currentTimeMillis();
		ocupado=true;
		dentro = Thread.currentThread();
		if (end-start==0) {
			return -1;
		}
		return (end-start);
		}
		else {
			throw new RuntimeException();
		}
	}
	@Override
	public synchronized void salirDeTramo() throws RuntimeException{
		Thread prueba = Thread.currentThread();
		if(prueba==dentro) {
			ocupado=false;
			notifyAll();
			dentro=null;
		}
		else {
			throw new RuntimeException();
		}
	}

}