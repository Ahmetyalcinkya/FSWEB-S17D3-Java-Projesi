package com.workintech.s17d3.zoo.exceptions.error;

import com.workintech.s17d3.zoo.entity.Koala;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class KoalaValidation {
    public static void IDisNotValid(int id){
        if(id <= 0) throw new KoalaException(Constant.ID_NOT_VALID, HttpStatus.BAD_REQUEST);
    }
    public static void sleepHourIsNotValid(int sleepHour){
        if(sleepHour > 24 || sleepHour <= 0) throw new KoalaException(Constant.SLEEP_HOUR_IS_NOT_VALID, HttpStatus.BAD_REQUEST);
    }
    public static void koalaNotExist(Map<Integer, Koala> koalas, int id){
        if(!koalas.containsKey(id)) throw new KoalaException(Constant.ANIMAL_NOT_EXIST, HttpStatus.NOT_FOUND);
    }
    public static void koalaExist(Map<Integer, Koala> koalas, int id){
        if(koalas.containsKey(id)) throw new KoalaException(Constant.ANIMAL_EXIST, HttpStatus.BAD_REQUEST);
    }
}
