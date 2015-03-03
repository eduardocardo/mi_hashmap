import java.util.ArrayList;
/**
 * Write a description of class MiHashMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiHashMap
{
    // arrayList que almacenara las claves de tipo String del HashMap
    private ArrayList<String> key;
    //array que actua como un arrayList de enteros y que almacenara los valores del HashMap
    private ArrayListInt values;

    /**
     * Constructor for objects of class MiHashMap
     */
    public MiHashMap()
    {
       key = new ArrayList<>();
       values = new ArrayListInt();
    }

    /**
     * Metodo para introducir un valor al HashMap,asocia la clave introducida al valor
     * @param String clave la clave a la que se le asocia el valor
     * @param int valor valor introducido al HashMap
     * @return si la clave ya existe sobreescribe este valor y devuelve el valor antiguo
     * si no existe devuelve -1
     */
    public int put(String clave,int valor)
    {
        int retorno = -1;
        boolean existe = false;
        //primero se comprueba si la clave pasada por parametro ya existe en el HashMap
        for(int i = 0; i < key.size(); i++)
        {
            //si el parametro introducido como clave coincide con algun valor del arrayList
            if(clave == key.get(i))
            {
                //guardamos el valor del arrayList correspondiente a ese indice para luego devolverlo
                retorno = values.get(i);
                //se sustituye el valor correspondiente a esa clave por el valor introducido por parametro
                values.set(i,valor);
                existe = true;
            }
        }
        //si la clave introducida no existe en el HashMap
        if(!existe)
        {
            //se añade la clave al arrayList
            key.add(clave);
            //se guarda el indice en el que se almaceno la clave en el arrayList
            int index = key.indexOf(clave);
            //se añade en el arrayListInt el valor introducido por parametro
            //en el mismo indice en el que se añadió la clave al arrayList
            values.add(index,valor);
        }
        return retorno;
    }
    
    /**
     * Metodo que devuelve el valor asociado con la clave especificada
     * @param String clave es la clave de la que se quiere obtener el valor asociado
     * @return el valor asociado a la clave o -1 si no existe la clave
     */
    public int get(String clave)
    {
        int retorno = -1;
        boolean existe = false;
        //primero se comprueba si la clave existe en el arrayList
        int i = 0;
        while((i < key.size()) && !existe)
        {
            //si la clave introducida por parametro coincide con algun valor del arrayList
            if(clave == key.get(i))
            {
                //almacenamos en la variable local el valor del arrayListInt asociado
                //al indice de esa clave
                retorno = values.get(i);
                existe = true;
            }
            i++;
        }
        return retorno;
    }
}
