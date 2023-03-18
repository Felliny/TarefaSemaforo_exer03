package Controller;

import java.util.concurrent.Semaphore;

public class CorridaSemaforo extends Thread{

    private int[] tempovolta= new int[14];
    private static int carro= 0;
    private Semaphore semaforo;
    private int equipe[]= new int[14];

    public CorridaSemaforo(int[] tempovolta, Semaphore semaforo, int[] equipe){
        this.tempovolta= tempovolta;
        this.semaforo= semaforo;
        this.equipe= equipe;
    }

    @Override
    public void run() {
        for (int i=1; i<=2; i++){
            try {
                semaforo.acquire();
                corrida();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                semaforo.release();
            }
        }

    }

    private void corrida() {
        int voltarapida= 0; //volta mais rápida do carro
        int tempo;

        for (int i=1; i<=3; i++){
            tempo= (int) (Math.random()* 9) + 2;
            if (i == 1){
                voltarapida= tempo;
            }
            else if (tempo < voltarapida){
                voltarapida= tempo;
            }
        }
//        System.out.println("O carro da equipe #"+ getId() +" teve a melhor volta com "+ voltarapida +" s.");
        equipe[carro]= (int) getId();
        tempovolta[carro]= voltarapida;
        carro++;
    }

}
