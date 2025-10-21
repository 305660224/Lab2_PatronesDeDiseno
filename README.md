Aplicacion de STRATEGY:
Se aplico el patron de diseño Strategy a el proceso de notificaciones.
Se quito el swich del metodo enviar de la clase ServicioNotificaciones.
Se añadieron las clases necesarias para notificar por cada medio (SMSStrategy, WhatsAppStrategy, etc).
Se añadio una interfaz llamada EnviarStrategy, para indicar que cada una de las clases creadas debe llevar el metodo "enviar".
Se creo un hashmap que almacena cada una instancias de cada medio de notificacion(SMSStrategy, WhatsAppStrategy, etc) y el canal correspondiente a notificar(SMS, WHattsapp, etc).
Al hacerle get al hashmap, se ejecutan las notificaciones correspondientes por los canales solicitados
***Si se desea añadir un nuevo medio de notificacion se debe crear una nueva clase respectiva y añadirlo al hashmap
