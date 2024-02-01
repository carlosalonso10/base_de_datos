package Configuracion;

public class Transacciones {
    public static final String DBname = "PMO12024";


    public static final String Tablepersonas = "personas" ;

    public static final String  id = "id";

    public static final String  nombres = "nombres";

    public static final String  apellidos = "apellidos";

    public static final String telefono = "telefono";
    public static final String  edad = "edad";
    public static final String  correo = "correo";

    //DDL create

    public static final String CreateTablePersonas = "Create table "+ Tablepersonas +"("+
            "id INTEGER PRIMARY KEY AUTOINCREMENT, nombres TEXT, apellidos TEXT" + "telefono  TEXT"
          +  ", edad INTEGER,"+"CORREO TEXT)";


    public static final String DropTablePersonas = "DROP TABLE IF EXISTS"+ Tablepersonas;

    public static final String SelectTablePersonas = "SELECT * FROM" + Tablepersonas;


}
