package com.workintech.s17d3.zoo.exceptions.error;

import com.workintech.s17d3.zoo.entity.Kangaroo;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class KangarooValidation {

    public static void IDisNotValid(int id){
        if(id <= 0) throw new KangarooException(Constant.ID_NOT_VALID, HttpStatus.BAD_REQUEST);
    }
    public static void kangarooIsNotExist(Map<Integer, Kangaroo> kangaroos, int id){
        if(!kangaroos.containsKey(id)) throw new KangarooException(Constant.ANIMAL_NOT_EXIST, HttpStatus.NOT_FOUND);
    }
    public static void kangarooExist(Map<Integer, Kangaroo> kangaroos, int id){
        if(kangaroos.containsKey(id)) throw new KangarooException(Constant.ANIMAL_EXIST, HttpStatus.BAD_REQUEST);
    }
}
