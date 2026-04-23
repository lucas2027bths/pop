public class SqlGenerator {

    public static void rooms(){

        for (int floor = 0; floor <= 8;floor++){

            for (int wing = 0; wing < 4; wing++){
                String realWing;


                if (wing == 0){
                    realWing = "N";
                }
                else if (wing == 1){
                    realWing = "E";
                }
                else if (wing == 2){
                    realWing = "S";
                }
                else {
                    realWing = "W";
                }



                for (int room = 1; room <= 20; room++){
                    if (floor == 0){
                        System.out.println("B" + realWing + room);
                    }else{
                        System.out.println(floor + realWing + room);
                    }

                }

            }

        }

    }



}
