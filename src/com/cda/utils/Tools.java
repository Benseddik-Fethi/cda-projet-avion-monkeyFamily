package com.cda.utils;

import java.util.Random;

public abstract class Tools {
    public static int genererInt(int borneInf, int borneSup) {
        Random random = new Random();
        int nb;
        nb = borneInf + random.nextInt(borneSup - borneInf);
        return nb;
    }


}
