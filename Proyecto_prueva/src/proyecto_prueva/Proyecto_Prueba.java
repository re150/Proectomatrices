/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_prueva;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;



/**
 *
 * @author angel
 */

public class Proyecto_Prueba {

    /**
     * @param args the command line arguments
     */
    static Random rand = new Random();
    static public  int aux = 50;
    static public  long Concu, sec ,Concu2;
 
    
    
    public static void main(String[] args ) {
        // TODO code application logic here
       //int[][] matrixA =  new int[aux][aux];
       
   //   logica  matris = new logica();
     //matris.matrices();
      MultiThr();
     // datosMatris(matrixA);
     //   show(matrixA);
          
     // Forkjoinmatrix();
       
       
        //sec = matris.sec; 
        if(Concu2 < sec) {
            System.out.println("Concurente win " +Concu2 + " ms " + "lost Secuencial  " + sec +" ms ");
        }else{
            System.out.println("Secuenciasl win " + sec +" ms " + "lost Concurente " + Concu2 + " ms ");
        } 
      
    }
    
    public static void Forkjoinmatrix(){
    
     /*int availableProcessors = Runtime.getRuntime().availableProcessors();
    System.out.println("Número de hilos disponibles: " + availableProcessors);*/
      long startTime = System.currentTimeMillis(); 
      
        int[][] matrixA = new int[aux][aux];  //{{3,1,-2},{0,4,2},{7,5,1}}; //[aux][aux];
        int[][] matrixB = new int[aux][aux];  //{{-1,0,8},{3,6,9},{0,0,3}}; // new int[aux][aux];
        int[][] result = new int[aux][aux];
        
        // Inicializa las matrices con valores aleatorios

               datosMatris( matrixA);
               datosMatris (matrixB);
         
             
        // Crea una instancia de ForkJoinPool y ejecuta la tarea
        ForkJoinPool pool = new ForkJoinPool();
        ForkjoinMatrix task = new ForkjoinMatrix(matrixA, matrixB, result, 0, aux, 0, aux);
        
        pool.invoke(task);
        show(result);
        
       long endTime = System.currentTimeMillis();
       long AllTime = endTime - startTime;   
       System.out.println("Tiempo transcurrido en milisegundos en concurente Thread: " + AllTime);
       Concu2  = AllTime;
    
    }
    public static void MultiThr() {
        
        long startTime = System.currentTimeMillis();
        int[][] matrixA =  new int[aux][aux]; //{{3,1,-2},{0,4,2},{7,5,1}};  //{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrixB =  new int[aux][aux];  //{{9, 8, 7},{{-1,0,8},{3,6,9},{0,0,3}}; {6, 5, 4}, {3, 2, 1}};
 
        datosMatris (matrixA);
       // show(matrixA);
        datosMatris (matrixB);
        //show(matrixB);
        
        int[][] result = new int[aux][aux];

        // Crear y ejecutar los threads
        hilos[] runnables = new hilos[aux];
        Thread[] threads = new Thread[aux];
        
        for (int i = 0; i <aux; i++) {
            runnables[i] = new hilos(matrixA, matrixB, result, i);
            threads[i] = new Thread(runnables[i]);
            threads[i].start();
            
        }

        // Esperar a que los threads terminen
        for (Thread thread : threads) {
            
           try {
               thread.join();
           } catch (InterruptedException ex) {
           }
           
        }

        // Imprimir resultado
        show(result);
        
        //END TIME
        long endTime = System.currentTimeMillis();
        long AllTime = endTime - startTime;
        System.out.println("Tiempo transcurrido en milisegundos en concurente Thread: " + AllTime);
         Concu  = AllTime;
    }
    
    
     private static void show(int[][] result) {
         System.out.println("\nThread ");
         
        for (int i = 0; i < aux; i++) {
            for (int j = 0; j < aux; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
    
      public static void datosMatris (int[][] x ){
             int mid = aux/2;
             
            
          datosMatris runnables1 = new datosMatris(x, 0, mid-1);
          datosMatris runnables2 = new datosMatris(x, mid, aux -1);
            
          Thread thread1 = new Thread(runnables1);
          Thread thread2 = new Thread(runnables2);
          
          thread1.start();
          thread2.start();
          
        try {
            thread1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Proyecto_Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            thread2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Proyecto_Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          int[][] combina = unir(x);
          
        /* for(int i = 0; i < aux ; i++){
             for(int j = 0; j < aux ; j++){
                x[i][j]= rand.nextInt(100);
             }
         }
         //show(x); */
   
     }
   
      public static int [][] unir(int [][] x){
          int[][] cobina = new int[x.length][x[0].length];
            
              for(int i = 0; i < x.length;  i++){
                  for(int j = 0; j <x[i].length; j++){
                      
                  }
              }
            
          return cobina;
      }
   
}
