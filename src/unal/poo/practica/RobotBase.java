package unal.poo.practica;

import becker.robots.*;

/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class RobotBase
{    
       //Declaracion de Variables -- Forma temporal - No es buena practica tener
       //variables estaticas
        public static City objetos;
        public static Robot estudiante;
        
	public static void main (String[] args){
            //Declarar la creacion de la ciudad
            objetos = new City("Field.txt");
	    objetos.showThingCounts(true);
            
            //Direction.NORTH, EAST, SOUTH, WEST
            //Definicion de la ubicacion del robot, Ciudad, posicion, Direccion, Numero things en el bolso.
            estudiante = new Robot(objetos,0, 2, Direction.EAST,0);
            
	    //Mover una interseccion en el sentido al cual este apuntando el objeto.
            creacionFuncion(3);
            
            creacionFuncionTurn(3);
            
            creacionFuncion(5);
            
            creacionFuncionTurn(3);
            
            creacionFuncion(5);
            
            creacionFuncionTurn(3);
            
            creacionFuncion(5);
            
            creacionFuncionTurn(3);
            
            creacionFuncion(5);
            
            creacionFuncionTurn(3);
            
            creacionFuncion(2);
            
            creacionFuncionTurn(3);
            
            creacionFuncion(2);
            
            creacionFuncionTurn(3);
            
            creacionFuncion(1);
            
            creacionFuncionTurn(3);
            
            creacionFuncion(1);
            
            //Tomando decisiones, Si puedo tomar un Thing
            boolean puedeTomar = estudiante.canPickThing();
            
            //Tomar un Thing
            if(puedeTomar == true)
               estudiante.pickThing();
            
            creacionFuncionTurn(2);
            
            creacionFuncion(1);
            
            creacionFuncionTurn(1);
            
            creacionFuncion(1);
            
            creacionFuncionTurn(1);
            
            creacionFuncion(1);
            
            creacionFuncionTurn(3);
            
            creacionFuncion(1);
            
            creacionFuncionTurn(3);
            
            creacionFuncion(3);
            
            creacionFuncionTurn(1);
            
            creacionFuncion(1);
            
            creacionFuncionTurn(1);
            
            creacionFuncion(1);
            
            int n=0;
            
            while (puedeTomar==true){
                estudiante.pickThing();
                n+=1;
            }
            
            while (n!=0)
            //Tomando decisiones, Si puedo tomar un Thing
            //boolean puedeTomar = estudiante.canPickThing();
            
            //Tomar un Thing
            //if(puedeTomar == true)
               //estudiante.pickThing();
                        
            //Especifica el numero de Thing que tiene en robot en el bolso
            int numeroThings = estudiante.countThingsInBackpack();
            
            //Poner Thing, se debe validar que tenga things en el bolso
            estudiante.putThing();
                       
            //Si el frente esta libre de Wall
            //estudiante.frontIsClear();
            
            //Invocando una funcion
            //creacionFuncion(4);
            
            //Toman un Thing
            //estudiante.pickThing();
            
            creacionFuncionTurn(2);
            
            creacionFuncion(1);
            
            creacionFuncionTurn(3);
            
            creacionFuncion(1);
            
            creacionFuncionTurn(3);
            
            creacionFuncion(3);
            
            creacionFuncionTurn(1);
            
            creacionFuncion(1);
            
            creacionFuncionTurn(1);
            
            creacionFuncion(1);
            
            creacionFuncionTurn(3);
            
            creacionFuncion(1);
            
            creacionFuncionTurn(2);
            
            creacionFuncion(1);
            
            creacionFuncionTurn(1);
            
            creacionFuncion(1);
            
            creacionFuncionTurn(3);
            
            creacionFuncion(4);
            
            creacionFuncionTurn(3);
            
            creacionFuncion(3);
            
            
	}
        
        public static void creacionFuncion(int parametroEntrada){
            for (int i = 0; i < parametroEntrada; i++) 
                estudiante.move();
        }
        public static void creacionFuncionTurn(int parametroEntrada){
            for (int i = 0; i < parametroEntrada; i++) 
                estudiante.turnLeft();
        }
}

