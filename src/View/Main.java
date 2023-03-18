package View;

import Controller.CorridaSemaforo;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        int tempovolta[]= new int[14];
        int equipe[]= new int[14];
        Semaphore semaforo= new Semaphore(5);

        for (int i=0; i<7; i++){
            Thread corrida1= new CorridaSemaforo(tempovolta, semaforo, equipe);
            corrida1.run();
        }

        int aux=0;
        int aux2= 0;
        for (int i=0; i<14; i++){
            for (int j=0; j<14-1; j++){
                if (tempovolta[j+1] <= tempovolta[j]){
                    aux= tempovolta[j+1];
                    aux2= equipe[j+1];
                    tempovolta[j+1]= tempovolta[j];
                    equipe[j+1]= equipe[j];
                    tempovolta[j]= aux;
                    equipe[j]= aux2;
                }
            }
        }

        int c=1;
        for (int i=0; i<14; i++){
            System.out.println(c++ +"o. O carro da equipe #"+ equipe[i] +" teve a melhor volta com "+ tempovolta[i] +" minutos.");
        }





    }
}
