package controller;

import java.util.concurrent.Semaphore;

public class ControllerCorredores extends Thread{

	public int idCorredor;
	public Semaphore semaforo;
	public int velocidade;
	
	public ControllerCorredores(int idCorredor, Semaphore semaforo, int velocidade) {
		this.idCorredor = idCorredor;
		this.semaforo = semaforo;
		this.velocidade = velocidade;
	}
	
	public void run() {
		Caminhada();
	}
	
	private void Caminhada() {
		CaminhadaPrePorta();
		try {
			semaforo.acquire();
			AtravessaPorta();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}
	
	private void CaminhadaPrePorta() {
		int dist = 0;
		do {
			dist = dist + velocidade;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (dist <= 200);
		
		System.out.println("Corredor " + idCorredor + " chegou na porta");
	}
	
	private void AtravessaPorta() {
		System.out.println("Corredor " + idCorredor + " abriu a porta e está atrevessando");
		int tempo = (int)((Math.random() * 1000) + 1000);
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.err.println("Corredor " + idCorredor + " atravessou");
		
	}

}
