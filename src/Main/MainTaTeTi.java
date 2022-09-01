/*
Hacer array con 9 casilleros
ir colocando cruz o cara

 */
package Main;

import Entidad.TaTeTi;
import Servicio.ServicioTableros;

public class MainTaTeTi {

    public static void main(String[] args) {

        ServicioTableros s = new ServicioTableros();
        TaTeTi t = s.creartablero();
        s.jugar(t);
       

    }
}
