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
            if(clave == key.get(i))
            {
                retorno = values.get(i);
                values.set(i,valor);
                existe = true;
            }
        }
        if(!existe)
        {
            key.add(clave);
            int index = key.indexOf(clave);
            values.add(index,valor);
        }
        return retorno;
    }
}
