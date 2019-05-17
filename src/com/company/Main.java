package com.company;


import java.util.*;

public class Main {

    static List<String> _1_al_999(int n) {
        // 1 - 999
        String unidades[] = {"", "un", "dos ", "tres ", "cuatro ", "cinco ", "seis ", "siete ", "ocho", "nueve"};
        String decenas[] = {"", "", " veinte ", "treinta ", " cuarenta ", "cincuenta ", "sesenta ", "setenta ", "ochenta ", "noventa "};
        String decenase[] = {"diez ", "once ", "doce ", "trece ", " catorce ", " quince ", "dieciseis ", "diecisiete ", "dieciocho ", "diecinueve "};
        String centenas[] = {"", "ciento ", "doscientos ", "trescientos ", "cuatrocientos ", "quinientos ", "seiscientos ", "setecientos ", "ochocientos ", "novecientos "};
        List<String> _num = new ArrayList<>();
        if (n >= 100) {
            if (n == 100) {
                _num.add("cien ");
            } else {
                _num.add(centenas[n / 100]);
            }
        }
        n %= 100;
        if (n < 10) {
            if (n > 0) {
                _num.add(unidades[n]);
            }

        } else if (10 <= n && n <= 19) {
            _num.add(decenase[n - 10]);
        } else if (n >= 21 && n <= 29) {
            _num.add("veinti " + unidades[n % 10]);
        } else {
            _num.add(decenas[n / 10]);
            if (n % 10 > 0) {
                _num.add("y " + unidades[n % 10]);
            }
        }
        return _num;
    }

    static List<String> _num4(int n) {
        String miles[] = {"", " mil ", "millon", "billon", "trillon", "cuatrillon", "quintillon", "sextillon", "septillon", "octillon", "nonillon"};
        List<String> _num = new ArrayList<>();
        if (n == 0) {
            _num.add("cero ");
        } else {
            int r = 0;
            while (n > 0) {
                if (n % 1000 > 0) {

                    List<String> _num3 = _1_al_999(n % 1000);
                    if (n % 1000 == 1 && r == 1) {
                        _num3 = _1_al_999(0);
                    }

                    if (r > 0) {
                        _num3.add(miles[r]);
                    }
                    if (r > 1 && n % 1000!=1) {
                        _num3.add("es ");
                    }
                    _num.addAll(0, _num3);
                }
                n /= 1000;
                r++;
            }
        }
        return _num;
    }

    public static void main(String[] args) {

//            ;

        List<String> cero = _num4(0);
        List<String> nueve = _num4(9);
        List<String> mil = _num4(1000);
        List<String> nuevemilcientocincuentayseis = _num4(9156);
        List<String> unmillon = _num4(1000000);
        List<String> tresmillonesdoscientosnoventamilseiscientoscuarentayuno = _num4(3290641);

        System.out.println(1+" = " +String.join((""), cero));
        System.out.println(1+" = " +String.join((""), nueve));
        System.out.println(9+" = " +String.join((""), mil));
        System.out.println(9156+" = " +String.join((""), nuevemilcientocincuentayseis));
        System.out.println(1000000+" = " +String.join((""), unmillon));
        System.out.println(3290641+" = " +String.join((""), tresmillonesdoscientosnoventamilseiscientoscuarentayuno));

    }
}


