package GeekOutMasters;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ModelGeek<componemt> {

    public int getCorazones;
    private Dado dado1,dado2,dado3,dado4,dado5,dado6,dado7,dado8,dado9,dado10,dado11,dado12,dado13,dado14,dado15,dado16,dado17,dado18,dado19,dado20,dado21,dado22,dado23,dado24;

    private int[] caras, carasInactivas, carasUsadas;
    private int puntaje, puntos;
    private int corazones,corazones1;
    private int[] Usando;
    private GUIGridBagLayout gui;


    /* Definimos que

        1 = Meeple
        2 = Nave Espacial
        3 = Superheroe
        4 = Corazon
        5 = Dragon
        6 = 42

    */

    public void Realizar(){
       if (Usando[0]==1){
           //gui.caraToDado1();
           caras[Usando[2]-1]=0;

           Random aleatorio = new Random();
           caras[Usando[3]-1] = aleatorio.nextInt(6) + 1;




       }
       if (Usando[0]==2){

           caras[Usando[2]-1]=0;
           caras[Usando[3]-1]=0;



       }
       if (Usando[0]==3){

           caras[Usando[2]-1]=0;
           if (caras[Usando[3]-1] == 1){
               caras[Usando[3]-1]=2;
           }
           else if (caras[Usando[3]-1] == 2){
               caras[Usando[3]-1] =1;
           }
           else if (caras[Usando[3]-1] == 3){
               caras[Usando[3]-1] =5;

           }
           else if (caras[Usando[3]-1] == 4){
               caras[Usando[3]-1] =6;

           }
           else if (caras[Usando[3]-1] == 5){
               caras[Usando[3]-1] =3;

           }
           else if (caras[Usando[3]-1] == 6){
               caras[Usando[3]-1] =4;

           }

       }
       if (Usando[0]==4){


           if(corazones==0) {

               Random aleatorio = new Random();
               caras[Usando[2] - 1] = aleatorio.nextInt(6) + 1;
               corazones=corazones+1;
               caras[7]=0;


           }else if (corazones==1 ){

               Random aleatorio = new Random();
               caras[Usando[2] - 1] = aleatorio.nextInt(6) + 1;
               corazones=corazones+1;
               caras[8]=0;

           }else if (corazones==2){
               Random aleatorio = new Random();
               caras[Usando[2] - 1] = aleatorio.nextInt(6) + 1;
               corazones=corazones+1;
               caras[9]=0;
           }
           else if (corazones>3){

               caras[Usando[2] - 1]=0;
           }

       }
       if (Usando[0]==5){

       }
       if (Usando[0]==6){

       }
    }

    public void BorrarUsados(){
        Usando[0]=0;
        Usando[1]=0;
        Usando[2]=0;
        Usando[3]=0;
    }

    public void BorrarCorazones(){
        corazones=0;
    }


    public ModelGeek(){
        puntaje = 0;
        corazones=0;
        dado1 = new Dado();
        dado2 = new Dado();
        dado3 = new Dado();
        dado4 = new Dado();
        dado5 = new Dado();
        dado6 = new Dado();
        dado7 = new Dado();
        dado8 = new Dado();
        dado9 = new Dado();
        dado10 = new Dado();
        caras = new int[10];
        carasInactivas =new int[3];
        Usando= new int [4];

    }

    public int getCorazones(){
        corazones1=corazones;
        return corazones1;
    }

    public int [] ObtenUsando(){

        return Usando;
    }



    public void calcularTiro(){
        caras[0]=dado1.getCara();
        caras[1]=dado2.getCara();
        caras[2]=dado3.getCara();
        caras[3]=dado4.getCara();
        caras[4]=dado5.getCara();
        caras[5]=dado6.getCara();
        caras[6]=dado7.getCara();
        //caras[7]=dado5.getCara();
        //caras[8]=dado6.getCara();
        //caras[9]=dado7.getCara();
    }


    public int[] getCaras() {
        return caras;
    }

    public int terminarRonda(){
       for (int j=0 ; j<8 ; j++){
           if(caras[j]==6){
               puntos=puntos+1;
           }
           if (caras[j]==5){
               puntos=0;
           }
           else{
               puntos=puntos;
           }
       }
        return puntos;
    }

    public int getPuntaje() {
        if (puntos == 0) {
            puntaje = 0;
        } else if (puntos == 1) {
            puntaje = 1;
        } else if (puntos == 2) {
            puntaje = 3;
        } else if (puntos == 3) {
            puntaje = 6;
        } else if (puntos == 4) {
            puntaje = 10;
        } else if (puntos == 5) {
            puntaje = 15;
        } else if (puntos == 6) {
            puntaje = 21;
        } else if (puntos == 7) {
            puntaje = 28;
        } else if (puntos == 8) {
            puntaje = 36;
        } else if (puntos == 9) {
            puntaje = 45;
        } else if (puntos == 10) {
            puntaje = 55;
        } else {
            puntaje = puntaje;
        }
        return puntaje;
    }


}
