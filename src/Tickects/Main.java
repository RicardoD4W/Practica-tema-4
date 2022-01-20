package Tickects;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        Scanner cad = new Scanner(System.in);
        Scanner reset = new Scanner(System.in);

        Date Abierta = Calendar.getInstance().getTime();
        Date Cerrada = Calendar.getInstance().getTime();

        String fechaIncidenciaAbierta = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss ").format(Calendar.getInstance().getTime());
        String fechaIncidenciaCerrada = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss ").format(Calendar.getInstance().getTime());

//-----------------------2 USUARIOS NORMAlES MAX + INCIDENCIAS MAX----------
        UsuarioNormal u1 = new UsuarioNormal();
        UsuarioNormal u2 = new UsuarioNormal();

        Entrada_Incidencia incidencia1U1 = new Entrada_Incidencia();
        Entrada_Incidencia incidencia2U1 = new Entrada_Incidencia();
        Entrada_Incidencia incidencia3U1 = new Entrada_Incidencia();

        Entrada_Incidencia incidencia1U2 = new Entrada_Incidencia();
        Entrada_Incidencia incidencia2U2 = new Entrada_Incidencia();
        Entrada_Incidencia incidencia3U2 = new Entrada_Incidencia();

//-----------------------2 TECNICOS NORMAlES MAX + INCIDENCIAS MAX----------
        Tecnico t1 = new Tecnico();     //todo ***usser*** --> t1 <-- ***pass***
        Tecnico t2 = new Tecnico();     //todo ***usser*** --> t2 <-- ***pass***



//-----------------------1 ADMINISTRADOR------------------------------------
        Administrador a1 = new Administrador(); //todo ***usser*** --> admin <-- ***pass***
//~~~~~~~~~~~~~~~~~~~~CREACION DE INSTANCIAS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


