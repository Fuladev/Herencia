/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.diego.herencia;

/**
 *
 * @author Diego Fula
 */
public class CuentaCorriente extends Cuenta {
    
    float sobregiro;
    
    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        sobregiro = 0;
    }

    @Override
    public void extractoMensual() {
        super.extractoMensual(); 
    }

    @Override
    public void retirar(float cantidad) {
        float resultado = saldo - cantidad;
        
        if (resultado < 0) {
            sobregiro = sobregiro - resultado;
            saldo = 0;
        }else{
            super.retirar(cantidad); 
        }
        
    }

    @Override
    public void consignar(float cantidad) {
        float residuo = sobregiro - cantidad;
        
        if (sobregiro > 0) {
            if (residuo > 0) {
                sobregiro = 0;
                saldo = residuo;
            }else{
                sobregiro = -residuo;
                saldo = 0;
            }
            
        }else{
            super.consignar(cantidad); 
        }
        
    }
    
    public void imprimir(){
        System.out.println("Saldo = $" + saldo);
        System.out.println("Comision Mensual = $" + comisionMensual);
        System.out.println("Numero de transacciones = $" + (numeroConsignaciones + numeroRetiros));
        System.out.println("Valor de sobregiro = $" + (numeroConsignaciones + numeroRetiros));
        System.out.println();
    }
    
    
    
}
