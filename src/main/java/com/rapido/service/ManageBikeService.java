package com.rapido.service;

import com.rapido.dao.BikeDao;
import com.rapido.entities.Bike;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageBikeService {

    @Autowired
    private BikeDao bikeDao;

    @Transactional
    public List<Bike> getBikes()
    {
        return bikeDao.getBikes();
    }
}
