package lift;

import becker.robots.*;
import java.util.Scanner;
import java.lang.*;


public class RobotBase
{    
        public static City building;
        public static RobotSE lift1;
        public static RobotSE lift2;
        public static int currentFloor1=1;
        public static int currentFloor2=1;
        public static int qFloor1=0;
        public static int qFloor2=0;
        public static int qFloor3=0;
        public static int qFloor4=0;
        public static int qFloor5=0;
        public static int qFloor6=0;
        public static int qFloor7=0;
        public static int qFloor8=0;
        public static int qFloor9=0;
        public static int qFloor10=0;
        public static int nPeople=31;
        
	public static void main (String[] args){
           
            building = new City("Field.txt");
	    building.showThingCounts(true);
            
            lift1 = new RobotSE(building,10, 2, Direction.NORTH,0);
            lift2 = new RobotSE(building,10, 1, Direction.NORTH,0);
                                    
            gotoFloor(1,5);
            pickPeople(1);
            
            gotoFloor(2,4);
            pickPeople(2);
            
            gotoFloor(1,7);
            leavePeople(1,3);
            
            gotoFloor(2,8);
            leavePeople(2,4);
            
            System.out.println("Floor 1 visits: " + qFloor1);
            System.out.println("Floor 2 visits: " + qFloor2);
            System.out.println("Floor 3 visits: " + qFloor3);
            System.out.println("Floor 4 visits: " + qFloor4);
            System.out.println("Floor 5 visits: " + qFloor5);
            System.out.println("Floor 6 visits: " + qFloor6);
            System.out.println("Floor 7 visits: " + qFloor7);
            System.out.println("Floor 8 visits: " + qFloor8);
            System.out.println("Floor 9 visits: " + qFloor9);
            System.out.println("Floor 10 visits: " + qFloor10);
            System.out.println("Number of people on building: " + nPeople);
                                            
	}
        
        public static void gotoFloor(int n, int floor){
            
            if(floor==1){
                qFloor1+=1;
            }
            if(floor==2){
                qFloor2+=1;
            }
            if(floor==3){
                qFloor3+=1;
            }
            if(floor==4){
                qFloor4+=1;
            }
            if(floor==5){
                qFloor5+=1;
            }
            if(floor==6){
                qFloor6+=1;
            }
            if(floor==7){
                qFloor7+=1;
            }
            if(floor==8){
                qFloor8+=1;
            }
            if(floor==9){
                qFloor9+=1;
            }
            if(floor==10){
                qFloor10+=1;
            }
            
            if(n==1){
                if((floor-currentFloor1)<0){
                    if(lift1.isFacingSouth()==false){
                        lift1.turnAround();
                    }
                    lift1.move(Math.abs(floor-currentFloor1));
                    currentFloor1=floor;
                }
                if((floor-currentFloor1)>0){
                    if(lift1.isFacingNorth()==false){
                        lift1.turnAround();
                    }
                    lift1.move((floor-currentFloor1));
                    currentFloor1=floor;
                }
            }
            if(n==2){
                if((floor-currentFloor2)<0){
                    if(lift2.isFacingSouth()==false){
                        lift2.turnAround();
                    }
                    lift2.move(Math.abs(floor-currentFloor2));
                    currentFloor2=floor;
                }
                if((floor-currentFloor2)>0){
                    if(lift2.isFacingNorth()==false){
                        lift2.turnAround();
                    }
                    lift2.move((floor-currentFloor2));
                    currentFloor2=floor;
                }
            }
            
        }
        
