package com.example.myapplication.DB.sqlite;

public class ConstantesDB {
    public static final String IF_EXIST = "drop table if exists ";

    public static final String CAMPO_CODIGO = "codigo";
    public static final String CAMPO_MARCA = "marca";
    public static final String CAMPO_COLOR = "color";
    public static final String CAMPO_DESCRIPCION = "descripcion";
    public static final String CAMPO_PRECIO = "precio";
    public static final String NOMBRE_TABLA_ARTICULO = "articulos";
    public static final String IF_EXIST_ART = "drop table "+NOMBRE_TABLA_ARTICULO;

    public static final String CREAR_TABLA_ARTICULO = "create table articulos ( codigo INTEGER PRIMARY KEY, descripcion text, marca text, color text, precio real );" ;

    public static final String CAMPO_ROL = "rol";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_APELLIDO = "apellido";
    public static final String CAMPO_EMAIL = "email";
    public static final String CAMPO_CONSTRASENIA = "constrasenia";
    public static final String NOMBRE_TABLA_USUARIO = "usuarios";
    public static final String IF_EXIST_USU = "drop table "+NOMBRE_TABLA_USUARIO;
    public static final String CREAR_TABLA_USUARIO = "create table "+NOMBRE_TABLA_USUARIO+" ( usuario_id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CAMPO_NOMBRE+" text,"
            + CAMPO_APELLIDO+" text,"
            + CAMPO_EMAIL+" text,"
            + CAMPO_ROL+" text,"
            + CAMPO_CONSTRASENIA+" text)" ;

    public static final String AGREGAR_USUARIO_DEFAULT = "INSERT INTO "+NOMBRE_TABLA_USUARIO+" (" + CAMPO_NOMBRE +", "+ CAMPO_APELLIDO+", "+ CAMPO_EMAIL+", "+CAMPO_CONSTRASENIA +", "+CAMPO_ROL +") "
            + "VALUES" +
            "(" +
            "'Ivan','Puero','matheuspuero@gmail.com','123', 'Admin')" ;
    public static final String AGREGAR_USUARIO_DEFAULT2 = "INSERT INTO "+NOMBRE_TABLA_USUARIO+" (" + CAMPO_NOMBRE +", "+ CAMPO_APELLIDO+", "+ CAMPO_EMAIL+", "+CAMPO_CONSTRASENIA +", "+CAMPO_ROL +") "
            + "VALUES" +
            "(" +
            "'ITB','ADMIN','admin@itb.com','123', 'Cliente')" ;


}
