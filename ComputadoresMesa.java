package Reto2Mintic_java;

public class ComputadoresMesa extends Computadores {

    private final static Integer ALMACENAMIENTO_BASE = 50;

    // vARIABLE

    private Integer almacenamiento;

    // Constructor

    public ComputadoresMesa (){
        // super();
        this.peso = PESO_BASE;
        this.precioBase = PRECIO_BASE;
        this.consumoW = CONSUMO_W;
        this.almacenamiento = ALMACENAMIENTO_BASE;
    }
    
    // Constructor

    public ComputadoresMesa ( Double precioBase, Integer peso){
        super(precioBase, peso);
        this.almacenamiento = ALMACENAMIENTO_BASE;

    }

    public ComputadoresMesa (Double precioBase, Integer peso, char consumoW, Integer almacenamiento){
        super(precioBase, peso, consumoW);
        this.almacenamiento = almacenamiento;
    }

    // Metodos

    public Double calcularPrecio(){
        Double adicion = super.calcularPrecio();
        if (almacenamiento > 100.0){
            adicion+=50.0;
        }
        //Codigo return adicion
        return adicion;

    }

    //getter

    public Integer getcarga(){
        return almacenamiento;
    }
}
