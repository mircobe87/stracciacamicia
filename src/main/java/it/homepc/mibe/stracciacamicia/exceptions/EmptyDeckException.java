/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.homepc.mibe.stracciacamicia.exceptions;

/**
 *
 * @author mircobe87
 */
public class EmptyDeckException extends RuntimeException {
    
    public EmptyDeckException() {
        super();
    }
    
    public EmptyDeckException(String msg) {
        super(msg);
    }
}
