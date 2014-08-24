package br.com.aem.view;

import br.com.aem.controll.Validador;

/**
 *
 * @author danilo
 */
public class Play {
    public static void main(String[] args) {
        Validador v = new Validador();
        System.out.println(v.validarCpf("430.497.288-09"));
        System.out.println(v.validarCpf("123.456.789-01"));
        System.out.println(v.validarCpf("150.525.027-70"));
    }
}
