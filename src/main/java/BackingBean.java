
import java.util.LinkedList;
import java.util.Random;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2131381
 */
@ManagedBean(name = "guessBean")
@SessionScoped
public class BackingBean {
    private int numero;
    private int intentos;
    private int premioAcum;
    private String estado;
    LinkedList<Integer> usados = new LinkedList<Integer>(); 
    public BackingBean(){
        intentos=0;
        premioAcum=100000;
        Random r = new Random();
        numero = r.nextInt(101);
        estado = "No ha adivinado";
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public int getNumero() {
        return numero;
    }

    public int getIntentos() {
        return intentos;
    }

    public int getPremioAcum() {
        return premioAcum;
    }

    public String getEstado() {
        return estado;
    }
    
    public void guess(int n){
        if (n == numero){
            estado = "Felicitaciones, ha ganado $"+premioAcum;
        }
        else{
            if(premioAcum - 10000 < 0){
                premioAcum=0;
            }
            else{
                premioAcum-=10000;
            }
            intentos+=1;
            usados.add(n);
        }
    }
    
    public void restart(){
       Random newr = new Random();
       numero = newr.nextInt(101);
       premioAcum = 100000;
       intentos=0;
       estado="No ha adivinado";
    }
    
}
