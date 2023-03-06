/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package utils;

import entities.Discussion;
import entities.Message;

/**
 *
 * @author Imen Frigui
 */
public interface MyListener {
    
    public void onClickListener(Message m);
    public void onClickListener(Discussion d);
    
}
