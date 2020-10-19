package com.devops.calculadoraAPI.controlador;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@RestController
@RequestMapping("/")
public class InfoController {

    @RequestMapping(value="/ip",method = RequestMethod.GET)
    public ResponseEntity<String> ip(){
        try {
            InetAddress address = InetAddress.getLocalHost();            
            return ResponseEntity.status(200).body(address.getHostAddress() +" -- " + address.getHostName());            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al intentar obetner la direccion ip");
        }
    }

}