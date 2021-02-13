package ie.gmit.dip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

    public class ServerConnection extends Thread{

        private Socket socket;
        private BufferedReader input;

        public ServerConnection( Socket socket ) throws IOException {
            this.socket = socket;
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }

        @Override
        public void run() {
            try{
                while (true){
                    String serverResponse = input.readLine();

                    if(serverResponse == null) break;

                    System.out.println(serverResponse);

                }

            }catch (IOException e){
//            e.printStackTrace();
                System.out.println("Connection to the server lost.");
            }finally {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


}
