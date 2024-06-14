/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vku.common;

import javax.swing.JTextField;

/**
 *
 * @author admin!
 */
public class Helper {

    public static class JTextFileUtil {

        public static void reset(Object... objs) {

            for(Object o : objs) {
                
                if(o instanceof JTextField) {
                    ((JTextField) o).setText("");
                }
                
            }
            
        }

    }

}
