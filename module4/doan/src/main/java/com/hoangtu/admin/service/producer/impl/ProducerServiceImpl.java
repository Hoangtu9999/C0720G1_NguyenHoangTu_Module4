package com.hoangtu.admin.service.producer.impl;

import com.hoangtu.admin.entity.Producer;
import com.hoangtu.admin.repository.ProducerRepository;
import com.hoangtu.admin.service.producer.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private ProducerRepository repository;

    @Override
    public List<Producer> findAll() {
        return this.repository.findAll();
    }
}