//---------------------*****VARIABLES*****---------------------------------
        int opcionRegitrase_IS;
        int opcionuser, menuuser, menuadmin, delete, alta, opcIncidencia, opcAsignacionIncidencia, opcMenuTecnico;
        String user, pass, codigo, comentarioTecnico;
        String usuario, contraseña, nombre , apellido1, apellido2;
        boolean exit1 = false;
        boolean exit2 = false;
        boolean exit3 = false;
        boolean exit4 = false;
        boolean exit5 = false;
        boolean exit6 = false;
        boolean comprob = false;

        String codigor = String.valueOf((int)(Math.random()*10000000));
        String comprobaciones = codigor;

        if (comprobaciones == codigor){
            codigor = String.valueOf((int)(Math.random()*10000000));
        }

        String destino;
        String mensaje;
        String asunto;
        Scanner s = new Scanner(System.in);
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        do {


            System.out.println("Bienvenido al programa de incidencia de tiquets");

            System.out.println("\n¿Que desea hacer?");
            System.out.println("\t(1).-Registrase\t(2).-Iniciar Sesión\t(3).-Salir");
            opcionRegitrase_IS = reset.nextInt();


            switch (opcionRegitrase_IS) {
                case 3:
                    exit1 = true;
                    break;

                case 1: //registrase como usuario

                    System.out.println("Usuarios disponibles... 2. \t si desea ampliarlo compre la versión completa del programa");
                    System.out.println("Qué usuario desea ocupar? (tenga en cuenta que se reescribirán los datos si uno de ellos ya ha sido previamente registrado)");
                    System.out.println(" (1) / (2)");
                    opcionuser = num.nextInt();

                    switch (opcionuser) {
                        case 1: //u1
                            System.out.println("Nombre?");
                            u1.setNombre(nombre = cad.nextLine());

                            System.out.println("Usuario?");
                            u1.setUsuario(usuario = cad.nextLine());

                            System.out.println("Contraseña?");
                            u1.setContraseña(contraseña = cad.nextLine());

                            System.out.println("Correo? ");
                            u1.setDestino(destino = s.nextLine());

                            System.out.println("Procederemos a enviarle un token de autentificación (le servirá para registrarse)");

                            //enviamos correo
                            asunto = "Verificación";

                            u1.setMensaje(codigor);

                            if (EnviarMail.enviarMail(u1.getDestino(),u1.getMensaje(),asunto)){
                                System.out.println("Mensaje enviado con éxito");
                            }else {
                                System.out.println("Error al enviar el mensaje");
                            }


                            break;

                        case 2: //u2
                            System.out.println("Nombre?");
                            u2.setNombre(nombre = cad.nextLine());

                            System.out.println("Usuario?");
                            u2.setUsuario(usuario = cad.nextLine());

                            System.out.println("Contraseña?");
                            u2.setContraseña(contraseña = cad.nextLine());

                            System.out.println("Correo? ");
                            u2.setDestino(destino = s.nextLine());

                            System.out.println("Procederemos a enviarle un token de autentificación (le servirá para registrarse)");

                            //enviamos correo
                            asunto = "Verificación";

                            u2.setMensaje(codigor);
                            if (EnviarMail.enviarMail(u2.getDestino(),u2.getMensaje(),asunto)){
                                System.out.println("Mensaje enviado con éxito");
                            }else {
                                System.out.println("Error al enviar el mensaje");
                            }

                            break;

                    }

                    break;




                case 2://iniciar sesion


                    System.out.println("Quiere iniciar sesión? (y/n)");
                    String comprobacion = cad.nextLine();

                    if (comprobacion.equals("y")){ //depend of comprub
                        comprob = false;
                    }else {
                        exit1 = true;
                        comprob = true;
                        break;
                    }



                    System.out.println("Usuario?");
                    user = cad.nextLine();

                    System.out.println("Contraseña?");
                    pass = cad.nextLine();


                    if (user.equals("t1") && pass.equals("t1")) { //entra tecnico 1
                        do {


                            if (t1.getNombre() != null) {
                                System.out.println("Bienvenido " + t1.getNombre() + ", tiene usted perfil de técnico.\n Menú:");
                                menúTecnico();

                                opcMenuTecnico = num.nextInt();

                                switch (opcMenuTecnico) {
                                    case 1://consultar indicencias asignadas a mi y añadir comentario
                                        if (incidencia1U1.getTecnico() == t1) {
                                            System.out.println(incidencia1U1.toStringnResuelta());
                                            System.out.println("Añada un comentario?");
                                            comentarioTecnico = cad.nextLine();
                                            incidencia1U1.setComentario_tecnico(comentarioTecnico);
                                        }
                                        if (incidencia2U1.getTecnico() == t1) {
                                            System.out.println(incidencia2U1.toStringnResuelta());
                                            System.out.println("Añada un comentario?");
                                            comentarioTecnico = cad.nextLine();
                                            incidencia2U1.setComentario_tecnico(comentarioTecnico);
                                        }
                                        if (incidencia3U1.getTecnico() == t1) {
                                            System.out.println(incidencia3U1.toStringnResuelta());
                                            System.out.println("Añada un comentario?");
                                            comentarioTecnico = cad.nextLine();
                                            incidencia3U1.setComentario_tecnico(comentarioTecnico);
                                        }
                                        if (incidencia1U2.getTecnico() == t1) {
                                            System.out.println(incidencia1U2.toStringnResuelta());
                                            System.out.println("Añada un comentario?");
                                            comentarioTecnico = cad.nextLine();
                                            incidencia1U2.setComentario_tecnico(comentarioTecnico);
                                        }
                                        if (incidencia2U2.getTecnico() == t1) {
                                            System.out.println(incidencia2U2.toStringnResuelta());
                                            System.out.println("Añada añadir un comentario?");
                                            comentarioTecnico = cad.nextLine();
                                            incidencia2U2.setComentario_tecnico(comentarioTecnico);
                                        }
                                        if (incidencia3U2.getTecnico() == t1) {
                                            System.out.println(incidencia3U2.toStringnResuelta());
                                            System.out.println("Añada un comentario?");
                                            comentarioTecnico = cad.nextLine();
                                            incidencia3U2.setComentario_tecnico(comentarioTecnico);
                                        }

                                        break;

                                    case 2: // Marcar incidencia como resuelta
                                        System.out.println("Que incidencia desea marcar como resuelta?");
                                        System.out.println(incidencia1U1.toStringnResuelta(1) + "\t\t\t--> ***(1)***");
                                        System.out.println(incidencia2U1.toStringnResuelta(1) + "\t\t\t--> ***(2)***");
                                        System.out.println(incidencia3U1.toStringnResuelta(1) + "\t\t\t--> ***(3)***");
                                        System.out.println(incidencia1U2.toStringnResuelta(1) + "\t\t\t--> ***(4)***");
                                        System.out.println(incidencia2U2.toStringnResuelta(1) + "\t\t\t--> ***(5)***");
                                        System.out.println(incidencia3U2.toStringnResuelta(1) + "\t\t\t--> ***(6)***");

                                        opcIncidencia = num.nextInt();
                                        switch (opcIncidencia) {
                                            case 1:
                                                incidencia1U1.setResuelta(true);
                                                incidencia1U1.setCalendarCerrada(fechaIncidenciaCerrada);
                                                //enviamos correo |  destino = u1.getdestino
                                                asunto = "Incidencia cerrada";
                                                u1.setMensaje(incidencia1U1.toStringResuelta());

                                                if (EnviarMail.enviarMail(u1.getDestino(),u1.getMensaje(),asunto)){
                                                    System.out.println("Mensaje enviado con éxito");
                                                }else {
                                                    System.out.println("Error al enviar el mensaje");
                                                }
                                                //
                                                break;
                                            case 2:
                                                incidencia2U1.setResuelta(true);
                                                incidencia2U1.setCalendarCerrada(fechaIncidenciaCerrada);
                                                //enviamos correo |  destino = u1.getdestino
                                                asunto = "Incidencia cerrada";
                                                u1.setMensaje(incidencia2U1.toStringResuelta());

                                                if (EnviarMail.enviarMail(u1.getDestino(),u1.getMensaje(),asunto)){
                                                    System.out.println("Mensaje enviado con éxito");
                                                }else {
                                                    System.out.println("Error al enviar el mensaje");
                                                }
                                                //
                                                break;
                                            case 3:
                                                incidencia3U1.setResuelta(true);
                                                incidencia3U1.setCalendarCerrada(fechaIncidenciaCerrada);
                                                //enviamos correo |  destino = u1.getdestino
                                                asunto = "Incidencia cerrada";
                                                u1.setMensaje(incidencia3U1.toStringResuelta());

                                                if (EnviarMail.enviarMail(u1.getDestino(),u1.getMensaje(),asunto)){
                                                    System.out.println("Mensaje enviado con éxito");
                                                }else {
                                                    System.out.println("Error al enviar el mensaje");
                                                }
                                                //
                                                break;
                                            case 4:
                                                incidencia1U2.setResuelta(true);
                                                incidencia1U2.setCalendarCerrada(fechaIncidenciaCerrada);
                                                //enviamos correo |  destino = u2.getdestino
                                                asunto = "Incidencia cerrada";
                                                u2.setMensaje(incidencia1U2.toStringResuelta());

                                                if (EnviarMail.enviarMail(u2.getDestino(),u2.getMensaje(),asunto)){
                                                    System.out.println("Mensaje enviado con éxito");
                                                }else {
                                                    System.out.println("Error al enviar el mensaje");
                                                }
                                                //
                                                break;
                                            case 5:
                                                incidencia2U2.setResuelta(true);
                                                incidencia2U2.setCalendarCerrada(fechaIncidenciaCerrada);
                                                //enviamos correo |  destino = u2.getdestino
                                                asunto = "Incidencia cerrada";
                                                u2.setMensaje(incidencia2U2.toStringResuelta());

                                                if (EnviarMail.enviarMail(u2.getDestino(),u2.getMensaje(),asunto)){
                                                    System.out.println("Mensaje enviado con éxito");
                                                }else {
                                                    System.out.println("Error al enviar el mensaje");
                                                }
                                                //
                                                break;
                                            case 6:
                                                incidencia3U2.setResuelta(true);
                                                incidencia3U2.setCalendarCerrada(fechaIncidenciaCerrada);
                                                //enviamos correo |  destino = u2.getdestino
                                                asunto = "Incidencia cerrada";
                                                u2.setMensaje(incidencia3U2.toStringResuelta());

                                                if (EnviarMail.enviarMail(u2.getDestino(),u2.getMensaje(),asunto)){
                                                    System.out.println("Mensaje enviado con éxito");
                                                }else {
                                                    System.out.println("Error al enviar el mensaje");
                                                }
                                                //
                                                break;
                                        }

                                        break;

                                    case 3: //consultar mis incidencias resueltas por mi
                                        if (incidencia1U1.getTecnico() == t1 && incidencia1U1.isResuelta() == true) {
                                            System.out.println(incidencia1U1.toStringResuelta());
                                        }
                                        if (incidencia2U1.getTecnico() == t1 && incidencia2U1.isResuelta() == true) {
                                            System.out.println(incidencia2U1.toStringResuelta());
                                        }
                                        if (incidencia3U1.getTecnico() == t1 && incidencia3U1.isResuelta() == true) {
                                            System.out.println(incidencia3U1.toStringResuelta());
                                        }
                                        if (incidencia1U2.getTecnico() == t1 && incidencia1U2.isResuelta() == true) {
                                            System.out.println(incidencia1U2.toStringResuelta());
                                        }
                                        if (incidencia2U2.getTecnico() == t1 && incidencia2U2.isResuelta() == true) {
                                            System.out.println(incidencia2U2.toStringResuelta());
                                        }
                                        if (incidencia3U2.getTecnico() == t1 && incidencia3U2.isResuelta() == true) {
                                            System.out.println(incidencia3U2.toStringResuelta());
                                        }
                                        break;

                                    case 4: //Mostrar mi perfil
                                        System.out.println(t1);
                                        break;

                                    case 5: //cambiar clave de acceso
                                        System.out.println("Nueva contraseña?");
                                        t1.setContraseña(contraseña = cad.nextLine());
                                        break;

                                    case 6://cerrar sesion
                                        exit2 = true;
                                        //exit1 = true;
                                        comprob = true;
                                        break;
                                }

                            } else {
                                System.out.println("No existe perfil creado");
                            }
                        }while (!exit2);

                    } //<>t1

                    if (user.equals("t2") && pass.equals("t2")) {//entra tecnico 2
                        do {


                            if (t2.getNombre() != null) {
                                System.out.println("Bienvenido " + t2.getNombre() + ", tiene usted perfil de técnico.\n Menú:");
                                menúTecnico();

                                opcMenuTecnico = num.nextInt();

                                switch (opcMenuTecnico) {
                                    case 1://consultar indicencias asignadas a mi
                                        //consultar indicencias asignadas a mi y añadir comentario
                                        if (incidencia1U1.getTecnico() == t2) {
                                            System.out.println(incidencia1U1.toStringnResuelta());
                                            System.out.println("Añada un comentario?");
                                            comentarioTecnico = cad.nextLine();
                                            incidencia1U1.setComentario_tecnico(comentarioTecnico);
                                        }
                                        if (incidencia2U1.getTecnico() == t2) {
                                            System.out.println(incidencia2U1.toStringnResuelta());
                                            System.out.println("Añada un comentario?");
                                            comentarioTecnico = cad.nextLine();
                                            incidencia2U1.setComentario_tecnico(comentarioTecnico);
                                        }
                                        if (incidencia3U1.getTecnico() == t2) {
                                            System.out.println(incidencia3U1.toStringnResuelta());
                                            System.out.println("Añada un comentario?");
                                            comentarioTecnico = cad.nextLine();
                                            incidencia3U1.setComentario_tecnico(comentarioTecnico);
                                        }
                                        if (incidencia1U2.getTecnico() == t2) {
                                            System.out.println(incidencia1U2.toStringnResuelta());
                                            System.out.println("Añada un comentario?");
                                            comentarioTecnico = cad.nextLine();
                                            incidencia1U2.setComentario_tecnico(comentarioTecnico);
                                        }
                                        if (incidencia2U2.getTecnico() == t2) {
                                            System.out.println(incidencia2U2.toStringnResuelta());
                                            System.out.println("Añada añadir un comentario?");
                                            comentarioTecnico = cad.nextLine();
                                            incidencia2U2.setComentario_tecnico(comentarioTecnico);
                                        }
                                        if (incidencia3U2.getTecnico() == t2) {
                                            System.out.println(incidencia3U2.toStringnResuelta());
                                            System.out.println("Añada un comentario?");
                                            comentarioTecnico = cad.nextLine();
                                            incidencia3U2.setComentario_tecnico(comentarioTecnico);
                                        }
                                        break;

                                    case 2: // Marcar incidencia como resuelta
                                        System.out.println("Que incidencia desea marcar como resuelta?");
                                        System.out.println(incidencia1U1.toStringnResuelta(1) + "\t\t\t--> ***(1)***");
                                        System.out.println(incidencia2U1.toStringnResuelta(1) + "\t\t\t--> ***(2)***");
                                        System.out.println(incidencia3U1.toStringnResuelta(1) + "\t\t\t--> ***(3)***");
                                        System.out.println(incidencia1U2.toStringnResuelta(1) + "\t\t\t--> ***(4)***");
                                        System.out.println(incidencia2U2.toStringnResuelta(1) + "\t\t\t--> ***(5)***");
                                        System.out.println(incidencia3U2.toStringnResuelta(1) + "\t\t\t--> ***(6)***");

                                        opcIncidencia = num.nextInt();
                                        switch (opcIncidencia) {
                                            case 1:
                                                incidencia1U1.setResuelta(true);
                                                incidencia1U1.setCalendarCerrada(fechaIncidenciaCerrada);
                                                //enviamos correo |  destino = u1.getdestino
                                                asunto = "Incidencia cerrada";
                                                u1.setMensaje(incidencia1U1.toStringResuelta());

                                                if (EnviarMail.enviarMail(u1.getDestino(),u1.getMensaje(),asunto)){
                                                    System.out.println("Mensaje enviado con éxito");
                                                }else {
                                                    System.out.println("Error al enviar el mensaje");
                                                }
                                                //
                                                break;
                                            case 2:
                                                incidencia2U1.setResuelta(true);
                                                incidencia2U1.setCalendarCerrada(fechaIncidenciaCerrada);
                                                //enviamos correo |  destino = u1.getdestino
                                                asunto = "Incidencia cerrada";
                                                u1.setMensaje(incidencia2U1.toStringResuelta());

                                                if (EnviarMail.enviarMail(u1.getDestino(),u1.getMensaje(),asunto)){
                                                    System.out.println("Mensaje enviado con éxito");
                                                }else {
                                                    System.out.println("Error al enviar el mensaje");
                                                }
                                                //
                                                break;
                                            case 3:
                                                incidencia3U1.setResuelta(true);
                                                incidencia3U1.setCalendarCerrada(fechaIncidenciaCerrada);
                                                //enviamos correo |  destino = u1.getdestino
                                                asunto = "Incidencia cerrada";
                                                u1.setMensaje(incidencia3U1.toStringResuelta());

                                                if (EnviarMail.enviarMail(u1.getDestino(),u1.getMensaje(),asunto)){
                                                    System.out.println("Mensaje enviado con éxito");
                                                }else {
                                                    System.out.println("Error al enviar el mensaje");
                                                }
                                                //
                                                break;
                                            case 4:
                                                incidencia1U2.setResuelta(true);
                                                incidencia1U2.setCalendarCerrada(fechaIncidenciaCerrada);
                                                //enviamos correo |  destino = u2.getdestino
                                                asunto = "Incidencia cerrada";
                                                u2.setMensaje(incidencia1U2.toStringResuelta());

                                                if (EnviarMail.enviarMail(u2.getDestino(),u2.getMensaje(),asunto)){
                                                    System.out.println("Mensaje enviado con éxito");
                                                }else {
                                                    System.out.println("Error al enviar el mensaje");
                                                }
                                                //
                                                break;
                                            case 5:
                                                incidencia2U2.setResuelta(true);
                                                incidencia2U2.setCalendarCerrada(fechaIncidenciaCerrada);
                                                //enviamos correo |  destino = u2.getdestino
                                                asunto = "Incidencia cerrada";
                                                u2.setMensaje(incidencia2U2.toStringResuelta());

                                                if (EnviarMail.enviarMail(u2.getDestino(),u2.getMensaje(),asunto)){
                                                    System.out.println("Mensaje enviado con éxito");
                                                }else {
                                                    System.out.println("Error al enviar el mensaje");
                                                }
                                                //
                                                break;
                                            case 6:
                                                incidencia3U2.setResuelta(true);
                                                incidencia3U2.setCalendarCerrada(fechaIncidenciaCerrada);
                                                //enviamos correo |  destino = u2.getdestino
                                                asunto = "Incidencia cerrada";
                                                u2.setMensaje(incidencia3U2.toStringResuelta());

                                                if (EnviarMail.enviarMail(u2.getDestino(),u2.getMensaje(),asunto)){
                                                    System.out.println("Mensaje enviado con éxito");
                                                }else {
                                                    System.out.println("Error al enviar el mensaje");
                                                }
                                                //
                                                break;
                                        }

                                        break;

                                    case 3: //consultar mis incidencias resueltas por mi
                                        if (incidencia1U1.getTecnico() == t2 && incidencia1U1.isResuelta() == true) {
                                            System.out.println(incidencia1U1.toStringResuelta());
                                        }
                                        if (incidencia2U1.getTecnico() == t2 && incidencia2U1.isResuelta() == true) {
                                            System.out.println(incidencia2U1.toStringResuelta());
                                        }
                                        if (incidencia3U1.getTecnico() == t2 && incidencia3U1.isResuelta() == true) {
                                            System.out.println(incidencia3U1.toStringResuelta());
                                        }
                                        if (incidencia1U2.getTecnico() == t2 && incidencia1U2.isResuelta() == true) {
                                            System.out.println(incidencia1U2.toStringResuelta());
                                        }
                                        if (incidencia2U2.getTecnico() == t2 && incidencia2U2.isResuelta() == true) {
                                            System.out.println(incidencia2U2.toStringResuelta());
                                        }
                                        if (incidencia3U2.getTecnico() == t2 && incidencia3U2.isResuelta() == true) {
                                            System.out.println(incidencia3U2.toStringResuelta());
                                        }
                                        break;

                                    case 4: //Mostrar mi perfil
                                        System.out.println(t2);
                                        break;

                                    case 5: //cambiar clave de acceso
                                        System.out.println("Nueva contraseña?");
                                        t2.setContraseña(contraseña = cad.nextLine());
                                        break;

                                    case 6://cerrar sesion
                                        exit3 = true;
                                        //exit1 = true;
                                        comprob = true;
                                        break;
                                }

                            } else {
                                System.out.println("No existe perfil creado");
                            }
                        }while (!exit3);
                    }//<>t2

                    if (user.equals("admin") && pass.equals("admin")) { //entra admin  exit2 = true;
                        do {


                            System.out.println("Bienvenido, tiene usted perfil de administrador.\n Menú:");
                            menúAdmin();

                            menuadmin = num.nextInt();
                            switch (menuadmin) {
                                case 1://consultar incidencias
                                    System.out.println(incidencia1U1);
                                    System.out.println(incidencia2U1);
                                    System.out.println(incidencia3U1);
                                    System.out.println(incidencia1U2);
                                    System.out.println(incidencia2U2);
                                    System.out.println(incidencia3U2);
                                    break;

                                case 2://consultar todos los usuarios
                                    System.out.println(u1);
                                    System.out.println(u2);
                                    break;

                                case 3://consultar todos los tecnicos
                                    System.out.println(t1);
                                    System.out.println(t2);
                                    break;

                                case 4://asignar incidencia a tecnico
                                    System.out.println("Mostrando incidencias abiertas sin resolver");
                                    if (incidencia1U1.isResuelta() == false && incidencia1U1.getUsuarioNormal() != null) {
                                        System.out.println(incidencia1U1.toStringnResuelta(1) + "\t***(1)***");
                                    }
                                    if (incidencia2U1.isResuelta() == false && incidencia2U1.getUsuarioNormal() != null) {
                                        System.out.println(incidencia2U1.toStringnResuelta(1) + "\t***(2)***");
                                    }
                                    if (incidencia3U1.isResuelta() == false && incidencia3U1.getUsuarioNormal() != null) {
                                        System.out.println(incidencia3U1.toStringnResuelta(1) + "\t***(3)***");
                                    }
                                    if (incidencia1U2.isResuelta() == false && incidencia1U2.getUsuarioNormal() != null) {
                                        System.out.println(incidencia1U2.toStringnResuelta(1) + "\t***(4)***");
                                    }
                                    if (incidencia2U2.isResuelta() == false && incidencia2U2.getUsuarioNormal() != null) {
                                        System.out.println(incidencia2U2.toStringnResuelta(1) + "\t***(5)***");
                                    }
                                    if (incidencia3U2.isResuelta() == false && incidencia3U2.getUsuarioNormal() != null) {
                                        System.out.println(incidencia3U2.toStringnResuelta(1) + "\t***(6)***");
                                    }

                                    System.out.println("A qué técnico le quiere asignar una incidencia?");
                                    System.out.println(" (1)-->" + t1.getNombre() + " / " + t2.getNombre() + " <--(2)");
                                    opcIncidencia = num.nextInt();

                                    switch (opcIncidencia) {
                                        case 1: //asignasr incidencia a tecnico1
                                            System.out.println("Qué incidencia desea asignarle? (1)/(2)/(3)/(4)/(5)/(6)");
                                            opcAsignacionIncidencia = num.nextInt();

                                            switch (opcAsignacionIncidencia) {
                                                case 1:
                                                    incidencia1U1.setTecnico(t1);
                                                    System.out.println("Asignación exitosa");
                                                    break;
                                                case 2:
                                                    incidencia2U1.setTecnico(t1);
                                                    System.out.println("Asignación exitosa");
                                                    break;
                                                case 3:
                                                    incidencia3U1.setTecnico(t1);
                                                    System.out.println("Asignación exitosa");
                                                    break;
                                                case 4:
                                                    incidencia1U2.setTecnico(t1);
                                                    System.out.println("Asignación exitosa");
                                                    break;
                                                case 5:
                                                    incidencia2U2.setTecnico(t1);
                                                    System.out.println("Asignación exitosa");
                                                    break;
                                                case 6:
                                                    incidencia3U2.setTecnico(t1);
                                                    System.out.println("Asignación exitosa");
                                                    break;
                                            }

                                            break;

                                        case 2: //asignar incidencia a tecnico 2
                                            System.out.println("Qué incidencia desea asignarle? (1)/(2)/(3)/(4)/(5)/(6)");
                                            opcAsignacionIncidencia = num.nextInt();

                                            switch (opcAsignacionIncidencia) {
                                                case 1:
                                                    incidencia1U1.setTecnico(t2);
                                                    System.out.println("Asignación exitosa");
                                                    break;
                                                case 2:
                                                    incidencia2U1.setTecnico(t2);
                                                    System.out.println("Asignación exitosa");
                                                    break;
                                                case 3:
                                                    incidencia3U1.setTecnico(t2);
                                                    System.out.println("Asignación exitosa");
                                                    break;
                                                case 4:
                                                    incidencia1U2.setTecnico(t2);
                                                    System.out.println("Asignación exitosa");
                                                    break;
                                                case 5:
                                                    incidencia2U2.setTecnico(t2);
                                                    System.out.println("Asignación exitosa");
                                                    break;
                                                case 6:
                                                    incidencia3U2.setTecnico(t2);
                                                    System.out.println("Asignación exitosa");
                                                    break;
                                            }

                                            break;

                                    }


                                    break;

                                case 5://dar de alta a un tecnico
                                    System.out.println("A que Técnico desea dar de alta?");
                                    System.out.println(" (1) / (2) ");

                                    alta = num.nextInt();
                                    switch (alta) {
                                        case 1:
                                            System.out.println("Porfavor proporcione los datos del Técnico");
                                            System.out.println("\tNombre: ");
                                            nombre = cad.nextLine();
                                            System.out.println("\tPrimer apellido: ");
                                            apellido1 = cad.nextLine();
                                            System.out.println("\tSegundo apellido: ");
                                            apellido2 = cad.nextLine();

                                            t1 = new Tecnico(nombre, apellido1, apellido2); //¿?
                                            codigo = (codigor) + nombre.substring(0, 1).toUpperCase() + apellido1.substring(0, 1).toUpperCase() + apellido2.substring(0, 1).toUpperCase();

                                            t1.setCodigo(codigo);

                                            break;

                                        case 2:
                                            System.out.println("Porfavor proporcione los datos del Técnico");
                                            System.out.println("\tNombre: ");
                                            nombre = cad.nextLine();
                                            System.out.println("\tPrimer apellido: ");
                                            apellido1 = cad.nextLine();
                                            System.out.println("\tSegundo apellido: ");
                                            apellido2 = cad.nextLine();

                                            t2 = new Tecnico(nombre, apellido1, apellido2); //¿?
                                            codigo = (codigor) + nombre.substring(0, 1).toUpperCase() + apellido1.substring(0, 1).toUpperCase() + apellido2.substring(0, 1).toUpperCase();
                                            t2.setCodigo(codigo);


                                            break;
                                    }

                                    break;

                                case 6://borrar tecnico
                                    System.out.println("A qué técnico desea borrar?");
                                    System.out.println(" (1)-->" + t1.getNombre() + " / " + t2.getNombre() + " <--(2)");

                                    delete = num.nextInt();
                                    switch (delete) {
                                        case 1:
                                            t1.borrarTecnico();
                                            System.out.println("Técnico borrado con éxito");
                                            break;

                                        case 2:
                                            t2.borrarTecnico();
                                            System.out.println("Técnico borrado con éxito");
                                            break;
                                    }
                                    break;

                                case 7://cerrar sesión
                                    exit4 = true;
                                    //exit1 = true;
                                    comprob = true;
                                    break;
                            }

                        }while (!exit4);
                    }//<> admin

                        //comprueba mails 1
                    if (user.equals(u1.getUsuario()) && pass.equals(u1.getContraseña()) && (u1.getDestino() != u2.getDestino())) {//entra el usuario 1
                        System.out.println("Token? ");
                        String token = s.nextLine();

                        if (token.equals(u1.getMensaje())) {

                            do {


                                System.out.println("Bienvenido " + u1.getNombre() + ", tiene usted perfil de usuario normal.\n Menú:");
                                menúUsuario();

                                menuuser = num.nextInt();
                                switch (menuuser) {
                                    case 1: //1.-Registrar una nueva incidencia
                                        System.out.println("Dispone de 3 incidencias cual desea usar? (tenga en cuenta que se reescribirán los datos si uno de ellos ya ha sido previamente registrado)");
                                        System.out.println(" (1) / (2) / (3) ");
                                        opcionuser = num.nextInt();

                                        switch (opcionuser) {
                                            case 1: //incidencia1U1
                                                System.out.println("Incidencia nº 1 del usuario " + u1.getUsuario()); //compriobacion credenciales
                                                incidencia1U1.setUsuarioNormal(u1);

                                                System.out.println("Descríbanos su incidencia");
                                                String comentario = cad.nextLine();
                                                incidencia1U1.setComentario_usuario(comentario);

                                                System.out.println("Nivel de prioridad");
                                                String prioridad = cad.nextLine();
                                                incidencia1U1.setPrioridad(prioridad);

                                                incidencia1U1.setResuelta(false);
                                                incidencia1U1.setId(Integer.parseInt(codigor));
                                                incidencia1U1.setCalendarAbierta(fechaIncidenciaAbierta);


                                                //enviamos correo
                                                asunto = "Nueva incidencia 1 del usuario "+ u1.getUsuario();

                                                u1.setMensaje(incidencia1U1.toStringnResuelta(1));
                                                if (EnviarMail.enviarMail(u1.getDestino(),u1.getMensaje(),asunto)){
                                                    System.out.println("Mensaje enviado con éxito");
                                                }else {
                                                    System.out.println("Error al enviar el mensaje");
                                                }
                                                //

                                                //enviamos telegram
                                                    String mensajeTelegram = ("Nueva incidencia 1 del usuario -->" + u1.getNombre());
                                                if (EnviarTelegram.enviaMensajeTelegram(mensajeTelegram)){
                                                    System.out.println("Notificado con éxito al administrador");
                                                }else {
                                                    System.out.println("Error al notificar al administrador");
                                                }
                                                //
                                                break;

                                            case 2://incidencia2U1
                                                System.out.println("Incidencia nº 2 del usuario " + u1.getUsuario()); //compriobacion credenciales
                                                incidencia2U1.setUsuarioNormal(u1);

                                                System.out.println("Descríbanos su incidencia");
                                                comentario = cad.nextLine();
                                                incidencia2U1.setComentario_usuario(comentario);

                                                System.out.println("Nivel de prioridad");
                                                prioridad = cad.nextLine();
                                                incidencia2U1.setPrioridad(prioridad);

                                                incidencia2U1.setResuelta(false);
                                                incidencia2U1.setId(Integer.parseInt(codigor));
                                                incidencia2U1.setCalendarAbierta(fechaIncidenciaAbierta);

                                                //enviamos correo
                                                asunto = "Nueva incidencia 2 del usuario "+ u1.getUsuario();

                                                u1.setMensaje(incidencia2U1.toStringnResuelta(1));
                                                if (EnviarMail.enviarMail(u1.getDestino(),u1.getMensaje(),asunto)){
                                                    System.out.println("Mensaje enviado con éxito");
                                                }else {
                                                    System.out.println("Error al enviar el mensaje");
                                                }
                                                //
                                                //enviamos telegram
                                                mensajeTelegram = ("Nueva incidencia 2 del usuario -->" + u1.getNombre());
                                                if (EnviarTelegram.enviaMensajeTelegram(mensajeTelegram)){
                                                    System.out.println("Notificado con éxito al administrador");
                                                }else {
                                                    System.out.println("Error al notificar al administrador");
                                                }
                                                //
                                                break;

                                            case 3://incidencia3U1
                                                System.out.println("Incidencia nº 3 del usuario " + u1.getUsuario()); //compriobacion credenciales
                                                incidencia3U1.setUsuarioNormal(u1);

                                                System.out.println("Descríbanos su incidencia");
                                                comentario = cad.nextLine();
                                                incidencia3U1.setComentario_usuario(comentario);

                                                System.out.println("Nivel de prioridad");
                                                prioridad = cad.nextLine();
                                                incidencia3U1.setPrioridad(prioridad);

                                                incidencia3U1.setResuelta(false);
                                                incidencia3U1.setId(Integer.parseInt(codigor));
                                                incidencia3U1.setCalendarAbierta(fechaIncidenciaAbierta);

                                                //enviamos correo
                                                asunto = "Nueva incidencia 3 del usuario "+ u1.getUsuario();

                                                u1.setMensaje(incidencia3U1.toStringnResuelta(1));
                                                if (EnviarMail.enviarMail(u1.getDestino(),u1.getMensaje(),asunto)){
                                                    System.out.println("Mensaje enviado con éxito");
                                                }else {
                                                    System.out.println("Error al enviar el mensaje");
                                                }
                                                //
                                                mensajeTelegram = ("Nueva incidencia 3 del usuario -->" + u1.getNombre());
                                                if (EnviarTelegram.enviaMensajeTelegram(mensajeTelegram)){
                                                    System.out.println("Notificado con éxito al administrador");
                                                }else {
                                                    System.out.println("Error al notificar al administrador");
                                                }
                                                //
                                                break;
                                        }

                                        break;

                                    case 2: //2.- Consultar incidencias abiertas
                                        if (!incidencia1U1.isResuelta() && t1.getNombre() != null && t2.getNombre() != null) {
                                            System.out.println(incidencia1U1.toStringnResuelta(1));
                                        }
                                        if (!incidencia2U1.isResuelta() && t1.getNombre() != null && t2.getNombre() != null) {
                                            System.out.println(incidencia2U1.toStringnResuelta(1));
                                        }
                                        if (!incidencia3U1.isResuelta() && t1.getNombre() != null && t2.getNombre() != null) {
                                            System.out.println(incidencia3U1.toStringnResuelta(1));
                                        }

                                        break;

                                    case 3: //3.- Consultar mis incidencias cerradas
                                        if (incidencia1U1.isResuelta()) {
                                            System.out.println(incidencia1U1.toStringResuelta());
                                        }
                                        if (incidencia2U1.isResuelta()) {
                                            System.out.println(incidencia2U1.toStringResuelta());
                                        }
                                        if (incidencia3U1.isResuelta()) {
                                            System.out.println(incidencia3U1.toStringResuelta());
                                        }

                                        break;

                                    case 4: //4.-Mostrar mi perfil
                                        System.out.println(u1);
                                        break;
                                    case 5: //5.- Cambiar clave de acceso

                                        System.out.println("1.- Cambiar contraseña\n2.- Cambiar correo ");
                                        int change = num.nextInt();
                                        switch (change){
                                            case 1: // change pass
                                                System.out.println("Nueva contraseña?");
                                                u1.setContraseña(contraseña = cad.nextLine());
                                                break;

                                            case 2: //change mail
                                                System.out.println("Nuevo correo? (tendrá que confirmarlo añadiendo el token): ");
                                                u1.setDestino(destino = cad.nextLine());

                                                System.out.println("Procederemos a enviarle un token de autentificación");
                                                //enviamos correo
                                                asunto = "Nueva verificación ";
                                                u1.setMensaje(String.valueOf((int)(Math.random()*10000000)));
                                                if (EnviarMail.enviarMail(u1.getDestino(),u1.getMensaje(),asunto)){
                                                    System.out.println("Mensaje enviado con éxito");
                                                }else {
                                                    System.out.println("Error al enviar el mensaje");
                                                }

                                                do {
                                                    System.out.println("Por favor, introduzca su nuevo token de verificación");
                                                    token = s.nextLine();

                                                }while (token.equals(u1.getMensaje()) == false);

                                                    System.out.println("Confirmación exitosa");




                                                break;
                                        } break;

                                    case 6: //6.- Cerrar sesión
                                        exit5 = true;
                                        //  exit1 = true;
                                        comprob = true;
                                        break;

                                }
                            } while (!exit5);
                        }else{
                            System.out.println("Confirmación incorrecta");
                        }
                    }

                        //comprueba mails 2
                    if (user.equals(u2.getUsuario()) && pass.equals(u2.getContraseña()) && (u1.getDestino() != u2.getDestino())) {//entra el usuario 2
                        System.out.println("Token? ");
                        String token = s.nextLine();

                        if (token.equals(u2.getMensaje())) {
                            do {


                                System.out.println("Bienvenido " + u2.getNombre() + ", tiene usted perfil de usuario normal.\n Menú:");
                                menúUsuario();

                                menuuser = num.nextInt();
                                switch (menuuser) {
                                    case 1: //1.-Registrar una nueva incidencia
                                        System.out.println("Dispone de 3 incidencias cual desea usar? (tenga en cuenta que se reescribirán los datos si uno de ellos ya ha sido previamente registrado)");
                                        System.out.println(" (1) / (2) / (3) ");
                                        opcionuser = num.nextInt();

                                        switch (opcionuser) {
                                            case 1: //incidencia1U2
                                                System.out.println("Incidencia nº 1 del usuario " + u2.getUsuario()); //compriobacion credenciales
                                                incidencia1U2.setUsuarioNormal(u2);

                                                System.out.println("Descríbanos su incidencia");
                                                String comentario = cad.nextLine();
                                                incidencia1U2.setComentario_usuario(comentario);

                                                System.out.println("Nivel de prioridad");
                                                String prioridad = cad.nextLine();
                                                incidencia1U2.setPrioridad(prioridad);

                                                incidencia1U2.setResuelta(false);
                                                incidencia1U2.setId(Integer.parseInt(codigor));
                                                incidencia1U2.setCalendarAbierta(fechaIncidenciaAbierta);


                                                //enviamos correo 1
                                                asunto = "Nueva incidencia 1 del usuario "+ u2.getUsuario();

                                                u2.setMensaje(incidencia1U2.toStringnResuelta(1));
                                                if (EnviarMail.enviarMail(u2.getDestino(),u2.getMensaje(),asunto)){
                                                    System.out.println("Mensaje enviado con éxito");
                                                }else {
                                                    System.out.println("Error al enviar el mensaje");
                                                }
                                                //
                                                String  mensajeTelegram = ("Nueva incidencia 1 del usuario -->" + u2.getNombre());
                                                if (EnviarTelegram.enviaMensajeTelegram(mensajeTelegram)){
                                                    System.out.println("Notificado con éxito al administrador");
                                                }else {
                                                    System.out.println("Error al notificar al administrador");
                                                }
                                                //

                                                break;

                                            case 2://incidencia2U2
                                                System.out.println("Incidencia nº 2 del usuario " + u2.getUsuario()); //compriobacion credenciales
                                                incidencia2U2.setUsuarioNormal(u2);

                                                System.out.println("Descríbanos su incidencia");
                                                comentario = cad.nextLine();
                                                incidencia2U2.setComentario_usuario(comentario);

                                                System.out.println("Nivel de prioridad");
                                                prioridad = cad.nextLine();
                                                incidencia2U2.setPrioridad(prioridad);

                                                incidencia2U2.setResuelta(false);
                                                incidencia2U2.setId(Integer.parseInt(codigor));
                                                incidencia2U2.setCalendarAbierta(fechaIncidenciaAbierta);

                                                //enviamos correo 2
                                                asunto = "Nueva incidencia 2 del usuario "+ u2.getUsuario();

                                                u2.setMensaje(incidencia2U2.toStringnResuelta(1));
                                                if (EnviarMail.enviarMail(u2.getDestino(),u2.getMensaje(),asunto)){
                                                    System.out.println("Mensaje enviado con éxito");
                                                }else {
                                                    System.out.println("Error al enviar el mensaje");
                                                }
                                                //
                                                mensajeTelegram = ("Nueva incidencia 2 del usuario -->" + u2.getNombre());
                                                if (EnviarTelegram.enviaMensajeTelegram(mensajeTelegram)){
                                                    System.out.println("Notificado con éxito al administrador");
                                                }else {
                                                    System.out.println("Error al notificar al administrador");
                                                }
                                                //
                                                break;

                                            case 3://incidencia2U3
                                                System.out.println("Incidencia nº 3 del usuario " + u2.getUsuario()); //compriobacion credenciales
                                                incidencia3U2.setUsuarioNormal(u2);

                                                System.out.println("Descríbanos su incidencia");
                                                comentario = cad.nextLine();
                                                incidencia3U2.setComentario_usuario(comentario);

                                                System.out.println("Nivel de prioridad");
                                                prioridad = cad.nextLine();
                                                incidencia3U2.setPrioridad(prioridad);

                                                incidencia3U2.setResuelta(false);
                                                incidencia3U2.setId(Integer.parseInt(codigor));
                                                incidencia3U2.setCalendarAbierta(fechaIncidenciaAbierta);

                                                //enviamos correo
                                                asunto = "Nueva incidencia 3 del usuario "+ u2.getUsuario();

                                                u2.setMensaje(incidencia3U2.toStringnResuelta(1));
                                                if (EnviarMail.enviarMail(u2.getDestino(),u2.getMensaje(),asunto)){
                                                    System.out.println("Mensaje enviado con éxito");
                                                }else {
                                                    System.out.println("Error al enviar el mensaje");
                                                }
                                                //
                                                mensajeTelegram = ("Nueva incidencia 3 del usuario -->" + u2.getNombre());
                                                if (EnviarTelegram.enviaMensajeTelegram(mensajeTelegram)){
                                                    System.out.println("Notificado con éxito al administrador");
                                                }else {
                                                    System.out.println("Error al notificar al administrador");
                                                }
                                                //

                                                break;
                                        }

                                        break;

                                    case 2: //2.- Consultar incidencias abiertas
                                        if (!incidencia1U2.isResuelta()) {
                                            System.out.println(incidencia1U1.toStringnResuelta(1));
                                        }
                                        if (!incidencia2U2.isResuelta()) {
                                            System.out.println(incidencia2U1.toStringnResuelta(1));
                                        }
                                        if (!incidencia3U2.isResuelta()) {
                                            System.out.println(incidencia3U1.toStringnResuelta(1));
                                        }

                                        break;

                                    case 3: //3.- Consultar mis incidencias cerradas
                                        if (incidencia1U2.isResuelta()) {
                                            System.out.println(incidencia1U1.toStringResuelta());
                                        }
                                        if (incidencia2U2.isResuelta()) {
                                            System.out.println(incidencia2U1.toStringResuelta());
                                        }
                                        if (incidencia3U2.isResuelta()) {
                                            System.out.println(incidencia3U1.toStringResuelta());
                                        }

                                        break;

                                    case 4: //4.-Mostrar mi perfil
                                        System.out.println(u2);
                                        break;
                                    case 5: //5.- Cambiar clave de acceso

                                        System.out.println("1.- Cambiar contraseña\n2.- Cambiar correo ");
                                        int change = num.nextInt();
                                        switch (change){
                                            case 1: // change pass
                                                System.out.println("Nueva contraseña?");
                                                u2.setContraseña(contraseña = cad.nextLine());
                                                break;

                                            case 2: //change mail
                                                System.out.println("Nuevo correo? (tendrá que confirmarlo añadiendo el token): ");
                                                u2.setDestino(destino = cad.nextLine());

                                                System.out.println("Procederemos a enviarle un token de autentificación");
                                                //enviamos correo
                                                asunto = "Nueva verificación ";
                                                u2.setMensaje(String.valueOf((int)(Math.random()*10000000)));

                                                if (EnviarMail.enviarMail(u2.getDestino(),u2.getMensaje(),asunto)){
                                                    System.out.println("Mensaje enviado con éxito");
                                                }else {
                                                    System.out.println("Error al enviar el mensaje");
                                                }

                                                do {
                                                    System.out.println("Por favor, introduzca su nuevo token de verificación");
                                                    token = s.nextLine();

                                                }while (token.equals(u2.getMensaje()) == false);

                                                System.out.println("Confirmación exitosa");




                                                break;
                                        } break;
                                    case 6: //6.- Cerrar sesión
                                        exit6 = true;
                                        //   exit1 = true;
                                        comprob = true;
                                        break;
                                }
                            } while (!exit6);
                        }else{
                            System.out.println("Confirmación incorrecta");
                        }
                    }


                    break;




}
        }while (!exit1);

    }


    public static void menúUsuario(){
        System.out.println(" 1.-Registrar una nueva incidencia\n 2.- Consultar incidencias abiertas\n 3.- Consultar mis incidencias cerradas\n 4.-Mostrar mi perfil\n 5.- Cambiar clave de acceso\n 6.- Cerrar sesión");
    }

    public static void menúTecnico(){
        System.out.println(" 1.-Consultar incidencias que tengo asignadas\n 2.- Marcar incidencia como cerrada\n 3.- Consultar incidencias que he resuelto\n 4.-Mostrar mi perfil\n 5.- Cambiar clave de acceso\n 6.- Cerrar sesión");
    }

    public static void menúAdmin(){
        System.out.println(" 1.-Consultar todas las incidencias\n 2.- Consultar todos los usuarios\n 3.- Consultar todos los técnicos\n 4.- Asignar incidencia a técnico\n 5.- Dar de alta a un técnico\n 6.- Borrar a un técnico \n 7.- Cerrar sesión");
    }
}

