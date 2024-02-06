package Configuracion;

public class Transacciones {
    public static final String DBname = "PM012024";


    public static final String Tablepersonas = "personas";

    public static final String id = "id";

    public static final String nombres = "nombres";

    public static final String apellidos = "apellidos";

    public static final String telefono = "telefono";
    public static final String edad = "edad";
    public static final String correo = "correo";

    public static final String direccion = "direccion";

    //DDL create

    public static final String CreateTablePersonas = "Create table " + Tablepersonas + "(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, nombres TEXT, apellidos TEXT , telefono  TEXT, edad INTEGER,"+"  correo TEXT, direccion TEXT)";


    public static final String DropTablePersonas = " DROP TABLE IF EXISTS " + Tablepersonas;

    public static final String SelectAllPersonas = " SELECT * FROM " + Tablepersonas;

}