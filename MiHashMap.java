import java.util.ArrayList;
import java.util.Iterator;
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
    
    /**
     * Metodo que comprueba si el mapa no tiene elementos
     * @return true si el mapa no contiene elementos
     */
    public boolean isEmpty()
    {
        //se considera de inicio que el mapa no esta vacio
        boolean vacio = false;
        //se comprueba si no hay elementos tanto en el arrayList como en el arrayListInt
        if((key.size()==0) && values.isEmpty())
        {
            vacio = true;
        }
        return vacio;
    }
    
    /**
     * Metodo que devuelve el numero de elementos del mapa
     * @return numero de elementos del mapa
     */
    public int size()
    {
        int tamaño = -1;
        //se comprueba si el  numero de elementos de ambos arrayList coincide
        if(key.size() == values.size())
        {
            tamaño = key.size();
        }
        return tamaño;
    }
    
    /**
     * Metodo que elimina del mapa el elemento con la clave dada
     * @param clave es la clave del elemento que se quiere eliminar
     * @return el elemento eliminado o -1 si no existe la clave en el mapa
     */
    public int remove(String clave)
    {
        int eliminado = -1;
        //primero se comprueba si la clave pasada por parametro existe en el mapa
        boolean existe = false;
        int i = 0;
        while((i < key.size()) && !existe)
        {
            //si la clave pasada por parametro coincide con algun valor del arrayList
            if(clave == key.get(i))
            {
                //se almacena el valor asociado a esa clave con ese indice
                eliminado = values.get(i);
                //se guarda el indice correspondiente a esa clave
                int index = key.indexOf(clave);
                //se elimina del arrayListInt el valor asociado a ese indice
                values.remove(index);
                //se elimina la clave del arrayList asociado a ese indice
                key.remove(i);
                existe = true;
            }
            i++;
        }
        return eliminado;
    }
    
    /**
     * Metodo que vacia el mapa
     */
    public void clear()
    {
        //primero se vacia las claves almacenadas en el arrayList
        for(Iterator<String> it = key.iterator(); it.hasNext();it.remove())
        {
            it.next();
        }
        //despues se vacia los valores del arrayListInt
        values.clear();
    }
    
    /**
     * Metodo que comprueba si el mapa tiene una determinada clave
     * @param clave es la clave que se quiere comprobar si existe
     * @return true si el mapa contiene la clave
     */
    public boolean containsKey(String clave)
    {
        //se considera que el mapa no contiene la clave
        boolean contiene = false;
        //si el arrayList contiene la clave pasada por parametro
        if(key.contains(clave))
        {
            contiene = true;
        }
        return contiene;
    }
    
}
