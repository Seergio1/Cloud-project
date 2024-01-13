package com.example.stock.Service;

import org.springframework.stereotype.Service;

import com.example.stock.Models.Out_method;
import com.example.stock.Repository.Out_methodRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.transaction.Transactional;


@Service
public class Out_methodService {
    @Autowired
    Out_methodRepository out_methodRepository;

    public String getOutMethodNameById(Long idMethod){
        String nameMethod = "";
        List<Out_method> listMethod = out_methodRepository.findOutMethodById(idMethod);
        int size = listMethod.size();
        for (int i = 0; i < size; i++) {
            nameMethod = listMethod.get(i).getName();
        }
        return nameMethod;
    }
}
