package GeekOutMasters;

public class ModelGeek {

    private Dado dado1,dado2,dado3,dado4,dado5,dado6,dado7,dado8,dado9,dado10;
    private int[] caras, carasInactivas;

    public ModelGeek(){
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
        caras = new int[7];
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


    }

    public void calcularTiroInactivos(){
        carasInactivas[0]=dado8.getCara();
        carasInactivas[1]=dado9.getCara();
        carasInactivas[2]=dado10.getCara();
    }

    public void DeterminarJuego(){

    }

    public int[] getCaras() {
        return caras;
    }






















}