        public static void pickPeople(int n){
            
            if(n==1){
                int c= lift1.countThingsInBackpack();
                lift1.setLabel(Integer.toString(c));
                
                while(lift1.countThingsInBackpack()<5){
                    
                    if(lift1.isFacingNorth()==true){
                        lift1.turnRight();
                        lift1.move();
                    }
                    
                    if(lift1.isFacingSouth()==true){
                        lift1.turnLeft();
                        lift1.move();
                    }
                    
                    int q=0;
                    
                    int f=5-(lift1.countThingsInBackpack());
                    
                    while(lift1.canPickThing()==true){
                        lift1.pickThing();
                        c= lift1.countThingsInBackpack();
                        lift1.setLabel(Integer.toString(c));
                        lift1.move();
                        q++;
                    }

                    if(q>5){
                        lift1.turnAround();
                        lift1.move(f+1);
                        for(int i=(q-f);i>0;i--){
                            lift1.putThing();
                            c= lift1.countThingsInBackpack();
                            lift1.setLabel(Integer.toString(c));
                            lift1.move();
                        }
                        lift1.turnRight();
                    }

                    if(q<=5){
                        lift1.turnAround();
                        lift1.move(5);
                        lift1.turnRight();
                    }
                }
            }
            
            if(n==2){
                int c= lift2.countThingsInBackpack();
                lift2.setLabel(Integer.toString(c));
                
                while(lift2.countThingsInBackpack()<5){
                    
                    if(lift2.isFacingNorth()==true){
                        lift2.turnRight();
                        lift2.move(2);
                    }
                    
                    if(lift2.isFacingSouth()==true){
                        lift2.turnLeft();
                        lift2.move(2);
                    }
                    
                    int q=0;
                    
                    int f=5-(lift2.countThingsInBackpack());
                    
                    while(lift2.canPickThing()==true){
                        lift2.pickThing();
                        c= lift2.countThingsInBackpack();
                        lift2.setLabel(Integer.toString(c));
                        lift2.move();
                        q++;
                    }

                    if(q>5){
                        lift2.turnAround();
                        lift2.move(f+1);
                        for(int i=(q-f);i>0;i--){
                            lift2.putThing();
                            c= lift2.countThingsInBackpack();
                            lift2.setLabel(Integer.toString(c));
                            lift2.move();
                        }
                        lift2.move();
                        lift2.turnRight();
                    }

                    if(q<=5){
                        lift2.turnAround();
                        lift2.move(6);
                        lift2.turnRight();
                    }
                }
            }
        }
        
        public static void leavePeople(int n, int x){
            
            if(n==1){
                int c= lift1.countThingsInBackpack();
                lift1.setLabel(Integer.toString(c));
                if(lift1.countThingsInBackpack()!=0){

                    if(lift1.isFacingNorth()==true){
                        lift1.turnRight();
                        lift1.move();
                    }

                    if(lift1.isFacingSouth()==true){
                        lift1.turnLeft();
                        lift1.move();
                    }

                    int q=1;

                    while(lift1.canPickThing()==true){
                        lift1.move();
                        q++;
                    }

                    for(int i=x;i>0;i--){
                        lift1.putThing();
                        c= lift1.countThingsInBackpack();
                        lift1.setLabel(Integer.toString(c));
                        lift1.move();
                        q++;
                    }

                    lift1.turnAround();
                    lift1.move(q);
                    lift1.turnRight();
                }
            }
            
            if(n==2){
                int c= lift2.countThingsInBackpack();
                lift2.setLabel(Integer.toString(c));
                if(lift2.countThingsInBackpack()!=0){

                    if(lift2.isFacingNorth()==true){
                        lift2.turnRight();
                        lift2.move(2);
                    }

                    if(lift2.isFacingSouth()==true){
                        lift2.turnLeft();
                        lift2.move(2);
                    }

                    int q=1;

                    while(lift2.canPickThing()==true){
                        lift2.move();
                        q++;
                    }

                    for(int i=x;i>0;i--){
                        lift2.putThing();
                        c= lift2.countThingsInBackpack();
                        lift2.setLabel(Integer.toString(c));
                        lift2.move();
                        q++;
                    }

                    lift2.turnAround();
                    lift2.move(q+1);
                    lift2.turnRight();
                }
            }
        }
        
}

