/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Notificaciones;

import java.util.HashMap;
import java.util.Map;
import Facturacion.Factura;
import Notificaciones.Notificacion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jprod
 */
public class ServicioNotificaciones {
    private int seq = 1;
    private final List<Notificacion> historial;
    private final Map<CanalNotificacion, EnviarStrategy> estrategias;

    /**
     * Iterator
     * @return 
     */
    public List<Notificacion> getHistorial(){ return historial; }

    public ServicioNotificaciones() {
        estrategias = new HashMap<>();
        historial = new ArrayList<>();
        estrategias.put(CanalNotificacion.PANTALLA, new PantallaStrategy());
        estrategias.put(CanalNotificacion.SMS, new SMSStrategy());
        estrategias.put(CanalNotificacion.WHATSAPP, new WhatsappStrategy());
        estrategias.put(CanalNotificacion.EMAIL, new EmailStrategy());
    }

    /**
     * Simulación de envío por canal
     * @param factura
     * @param canal
     * @return 
     */
    public Notificacion enviar(Factura factura, CanalNotificacion canal){
        Notificacion n = new Notificacion(seq++, factura, canal);
        try {
            if (estrategias != null) {
            EnviarStrategy estrategia = estrategias.get(canal);
            estrategia.Enviar(factura);
            }
            n.setEstado(EstadoNotificacion.ENVIADA);
        } catch (Exception e){
            n.setEstado(EstadoNotificacion.FALLIDA);
        }
        historial.add(n);
        return n;
    }

}
