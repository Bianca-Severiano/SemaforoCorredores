package view;

import java.util.concurrent.Semaphore;

import controller.ControllerCorredores;

public class Principal {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore (1);
		int velocidade;
		
		for (int i = 0; i < 4; i++) {
			velocidade = (int)((Math.random() * 3) + 4);
			Thread t = new ControllerCorredores(i, semaforo, velocidade);
			t.start();
		}

	}

}
