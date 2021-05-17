# Connessione Arduino su Android Studio

                    //Bisogna effettuare la connessione con l'Arduino
                    //00000000-0000-1000-8000-00805F9B34FB
                    UUID miouuid= UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");      //profilo del serial
                    try {
                        BluetoothSocket mioSocket=ArduinoBT.createRfcommSocketToServiceRecord(miouuid);
                        OutputStream mioStream=mioSocket.getOutputStream();
                        mioStream.write(92);
                        mioSocket.close();
                        mioStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
