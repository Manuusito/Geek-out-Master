package GeekOutMasters;

import javax.swing.*;
import java.awt.*;

public class ModelGeek {

    private Dado dado1,dado2,dado3,dado4,dado5,dado6,dado7,dado8,dado9,dado10;
    private JLabel dado11,dado22,dado33,dado44,dado55,dado66,dado77,dado88,dado99,dado1010;

    private int[] caras, carasInactivas;
    private int puntaje;
    private int corazones;


    public int HayCorazones(){
        corazones=0;
        if (caras[0]==4){
            corazones=corazones+1;
        }
        else if(caras[1]==4){
            corazones=corazones+1;
        }
        else if(caras[2]==4) {
            corazones = corazones + 1;
        }
        else if(caras[3]==4){
            corazones=corazones+1;
        }
        else if(caras[4]==4){
            corazones=corazones+1;
        }
        else if(caras[5]==4){
            corazones=corazones+1;
        }
        else if(caras[6]==4){
            corazones=corazones+1;
        }
        else if(caras[7]==4){
            corazones=corazones+1;
        }
        return corazones;
    }

    public Component CaraCorazones(){
        if (caras[0]==4){
            return dado1;
        }
        else if(caras[1]==4){
            return dado2;
        }
        else if(caras[2]==4){
            return dado3;
        }
        else if(caras[3]==4){
            return dado4;
        }
        else if(caras[4]==4){
            return dado5;
        }
        else if(caras[5]==4){
            return dado6;
        }
        else if(caras[6]==4){
            return dado7;
        }
        else if(caras[7]==4){
            return dado8;
        }
        else return null;
    }


    public ModelGeek(){
        puntaje = 0;
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
    }

    /* Definimos que

        1 = Meeple
        2 = Nave Espacial
        3 = Superheroe
        4 = Corazon
        5 = Dragon
        6 = 42

    */

    public void calcularTiro(){
        caras[0]=dado1.getCara();
        caras[1]=dado2.getCara();
        caras[2]=dado3.getCara();
        caras[3]=dado4.getCara();
        caras[4]=dado5.getCara();
        caras[5]=dado6.getCara();
        caras[6]=dado7.getCara();
        //carasInactivas[0]=dado5.getCara();
        //carasInactivas[1]=dado6.getCara();
        //carasInactivas[2]=dado7.getCara();
    }

   public void calcularTiroInactivos1(){
        caras[7]=dado8.getCara();

    }
    public void calcularTIroInactivo2(){
        caras[8]=dado9.getCara();

    }
    public void calcularTIroInactivo3(){
        caras[9]=dado10.getCara();

    }

    public void DeterminarJuego(){
        if (puntaje>=30){


        }else{

        }

    }


    public int[] getCaras() {
        return caras;
    }






















}
