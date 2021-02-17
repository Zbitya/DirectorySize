package com.bitya.dirsize;

import java.io.File;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author bitya
 */
public class Main {
    
    static long dirSize(File d) {
        if (d.isFile()) return -1;
        long size = 0;
        File[] files = d.listFiles();
        for (int i = 0; i < files.length; ++i) {
            if (files[i].isDirectory()) {
                dirSize(files[i]);
            }
            size += files[i].length();
        }
        return size;
    }
    
    public static void main(String[] args) {
        
        String str = JOptionPane.showInputDialog(null, "Введите путь до папки для подсчёта её размера", "Ввод", JOptionPane.QUESTION_MESSAGE);
        File dir = new File(str);
        
        double size = dirSize(dir);
        double size_kib = size     / 1024;
        double size_mib = size_kib / 1024;
        double size_gib = size_mib / 1024;
        
        String result = "The length of the directory " + str + " is ";
        if (size_kib < 0) {
            result += size;
        } else {
            if (size_gib >= 1) {
                result += size_gib;
                result += " GiB";
            } else if (size_mib >= 1) {
                result += size_mib;
                result += " MiB";
            } else {
                result += size_kib;
                result += " KiB";
            }
        }
        
        JOptionPane.showMessageDialog(null, result, "Результат", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
}
