package test;

import com.jaume.penjat.Puntuacio;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PuntuacioTest {
    private Puntuacio puntuacio ;

//TimeUnit.SECONDS.sleep(1);

    @BeforeEach
        /* COMENTARIO 0 caso de prueba
        *-Nuestro objetico es que con Beforeach , cree la clase privada puntuacion dandole un nuevo valor vacio para nuestra
        * puntuación
        * */
    void InicioPuntuacion(){
        this.puntuacio = new Puntuacio();

    }
    @Test
    void comprebaParaules(String praulaEndv){
        String[] paraulaEndv = {"p","e","i","x"};
        for (int i = 0; i < paraulaEndv.length; i++) {
            String prova = null;
            paraulaEndv[i] = prova;
            System.out.println(prova);
            assertTrue(Arrays.asList(puntuacio.getLetresBonus()).contains(prova));


        }
        //Querermos comprobar que cuando se le otorga una palabra con letras bonus las identifica .



    }
    @ParameterizedTest
    /*
    * COMENTARIO 4 caso de prueba
    * -Este caso de prueba entre las muchas variables que pudiese tener , cojeremos un valor que no coincida con el esperado (1 2 3)
    * -Al hacerlo sabemos que nuestra palabra será catalogada como error ("err")
    * -Por lo tanto buscaremos este caso específico y lo compararemos con el error , si coinciden estearemos sdeguros que nuestro código es firme  */
    @ValueSource(ints = {0} )
    void  dificultatNoMatch( int noMatch){
        String paraula = puntuacio.getParaulaSecretaDificultat(noMatch);
       if (noMatch == 0){
           assertEquals("err", paraula);
           System.out.println("Test correcto ");

       }else{
           System.out.println("Test fallido ");
       }

    }

   @ParameterizedTest
   /*
   COMENTARIO 1 caso de prueba
   -En este método , según los valores que se nos presenten (dificultad que elijamos),
   se nos randomizará una palabra de los arrays 1 2 o 3 .
   -Queremos comprobar que la palabra randomizada en efecto coincide con alguna palabra de nuestro array 1 2 o 3 .
   Asi nos aseguramos que el método devuelve una palabbra correcta.

   -Para cada caso definiremos el assert <Equals>  que al ser cierto parará el desarrollo del test en ese momento (
   lo mismo para los 3 casos de dificultad)
   *  */
   @ValueSource(ints = {1, 2, 3})
    void dificultadIgualParaula(int dificultat){
       String paraula = puntuacio.getParaulaSecretaDificultat(dificultat);
       switch (dificultat){
           case 1:
               assertTrue(Arrays.asList(puntuacio.getParaules1()).contains(paraula));
               break;
           case 2 :
               assertTrue(Arrays.asList(puntuacio.getParaules2()).contains(paraula));
               break;
           case 3 :
               assertTrue(Arrays.asList(puntuacio.getParaules3()).contains(paraula));
               break;
           default:
               break;

       }



    }
    @Test
    void getTime(){}
    @ParameterizedTest
    /*
    * COMENTARIO 2 caso de preueba
    * -Este test , dados 3 valores correctos de la dificultad se asegura que  los numeros de intentos coinciden con
    * los esperados .
    * -Para ello deberemos especificar a mano cada una de las 3 posibilidades y la compararemos con el resultado del método original    * */
    @ValueSource(ints = {1, 2, 3})
    void getParaulaSecretaDificultat(int number) {

        puntuacio.getParaulaSecretaDificultat(number);
        int resultat = 0;
        switch (number) {
            case 1:
                number = 1;
                resultat = 5;
                break;

            case 2:
                number = 2;
                resultat = 4;
                break;

            case 3:
                number = 3;
                resultat = 3;
                break;
            default:
                ;
                break;
        }
        Assertions.assertEquals(resultat,puntuacio.getIntents());
    }

}