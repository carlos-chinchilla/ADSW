package es.upm.dit.adsw.practica3;

public class Hebra extends Thread{
	private Vector destino;
	private int vueltas;
	private Vehiculo v;
	private Vector posInicial;
	
	public Hebra(Vector destino,int vueltas,Vehiculo v, Vector posInicial) {
		this.destino=destino;
		this.vueltas=vueltas;
		this.v=v;
		this.posInicial=posInicial;
	}
	
	@Override
	public void run() {
		int aux=0;
		//Vector posInicial = v.getPos();
		
		if(this.vueltas==1) {
			v.irA(this.destino);
		}
		else {
			while(aux < this.vueltas && this.vueltas != 0) {
			v.irA(this.destino);
			aux++;
			v.irA(posInicial);
			aux++;
			}
		}
		
	}

}
