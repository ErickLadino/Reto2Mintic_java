public class Computadores {
    
    //variables base

    protected final static char CONSUMO_W = 'F';
    protected final static double PRECIO_BASE = 100.0;
    protected final static Integer PESO_BASE = 5;

    //VARIABLES

    protected Integer peso;
    protected char consumoW;
    protected double precioBase;

    //Constructores public Computadores () 
    //Constructor

    public Computadores (){
        this.peso = PESO_BASE;
        this.consumoW = CONSUMO_W;
        this.precioBase = PRECIO_BASE;
    }

    public Computadores (Double precioBase, Integer peso){
        this.precioBase = precioBase;
        this.consumoW = CONSUMO_W;
        this.peso = peso;
    }

    public Computadores (Double precioBase, Integer peso, char consumoW){
        this.precioBase = precioBase;
        this.consumoW = consumoW;
        this.peso = peso;
    }

    //Metodos

    public Double calcularPrecio(){
        Double adicion = 0.0;

        // Codigo para consumo

        switch (consumoW){
            case 'A':
                adicion += 100.0;
                break;
            
            case 'B':
                adicion += 80.0;
                break;
            
            case 'C':
                adicion += 60.0;
                break;

            case 'D':
                adicion += 50.0;
                break;
            
            case 'E':
                adicion += 30.0;
                break;
            
            case 'F':
                adicion += 10.0;
                break;
        }

        // Codigo para peso;

        if (peso >= 0 && peso < 19){
            adicion += 10.0;

        } else if (peso >= 20 && peso < 49 ){
            adicion += 50.0;

        } else if (peso >= 50 && peso < 79 ){
            adicion += 80.0;

        } else if (peso >= 80){
            adicion += 100.0;

        }
        return precioBase + adicion;


    }

    // GEtters

    public int getPeso(){
        return peso;
    }

    public char getConsumoW(){
        return consumoW;
    }

    public double getPrecioBase(){
        return precioBase;
    }

}

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

public class ComputadoresPortatiles extends Computadores {
    private final static Integer PULGADAS_BASE = 20;
    private Integer pulgadas;
    private boolean camaraITG;
    
    //Constructores

    public ComputadoresPortatiles(){
        this.peso = PESO_BASE;
        this.precioBase = PRECIO_BASE;
        this.consumoW = CONSUMO_W;
        this.pulgadas = PULGADAS_BASE;
        this.camaraITG = false;
    }

    // Construtor

    public ComputadoresPortatiles (Double precioBase, Integer peso){
        super(precioBase, peso);
        this.pulgadas = PULGADAS_BASE;
        this.camaraITG = false;
    }

    public ComputadoresPortatiles (Double precioBase, Integer peso, char consumoW, Integer pulgadas, boolean camaraITG){
        super(precioBase, peso, consumoW);
        this.pulgadas = pulgadas;
        this.camaraITG =camaraITG;
    } 

    // Metodos
    public Double calcularPrecio (){
        Double adicion = super.calcularPrecio();
        if (pulgadas > 40){
            adicion += precioBase*0.3;
        }
        if (camaraITG){
            adicion += 50.0;
        }

        //Metodo codigo return adicion;

        return adicion;

    }

}

public class PrecioTotal {

    private Double totalComputadores = 0.0;
    private Double totalComputadoresPortatiles = 0.0;
    private Double totalComputadoresMesa = 0.0;
    private Computadores[] listaComputadores;

    // Constructor

    public PrecioTotal(Computadores[] pComputadores){
        this.listaComputadores=pComputadores;
    }

    public void mostrarTotales(){
        //Codigo
        for (int i = 0; i < listaComputadores.length; i++ ){
            if (listaComputadores[i] instanceof Computadores){
                totalComputadores += listaComputadores[i].calcularPrecio();
            }
            if (listaComputadores[i] instanceof ComputadoresMesa){
                totalComputadoresMesa += listaComputadores[i].calcularPrecio();
            }
            if (listaComputadores[i] instanceof ComputadoresPortatiles){
                totalComputadoresPortatiles += listaComputadores[i].calcularPrecio();
            }
        }

         // Mostramos los resultados

        System.out.println("La suma del precio de los computadores es de " + totalComputadores);
        System.out.println("La suma del precio de los computadores de mesa es de " + totalComputadoresMesa);
        System.out.print("La suma del precio de los computadores portátiles es de " + totalComputadoresPortatiles);
    }
    
}


